package repositories;
import java.lang.*;
import entities.*;
import interfaces.*;

public class CourseRepo implements ICourseRepo
{
    private String file="repositories/data/courses.txt";
    private FileIO fio=new FileIO();
    public void addCourse(Course c)
    {
        Course crs[]=this.getAllCourse();
        for(int i=0;i<100;i++)
        {
            if(crs[i]==null)
            {
                crs[i]=c;
                break;
            }
        }

        String data[]=new String[100];

        for(int i=0;i<100;i++)
        {
            if(crs[i]!=null)
            {
                data[i]=crs[i].toStringCourse();
            }
        }

        fio.writeFile(this.file,data);
    }
    public void updateCourse(Course c)
    {
        Course crs=this.searchCourse(c.getCode());
        if(crs!=null)
        {
            this.deleteCourse(c.getCode());
            this.addCourse(c);
        }
        else
        {
            System.out.println("Not Found");
        }
    }
    public void deleteCourse(String code)
    {
        Course []crs=this.getAllCourse();

        for(int i=0;i<100;i++)
        {
            if(crs[i]!=null)
            {
                if(crs[i].getCode().equals(code))
                {
                    crs[i]=null;
                }
            }
        }

        String data[]=new String[100];

        for(int i=0;i<100;i++) {
            if(crs[i]!=null) {
                data[i]=crs[i].toStringCourse();
            }
        }
        fio.writeFile(this.file,data);
    }
    public Course searchCourse(String code)
    {
        Course crs[]=this.getAllCourse();
        for(int i=0;i<100;i++) {
            if(crs[i]!=null) {
                if(crs[i].getCode().equals(code))
                {
                    return crs[i];
                }
            }
        }
        return null;
    }
    public Course[] getAllCourse()
    {
        String data[]=fio.readFile(this.file);
        Course crs[]=new Course[100];
        Course cr=new Course();

        for(int i=0;i<crs.length;i++) {
            if(crs[i]==null) {
                if(data[i]!=null) {
                    crs[i]=cr.formCourse(data[i]);
                }
            }
        }
        return crs;
    }
}
