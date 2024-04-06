package ma.emsi.Hospital.web;

import ma.emsi.Hospital.Repository.PatientRepository;
import ma.emsi.Hospital.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class PatientRestController {
    @Autowired
    private PatientRepository patientRepository;
    @GetMapping("/patient")
    public List<Patient> patientList(){
        return patientRepository.findAll();
    }
}
