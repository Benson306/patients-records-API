package com.example.mysqlcrud.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "patients")
public class Patients {
    @Id
    @GeneratedValue

    @JsonProperty("id")
    private int id;
    @JsonProperty("fullName")
    private String fullName;
    @JsonProperty("YOB")
    private int yob;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYOB() {
        return yob;
    }

    public void setYOB(int YOB) {
        this.yob = YOB;
    }
}
