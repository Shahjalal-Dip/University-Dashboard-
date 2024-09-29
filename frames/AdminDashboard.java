package frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import entities.*;
import repositories.*;

public class AdminDashboard extends JFrame implements ActionListener {
    private JPanel c;
    private JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10,jl11,jl12,jl13,jl14,jl15,jl16;
    private JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12;
    private Font f,f1;
    private Cursor cursor;
    private ImageIcon img,img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12;
    private User u;
	
    public AdminDashboard(User u){
		this.u=u;
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Admin home page");
        this.setBounds(100,0,930,730);
        initComponents();
    }
    public void initComponents() {
        this.c=new JPanel();
        this.c.setLayout(null);
        this.c.setBackground(Color.DARK_GRAY);

        this.img = new ImageIcon(getClass().getResource("./image/admin.png"));
        this.img1 = new ImageIcon(getClass().getResource("./image/add-user.png"));
        this.img2 = new ImageIcon(getClass().getResource("./image/update.png"));
        this.img3 = new ImageIcon(getClass().getResource("./image/student.png"));
        this.img4 = new ImageIcon(getClass().getResource("./image/course.png"));
        this.img5 = new ImageIcon(getClass().getResource("./image/rotation.png"));
        this.img6 = new ImageIcon(getClass().getResource("./image/script.png"));
        this.img7 = new ImageIcon(getClass().getResource("./image/teacher.png"));
        this.img8 = new ImageIcon(getClass().getResource("./image/faculty-data.png"));
        this.img9 = new ImageIcon(getClass().getResource("./image/faculty-de.png"));
        this.img10 = new ImageIcon(getClass().getResource("./image/admin-add.png"));
        this.img11 = new ImageIcon(getClass().getResource("./image/admin update.png"));
        this.img12 = new ImageIcon(getClass().getResource("./image/admin details.png"));

        this.f = new Font("Arial", Font.CENTER_BASELINE, 17);
        this.f1 = new Font("Arial", Font.ITALIC+Font.BOLD, 20);

        this.cursor = new Cursor(Cursor.HAND_CURSOR);

        this.jl1 = new JLabel("Welcome To");
        this.jl1.setBounds(410, 5, 300, 30);
        this.jl1.setForeground(Color.WHITE);
        this.jl1.setFont(f1);
        this.c.add(this.jl1);

        this.jl2 = new JLabel("Admin");
        this.jl2.setBounds(480, 30, 300, 30);
        this.jl2.setForeground(Color.WHITE);
        this.jl2.setFont(this.f1);
        this.c.add(this.jl2);

        AdminRepo are = new AdminRepo();
        Admin a=are.searchAdmin(u.getUserId());

        this.jl3 = new JLabel("Dashboard  "+a.getName());
        this.jl3.setBounds(510, 60, 300, 30);
        this.jl3.setForeground(Color.WHITE);
        this.jl3.setFont(this.f1);
        this.c.add(this.jl3);

        this.jl4 = new JLabel(this.img);
        this.jl4.setBounds(280, -10, img.getIconWidth(), img.getIconHeight());
        this.c.add(this.jl4);

        this.jl5 = new JLabel("Add Student");
        this.jl5.setBounds(75, 270, 200, 40);
        this.jl5.setForeground(Color.WHITE);
        this.jl5.setFont(this.f);
        this.c.add(this.jl5);

        this.jl6 = new JLabel("Student Details Operation");
        this.jl6.setBounds(245, 270, 300, 40);
        this.jl6.setForeground(Color.WHITE);
        this.jl6.setFont(this.f);
        this.c.add(this.jl6);

        this.jl7 = new JLabel("Student Information");
        this.jl7.setBounds(490, 270, 200, 40);
        this.jl7.setForeground(Color.WHITE);
        this.jl7.setFont(this.f);
        this.c.add(this.jl7);

        this.jl8 = new JLabel("Add course");
        this.jl8.setBounds(75, 460, 200, 40);
        this.jl8.setForeground(Color.WHITE);
        this.jl8.setFont(this.f);
        this.c.add(this.jl8);

        this.jl9 = new JLabel("Course Operation");
        this.jl9.setBounds(275, 460, 250, 40);
        this.jl9.setForeground(Color.WHITE);
        this.jl9.setFont(this.f);
        this.c.add(this.jl9);

        this.jl10 = new JLabel("Course Details");
        this.jl10.setBounds(510, 460, 200, 40);
        this.jl10.setForeground(Color.WHITE);
        this.jl10.setFont(this.f);
        this.c.add(this.jl10);

        this.jl11 = new JLabel("Add Faculty");
        this.jl11.setBounds(75, 650, 200, 40);
        this.jl11.setForeground(Color.WHITE);
        this.jl11.setFont(this.f);
        this.c.add(this.jl11);

        this.jl12 = new JLabel("Faculty Operation");
        this.jl12.setBounds(275, 650, 300, 40);
        this.jl12.setForeground(Color.WHITE);
        this.jl12.setFont(this.f);
        this.c.add(this.jl12);

        this.jl13 = new JLabel("Faculty Information");
        this.jl13.setBounds(490, 650, 200, 40);
        this.jl13.setForeground(Color.WHITE);
        this.jl13.setFont(this.f);
        this.c.add(this.jl13);

        this.jl14 = new JLabel("Add Admin");
        this.jl14.setBounds(745, 270, 200, 40);
        this.jl14.setForeground(Color.WHITE);
        this.jl14.setFont(this.f);
        this.c.add(this.jl14);

        this.jl15 = new JLabel("Admin Operation");
        this.jl15.setBounds(720, 460, 250, 40);
        this.jl15.setForeground(Color.WHITE);
        this.jl15.setFont(this.f);
        this.c.add(this.jl15);

        this.jl16 = new JLabel("Admin Details");
        this.jl16.setBounds(732, 650, 250, 40);
        this.jl16.setForeground(Color.WHITE);
        this.jl16.setFont(this.f);
        this.c.add(this.jl16);

        this.btn1 = new JButton(this.img1);
        this.btn1.setBounds(30, 120, 190, 150);
        this.btn1.setBackground(Color.BLACK);
        this.btn1.setCursor(this.cursor);
        this.c.add(this.btn1);

        this.btn2 = new JButton(this.img2);
        this.btn2.setBounds(250, 120, 190, 150);
        this.btn2.setBackground(Color.BLACK);
        this.btn2.setForeground(Color.WHITE);
        this.btn2.setCursor(this.cursor);
        this.c.add(this.btn2);

        this.btn3 = new JButton(this.img3);
        this.btn3.setBounds(470, 120, 190, 150);
        this.btn3.setBackground(Color.BLACK);
        this.btn3.setForeground(Color.WHITE);
        this.btn3.setCursor(this.cursor);
        this.c.add(this.btn3);

        this.btn4 = new JButton(this.img4);
        this.btn4.setBounds(30, 310, 190, 150);
        this.btn4.setBackground(Color.BLACK);
        this.btn4.setForeground(Color.WHITE);
        this.btn4.setCursor(this.cursor);
        this.c.add(this.btn4);

        this.btn5 = new JButton(this.img5);
        this.btn5.setBounds(250, 310, 190, 150);
        this.btn5.setBackground(Color.BLACK);
        this.btn5.setForeground(Color.WHITE);
        this.btn5.setCursor(this.cursor);
        this.c.add(this.btn5);

         this.btn6 = new JButton( this.img6);
         this.btn6.setBounds(470, 310, 190, 150);
         this.btn6.setBackground(Color.BLACK);
         this.btn6.setForeground(Color.WHITE);
         this.btn6.setCursor( this.cursor);
         this.c.add( this.btn6);

         this.btn7 = new JButton( this.img7);
         this.btn7.setBounds(30, 500, 190, 150);
         this.btn7.setBackground(Color.BLACK);
         this.btn7.setForeground(Color.WHITE);
         this.btn7.setCursor( this.cursor);
         this.c.add( this.btn7);

         this.btn8 = new JButton( this.img8);
         this.btn8.setBounds(250, 500, 190, 150);
         this.btn8.setBackground(Color.BLACK);
         this.btn8.setForeground(Color.WHITE);
         this.btn8.setCursor( this.cursor);
         this.c.add( this.btn8);

         this.btn9 = new JButton( this.img9);
         this.btn9.setBounds(470, 500, 190, 150);
         this.btn9.setBackground(Color.BLACK);
         this.btn9.setForeground(Color.WHITE);
         this.btn9.setCursor( this.cursor);
         this.c.add( this.btn9);

         this.btn10 = new JButton( this.img10);
         this.btn10.setBounds(690, 120, 190, 150);
         this.btn10.setBackground(Color.BLACK);
         this.btn10.setForeground(Color.WHITE);
         this.btn10.setCursor( this.cursor);
         this.c.add( this.btn10);

         this. btn11 = new JButton( this.img11);
         this.btn11.setBounds(690, 310, 190, 150);
         this.btn11.setBackground(Color.BLACK);
         this.btn11.setForeground(Color.WHITE);
         this.btn11.setCursor( this.cursor);
         this.c.add( this.btn11);

         this.btn12 = new JButton( this.img12);
         this.btn12.setBounds(690, 500, 190, 150);
         this.btn12.setBackground(Color.BLACK);
         this.btn12.setForeground(Color.WHITE);
         this.btn12.setCursor( this.cursor);
         this.c.add( this.btn12);

         this.add(this.c);

         this.btn1.addActionListener(this);
         this.btn2.addActionListener(this);
         this.btn3.addActionListener(this);
         this.btn4.addActionListener(this);
         this.btn5.addActionListener(this);
         this.btn6.addActionListener(this);
         this.btn7.addActionListener(this);
         this.btn8.addActionListener(this);
         this.btn9.addActionListener(this);
         this.btn10.addActionListener(this);
         this.btn11.addActionListener(this);
         this.btn12.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn1){
            AddStudent frame = new AddStudent(u);
           frame.setVisible(true);
        }
        if(e.getSource()==btn2){
            StudentOperation frame = new StudentOperation(u);
			frame.setVisible(true);
        }
        if(e.getSource()==btn3){
		 StudentRepo sre = new StudentRepo();
         Student st[]=sre.getAllStudent();
		 String [][]stuData = new String[st.length][11];
		 StudentInfo frame = new StudentInfo(stuData,u);
         for(int i=0;i<st.length;i++){
             if(st[i]!=null) {
                 stuData[i][0] = st[i].getUserId();
                 stuData[i][1] = st[i].getName();
                 stuData[i][2] = st[i].getDepartment();
                 stuData[i][3] = st[i].getSession();
                 stuData[i][4] = st[i].getEmail();
                 stuData[i][5] = st[i].getPhoneNo();
                 stuData[i][6] = String.valueOf(st[i].getAge());
                 stuData[i][7] = st[i].getAddress();
                 stuData[i][8] = String.valueOf(st[i].getCompletdCredit());
                 stuData[i][9] = String.valueOf(st[i].getCgpa());
                 stuData[i][10] = st[i].getGender();
             }
			 frame = new StudentInfo(stuData,u);
         }
       
         frame.setVisible(true);
		 this.dispose();
		}
        if(e.getSource()==btn4){
            AddCourse frame = new AddCourse(u);
           frame.setVisible(true);
        }
        if(e.getSource()==btn5){
            CourseOperation frame = new CourseOperation(u);
			frame.setVisible(true);
        }
        if(e.getSource()==btn6){
            CourseRepo cre = new CourseRepo();
            Course crs[]=cre.getAllCourse();
		    String [][]crsData = new String[crs.length][4];
		    CourseDetails frame = new CourseDetails(crsData,u);
         for(int i=0;i<crs.length;i++){
             if(crs[i]!=null) {
                 crsData[i][0] = crs[i].getCode();
                 crsData[i][1] = crs[i].getName();
                 crsData[i][2] = String.valueOf(crs[i].getCredit());
                 crsData[i][3] = crs[i].getPre();

             }
			 frame = new CourseDetails(crsData,u);
         }
       
         frame.setVisible(true);
		 this.dispose();
        }
		if(e.getSource()==btn7){
             AddFaculty f = new AddFaculty(u);
            f.setVisible(true);
			this.dispose();
        }
        if(e.getSource()==btn8){
            FacultyOperation f = new FacultyOperation(u);
            f.setVisible(true);
			this.dispose();
        }
		if(e.getSource()==btn9){
            FacultyRepo fre = new FacultyRepo();
            Faculty ft[]=fre.getAllFaculty();
		    String [][]fData = new String[ft.length][9];
		    FacultyInfo frame = new FacultyInfo(fData,u);
         for(int i=0;i<ft.length;i++){
             if(ft[i]!=null) {
                 fData[i][0] = ft[i].getUserId();
                 fData[i][1] = ft[i].getName();
                 fData[i][2] = ft[i].getEmail();
                 fData[i][3] = ft[i].getPhoneNo();
				 fData[i][4] = ft[i].getGender();
                 fData[i][5] = String.valueOf(ft[i].getAge());
                 fData[i][6] = ft[i].getAddress();
                 fData[i][7] = ft[i].getBirth();
                 fData[i][8] = ft[i].getNID();
                 
             }
			 frame = new FacultyInfo(fData,u);
         }
       
         frame.setVisible(true);
		 this.dispose();
        }
        if(e.getSource()==btn10){
            AddAdmin f = new AddAdmin(u);
            f.setVisible(true);
			this.dispose();
        }
		if(e.getSource()==btn11){
            AdminOperationFrame f = new AdminOperationFrame(u);
            f.setVisible(true);
			this.dispose();
        }
        if(e.getSource()==btn12){
            AdminRepo fre = new AdminRepo();
            Admin ft[]=fre.getAllAdmin();
		    String [][]fData = new String[ft.length][10];
		    AdminInfo frame = new AdminInfo(fData,u);
         for(int i=0;i<ft.length;i++){
             if(ft[i]!=null) {
                 fData[i][0] = ft[i].getUserId();
                 fData[i][1] = ft[i].getName();
                 fData[i][2] = ft[i].getEmail();
                 fData[i][3] = ft[i].getPhoneNo();
				 fData[i][4] = ft[i].getGender();
                 fData[i][5] = String.valueOf(ft[i].getAge());
                 fData[i][6] = ft[i].getAddress();
                 fData[i][7] = ft[i].getBirth();
                 fData[i][8] = ft[i].getNID();
                 fData[i][9] = ft[i].getAdminTy();
             }
			 frame = new AdminInfo(fData,u);
         }
       
         frame.setVisible(true);
		 this.dispose();
        }
    }
}
