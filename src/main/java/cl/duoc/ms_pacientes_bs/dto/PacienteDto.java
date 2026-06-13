package cl.duoc.ms_pacientes_bs.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.time.LocalDate;

@Data
public class PacienteDto {

    private Long id;

    @NotBlank(message = "El RUN del paciente es obligatorio")
    @Size(max = 12, message = "El RUN no puede tener más de 12 caracteres")
    private String run;

    private String numeroRegistro;

    private String numeroFichaClinica;

    @NotBlank(message = "Los apellidos son obligatorios")
    private String apellidos;

    @NotBlank(message = "Los nombres son obligatorios")
    private String nombres;

    private String sexo;

    private LocalDate fechaNacimiento;

    private String direccion;

    private String telefonoContacto;
}
