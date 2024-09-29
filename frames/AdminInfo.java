package frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import entities.*;
import repositories.*;

public class AdminInfo extends JFrame implements ActionListener{
    private Container c;
    private JLabel l1;
    private JTable jt;
    private JButton btn;
    private Cursor cursor;
    private Font f;
    private JScrollPane sp;
    private String []col={"Student ID","Name","Email","Phone Number","Gender","Age","Address","Date of Birth","NID no","Admin Type"};
    private String [][]row;
    private User u;
    public AdminInfo(String [][]row,User u) {
        this.row=row;
        this.u=u;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Admin Information List ");
        this.setBounds(200,60,820,540);
        initComponents();
    }
    public void initComponents(){
        this.c=this.getContentPane();
        this.c.setBackground(Color.GRAY);
        this.c.setLayout(null);

        this.f=new Font("Arial",Font.ITALIC+Font.BOLD,18);

        this.cursor = new Cursor(Cursor.HAND_CURSOR);

        this.l1=new JLabel("Admin Information");
        this.l1.setBounds(290,20,200,40);
        this.l1.setFont(f);
        this.c.add(l1);

        this.jt = new JTable(row,col);
        this.jt.setBackground(Color.GREEN);
        this.jt.setEnabled(false);
        this.jt.setRowHeight(20);

        this.sp = new JScrollPane(jt);
        this.sp.setBounds(20,80,760,330);
        this.c.add(sp);
        this.c.revalidate();
        this.c.repaint();

        this.btn = new JButton("Back");
        this.btn.setBounds(300, 435, 100, 30);
        this.btn.setCursor(cursor);
        this.c.add(btn);

        this.btn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      
        if(e.getSource()==btn){
           
                AdminDashboard frame = new AdminDashboard(u);
                frame.setVisible(true);
                this.dispose();
            
        }
    }
}
