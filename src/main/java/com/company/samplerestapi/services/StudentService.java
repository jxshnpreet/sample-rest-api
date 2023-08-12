package com.company.samplerestapi.services;

import com.company.samplerestapi.model.Student;
import com.company.samplerestapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService
{
    @Autowired
    private StudentRepository studentRepository;
//    Singleton --> Hard-Coded Data
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
//        return students;
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(student -> students.add(student));
        return students;
    }
    //Optional :- if the condition matches then it will return with the object else it'll return null
    public Optional<Student> getStudentInfo(String r_no) {
//       return students.stream().filter(s -> s.getR_no().equals(r_no)).findFirst().get();
        return studentRepository.findById(r_no);
    }

    public void addStudent(Student student) {
//        students.add(student);
        studentRepository.save(student);
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

    public Optional<Student> deleteStudent(String r_no) {
        Optional<Student> student = studentRepository.findById(r_no);
        studentRepository.deleteById(r_no);
        return student;
    }
}
