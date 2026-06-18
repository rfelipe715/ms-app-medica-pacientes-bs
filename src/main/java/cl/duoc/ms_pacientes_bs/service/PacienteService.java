package cl.duoc.ms_pacientes_bs.service;

import cl.duoc.ms_pacientes_bs.client.PacienteClient;
import cl.duoc.ms_pacientes_bs.dto.PacienteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private PacienteClient pacienteClient;

    public PacienteDto registrarPaciente(PacienteDto dto) {
        // Aquí el "cerebro" delega la tarea enviando los datos por internet al DB
        return pacienteClient.registrarPaciente(dto);
    }
}