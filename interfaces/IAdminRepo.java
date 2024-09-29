package interfaces;
import java.lang.*;
import entities.*;

public interface IAdminRepo
{
    public void addAdmin(Admin a);
    public void updateAdmin(Admin a);
    public void deleteAdmin(String id);
    public Admin searchAdmin(String id);
    public Admin[] getAllAdmin();
}