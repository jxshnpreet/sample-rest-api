package com.company.samplerestapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//POJO :- Plain Old Java Object
@Entity
@Table(name = "students")
public class Student {
    @Column(name = "name")
    private String name;
    @Column(name = "dept")
    private String dept;
    @Id
    @Column(name = "r_no")
    private String r_no;
    @Column(name = "stream")
    private String stream;
    public Student(){}

    public Student(String r_no, String name, String stream, String dept) {
        this.dept = dept;
        this.r_no = r_no;
        this.name = name;
        this.stream = stream;
    }

    public String getR_no() {
        return r_no;
    }

    public void setR_no(String r_no) {
        this.r_no = r_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }
}
