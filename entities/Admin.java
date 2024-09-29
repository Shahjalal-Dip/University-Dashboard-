package entities;
import java.lang.*;

public class Admin extends User
{
    private String birth,NID,adminTy;

    public Admin()
    {
        super();
    }

    public Admin(String userId, String name, String email, String phoneNo, String gender,int age, String address, int role,String securityAns, String password, String adminTy,String birth, String NID)
    {
        super(userId, name, email, phoneNo, gender, age, address, role, securityAns, password);
        this.adminTy=adminTy;
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
    public String getAdminTy() {
        return adminTy;
    }

    public void setAdminTy(String adminTy) {
        this.adminTy = adminTy;
    }

    public String toStringAdmin()
    {
        String str=this.userId+","+this.name+","+this.email+","+this.phoneNo+","+this.gender+","+this.age+","+this.address+","+this.birth+","+this.NID+","+this.adminTy+"\n";
        return str;
    }

    public Admin formAdmin(String str)
    {
        String[] info=str.split(",");
        Admin a=new Admin();
        a.setUserId(info[0]);
        a.setName(info[1]);
        a.setEmail(info[2]);
        a.setPhoneNo(info[3]);
        a.setGender(info[4]);
        a.setAge(Integer.parseInt(info[5]));
        a.setAddress(info[6]);
        a.setBirth(info[7]);
        a.setNID(info[8]);
        a.setAdminTy(info[9]);

        return a;
    }
}