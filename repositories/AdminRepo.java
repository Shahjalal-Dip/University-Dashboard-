package repositories;
import java.lang.*;
import entities.*;
import interfaces.*;

public class AdminRepo implements IAdminRepo
{
    private String file="repositories/data/admins.txt";
    private FileIO fio=new FileIO();
    public void addAdmin(Admin a)
    {
        Admin adms[]=this.getAllAdmin();
        for(int i=0;i<100;i++)
        {
            if(adms[i]==null)
            {
                adms[i]=a;
                break;
            }
        }

        String data[]=new String[100];

        for(int i=0;i<100;i++)
        {
            if(adms[i]!=null)
            {
                data[i]=adms[i].toStringAdmin();
            }
        }

        fio.writeFile(this.file,data);
    }

    public void updateAdmin(Admin a)
    {
        Admin adm=this.searchAdmin(a.getUserId());
        if(adm!=null)
        {
            this.deleteAdmin(a.getUserId());
            this.addAdmin(a);
        }
        else
        {
            System.out.println("Not Found");
        }
    }
    public void deleteAdmin(String id)
    {
        Admin adms[]=this.getAllAdmin();

        for(int i=0;i<100;i++)
        {
            if(adms[i]!=null)
            {
                if(adms[i].getUserId().equals(id))
                {
                    adms[i]=null;
                }
            }
        }

        String data[]=new String[100];

        for(int i=0;i<100;i++)
        {
            if(adms[i]!=null)
            {
                data[i]=adms[i].toStringAdmin();
            }
        }

        fio.writeFile(this.file,data);
    }
    public Admin searchAdmin(String id)
    {
        Admin adms[]=this.getAllAdmin();

        for(int i=0;i<100;i++)
        {
            if(adms[i]!=null)
            {
                if(adms[i].getUserId().equals(id))
                {
                    return adms[i];
                }
            }
        }

        return null;
    }
    public Admin[] getAllAdmin()
    {
        String data[]=fio.readFile(this.file);
        Admin adms[]=new Admin[100];
        Admin adm=new Admin();

        for(int i=0;i<adms.length;i++)
        {
            if(adms[i]==null)
            {
                if(data[i]!=null)
                {
                    adms[i]=adm.formAdmin(data[i]);
                }

            }
        }

        return adms;
    }
}
