package ma.fsr.tp1.cabinetmedical.controller;

import ma.fsr.tp1.cabinetmedical.entity.Patient;
import ma.fsr.tp1.cabinetmedical.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/patients")
public class PatientController {
    public final PatientService  patientService;
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<Patient> getAll() {
        return patientService.getAll();
    }

    @GetMapping("/{id}")
        public Patient getPatientsById(@PathVariable Long id){
            return patientService.getPatientById(id) ;
        }

    @GetMapping("/ByName")
        public List<Patient> getPatientsByname(@RequestParam String nom){
            return patientService.searchPatientByNom(nom) ;
    }

    @PostMapping
        public Patient addPatient(@RequestBody Patient patient) throws Exception {
           return patientService.createPatient(patient) ;
    }
    @PutMapping
        public Patient updatePatient(@RequestBody Patient patient) throws Exception {
            return patientService.updatePatient(patient) ;
    }

    @DeleteMapping
        public void deletePatient(@RequestBody Patient patient) throws Exception {
            patientService.deletePatient(patient) ;
    }

    }
