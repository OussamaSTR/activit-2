package ma.emsi.Hospital.Repository;

import ma.emsi.Hospital.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
  List<Medecin> findBySp(String mc);
}
