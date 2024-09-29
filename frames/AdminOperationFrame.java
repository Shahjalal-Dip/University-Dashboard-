package frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import entities.*;
import repositories.*;

public class AdminOperationFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel,nameLabel,DoBLabel,phoneNoLabel,emailIdLabel,genderLabel,nidNoLabel,comboLabel,ageLB,addLB;
	private JTextField userIdTF,nameTF,DoBTF,phoneNoTF,emailIdTF,nidNoTF,ageTF,addTF;
	private JRadioButton maleRB,femaleRB;
	private ButtonGroup BG;
	private JButton saveChangesBtn,backBtn,srcBtn;
	private JComboBox adCB;
	private JPanel panel;
	private User u;
	
	public AdminOperationFrame(User u)
	{
		super("Admin Operation Frame");
		this.setSize(500,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.u=u;
		
		this.panel=new JPanel();
		this.panel.setBackground(Color.YELLOW);
		this.panel.setLayout(null);
		
		this.userIdLabel=new JLabel("User Id :");
        this.userIdLabel.setBounds(80,60,70,30);
        this.panel.add(userIdLabel);

        this.userIdTF=new JTextField();
        this.userIdTF.setBounds(170,60,170,30);
        this.panel.add(userIdTF);

        this.nameLabel=new JLabel("Admin Name:");
        this.nameLabel.setBounds(80,110,80,20);
        this.panel.add(nameLabel);

        this.nameTF=new JTextField();
        this.nameTF.setBounds(170,110,170,30);
        this.panel.add(nameTF);

        this.DoBLabel=new JLabel("Date Of Birth:");
        this.DoBLabel.setBounds(80,150,100,30);
        this.panel.add(DoBLabel);

        this.DoBTF=new JTextField();
        this.DoBTF.setBounds(170,150,170,30);
        this.panel.add(DoBTF);

        this.nidNoLabel=new JLabel("NID No :");
        this.nidNoLabel.setBounds(80,200,70,30);
        this.panel.add(nidNoLabel);
		
		this.nidNoTF=new JTextField();
        this.nidNoTF.setBounds(170,200,170,30);
        this.panel.add(nidNoTF);

        this.ageLB=new JLabel("Age :");
        this.ageLB.setBounds(80,250,70,30);
        this.panel.add(ageLB);

        this.ageTF=new JTextField();
        this.ageTF.setBounds(170,250,170,30);
        this.panel.add(ageTF);

        this.addLB=new JLabel("Address :");
        this.addLB.setBounds(80,300,70,30);
        this.panel.add(addLB);

        this.addTF=new JTextField();
        this.addTF.setBounds(170,300,170,30);
        this.panel.add(addTF);

        this.phoneNoLabel=new JLabel("Phone No :");
        this.phoneNoLabel.setBounds(80,350,70,30);
        this.panel.add(phoneNoLabel);

        this.phoneNoTF=new JTextField();
        this.phoneNoTF.setBounds(170,350,170,30);
        this.panel.add(phoneNoTF);

        this.emailIdLabel=new JLabel("Email Id :");
        this.emailIdLabel.setBounds(80,400,70,30);
        this.panel.add(emailIdLabel);

        this.emailIdTF=new JTextField();
        this.emailIdTF.setBounds(170,400,170,30);
        this.panel.add(emailIdTF);

        this.genderLabel=new JLabel("Gender :");
        this.genderLabel.setBounds(80,450,70,30);
        this.panel.add(genderLabel);

        this.maleRB=new JRadioButton("Male");
        this.maleRB.setBackground(Color.YELLOW);
        this.maleRB.setBounds(170,450,70,30);
        this.panel.add(maleRB);

        this.femaleRB=new JRadioButton("Female");
        this.femaleRB.setBackground(Color.YELLOW);
        this.femaleRB.setBounds(250,450,70,30);
        this.panel.add(femaleRB);

        this.BG=new ButtonGroup();
        this.BG.add(maleRB);
        this.BG.add(femaleRB);
		
        this.saveChangesBtn=new JButton("Save");
        this.saveChangesBtn.setBounds(60,550,120,30);
		this.saveChangesBtn.addActionListener(this);
        this.panel.add(saveChangesBtn);

        this.backBtn=new JButton("Back");
        this.backBtn.setBounds(300,550,80,30);
		this.backBtn.addActionListener(this);
        this.panel.add(backBtn);
		
		this.srcBtn=new JButton("Search");
		this.srcBtn.setBounds(200,550,80,30);
		this.srcBtn.addActionListener(this);
		this.panel.add(srcBtn);
		
		this.comboLabel=new JLabel("Enter Type Of Admin:");
        this.comboLabel.setBounds(80,500,170,30);
        this.panel.add(comboLabel);

        String item[]={"Academic Admin","Registrar Admin","IT Admin"};
        this.adCB=new JComboBox(item);
        this.adCB.setBounds(250,500,170,30);
        this.panel.add(adCB);
		
		
		this.add(this.panel);
	}
     public void actionPerformed(ActionEvent e)
    {
		 if (e.getSource() == saveChangesBtn) {
			 if (userIdTF.getText() != null) {
                Admin st = new Admin();
                st.setUserId(userIdTF.getText());
                st.setName(nameTF.getText());
                st.setEmail(emailIdTF.getText());
                st.setPhoneNo(phoneNoTF.getText());
                st.setAge(Integer.parseInt(ageTF.getText()));
                st.setAddress(addTF.getText());
				st.setBirth(DoBTF.getText());
				st.setAdminTy(adCB.getSelectedItem().toString());
				st.setNID(addTF.getText());
                
                if (maleRB.isSelected()) {
                    st.setGender(maleRB.getText());
                } else {
                    st.setGender(femaleRB.getText());
                }
                AdminRepo sre = new AdminRepo();
                sre.updateAdmin(st);
                JOptionPane.showMessageDialog(this,"Update Information Successfully");
            }else{
                JOptionPane.showMessageDialog(this,"Invalid User ID");
            }
        } 
	 
	    if (e.getSource() == srcBtn) {
            if (userIdTF.getText() != null) {
                AdminRepo sre = new AdminRepo();
                Admin st = sre.searchAdmin(userIdTF.getText());

                userIdTF.setText(st.getUserId());
                nameTF.setText(st.getName());
                emailIdTF.setText(st.getEmail());
                phoneNoTF.setText(st.getPhoneNo());
                ageTF.setText(String.valueOf(st.getAge()));
                addTF.setText(st.getAddress());
                DoBTF.setText(st.getBirth());
				nidNoTF.setText(st.getNID());
				adCB.setSelectedItem(st.getAdminTy());
				
                if (st.getGender().equals("Male")) {
                    maleRB.setSelected(true);
                } else {
                    femaleRB.setSelected(true);
                }
                JOptionPane.showMessageDialog(this, "Successfully Search Information");
            } else if (userIdTF.getText() == null) {
                JOptionPane.showMessageDialog(this, "Invalid Student Id", "Error", JOptionPane.ERROR_MESSAGE);
            } 
		}
		if (e.getSource() == backBtn) {
			AdminDashboard f = new AdminDashboard(u);
			f.setVisible(true);
			this.dispose();
		}
	}
	}