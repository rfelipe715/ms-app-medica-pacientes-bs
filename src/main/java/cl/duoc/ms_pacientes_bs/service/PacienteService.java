package cl.duoc.ms_pacientes_bs.service;

import cl.duoc.ms_pacientes_bs.client.PacienteClient;
import cl.duoc.ms_pacientes_bs.dto.PacienteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteClient pacienteClient;

    public PacienteDto registrarPaciente(PacienteDto dto) {
        return pacienteClient.registrarPaciente(dto);
    }

    public List<PacienteDto> obtenerTodos() {
        return pacienteClient.obtenerTodos();
    }

    public PacienteDto obtenerPorId(Long id) {
        return pacienteClient.obtenerPorId(id);
    }

    public PacienteDto editarPaciente(Long id, PacienteDto datosNuevos) {
        return pacienteClient.editarPaciente(id, datosNuevos);
    }

    public void eliminarPaciente(Long id) {
        pacienteClient.eliminarPaciente(id);
    }
}