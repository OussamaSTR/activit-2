package ma.emsi.Hospital.Repository;

import ma.emsi.Hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByNom(String n);
}
