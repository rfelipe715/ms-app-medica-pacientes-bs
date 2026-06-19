package cl.duoc.ms_pacientes_bs.controller;

import cl.duoc.ms_pacientes_bs.dto.PacienteDto;
import cl.duoc.ms_pacientes_bs.dto.PacienteConCitasDto;
import cl.duoc.ms_pacientes_bs.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    // C - Create
    @PostMapping
    public ResponseEntity<PacienteDto> registrarPaciente(@Valid @RequestBody PacienteDto pacienteDto) {
        PacienteDto nuevoPaciente = pacienteService.registrarPaciente(pacienteDto);
        return new ResponseEntity<>(nuevoPaciente, HttpStatus.CREATED);
    }

    // R - Read (Obtener todos)
    @GetMapping
    public ResponseEntity<List<PacienteDto>> obtenerTodos() {
        List<PacienteDto> pacientes = pacienteService.obtenerTodos();
        return new ResponseEntity<>(pacientes, HttpStatus.OK);
    }

    // R - Read (Obtener todos con citas)
    @GetMapping("/con-citas")
    public ResponseEntity<List<PacienteConCitasDto>> obtenerTodosConCitas() {
        List<PacienteConCitasDto> pacientes = pacienteService.obtenerTodosConCitas();
        return new ResponseEntity<>(pacientes, HttpStatus.OK);
    }

    // R - Read (Obtener por ID)
    @GetMapping("/{id}")
    public ResponseEntity<PacienteDto> obtenerPorId(@PathVariable Long id) {
        try {
            PacienteDto paciente = pacienteService.obtenerPorId(id);
            return new ResponseEntity<>(paciente, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // R - Read (Obtener por ID con citas)
    @GetMapping("/{id}/con-citas")
    public ResponseEntity<PacienteConCitasDto> obtenerPorIdConCitas(@PathVariable Long id) {
        try {
            PacienteConCitasDto paciente = pacienteService.obtenerPorIdConCitas(id);
            if (paciente != null) {
                return new ResponseEntity<>(paciente, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // U - Update (Editar)
    @PutMapping("/{id}")
    public ResponseEntity<PacienteDto> editarPaciente(@PathVariable Long id, @Valid @RequestBody PacienteDto datosNuevos) {
        try {
            PacienteDto pacienteActualizado = pacienteService.editarPaciente(id, datosNuevos);
            return new ResponseEntity<>(pacienteActualizado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // D - Delete (Eliminar)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPaciente(@PathVariable Long id) {
        try {
            pacienteService.eliminarPaciente(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
