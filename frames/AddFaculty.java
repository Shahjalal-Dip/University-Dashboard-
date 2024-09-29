package frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import entities.*;
import repositories.*;
public class AddFaculty extends JFrame implements ActionListener
{
    private JLabel userIdLabel,nameLabel,DoBLabel,phoneNoLabel,emailIdLabel,genderLabel,nidNoLabel,ageLB,addLB;
    private JTextField userIdTF,nameTF,DoBTF,phoneNoTF,emailIdTF,nidNoTF,ageTF,addTF;
    private JRadioButton maleRB,femaleRB;
    private ButtonGroup BG;
    private JButton saveBtn,backBtn;
    private JPanel panel;
    private User u;
    public AddFaculty(User u)
    {
        super("Add Faculty Frame");
        this.setSize(500,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		this.u=u;
		
        this.panel=new JPanel();
        this.panel.setBackground(Color.ORANGE);
        this.panel.setLayout(null);

        this.userIdLabel=new JLabel("User Id :");
        this.userIdLabel.setBounds(60,60,70,30);
        this.panel.add(userIdLabel);

        this.userIdTF=new JTextField();
        this.userIdTF.setBounds(120,60,170,30);
        this.panel.add(userIdTF);


        this.nameLabel=new JLabel("Faculty Name:");
        this.nameLabel.setBounds(20,110,90,30);
        this.panel.add(nameLabel);

        this.nameTF=new JTextField();
        this.nameTF.setBounds(120,110,170,30);
        this.panel.add(nameTF);

        this.DoBLabel=new JLabel("Date Of Birth:");
        this.DoBLabel.setBounds(29,160,80,30);
        this.panel.add(DoBLabel);

        this.DoBTF=new JTextField();
        this.DoBTF.setBounds(120,160,170,30);
        this.panel.add(DoBTF);

        this.nidNoLabel=new JLabel("NID No :");
        this.nidNoLabel.setBounds(62,210,70,30);
        this.panel.add(nidNoLabel);

        this.nidNoTF=new JTextField();
        this.nidNoTF.setBounds(120,210,170,30);
        this.panel.add(nidNoTF);

        this.phoneNoLabel=new JLabel("Phone No :");
        this.phoneNoLabel.setBounds(48,260,70,30);
        this.panel.add(phoneNoLabel);

        this.phoneNoTF=new JTextField();
        this.phoneNoTF.setBounds(120,260,170,30);
        this.panel.add(phoneNoTF);

        this.emailIdLabel=new JLabel("Email Id :");
        this.emailIdLabel.setBounds(55,310,70,30);
        this.panel.add(emailIdLabel);

        this.emailIdTF=new JTextField();
        this.emailIdTF.setBounds(120,310,170,30);
        this.panel.add(emailIdTF);

        this.genderLabel=new JLabel("Gender :");
        this.genderLabel.setBounds(55,360,70,30);
        this.panel.add(genderLabel);

        this.maleRB=new JRadioButton("Male");
        this.maleRB.setBounds(120,360,70,30);
        this.maleRB.setBackground(Color.ORANGE);
        this.panel.add(maleRB);

        this.femaleRB=new JRadioButton("Female");
        this.femaleRB.setBounds(190,360,70,30);
        this.femaleRB.setBackground(Color.ORANGE);
        this.panel.add(femaleRB);

        this.BG=new ButtonGroup();
        this.BG.add(maleRB);
        this.BG.add(femaleRB);

        this.ageLB=new JLabel("Age :");
        this.ageLB.setBounds(55,410,70,30);
        this.panel.add(ageLB);

        this.ageTF=new JTextField();
        this.ageTF.setBounds(120,410,170,30);
        this.panel.add(ageTF);

        this.addLB=new JLabel("Address :");
        this.addLB.setBounds(55,460,70,30);
        this.panel.add(addLB);

        this.addTF=new JTextField();
        this.addTF.setBounds(120,460,170,30);
        this.panel.add(addTF);

        this.saveBtn=new JButton("Save");
        this.saveBtn.setBounds(60,510,80,30);
        this.saveBtn.setBackground(Color.BLUE);
        this.saveBtn.addActionListener(this);
        this.panel.add(saveBtn);

        this.backBtn=new JButton("Back");
        this.backBtn.setBounds(160,510,80,30);
        this.backBtn.setBackground(Color.BLUE);
        this.backBtn.addActionListener(this);
        this.panel.add(backBtn);


        this.add(this.panel);
    }

    public void actionPerformed(ActionEvent ae)
    {
        String command=ae.getActionCommand();
        if(saveBtn.getText().equals(command))
        {
			Faculty st = new Faculty();
            st.setUserId(userIdTF.getText());
            st.setName(nameTF.getText());
            st.setEmail(emailIdTF.getText());
            st.setPhoneNo(phoneNoTF.getText());
            st.setAge(Integer.parseInt(ageTF.getText()));
            st.setAddress(addTF.getText());
            st.setBirth(DoBTF.getText());
            st.setNID(nidNoTF.getText());
            if(maleRB.isSelected()){
                st.setGender(maleRB.getText());
            }else{
                st.setGender(femaleRB.getText());
            }
            FacultyRepo sre = new FacultyRepo();
            sre.addFaculty(st);
            
            JOptionPane.showMessageDialog(this,"Faculty Added");
        }
        if(backBtn.getText().equals(command))
        {
           AdminDashboard f = new AdminDashboard(u);
		   f.setVisible(true);
		   this.dispose();
        }


    }
}