package cl.duoc.ms_pacientes_bs.controller;

import cl.duoc.ms_pacientes_bs.dto.PacienteDto;
import cl.duoc.ms_pacientes_bs.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<PacienteDto> registrarPaciente(@Valid @RequestBody PacienteDto pacienteDto) {
        PacienteDto nuevoPaciente = pacienteService.registrarPaciente(pacienteDto);
        return new ResponseEntity<>(nuevoPaciente, HttpStatus.CREATED);
    }
}