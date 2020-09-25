package repository;

import model.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    Connection connection = null;
    public StudentRepository(){
        String url = "jdbc:mysql://localhost:3306/tranminhduc";
        String userName = "root";
        String password = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, userName, password);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public List<Student> getAllStudent(){
        List<Student> students = new ArrayList<>();
        String sql = "select * from student";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                Student student = new Student();
                student.setId(rs.getLong(1));
                student.setName(rs.getString(2));
                student.setProvince(rs.getString(3));
                students.add(student);
            }
        } catch (Exception e){
            System.out.println(e);
        }
        return  students;
    }



}
