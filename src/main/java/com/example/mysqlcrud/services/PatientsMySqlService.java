package com.example.mysqlcrud.services;

import com.example.mysqlcrud.DAO.PatientsDao;
import com.example.mysqlcrud.model.Patients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PatientsMySqlService {
    @Autowired
    private PatientsDao patientsDao;

    public Patients savePatient(Patients patient){
        return patientsDao.save(patient);
    }

    public List<Patients> getPatients(){
        return patientsDao.findAll();
    }

    public Patients getPatientById(int patientId){
        return patientsDao.findById(patientId).orElse(null);
    }

    public Patients getPatientByName(String fullName){
        return patientsDao.findByFullName(fullName);
    }

    public String deletePatient(int patientsId){
        patientsDao.deleteById(patientsId);
        return "Patient Removed";
    }

    public String updatePatient(Patients patient){
        //get ID
        Patients existingPatient = patientsDao.findById(patient.getId()).orElse(null);
        existingPatient.setFullName(patient.getFullName());
        existingPatient.setYOB(patient.getYOB());

        patientsDao.save(existingPatient);

        return "Patient Updated";

    }
}
