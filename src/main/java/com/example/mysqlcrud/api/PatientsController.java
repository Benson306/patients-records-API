package com.example.mysqlcrud.api;

import com.example.mysqlcrud.model.Patients;
import com.example.mysqlcrud.services.PatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/patients")
public class PatientsController {
    @Autowired
    private PatientsService patientsService;

    @PostMapping
    public Patients addPatient(@RequestBody Patients patient){
        return patientsService.addPatients(patient);
    }

    @GetMapping
    public List<Patients> getPatients(){
        return patientsService.getPatients();
    }

    @DeleteMapping(value = "/{patientId}")
    public void deletePatient(@PathVariable("patientId") int patientId){
        patientsService.deletePatient(patientId);
    }

    @PutMapping(value = "/{patientId}")
    public void updatePatient(@PathVariable("patientId") int patientId, @RequestBody Patients patient){
        patientsService.updatePatient(patientId, patient);
    }
}
