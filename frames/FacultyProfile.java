package frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import entities.*;
import repositories.*;
public class FacultyProfile extends JFrame implements ActionListener
{
    private JLabel titleLB,userIdLabel,nameLabel,DoBLabel,phoneNoLabel,emailIdLabel,genderLabel,nidNoLabel,ageLB,addLB;
    private JButton backBtn;
    private JPanel panel;
    private Font f;
    private User u;
    public FacultyProfile(User u)
    {
        super("Faculty Profile");
        this.setBounds(300,40,500,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.u=u;

        this.panel=new JPanel();
        this.panel.setBackground(Color.PINK);
        this.panel.setLayout(null);
		
		FacultyRepo sre = new FacultyRepo();
        Faculty ft = sre.searchFaculty(u.getUserId());

        this.f = new Font("Arial", Font.ITALIC+Font.BOLD, 17);

        this.titleLB=new JLabel("Your Profile--");
        this.titleLB.setBounds(60,20,150,30);
        this.titleLB.setFont(f);
        this.panel.add(titleLB);

        this.userIdLabel=new JLabel("User Id :"+ft.getUserId());
        this.userIdLabel.setBounds(60,60,200,30);
        this.userIdLabel.setFont(f);
        this.panel.add(userIdLabel);

        this.nameLabel=new JLabel("Faculty Name:"+ft.getName());
        this.nameLabel.setBounds(60,110,200,30);
        this.nameLabel.setFont(f);
        this.panel.add(nameLabel);

        this.DoBLabel=new JLabel("Date Of Birth:"+ft.getBirth());
        this.DoBLabel.setBounds(60,160,200,30);
        this.DoBLabel.setFont(f);
        this.panel.add(DoBLabel);

        this.nidNoLabel=new JLabel("NID No :"+ft.getNID());
        this.nidNoLabel.setBounds(60,210,200,30);
        this.nidNoLabel.setFont(f);
        this.panel.add(nidNoLabel);

        this.phoneNoLabel=new JLabel("Phone No :"+ft.getPhoneNo());
        this.phoneNoLabel.setBounds(60,260,200,30);
        this.phoneNoLabel.setFont(f);
        this.panel.add(phoneNoLabel);

        this.emailIdLabel=new JLabel("Email Id :"+ft.getEmail());
        this.emailIdLabel.setBounds(60,310,300,30);
        this.emailIdLabel.setFont(f);
        this.panel.add(emailIdLabel);

        this.genderLabel=new JLabel("Gender :"+ft.getGender());
        this.genderLabel.setBounds(60,360,200,30);
        this.genderLabel.setFont(f);
        this.panel.add(genderLabel);

        this.ageLB=new JLabel("Age :"+ft.getAge());
        this.ageLB.setBounds(60,410,200,30);
        this.ageLB.setFont(f);
        this.panel.add(ageLB);

        this.addLB=new JLabel("Address :"+ft.getAddress());
        this.addLB.setBounds(55,460,200,30);
        this.addLB.setFont(f);
        this.panel.add(addLB);

        this.backBtn=new JButton("Back");
        this.backBtn.setBounds(160,510,120,30);
        this.backBtn.setBackground(Color.CYAN);
        this.backBtn.addActionListener(this);
        this.panel.add(backBtn);

        this.add(this.panel);
    }

    public void actionPerformed(ActionEvent ae)
    {
        String command=ae.getActionCommand();
        if(backBtn.getText().equals(command))
        {
            FacultyDashboard f = new FacultyDashboard(u);
            f.setVisible(true);
            this.dispose();
        }
    }
}