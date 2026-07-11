package cl.duoc.ms_pacientes_bs.client;

import cl.duoc.ms_pacientes_bs.dto.CitaDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "citas-bs", url = "${citas-bs.url}")
public interface CitasRestClient {

    @GetMapping
    List<CitaDto> obtenerCitas();

}
