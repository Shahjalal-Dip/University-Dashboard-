package repositories;
import java.lang.*;
import entities.*;
import interfaces.*;

public class UserRepo implements IUserRepo
{
    private String file="repositories/data/users.txt";
    private FileIO fio=new FileIO();
    public void addUser(User u)
    {
        User usrs[]=this.getAllUser();
        for(int i=0;i<100;i++)
        {
            if(usrs[i]==null)
            {
                usrs[i]=u;
                break;
            }
        }

        String data[]=new String[100];

        for(int i=0;i<100;i++)
        {
            if(usrs[i]!=null)
            {
                data[i]=usrs[i].toStringUser();
            }
        }

        fio.writeFile(this.file,data);
    }

    public void updateUser(User u)
    {
        User usr=this.searchUser(u.getUserId());
        if(usr!=null)
        {
            this.deleteUser(u.getUserId());
            this.addUser(u);
        }
        else
        {
            System.out.println("Not Found");
        }
    }
    public void deleteUser(String id)
    {
        User usrs[]=this.getAllUser();

        for(int i=0;i<100;i++)
        {
            if(usrs[i]!=null)
            {
                if(usrs[i].getUserId().equals(id))
                {
                    usrs[i]=null;
                }
            }
        }

        String data[]=new String[100];

        for(int i=0;i<100;i++)
        {
            if(usrs[i]!=null)
            {
                data[i]=usrs[i].toStringUser();
            }
        }

        fio.writeFile(this.file,data);
    }
    public User searchUser(String id)
    {
        User usrs[]=this.getAllUser();

        for(int i=0;i<100;i++)
        {
            if(usrs[i]!=null)
            {
                if(usrs[i].getUserId().equals(id))
                {
                    return usrs[i];
                }
            }
        }

        return null;
    }
    public User[] getAllUser()
    {
        String data[]=fio.readFile(this.file);
        User usrs[]=new User[100];
        User usr=new User();

        for(int i=0;i<usrs.length;i++)
        {
            if(usrs[i]==null)
            {
                if(data[i]!=null)
                {
                    usrs[i]=usr.formUser(data[i]);
                }

            }
        }

        return usrs;
    }
}
