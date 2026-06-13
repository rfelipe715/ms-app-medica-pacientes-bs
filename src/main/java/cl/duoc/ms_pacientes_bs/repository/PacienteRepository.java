package cl.duoc.ms_pacientes_bs.repository;

import cl.duoc.ms_pacientes_bs.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    boolean existsByRun(String run);

    boolean existsByNumeroFichaClinica(String numeroFichaClinica);
}