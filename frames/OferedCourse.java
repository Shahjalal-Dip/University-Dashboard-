package frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import entities.*;
import repositories.*;
public class OferedCourse extends JFrame implements ActionListener
{
	private JLabel OCLabel;
	private JCheckBox P1LbCB,CADLbCB,BSCB,DSCB,DSLbCB,mth4CB,mth6CB,IECLbCB,EcoCB,EDCB;
	private JButton CBtn,backBtn;
	private JPanel panel;
	private User u;
	
	public OferedCourse(User u)
	{
		super("Course Operation Frame");
		this.setSize(500,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.u=u;
		
		this.panel=new JPanel();
		this.panel.setBackground(Color.ORANGE);
		this.panel.setLayout(null);
		
		
		this.OCLabel=new JLabel("Offered Courses :");
		this.OCLabel.setBounds(80,80,120,20);
		this.panel.add(OCLabel);
		
		this.P1LbCB=new JCheckBox("Physics 1 Lab");
		this.P1LbCB.setBounds(120,110,120,20);
		this.P1LbCB.setBackground(Color.ORANGE);
		this.panel.add(P1LbCB);
		
		this.CADLbCB=new JCheckBox("CAD Lab");
		this.CADLbCB.setBounds(120,140,120,20);
		this.CADLbCB.setBackground(Color.ORANGE);
		this.panel.add(CADLbCB);
		
		this.BSCB=new JCheckBox("Bangladesh Studies");
		this.BSCB.setBounds(120,170,150,20);
		this.BSCB.setBackground(Color.ORANGE);
		this.panel.add(BSCB);
		
		this.DSCB=new JCheckBox("Data Structure");
		this.DSCB.setBounds(120,200,150,20);
		this.DSCB.setBackground(Color.ORANGE);
		this.panel.add(DSCB);
		
		this.DSLbCB=new JCheckBox("Data Structure Lab");
		this.DSLbCB.setBounds(120,230,150,20);
		this.DSLbCB.setBackground(Color.ORANGE);
		this.panel.add(DSLbCB);
		
		this.mth4CB=new JCheckBox("Mathematics 4");
		this.mth4CB.setBounds(120,260,150,20);
		this.mth4CB.setBackground(Color.ORANGE);
		this.panel.add(mth4CB);
		
		this.mth6CB=new JCheckBox("Mathematics 6");
		this.mth6CB.setBounds(120,290,150,20);
		this.mth6CB.setBackground(Color.ORANGE);
		this.panel.add(mth6CB);
		
		this.IECLbCB=new JCheckBox("IEC Lab");
		this.IECLbCB.setBackground(Color.ORANGE);
		this.IECLbCB.setBounds(120,320,150,20);
		this.panel.add(IECLbCB);
		
		this.EcoCB=new JCheckBox("Economics");
		this.EcoCB.setBackground(Color.ORANGE);
		this.EcoCB.setBounds(120,350,150,20);
		this.panel.add(EcoCB);
		
		this.EDCB=new JCheckBox("Electronic Device");
		this.EDCB.setBounds(120,380,150,20);
		this.EDCB.setBackground(Color.ORANGE);
		this.panel.add(EDCB);
		
		this.CBtn=new JButton("Confirm");
		this.CBtn.setBounds(120,450,100,30);
		this.CBtn.setBackground(Color.YELLOW);
		this.panel.add(CBtn);
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(250,450,100,30);
		this.backBtn.setBackground(Color.YELLOW);
		this.panel.add(backBtn);
		
		this.add(this.panel);
		
	}
	 @Override
        public void actionPerformed(ActionEvent e) {
        if(e.getSource()==CBtn){
         
        }
        if(e.getSource()==backBtn){
        StudentDashboard frame = new StudentDashboard(u);
        frame.setVisible(true);
		this.dispose();
        }
       
    }
	
}