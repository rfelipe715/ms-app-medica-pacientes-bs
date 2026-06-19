package cl.duoc.ms_pacientes_bs.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CitaDto {

    private Long id;
    private Long pacienteId;
    private String fecha;
    private String hora;
    private String estado;
}
