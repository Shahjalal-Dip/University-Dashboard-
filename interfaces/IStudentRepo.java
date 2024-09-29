package interfaces;
import java.lang.*;
import entities.*;

public interface IStudentRepo
{
    public void addStudent(Student s);
    public void updateStudent(Student s);
    public void deleteStudent(String id);
    public Student searchStudent(String id);
    public Student[] getAllStudent();
}