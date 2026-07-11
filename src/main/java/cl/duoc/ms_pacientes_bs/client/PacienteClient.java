package cl.duoc.ms_pacientes_bs.client;

import cl.duoc.ms_pacientes_bs.dto.PacienteDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ms-pacientes-db", url = "${ms-pacientes-db.url}")
public interface PacienteClient {

    // C - Create
    @PostMapping
    PacienteDto registrarPaciente(@RequestBody PacienteDto dto);

    // R - Read (Todos)
    @GetMapping
    List<PacienteDto> obtenerTodos();

    // R - Read (Por ID)
    @GetMapping("/{id}")
    PacienteDto obtenerPorId(@PathVariable("id") Long id);

    // U - Update
    @PutMapping("/{id}")
    PacienteDto editarPaciente(@PathVariable("id") Long id, @RequestBody PacienteDto datosNuevos);

    // D - Delete
    @DeleteMapping("/{id}")
    void eliminarPaciente(@PathVariable("id") Long id);
}