package frames;
import entities.*;
import repositories.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SignUpFrame extends JFrame implements ActionListener {
    private JLabel signUpLB, firstLB, nameLB, ageLB, emailLB, genderLB, dpLB, phnnumLB, passLB, typeLB, addressLB, datebLB, rcodeLB;
    private JTextField firstTF, nameTF, ageTF, emailTF, phnnumTF, addressTF, datebTF, rcodeTF;
    private JPasswordField passPF;
    private JButton subBtn, exitBtn;
    private JRadioButton maleRB, femaleRB;
    private ButtonGroup genderBG;
    private JComboBox dpCB,tyCB;
    private JPanel panel;


    public SignUpFrame() {
        super("Sign Up Page");
        this.setSize(600, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        this.panel = new JPanel();

        this.panel.setBackground(Color.GREEN);
        this.panel.setLayout(null);
        this.add(this.panel);

        this.signUpLB = new JLabel("Sign Up Here");
        this.signUpLB.setBounds(220, 20, 100, 30);
        this.panel.add(signUpLB);

        this.firstLB = new JLabel("User Id:  ");
        this.firstLB.setBounds(80, 70, 170, 30);
        this.panel.add(firstLB);

        this.firstTF = new JTextField();
        this.firstTF.setBounds(260, 70, 170, 30);
        this.panel.add(firstTF);

        this.nameLB = new JLabel("Enter Your First Name:");
        this.nameLB.setBounds(80, 105, 170, 30);
        this.panel.add(nameLB);

        this.nameTF = new JTextField();
        this.nameTF.setBounds(260, 105, 170, 30);
        this.panel.add(nameTF);

        this.ageLB = new JLabel("Enter Your Age:");
        this.ageLB.setBounds(80, 140, 200, 30);
        this.panel.add(ageLB);

        this.ageTF = new JTextField();
        this.ageTF.setBounds(260, 140, 170, 30);
        this.panel.add(ageTF);

        this.emailLB = new JLabel("Enter Your Email:");
        this.emailLB.setBounds(80, 175, 170, 30);
        this.panel.add(emailLB);

        this.emailTF = new JTextField();
        this.emailTF.setBounds(260, 175, 170, 30);
        this.panel.add(emailTF);

        this.phnnumLB = new JLabel("Enter Your Phone Number:");
        this.phnnumLB.setBounds(80, 210, 170, 30);
        this.panel.add(phnnumLB);

        this.phnnumTF = new JTextField();
        this.phnnumTF.setBounds(260, 210, 170, 30);
        this.panel.add(phnnumTF);

        this.addressLB = new JLabel("Enter Your Current Address:");
        this.addressLB.setBounds(80, 245, 170, 30);
        this.panel.add(addressLB);

        this.addressTF = new JTextField();
        this.addressTF.setBounds(260, 245, 170, 30);
        this.panel.add(addressTF);

        this.datebLB = new JLabel("Enter Your Date Of Birth:");
        this.datebLB.setBounds(80, 280, 170, 30);
        this.panel.add(datebLB);

        this.datebTF = new JTextField();
        this.datebTF.setBounds(260, 280, 170, 30);
        this.panel.add(datebTF);

        this.genderLB = new JLabel("Select Your Gender:");
        this.genderLB.setBounds(80, 315, 150, 20);
        this.panel.add(genderLB);

        this.maleRB = new JRadioButton("Male");
        this.maleRB.setBackground(Color.GREEN);
        this.maleRB.setBounds(260, 315, 90, 20);
        this.panel.add(maleRB);

        this.femaleRB = new JRadioButton("Female");
        this.femaleRB.setBackground(Color.GREEN);
        this.femaleRB.setBounds(360, 315, 90, 20);
        this.panel.add(femaleRB);

        this.genderBG = new ButtonGroup();
        this.genderBG.add(maleRB);
        this.genderBG.add(femaleRB);

        this.dpLB = new JLabel("Your Country:");
        this.dpLB.setBounds(80, 350, 100, 20);
        this.panel.add(dpLB);

        String item[] = {"BANGLADESH", "RUSSIA", "USA", "CHINA", "INDIA"};
        this.dpCB = new JComboBox(item);
        this.dpCB.setBounds(260, 350, 170, 30);
        this.panel.add(dpCB);

        this.passLB = new JLabel("Choose A Strong Password:");
        this.passLB.setBounds(80, 390, 170, 30);
        this.panel.add(passLB);

        this.passPF = new JPasswordField();
        this.passPF.setBounds(260, 390, 170, 30);
        this.panel.add(passPF);

        this.typeLB = new JLabel("Sign Up Type:");
        this.typeLB.setBounds(80, 430, 150, 30);
        this.panel.add(typeLB);

        String type[] = {"Student","Faculty","Admin"};
        this.tyCB = new JComboBox(type);
        this.tyCB.setBounds(260, 430, 170, 30);
        this.panel.add(tyCB);

        this.rcodeLB = new JLabel("Enter Security Code(Optional):");
        this.rcodeLB.setBounds(80, 470, 190, 30);
        this.panel.add(rcodeLB);

        this.rcodeTF = new JTextField();
        this.rcodeTF.setBounds(260, 470, 170, 30);
        this.panel.add(rcodeTF);

        this.subBtn = new JButton("Submit");
        this.subBtn.setBounds(180, 580, 90, 30);
        this.subBtn.addActionListener(this);
        this.panel.add(subBtn);

        this.exitBtn = new JButton("Back");
        this.exitBtn.setBounds(290, 580, 90, 30);
        this.exitBtn.addActionListener(this);
        this.panel.add(exitBtn);

        UserRepo urp = new UserRepo();
        Random rn = new Random();
        while(true) {
            String []a=new String[3];
            for(int i=0;i<3;i++) {
                a[i] = String.valueOf(rn.nextInt(9));
            }
            String id =a[0] + a[1] + a[2];
            User user = urp.searchUser(id);
            if(user==null){
                firstTF.setText(id);
                break;
            }
        }

    }

    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        if (command.equals(subBtn.getText())) {
            if(tyCB.getSelectedItem().toString().equals("Student")){
            String userId, name, department,session,email, phoneNo, gender, address, securityAns, pass;
            int age;
            if ((!firstTF.getText().isEmpty())&&(!ageTF.getText().isEmpty()) && (!nameTF.getText().isEmpty()) && (!emailTF.getText().isEmpty()) && (!phnnumTF.getText().isEmpty()) && ((maleRB.isSelected()) || (femaleRB.isSelected())) && (!ageTF.getText().isEmpty()) && (!addressTF.getText().isEmpty()) && (!rcodeTF.getText().isEmpty()) && (!String.valueOf(passPF.getPassword()).isEmpty())) {
     
                    try
                    {
						userId = firstTF.getText();
                        name=nameTF.getText();
                        email=emailTF.getText();

                        phoneNo=phnnumTF.getText();

                        if(maleRB.isSelected()){
                            gender=maleRB.getText();
                        }

                        else if(femaleRB.isSelected()){
                            gender=femaleRB.getText();
                        }
                        else{
                            gender=maleRB.getText();
                        }

                        age=Integer.parseInt(ageTF.getText());
                        address=addressTF.getText();
                        int role=3;
                        securityAns=rcodeTF.getText();
                        pass=String.valueOf(passPF.getPassword());
                        department = "N/A";
                        session="24-25";
                        Student s=new Student(userId,name,department,session,email,phoneNo,gender,age,address,role,securityAns,pass,0,0.0f);
                        UserRepo urp = new UserRepo();
						urp.addUser(s);
                        StudentRepo srp=new StudentRepo();
                        srp.addStudent(s);
                        JOptionPane.showMessageDialog(this,"student signed up Successfully");
                    }
                    catch(Exception e)
                    {
                        JOptionPane.showMessageDialog(this,"provide valid age");
                    }
            }
            else {
                JOptionPane.showMessageDialog(this,"please fill up all the field properly");
            }

            }
			 if(tyCB.getSelectedItem().toString().equals("Faculty")){
                    String userId, name, email, phoneNo, gender, address, securityAns, pass,birth,NID;
                    int age;
                    if ((!firstTF.getText().isEmpty())&&(!ageTF.getText().isEmpty()) && (!nameTF.getText().isEmpty()) && (!emailTF.getText().isEmpty()) && (!phnnumTF.getText().isEmpty()) && ((maleRB.isSelected()) || (femaleRB.isSelected())) && (!ageTF.getText().isEmpty()) && (!addressTF.getText().isEmpty()) && (!rcodeTF.getText().isEmpty()) && (!String.valueOf(passPF.getPassword()).isEmpty())) {
                        
                        try
                        {
                            userId = firstTF.getText();
                            name=nameTF.getText();
                            email=emailTF.getText();

                            phoneNo=phnnumTF.getText();

                            if(maleRB.isSelected()){
                                gender=maleRB.getText();
                            }

                            else if(femaleRB.isSelected()){
                                gender=femaleRB.getText();
                            }
                            else{
                                gender=maleRB.getText();
                            }

                            age=Integer.parseInt(ageTF.getText());
                            address=addressTF.getText();
                            int role=2;
                            securityAns=rcodeTF.getText();
                            pass=String.valueOf(passPF.getPassword());
                            birth=datebTF.getText();
                            NID="N/A";
                            Faculty s=new Faculty(userId,name,email,phoneNo,gender,age,address,role,securityAns,pass,birth,NID);
                            UserRepo urp = new UserRepo();
                            urp.addUser(s);
                            FacultyRepo srp=new FacultyRepo();
                            srp.addFaculty(s);
                            JOptionPane.showMessageDialog(this,"Faculty signed up Successfully");
                        }
                        catch(Exception e)
                        {
                            JOptionPane.showMessageDialog(this,"provide valid age");
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(this,"please fill up all the field properly");
                    }

                }
            if(tyCB.getSelectedItem().toString().equals("Admin")){
                String userId, name, email, phoneNo, gender, address, securityAns, pass,birth,NID,adminTy;
                int age;
                if ((!firstTF.getText().isEmpty())&&(!ageTF.getText().isEmpty()) && (!nameTF.getText().isEmpty()) && (!emailTF.getText().isEmpty()) && (!phnnumTF.getText().isEmpty()) && ((maleRB.isSelected()) || (femaleRB.isSelected())) && (!ageTF.getText().isEmpty()) && (!addressTF.getText().isEmpty()) && (!rcodeTF.getText().isEmpty()) && (!String.valueOf(passPF.getPassword()).isEmpty())) {

                    try
                    {
                        userId = firstTF.getText();
                        name=nameTF.getText();
                        email=emailTF.getText();

                        phoneNo=phnnumTF.getText();

                        if(maleRB.isSelected()){
                            gender=maleRB.getText();
                        }

                        else if(femaleRB.isSelected()){
                            gender=femaleRB.getText();
                        }
                        else{
                            gender=maleRB.getText();
                        }

                        age=Integer.parseInt(ageTF.getText());
                        address=addressTF.getText();
                        int role=1;
                        securityAns=rcodeTF.getText();
                        pass=String.valueOf(passPF.getPassword());
                        birth=datebTF.getText();
                        NID="N/A";
                        adminTy="N/A";
                        Admin s=new Admin(userId,name,email,phoneNo,gender,age,address,role,securityAns,pass,adminTy,birth,NID);
                        UserRepo urp = new UserRepo();
                        urp.addUser(s);
                        AdminRepo arp=new AdminRepo();
                        arp.addAdmin(s);
                        JOptionPane.showMessageDialog(this,"Admin signed up Successfully");
                    }
                    catch(Exception e)
                    {
                        JOptionPane.showMessageDialog(this,"provide valid age");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(this,"please fill up all the field properly");
                }

            }
        }
		if (command.equals(exitBtn.getText())) {
			LoginFrame frame =  new LoginFrame();
			frame.setVisible(true);
			this.dispose();
		}
    }
    }


