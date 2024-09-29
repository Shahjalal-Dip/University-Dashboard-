package entities;
import java.lang.*;

public class Student extends User
{
    private int completedCredit;
    private float cgpa;
    private String department,session;

    public Student()
    {
        super();
    }

    public Student(String userId, String name, String department,String session,String email, String phoneNo, String gender,int age, String address, int role,String securityAns, String password, int completedCredit,float cgpa)
    {
        super(userId, name, email, phoneNo, gender, age, address, role, securityAns, password);
        this.completedCredit=completedCredit;
        this.cgpa=cgpa;
		this.department=department;
		this.session=session;
    }

    public void setCompletdCredit(int completedCredit)
    {
        this.completedCredit=completedCredit;
    }

    public void setCgpa(float cgpa)
    {
        this.cgpa=cgpa;
    }

    public void setDepartment(String department){
        this.department=department;
    }
    public void setSession(String session){
        this.session=session;
    }
    public int getCompletdCredit(){
        return this.completedCredit;
    }

    public float getCgpa(){
        return this.cgpa;
    }
    public String getDepartment(){
        return this.department;
    }
    public String getSession(){
        return this.session;
    }



    public String toStringStudent(){
        String str=this.userId+","+this.name+","+this.department+","+this.session+","+this.email+","+this.phoneNo+","+this.age+","+this.address+","+this.completedCredit+","+this.cgpa+","+this.gender+"\n";
        return str;
    }

    public Student formStudent(String str){
        String[] info=str.split(",");
        Student s=new Student();
        s.setUserId(info[0]);
        s.setName(info[1]);
        s.setDepartment(info[2]);
        s.setSession(info[3]);
        s.setEmail(info[4]);
        s.setPhoneNo(info[5]);
        s.setAge(Integer.parseInt(info[6]));
        s.setAddress(info[7]);
        s.setCompletdCredit(Integer.parseInt(info[8]));
        s.setCgpa(Float.parseFloat(info[9]));
        s.setGender(info[10]);

        return s;
    }


}