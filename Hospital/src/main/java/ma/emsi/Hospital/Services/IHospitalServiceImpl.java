package ma.emsi.Hospital.Services;

import jakarta.transaction.Transactional;
import ma.emsi.Hospital.Repository.ConsultationRepository;
import ma.emsi.Hospital.Repository.MedecinRepository;
import ma.emsi.Hospital.Repository.PatientRepository;
import ma.emsi.Hospital.Repository.RendezVousRepository;
import ma.emsi.Hospital.entities.Consultation;
import ma.emsi.Hospital.entities.Medecin;
import ma.emsi.Hospital.entities.Patient;
import ma.emsi.Hospital.entities.RendezVous;
import org.springframework.stereotype.Service;

@Service @Transactional
public class IHospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public IHospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient addPatient(Patient p) {
        return patientRepository.save(p);
    }

    @Override
    public Medecin addMedecin(Medecin m) {
        return medecinRepository.save(m);
    }

    @Override
    public RendezVous addRendezVous(RendezVous rv) {
        return rendezVousRepository.save(rv);
    }

    @Override
    public Consultation addConsultation(Consultation cl) {
        return consultationRepository.save(cl);
    }

}
