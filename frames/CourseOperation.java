package frames;
import entities.*;
import repositories.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CourseOperation extends JFrame implements ActionListener {
    private Container c;
    private JLabel jl,jl1,jl2,jl3;
    private JTextField tf,tf1,tf2,tf3;
    private JButton btn1,btn2,btn3,btn4,btn5;
    private Font f,f1;
    private Cursor cursor;
    private ImageIcon img;
	private User u;

    public CourseOperation(User u){
		this.u=u;
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Course Updation Form");
        this.setBounds(600,90,520,450);
        initComponents();
    }
    public void initComponents() {
        this.c = this.getContentPane();
        this.c.setLayout(null);
        this.c.setBackground(Color.LIGHT_GRAY);

        this.f = new Font("Arial", Font.CENTER_BASELINE, 17);
        this.f1 = new Font("Arial", Font.CENTER_BASELINE, 35);

        this.cursor = new Cursor(Cursor.HAND_CURSOR);

        this.jl = new JLabel("Course Code : ");
        this.jl.setBounds(40, 20, 150, 40);
        this.c.add(jl);

        this.jl1 = new JLabel("Course Name : ");
        this.jl1.setBounds(40, 70, 150, 40);
        this.c.add(jl1);

        this.jl2 = new JLabel("Credit : ");
        this.jl2.setBounds(40, 120, 150, 40);
        this.c.add(jl2);

        this.jl3 = new JLabel("Pre-Requisite : ");
        this.jl3.setBounds(40, 170, 150, 40);
        this.c.add(jl3);

        this.tf = new JTextField("write Code for search");
        this.tf.setBounds(170, 20, 210, 30);
        this.tf.setForeground(Color.BLACK);
        this.c.add(tf);

        this.tf1 = new JTextField();
        this.tf1.setBounds(170, 70, 210, 30);
        this.tf1.setForeground(Color.BLACK);
        this.c.add(tf1);

        this.tf2 = new JTextField();
        this.tf2.setBounds(170, 120, 210, 30);
        this.tf2.setForeground(Color.BLACK);
        this.c.add(tf2);

        this.tf3 = new JTextField();
        this.tf3.setBounds(170, 170, 210, 30);
        this.tf3.setForeground(Color.BLACK);
        this.c.add(tf3);

        this.btn1 = new JButton("Update");
       this. btn1.setBounds(40, 260, 100, 30);
        this.btn1.setCursor(cursor);
        this.c.add(btn1);

        this.btn2 = new JButton("Delete");
        this.btn2.setBounds(170, 260, 100, 30);
        this.btn2.setCursor(cursor);
        this.c.add(btn2);

        this.btn3 = new JButton("Reset");
        this.btn3.setBounds(300, 260, 100, 30);
        this.btn3.setCursor(cursor);
        this.c.add(btn3);

        this.btn4 = new JButton("Search");
        this.btn4.setBounds(395, 20, 90, 30);
        this.btn4.setCursor(cursor);
        this.c.add(btn4);

        this.btn5 = new JButton("Back");
        this.btn5.setBounds(170, 335, 100, 30);
        this.btn5.setCursor(cursor);
        this.c.add(btn5);

        this.btn1.addActionListener(this);
        this.btn2.addActionListener(this);
        this.btn3.addActionListener(this);
        this.btn4.addActionListener(this);
        this.btn5.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn1){
            if (tf.getText() != null) {
                Course crs = new Course();
                crs.setCode(tf.getText());
                crs.setName(tf1.getText());
                crs.setCredit(Integer.parseInt(tf2.getText()));
                crs.setPre(tf3.getText());

                CourseRepo cre = new CourseRepo();
                cre.updateCourse(crs);
                JOptionPane.showMessageDialog(this, "Update Course Info Successfully");
            }else{
                JOptionPane.showMessageDialog(this,"Invalid Course Code");
            }
        }
        if(e.getSource()==btn2) {
            if (tf.getText() != null) {
                CourseRepo cre = new CourseRepo();
                cre.deleteCourse(tf.getText());
                JOptionPane.showMessageDialog(this, "Delete successfully");
            } else if (tf.getText() == null) {
                JOptionPane.showMessageDialog(this, "Invalid Student Id", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(e.getSource()==btn3){
            tf.setText("");tf1.setText("");
            tf2.setText("");tf3.setText("");
        }
        if(e.getSource()==btn4){
            if (tf.getText() != null) {
                CourseRepo cre = new CourseRepo();
                Course cr = cre.searchCourse(tf.getText());

                tf.setText(cr.getCode());
                tf1.setText(cr.getName());
                tf2.setText(String.valueOf(cr.getCredit()));
                tf3.setText(cr.getPre());

                JOptionPane.showMessageDialog(this, "Successfully Search Course Information");
            } else if (tf.getText() == null) {
                JOptionPane.showMessageDialog(this, "Invalid Course Code", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
         if(e.getSource()==btn5){
            AdminDashboard frame = new AdminDashboard(u);
            frame.setVisible(true);
            this.dispose();
        }
    }
}
