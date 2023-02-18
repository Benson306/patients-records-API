package com.example.mysqlcrud.services;

import com.example.mysqlcrud.model.Patients;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class PatientsService {
    private List<Patients> PatientsList = new CopyOnWriteArrayList<>();
    private int patientsCount = 1;

    public Patients addPatients(Patients patient){
        patient.setId(patientsCount);
        PatientsList.add(patient);
        patientsCount++;

        return patient;
    }

    public List<Patients> getPatients(){
        return PatientsList;
    }

    public Patients getPatient(int patientId){
        return PatientsList
                .stream()
                .filter(p -> p.getId() == patientId)
                .findFirst()
                .get();
    }

    public Patients updatePatient(int patientId,Patients patient){
        PatientsList
                .stream()
                .forEach(p -> {
                    if(p.getId() == patientId){
                        p.setFullName(patient.getFullName());
                        p.setYOB(patient.getYOB());
                    }
                });
        return patient;
    };

    public void deletePatient(int patientId){
        PatientsList
                .stream()
                .forEach(p -> {
                    if(p.getId() == patientId){
                        PatientsList.remove(p);
                    }
                });
    }

}
