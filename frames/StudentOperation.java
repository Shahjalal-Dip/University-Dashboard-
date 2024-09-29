package frames;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import entities.*;
import repositories.*;

public class StudentOperation extends JFrame implements ActionListener {
    private Container c;
    private JLabel jl, jl1, jl2, jl3, jl4, jl5, jl6, jl7, jl8, jl9;
    private JTextField tf, tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9;
    private JRadioButton btn1, btn2;
    private ButtonGroup bg;
    private JButton btn3, btn4, btn5, btn6, btn7;
    private Font f, f1;
    private Cursor cursor;
    private ImageIcon img;
	private User u;

    public StudentOperation(User u) {
		this.u=u;
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Student Information Updation Form");
        this.setBounds(600, 0, 520, 750);
        initComponents();
    }

    public void initComponents() {
        this.c = this.getContentPane();
        this.c.setLayout(null);
        this.c.setBackground(Color.cyan);

        this.f = new Font("Arial", Font.CENTER_BASELINE, 17);
        this.f1 = new Font("Arial", Font.CENTER_BASELINE, 35);

        this.cursor = new Cursor(Cursor.HAND_CURSOR);

        this.jl = new JLabel("Student ID : ");
        this.jl.setBounds(40, 20, 150, 40);
        this.c.add(jl);

        this.jl1 = new JLabel("Name : ");
        this.jl1.setBounds(40, 70, 150, 40);
        this.c.add(jl1);

        this.jl2 = new JLabel("Department : ");
        this.jl2.setBounds(40, 120, 150, 40);
        this.c.add(jl2);

        this.jl3 = new JLabel("Session : ");
        this.jl3.setBounds(40, 170, 150, 40);
        this.c.add(jl3);

        this.jl4 = new JLabel("Email : ");
        this.jl4.setBounds(40, 220, 150, 40);
        this.c.add(jl4);

        this.jl5 = new JLabel("Phone Number : ");
        this.jl5.setBounds(40, 270, 150, 40);
        this.c.add(jl5);

        this.jl6 = new JLabel("Age : ");
        this.jl6.setBounds(40, 320, 150, 40);
        this.c.add(jl6);

        this.jl7 = new JLabel("Address : ");
        this.jl7.setBounds(40, 370, 150, 40);
        this.c.add(jl7);

        this.jl8 = new JLabel("Completed Credit : ");
        this.jl8.setBounds(40, 420, 150, 40);
        this.c.add(jl8);

        this.jl9 = new JLabel("CGPA : ");
        this.jl9.setBounds(40, 470, 150, 40);
        this.c.add(jl9);


        this.tf = new JTextField();
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

        this.tf4 = new JTextField();
        this.tf4.setBounds(170, 220, 210, 30);
        this.tf4.setForeground(Color.BLACK);
        this.c.add(tf4);

        this.tf5 = new JTextField();
        this.tf5.setBounds(170, 270, 210, 30);
        this.tf5.setForeground(Color.BLACK);
        this.c.add(tf5);

        this.tf6 = new JTextField();
        this.tf6.setBounds(170, 320, 210, 30);
        this.tf6.setForeground(Color.BLACK);
        this.c.add(tf6);

        this.tf7 = new JTextField();
        this.tf7.setBounds(170, 370, 210, 30);
        this.tf7.setForeground(Color.BLACK);
        this.c.add(tf7);

        this.tf8 = new JTextField();
        this.tf8.setBounds(170, 420, 210, 30);
        this.tf8.setForeground(Color.BLACK);
        this.c.add(tf8);

        this.tf9 = new JTextField();
        this.tf9.setBounds(170, 470, 210, 30);
        this.tf9.setForeground(Color.BLACK);
        this.c.add(tf9);

        this.btn1 = new JRadioButton("Male");
        this.btn1.setBounds(40, 515, 100, 30);
        this.btn1.setBackground(Color.cyan);
        this.btn1.setCursor(cursor);
        this.c.add(btn1);

        this.btn2 = new JRadioButton("Female");
        this.btn2.setBounds(140, 515, 150, 30);
        this.btn2.setBackground(Color.cyan);
        this.btn2.setCursor(cursor);
        this.c.add(btn2);

        this.bg = new ButtonGroup();
        this.bg.add(btn1);
        this.bg.add(btn2);

        this.btn3 = new JButton("Update");
        this.btn3.setBounds(40, 585, 100, 30);
        this.btn3.setCursor(cursor);
        this.c.add(btn3);

        this.btn4 = new JButton("Delete");
        this.btn4.setBounds(170, 585, 100, 30);
        this.btn4.setCursor(cursor);
        this.c.add(btn4);

        this.btn5 = new JButton("Reset");
        this.btn5.setBounds(300, 585, 100, 30);
        this.btn5.setCursor(cursor);
        this.c.add(btn5);

        this.btn6 = new JButton("Search");
        this.btn6.setBounds(395, 20, 90, 30);
        this.btn6.setCursor(cursor);
        this.c.add(btn6);

        this.btn7 = new JButton("Back");
        this.btn7.setBounds(170, 640, 100, 30);
        this.btn7.setCursor(cursor);
        this.c.add(btn7);

        this.btn1.addActionListener(this);
        this.btn2.addActionListener(this);
        this.btn3.addActionListener(this);
        this.btn4.addActionListener(this);
        this.btn5.addActionListener(this);
        this.btn6.addActionListener(this);
        this.btn7.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource()==btn3) {
			 if (tf.getText() != null) {
                Student st = new Student();
                st.setUserId(tf.getText());
                st.setName(tf1.getText());
                st.setDepartment(tf2.getText());
                st.setSession(tf3.getText());
                st.setEmail(tf4.getText());
                st.setPhoneNo(tf5.getText());
                st.setAge(Integer.parseInt(tf6.getText()));
                st.setAddress(tf7.getText());
                st.setCompletdCredit(Integer.parseInt(tf8.getText()));
                st.setCgpa(Float.parseFloat(tf9.getText()));
                if (btn1.isSelected()) {
                    st.setGender(btn1.getText());
                } else {
                    st.setGender(btn2.getText());
                }
                StudentRepo sre = new StudentRepo();
                sre.updateStudent(st);
                JOptionPane.showMessageDialog(this,"Update Information Successfully");
            }else{
                JOptionPane.showMessageDialog(this,"Invalid User ID");
            }
        } 
         if (e.getSource()==btn4) {
            if (tf.getText() != null) {
                StudentRepo sre = new StudentRepo();
                 sre.deleteStudent(tf.getText());
                JOptionPane.showMessageDialog(this,"Delete successfully");
				 tf.setText("");tf1.setText("");
                 tf2.setText("");tf3.setText("");
                 tf4.setText("");tf5.setText("");
			     tf6.setText("");tf7.setText("");
                 tf8.setText("");tf9.setText("");
                 bg.clearSelection();
            }else if(tf.getText()==null){
                JOptionPane.showMessageDialog(this,"Invalid Student Id","Error",JOptionPane.ERROR_MESSAGE);
        } 
		}
	    if (e.getSource()==btn5) {
            tf.setText("");tf1.setText("");
            tf2.setText("");tf3.setText("");
            tf4.setText("");tf5.setText("");
			tf6.setText("");tf7.setText("");
            tf8.setText("");tf9.setText("");
            bg.clearSelection();
            JOptionPane.showMessageDialog(this,"Reset Successfully");
        } 
	    if (e.getSource()==btn6) {
            if (tf.getText() != null) {
                StudentRepo sre = new StudentRepo();
                Student st = sre.searchStudent(tf.getText());

                tf.setText(st.getUserId());
                tf1.setText(st.getName());
                tf2.setText(st.getDepartment());
                tf3.setText(st.getSession());
                tf4.setText(st.getEmail());
                tf5.setText(st.getPhoneNo());
                tf6.setText(String.valueOf(st.getAge()));
                tf7.setText(st.getAddress());
                tf8.setText(String.valueOf(st.getCompletdCredit()));
                tf9.setText(String.valueOf(st.getCgpa()));
                if (st.getGender().equals("Male")) {
                    btn1.setSelected(true);
                } else {
                    btn2.setSelected(true);
                }
                JOptionPane.showMessageDialog(this, "Successfully Search Information");
            } else if (tf.getText() == null) {
                JOptionPane.showMessageDialog(this, "Invalid Student Id", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (e.getSource() == btn7) {

            }
        }
		if(e.getSource()==btn7){
			if(u.getRole()==1){
             AdminDashboard frame = new AdminDashboard(u);
             frame.setVisible(true);
			 this.dispose();
			}
			if(u.getRole()==2){
			 FacultyDashboard frame = new FacultyDashboard(u);
             frame.setVisible(true);
             this.dispose();			 
			}
			
		}
    }
}
