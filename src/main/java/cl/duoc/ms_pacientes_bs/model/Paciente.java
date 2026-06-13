package cl.duoc.ms_pacientes_bs.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 12)
    private String run;

    @Column(name = "numero_registro", length = 20)
    private String numeroRegistro;

    @Column(name = "numero_ficha_clinica", unique = true, length = 20)
    private String numeroFichaClinica;

    @Column(nullable = false, length = 100)
    private String apellidos;

    @Column(nullable = false, length = 100)
    private String nombres;

    @Column(length = 20)
    private String sexo;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(length = 200)
    private String direccion;

    @Column(name = "telefono_contacto", length = 20)
    private String telefonoContacto;

}