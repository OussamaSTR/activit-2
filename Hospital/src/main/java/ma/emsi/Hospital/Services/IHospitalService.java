package ma.emsi.Hospital.Services;

import ma.emsi.Hospital.entities.Consultation;
import ma.emsi.Hospital.entities.Medecin;
import ma.emsi.Hospital.entities.Patient;
import ma.emsi.Hospital.entities.RendezVous;

public interface IHospitalService {
    Patient addPatient(Patient p);
    Medecin addMedecin(Medecin m);
    RendezVous addRendezVous(RendezVous rv);
    Consultation addConsultation(Consultation cl);
}
