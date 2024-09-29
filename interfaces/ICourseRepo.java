package interfaces;
import java.lang.*;
import entities.*;

 public interface ICourseRepo
{
    public void addCourse(Course s);
    public void updateCourse(Course s);
    public void deleteCourse(String code);
    public Course searchCourse(String id);
    public Course[] getAllCourse();
}
