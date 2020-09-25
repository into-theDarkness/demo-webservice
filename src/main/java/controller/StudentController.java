package controller;


import model.Student;
import repository.StudentRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;


@Path("/getStudent")
public class StudentController {
    StudentRepository StudentRepository = new StudentRepository();
    @GET
    @Produces("application/json")
    public List<Student> getStudent(){
       List<Student> students = StudentRepository.getAllStudent();
       return students;
    }

}
