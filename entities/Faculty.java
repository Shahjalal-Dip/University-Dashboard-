package entities;
import java.lang.*;

public class Faculty extends User
{
    private String birth,NID;
    public Faculty()
    {
        super();
    }

    public Faculty(String userId, String name, String email, String phoneNo, String gender,int age, String address, int role,String securityAns, String password,String birth, String NID)
    {
        super(userId, name, email, phoneNo, gender, age, address, role, securityAns, password);
        this.birth=birth;
        this.NID=NID;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getNID() {
        return NID;
    }

    public void setNID(String NID) {
        this.NID = NID;
    }
    public String toStringFaculty()
    {
        String str=this.userId+","+this.name+","+this.email+","+this.phoneNo+","+this.gender+","+this.age+","+this.address+","+this.birth+","+this.NID+"\n";
        return str;
    }

    public Faculty formFaculty(String str)
    {
        String[] info=str.split(",");
        Faculty f=new Faculty();
        f.setUserId(info[0]);
        f.setName(info[1]);
        f.setEmail(info[2]);
        f.setPhoneNo(info[3]);
        f.setGender(info[4]);
        f.setAge(Integer.parseInt(info[5]));
        f.setAddress(info[6]);
        f.setBirth(info[7]);
        f.setNID(info[8]);
        return f;
    }

}