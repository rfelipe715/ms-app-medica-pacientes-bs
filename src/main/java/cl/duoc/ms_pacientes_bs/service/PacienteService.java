package cl.duoc.ms_pacientes_bs.service;

import cl.duoc.ms_pacientes_bs.dto.PacienteDto;
import cl.duoc.ms_pacientes_bs.model.Paciente;
import cl.duoc.ms_pacientes_bs.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente registrarPaciente(PacienteDto dto) {


        if (pacienteRepository.existsByRun(dto.getRun())) {
            throw new IllegalArgumentException("Error: Ya existe un paciente registrado con el RUN " + dto.getRun());
        }

        if (dto.getNumeroFichaClinica() != null && pacienteRepository.existsByNumeroFichaClinica(dto.getNumeroFichaClinica())) {
            throw new IllegalArgumentException("Error: Ya existe un paciente con el número de ficha " + dto.getNumeroFichaClinica());
        }


        Paciente paciente = new Paciente();
        paciente.setRun(dto.getRun());
        paciente.setNumeroRegistro(dto.getNumeroRegistro());
        paciente.setNumeroFichaClinica(dto.getNumeroFichaClinica());
        paciente.setApellidos(dto.getApellidos());
        paciente.setNombres(dto.getNombres());
        paciente.setSexo(dto.getSexo());
        paciente.setFechaNacimiento(dto.getFechaNacimiento());
        paciente.setDireccion(dto.getDireccion());
        paciente.setTelefonoContacto(dto.getTelefonoContacto());



        return pacienteRepository.save(paciente);
    }
}}