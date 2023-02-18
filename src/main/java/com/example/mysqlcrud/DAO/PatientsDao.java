package com.example.mysqlcrud.DAO;

import com.example.mysqlcrud.model.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientsDao extends JpaRepository<Patients, Integer> {

    Patients findByFullName(String fullName);
}
