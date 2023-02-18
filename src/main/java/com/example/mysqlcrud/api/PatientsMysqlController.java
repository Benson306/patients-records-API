package com.example.mysqlcrud.api;

import com.example.mysqlcrud.model.Patients;
import com.example.mysqlcrud.services.PatientsMySqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v2/patients")
public class PatientsMysqlController {
    @Autowired
    private PatientsMySqlService patientsMySqlService;

    @GetMapping
    public List<Patients> getPatients(){
        return patientsMySqlService.getPatients();
    }
    @GetMapping(value = "/id/{patientId}")
    public Patients getPatientById(@PathVariable("patientId") int patientId){
        return patientsMySqlService.getPatientById(patientId);
    }

    @GetMapping(value = "/name/{name}")
    public Patients getPatientByName(@PathVariable("name") String patientName){
        return patientsMySqlService.getPatientByName(patientName);
    }

    @PostMapping(value = "/add")
    public Patients addPatients(@RequestBody Patients patient){
        return patientsMySqlService.savePatient(patient);
    }
    @DeleteMapping(value = "/delete/{id}")
    public String deletePatient(@PathVariable("id") int id){
        return patientsMySqlService.deletePatient(id);
    }

    @PutMapping(value = "/edit/{id}")
    public String updatePatient(@PathVariable int id,@RequestBody Patients patient){
        return patientsMySqlService.updatePatient(id,patient);
    }



}
