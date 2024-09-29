package frames;
import entities.*;
import repositories.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class CourseDetails extends JFrame implements ActionListener{
    private Container c;
    private JLabel l1;
    private JTable jt;
    private JButton btn;
    private Cursor cursor;
    private Font f;
    private JScrollPane sp;
    private String []col={"Course Code","Course Name","Credit","Pre-Requisite"};
    private String [][]row;
	private User u;

    public CourseDetails(String [][]row,User u) {
		this.u=u;
        this.row = row;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Course Details List ");
        this.setBounds(200,60,740,540);
        initComponents();

    }
    public void initComponents(){
        this.c=this.getContentPane();
        this.c.setBackground(Color.GRAY);
        this.c.setLayout(null);

        this.f=new Font("Arial",Font.ITALIC+Font.BOLD,18);

        this.cursor = new Cursor(Cursor.HAND_CURSOR);

        this.l1=new JLabel("Course Details");
        this.l1.setBounds(270,20,200,40);
        this.l1.setFont(f);
        this.c.add(l1);

        this.jt = new JTable(row,col);
        this.jt.setBackground(Color.CYAN);
        this.jt.setRowHeight(20);

        this.sp = new JScrollPane(jt);
        this.sp.setBounds(20,80,680,230);
        this.c.add(this.sp);
        this.c.revalidate();
        this.c.repaint();

        this.btn = new JButton("Back");
        this.btn.setBounds(300, 365, 100, 30);
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
