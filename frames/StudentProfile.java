package frames;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import entities.*;
import repositories.*;

public class StudentProfile extends JFrame implements ActionListener {
    private Container c;
    private JLabel jl, jl1, jl2, jl3, jl4, jl5, jl6, jl7, jl8, jl9, jl10;
    private JButton btn1;
    private Font f, f1;
    private Cursor cursor;
    User u;
    public StudentProfile(User u) {
		this.u=u;
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Profile");
        this.setBounds(600, 20, 470, 670);
        initComponents();
    }

    public void initComponents() {
        this.c = this.getContentPane();
        this.c.setLayout(null);
        this.c.setBackground(Color.GRAY);

        this.f = new Font("Arial", Font.ITALIC+Font.BOLD, 15);

        this.cursor = new Cursor(Cursor.HAND_CURSOR);
		
		StudentRepo sre = new StudentRepo();
        Student st = sre.searchStudent(u.getUserId());
		
        this.jl = new JLabel("Student ID : "+st.getUserId());
        this.jl.setBounds(40, 20, 250, 40);
        this.jl.setFont(f);
        this.c.add(jl);

        this.jl1 = new JLabel("Name : "+st.getName());
        this.jl1.setBounds(40, 70, 250, 40);
        this.jl1.setFont(f);
        this.c.add(jl1);

        this.jl2 = new JLabel("Department : "+st.getDepartment());
        this.jl2.setBounds(40, 120, 250, 40);
        this.jl2.setFont(f);
        this.c.add(jl2);

        this.jl3 = new JLabel("Session : "+st.getSession());
        this.jl3.setBounds(40, 170, 250, 40);
        this.jl3.setFont(f);
        this.c.add(jl3);

        this.jl4 = new JLabel("Email : "+st.getEmail());
        this.jl4.setBounds(40, 220, 250, 40);
        this.jl4.setFont(f);
        this.c.add(jl4);

        this.jl5 = new JLabel("Phone Number : "+st.getPhoneNo());
        this.jl5.setBounds(40, 270, 250, 40);
        this.jl5.setFont(f);
        this.c.add(jl5);

        this.jl6 = new JLabel("Age : "+String.valueOf(st.getAge()));
        this.jl6.setBounds(40, 320, 250, 40);
        this.jl6.setFont(f);
        this.c.add(jl6);

        this.jl7 = new JLabel("Address : "+st.getAddress());
        this.jl7.setBounds(40, 370, 250, 40);
        this.jl7.setFont(f);
        this.c.add(jl7);

        this.jl8 = new JLabel("Completed Credit : "+String.valueOf(st.getCompletdCredit()));
        this.jl8.setBounds(40, 420, 250, 40);
        this.jl8.setFont(f);
        this.c.add(jl8);

        this.jl9 = new JLabel("CGPA : "+String.valueOf(st.getCgpa()));
        this.jl9.setBounds(40, 470, 250, 40);
        this.jl9.setFont(f);
        this.c.add(jl9);

        this.jl10 = new JLabel("Gender : "+st.getGender());
        this.jl10.setBounds(40, 520, 250, 40);
        this.jl10.setFont(f);
        this.c.add(jl10);

        this.btn1 = new JButton("Exit");
        this.btn1.setBounds(40,570,100,35);
        this.btn1.setFont(f);
        this.c.add(btn1);

        this.btn1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
		        if(e.getSource()==btn1){
					StudentDashboard frame = new StudentDashboard(u);
					frame.setVisible(true);
					this.dispose();
    }
}
}