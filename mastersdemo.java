import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class mastersdemo  extends JFrame implements ActionListener
{

		
	JLabel l_back=new JLabel(new ImageIcon("F:/Project/pics/masters.jpeg"));
	
	JButton bemp=new JButton("Employee");
	JButton bper=new JButton("Performance");
	JButton brem=new JButton("Remuneration");
	JButton batt=new JButton("Attendance");
	JButton bleave=new JButton("Leave");
	JButton bhol=new JButton("Holiday");
	JButton bpay=new JButton("Payment");
	JButton bcancel=new JButton("Cancel");


	public mastersdemo()
	{
		setLayout(null);
		setVisible(true);
		setSize(2500,1500);

		setResizable(false);
		setLocationRelativeTo(null);

		add(bemp);
		add(bper);
		add(brem);
		add(batt);
		add(bleave);
		add(bhol);
		add(bpay);
		add(bcancel);

		add(l_back);

		l_back.setBounds(0,1,1528,830);

		bemp.addActionListener(this);
		bper.addActionListener(this);
		brem.addActionListener(this);
		batt.addActionListener(this);
		bleave.addActionListener(this);
		bhol.addActionListener(this);
		bpay.addActionListener(this);
		bcancel.addActionListener(this);

		bemp.setBounds(300,168,326,80);
		bper.setBounds(300,355,324,80);
		brem.setBounds(300,548,326,80);
		batt.setBounds(930,172,326,80);
		bleave.setBounds(930,359,326,80);
		bhol.setBounds(930,552,326,80);
		bpay.setBounds(600,678,350,80);

		bemp.setFont(new Font("Times New Roman",Font.PLAIN,28));
	    bper.setFont(new Font("Times New Roman",Font.PLAIN,28));
        brem.setFont(new Font("Times New Roman",Font.PLAIN,28));
        batt.setFont(new Font("Times New Roman",Font.PLAIN,28));
        bleave.setFont(new Font("Times New Roman",Font.PLAIN,28));
        bhol.setFont(new Font("Times New Roman",Font.PLAIN,28));
        bpay.setFont(new Font("Times New Roman",Font.PLAIN,28));

        bemp.setBackground(new Color(154,205,50));
        bper.setBackground(new Color(154,205,50));

brem.setBackground(new Color(154,205,50));
batt.setBackground(new Color(154,205,50));
bleave.setBackground(new Color(154,205,50));
bhol.setBackground(new Color(154,205,50));
bpay.setBackground(new Color(154,205,50));

		//bcancel.setBounds(1860,405,47,47);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==bemp)
		{
			new emp();
		}
		if(e.getSource()==bper)
		{
			new performance();
		}
		if(e.getSource()==brem)
		{
			new remuneration();
		}
		if(e.getSource()==batt)
		{
			new attendance();
		}
		if(e.getSource()==bleave)
		{
			new leave();
		}
		if(e.getSource()==bhol)
		{
			new holiday();
		}
		if(e.getSource()==bpay)
		{
			new payslip();
		}
		if(e.getSource()==bcancel)
		{
			this.dispose();
		}
	}
	public static void main(String args[])throws IOException
	{
		mastersdemo obj=new mastersdemo();
	}
}