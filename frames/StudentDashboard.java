package frames;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import entities.*;
import repositories.*;

public class StudentDashboard extends JFrame implements ActionListener {
    private JPanel c;
    private JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8;
    private JButton btn1,btn2,btn3,btn4;
    private Font f,f1;
    private Cursor cursor;
    private ImageIcon img,img1,img2,img3,img4;
	User u;

    StudentDashboard(User u){
		this.u=u;
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Student home page");
        this.setBounds(100,30,930,430);
        initComponents();
    }
    public void initComponents() {
        this.c=new JPanel();
       this. c.setLayout(null);
       this. c.setBackground(Color.DARK_GRAY);

        this.img = new ImageIcon(getClass().getResource("./image/graduated.png"));
        this.img1 = new ImageIcon(getClass().getResource("./image/profile.png"));
        this.img2 = new ImageIcon(getClass().getResource("./image/transaction.png"));
        this.img3 = new ImageIcon(getClass().getResource("./image/course.png"));
        this.img4 = new ImageIcon(getClass().getResource("./image/script.png"));


        this.f = new Font("Arial", Font.CENTER_BASELINE, 17);
        this.f1 = new Font("Arial", Font.ITALIC+Font.BOLD, 20);

        this.cursor = new Cursor(Cursor.HAND_CURSOR);

        this.jl1 = new JLabel("Welcome To");
        this.jl1.setBounds(410, 15, 300, 30);
        this.jl1.setForeground(Color.WHITE);
        this.jl1.setFont(f1);
        this.c.add(jl1);

        this.jl2 = new JLabel("Student");
        this.jl2.setBounds(480, 40, 300, 30);
        this.jl2.setForeground(Color.WHITE);
        this.jl2.setFont(f1);
        this.c.add(jl2);

        StudentRepo sre = new StudentRepo();
        Student s=sre.searchStudent(u.getUserId());

        this.jl3 = new JLabel("Dashboard  "+s.getName());
        this.jl3.setBounds(510, 70, 300, 30);
        this.jl3.setForeground(Color.WHITE);
        this.jl3.setFont(f1);
        this.c.add(jl3);

        this.jl4 = new JLabel(img);
        this.jl4.setBounds(280, 10, img.getIconWidth(), img.getIconHeight());
        this.c.add(jl4);

        this.jl5 = new JLabel("My Profile");
        this.jl5.setBounds(85, 320, 200, 40);
        this.jl5.setForeground(Color.WHITE);
        this.jl5.setFont(f);
        this.c.add(jl5);

        this.jl6 = new JLabel("Update Profile");
        this.jl6.setBounds(290, 320, 300, 40);
        this.jl6.setForeground(Color.WHITE);
        this.jl6.setFont(f);
        this.c.add(jl6);

        this.jl7 = new JLabel("Course Registration");
        this.jl7.setBounds(490, 320, 200, 40);
        this.jl7.setForeground(Color.WHITE);
        this.jl7.setFont(f);
        this.c.add(jl7);

        this.jl8 = new JLabel("View Registered Course");
        this.jl8.setBounds(700, 320, 200, 40);
        this.jl8.setForeground(Color.WHITE);
        this.jl8.setFont(f);
        this.c.add(jl8);

        this.btn1 = new JButton(img1);
        this.btn1.setBounds(30, 170, 190, 150);
        this.btn1.setBackground(Color.BLACK);
        this.btn1.setCursor(cursor);
        this.c.add(btn1);

        this.btn2 = new JButton(img2);
        this.btn2.setBounds(250, 170, 190, 150);
        this.btn2.setBackground(Color.BLACK);
        this.btn2.setForeground(Color.WHITE);
        this.btn2.setCursor(cursor);
        this.c.add(btn2);

        this.btn3 = new JButton(img3);
        this.btn3.setBounds(470, 170, 190, 150);
        this.btn3.setBackground(Color.BLACK);
        this.btn3.setForeground(Color.WHITE);
        this.btn3.setCursor(cursor);
        this.c.add(btn3);

        this.btn4 = new JButton(img4);
        this.btn4.setBounds(690, 170, 190, 150);
        this.btn4.setBackground(Color.BLACK);
        this.btn4.setForeground(Color.WHITE);
        this.btn4.setCursor(cursor);
        this.c.add(btn4);

        this.add(this.c);
        this.btn1.addActionListener(this);
        this.btn2.addActionListener(this);
        this.btn3.addActionListener(this);
		this.btn4.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==btn1){
        StudentProfile frame = new StudentProfile(u);
        frame.setVisible(true);
		this.dispose();
        }
        if(e.getSource()==btn2){
        ProfileUP frame = new ProfileUP(u);
        frame.setVisible(true);
		this.dispose();
        }
        if(e.getSource()==btn3){
          OferedCourse f = new OferedCourse(u);
		  f.setVisible(true);
		  this.dispose();
        }
	    if(e.getSource()==btn4){

        }
    }
}
