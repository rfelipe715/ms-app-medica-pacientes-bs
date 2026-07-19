package cl.duoc.ms_pacientes_bs.service;

import cl.duoc.ms_pacientes_bs.client.PacienteClient;
import cl.duoc.ms_pacientes_bs.client.CitasRestClient;
import cl.duoc.ms_pacientes_bs.dto.PacienteDto;
import cl.duoc.ms_pacientes_bs.dto.PacienteConCitasDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteService {

    private static final Logger log = LoggerFactory.getLogger(PacienteService.class);

    @Autowired
    private PacienteClient pacienteClient;

    @Autowired
    private CitasRestClient citasRestClient;

    public PacienteDto registrarPaciente(PacienteDto dto) {
        log.info("Registrando paciente run={}", dto.getRun());
        return pacienteClient.registrarPaciente(dto);
    }

    public List<PacienteDto> obtenerTodos() {
        return pacienteClient.obtenerTodos();
    }

    public List<PacienteConCitasDto> obtenerTodosConCitas() {
        return pacienteClient.obtenerTodos().stream()
            .map(this::enriquecerPaciente)
            .collect(Collectors.toList());
    }

    public PacienteDto obtenerPorId(Long id) {
        return pacienteClient.obtenerPorId(id);
    }

    public PacienteConCitasDto obtenerPorIdConCitas(Long id) {
        PacienteDto paciente = pacienteClient.obtenerPorId(id);
        if (paciente != null) {
            return enriquecerPaciente(paciente);
        }
        return null;
    }

    public PacienteDto editarPaciente(Long id, PacienteDto datosNuevos) {
        log.info("Editando paciente id={}", id);
        return pacienteClient.editarPaciente(id, datosNuevos);
    }

    public void eliminarPaciente(Long id) {
        log.info("Eliminando paciente id={}", id);
        pacienteClient.eliminarPaciente(id);
    }

    private PacienteConCitasDto enriquecerPaciente(PacienteDto pacienteDto) {
        PacienteConCitasDto conCitas = new PacienteConCitasDto();
        conCitas.setId(pacienteDto.getId());
        conCitas.setRun(pacienteDto.getRun());
        conCitas.setNumeroRegistro(pacienteDto.getNumeroRegistro());
        conCitas.setNumeroFichaClinica(pacienteDto.getNumeroFichaClinica());
        conCitas.setNombres(pacienteDto.getNombres());
        conCitas.setApellidos(pacienteDto.getApellidos());
        conCitas.setSexo(pacienteDto.getSexo());
        conCitas.setFechaNacimiento(pacienteDto.getFechaNacimiento());
        conCitas.setDireccion(pacienteDto.getDireccion());
        conCitas.setTelefonoContacto(pacienteDto.getTelefonoContacto());
        
        try {
            conCitas.setCitas(citasRestClient.obtenerCitas().stream()
                .filter(c -> c.getPacienteId().equals(pacienteDto.getId()))
                .collect(Collectors.toList()));
        } catch (Exception e) {
            log.warn("No se pudieron obtener las citas del paciente id={}: {}", pacienteDto.getId(), e.getMessage());
        }
        
        return conCitas;
    }
}
