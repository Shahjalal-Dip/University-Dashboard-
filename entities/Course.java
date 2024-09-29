package entities;
import java.lang.*;
public class Course  {
    private String code,name,pre;
    private int credit;

    public Course(){

    }
    public Course(String code,String name,int credit,String pre){
        this.code=code;
        this.name=name;
        this.credit=credit;
        this.pre=pre;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPre() {
        return pre;
    }

    public void setPre(String pre) {
        this.pre = pre;
    }
    public String toStringCourse(){
        String data=this.code+","+this.name+","+this.credit+","+this.pre+"\n";
        return data;
    }
    public Course formCourse(String str)
    {
        String[] data=str.split(",");
        Course crs=new Course();
        crs.setCode(data[0]);
        crs.setName(data[1]);
        crs.setCredit(Integer.parseInt(data[2]));
        crs.setPre(data[3]);
        return crs;
    }
}
