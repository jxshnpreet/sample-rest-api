package com.company.samplerestapi.Controller;

import com.company.samplerestapi.model.Student;
import com.company.samplerestapi.services.StudentService;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
//    Service Dependency - inject - DEPENDENCY INJECTION
//    IOC: Inversion of Control done with the help of dependency injection
//    ClassName objName = new Constructor()
    @Autowired
    StudentService studentService; //Not making object we're giving reference
//    Function which returns a list of Student as a response
    @RequestMapping(method = RequestMethod.GET, value = "/Students")
    public List<Student> getAllPersons(){
        return studentService.getAllStudents();
    }

//    Path variable take variable value from link while request body will take variable input from body

    @RequestMapping(method = RequestMethod.GET, value = "/Students/{r_no}")
    public Optional<Student> getStudentInfo(@PathVariable String r_no){
        return studentService.getStudentInfo(r_no);
    }
//    POST-localhost:8080/Students -> Enroll/Add a Student
//    Request body is converting json into object
    @RequestMapping(method = RequestMethod.POST, value = "/Students")
    public Student addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return student;
    }
//    PUT - localhost8080/Students/r_no -> Edit the info of the student whose r_no is passed
//    localhost:8080/Students/12345
    @RequestMapping(method = RequestMethod.PUT, value = "/Students/{r_no}")
    public Student editStudent(@PathVariable String r_no, @RequestBody Student student){
        studentService.editStudent(r_no, student);
        return student;
    }
//  DELETE :- Remove the student whose r_no is passed
    @RequestMapping(method = RequestMethod.DELETE, value = "/Students/{r_no}")
    public Optional<Student> deleteStudent(@PathVariable String r_no){
        return studentService.deleteStudent(r_no);
    }

}
