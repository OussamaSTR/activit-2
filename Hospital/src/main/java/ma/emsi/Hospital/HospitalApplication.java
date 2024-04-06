package ma.emsi.Hospital;

import ma.emsi.Hospital.Repository.ConsultationRepository;
import ma.emsi.Hospital.Repository.MedecinRepository;
import ma.emsi.Hospital.Repository.PatientRepository;
import ma.emsi.Hospital.Repository.RendezVousRepository;
import ma.emsi.Hospital.Services.IHospitalService;
import ma.emsi.Hospital.entities.Consultation;
import ma.emsi.Hospital.entities.Medecin;
import ma.emsi.Hospital.entities.Patient;
import ma.emsi.Hospital.entities.RendezVous;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import  java.util.*;
import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

	public static void main(String[] args) {

		SpringApplication.run(HospitalApplication.class, args);
	}
	@Bean
     CommandLineRunner start(IHospitalService iHospitalService,
							 MedecinRepository medecinRepository,
							 PatientRepository patientRepository,
							 RendezVousRepository rendezVousRepository,
							 ConsultationRepository consultationRepository) {
		return args -> {
			Stream.of("Ahmed", "Yassine", "Karim").forEach(name -> {
				Patient p = new Patient();
				p.setNom(name);
				p.setDn(new Date());
				p.setMalade(false);
				iHospitalService.addPatient(p);
			});
			Stream.of("Wahid", "Said", "Youssuf").forEach(name -> {
				Medecin m = new Medecin();
				m.setNom(name);
				m.setEmail(name+"@gmail.com");
				m.setSp(Math.random() > 1 ? "Genicologue" : "Cardio");
				iHospitalService.addMedecin(m);

			});
			List<Medecin> ml = medecinRepository.findBySp("Cardio");
			Patient p=patientRepository.findById(2L).get();
			Medecin m=medecinRepository.findById(3L).get();


			RendezVous rv= new RendezVous();
			rv.setP(p);
			rv.setM(m);
			rv.setDate(new Date());
			rendezVousRepository.save(rv);
			RendezVous r =rendezVousRepository.findById(1L).get();

			Consultation cl = new Consultation();
			cl.setDatedecons(new Date());
			cl.setRv(r);
			cl.setRapp("Rapport 1");
			consultationRepository.save(cl);

		};
	}
}
