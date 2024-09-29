package frames;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import entities.*;
import repositories.*;

public class LoginFrame extends JFrame implements ActionListener {
    private Container c;
    private JLabel jl,jl1,jl2,jl3;
    private JTextField tf;
    private JPasswordField pf;
    private JButton btn1,btn2,btn3;
    private Font f,f1;
    private Cursor cursor;
    private ImageIcon img1;


    public LoginFrame(){
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Login");
        this.setBounds(550,90,400,500);
        initComponents();
    }
    public void initComponents() {
        this.c = this.getContentPane();
        this.c.setLayout(null);
        this.c.setBackground(Color.DARK_GRAY);

        this.img1 = new ImageIcon(getClass().getResource("./image/account.png"));

        this.f = new Font("Arial", Font.CENTER_BASELINE, 17);
        this.f1 = new Font("Arial", Font.CENTER_BASELINE, 35);

        this.cursor = new Cursor(Cursor.HAND_CURSOR);

        this.jl = new JLabel(img1);
        this.jl.setBounds(155, 10, 70, 70);
        this.c.add(jl);

        this.jl1 = new JLabel("login");
        this.jl1.setBounds(150, 75, 130, 50);
        this.jl1.setForeground(Color.WHITE);
        this.jl1.setFont(f1);
        this.c.add(jl1);

        this.jl2 = new JLabel("User ID :");
        this.jl2.setBounds(40, 150, 80, 30);
        this.jl2.setForeground(Color.WHITE);
        this.jl2.setBackground(Color.DARK_GRAY);
        this.jl2.setOpaque(true);
        this.jl2.setFont(f);
        this.c.add(jl2);

        this.jl3 = new JLabel("Password :");
        this.jl3.setBounds(40, 220, 100, 30);
        this.jl3.setForeground(Color.WHITE);
        this.jl3.setBackground(Color.DARK_GRAY);
        this.jl3.setOpaque(true);
        this.jl3.setFont(f);
        this.c.add(jl3);

        this.tf = new JTextField();
        this.tf.setBounds(140, 150, 200, 30);
        this.tf.setForeground(Color.BLACK);
        this.c.add(tf);

        this.pf = new JPasswordField();
        this.pf.setBounds(140, 220, 200, 30);
        this.pf.setForeground(Color.RED);
        this.pf.setEchoChar('*');
        this.pf.setFont(f);
        this.c.add(pf);

        this.btn1 = new JButton("Sign UP");
        this.btn1.setBounds(150, 300, 85, 30);
        this.btn1.setBackground(Color.WHITE);
        this.btn1.setCursor(cursor);
        this.c.add(btn1);

        this.btn2 = new JButton("Login");
        this.btn2.setBounds(250, 300, 85, 30);
        this.btn2.setBackground(Color.WHITE);
        this.btn2.setCursor(cursor);
        this.c.add(btn2);

        this.btn3 = new JButton("Exit");
        this.btn3.setBounds(30, 300, 85, 30);
        this.btn3.setBackground(Color.WHITE);
        this.btn3.setCursor(cursor);
        this.c.add(btn3);

        this.btn1.addActionListener(this);
        this.btn2.addActionListener(this);
        this.btn3.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if(cmd.equals(btn2.getText()))
        {
            String uid=tf.getText();
            String pass=String.valueOf(pf.getPassword());
            UserRepo urp=new UserRepo();
            User user=urp.searchUser(uid);
            if(user!=null)
            {
                if(user.getUserId().equals(uid)&&user.getPassword().equals(pass)&&user.getRole()==1){
                    AdminDashboard frame=new AdminDashboard(user);
                    this.setVisible(false);
                    frame.setVisible(true);
                }
                else if(user.getUserId().equals(uid)&&user.getPassword().equals(pass)&&user.getRole()==2){
                    FacultyDashboard frame=new FacultyDashboard(user);
                    this.setVisible(false);
                    frame.setVisible(true);
                }
                else if(user.getUserId().equals(uid)&&user.getPassword().equals(pass)&&user.getRole()==3){
                    StudentDashboard f = new StudentDashboard(user);
                    f.setVisible(true);
					this.dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Wrong user Id or Password!");
                }
            }

            else
            {
                JOptionPane.showMessageDialog(this, "Wrong user Id or Password!");
            }
        }
		
		if(cmd.equals(btn1.getText())){
			SignUpFrame frame=new SignUpFrame();
			frame.setVisible(true);
			this.dispose();
		}

        if(cmd.equals(btn3.getText())){
            this.dispose();
        }
    }
}
