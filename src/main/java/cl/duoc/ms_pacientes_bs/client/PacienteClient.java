package cl.duoc.ms_pacientes_bs.client;

import cl.duoc.ms_pacientes_bs.dto.PacienteDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ms-pacientes-db", url = "localhost:8082/api/pacientes")
public interface PacienteClient {

    @PostMapping
    PacienteDto registrarPaciente(@RequestBody PacienteDto dto);
}