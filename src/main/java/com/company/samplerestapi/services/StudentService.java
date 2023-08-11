package com.company.samplerestapi.services;

import com.company.samplerestapi.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class StudentService
{
//    Dependency Injection - Auto-Wiring
//    This is a data fetched from the Database
    List<Student> students = new ArrayList<>(
        Arrays.asList(
                new Student("1","Student 1","CSE" ,"USET" ),
                new Student("2","Student 2","CSE" ,"USET" ),
                new Student("3","Student 3","BCA" ,"USET" ),
                new Student("4","Student 4","MCA" ,"USET" ),
                new Student("5","Student 5","MBBS" ,"Medical" )
        )
    );
    public List<Student> getAllStudents(){
        return students;
    }

    public Student getStudentInfo(String r_no) {
       return students.stream().filter(s -> s.getR_no().equals(r_no)).findFirst().get();
    }

    public void addStudent(Student student) {
        students.add(student);
    }
    public void editStudent(String r_no, Student updatedStudent) {
//        to check if the student is available in db or not
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            if (s.getR_no().equals(r_no)){
                students.set(i, updatedStudent);
            }
        }
    }
}
