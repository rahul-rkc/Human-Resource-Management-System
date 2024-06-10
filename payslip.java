//package project;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
public class payslip extends JFrame implements ActionListener,FocusListener
{
	JLabel l_back=new JLabel(new ImageIcon("F:/Project/pics/aa.png"));
    JLabel head=new JLabel("PAYSLIP OF EMPLOYEE");
    JLabel eid=new JLabel("Employee ID");
    JLabel name=new JLabel("Name");
    JLabel fm=new JLabel("For Month");
    JLabel bsal=new JLabel("Basic Salary");
    JLabel dep=new JLabel("Department");
    JLabel dob=new JLabel("DOB");

	//department
	String dpt[]={"Select Department","Sales","Purchase","EDP","Developer","Programmer","Designer"};
	JComboBox cmbdept=new JComboBox(dpt);

	JTextField teid=new JTextField();
	JTextField tname=new JTextField();	
	JTextField tbasic=new JTextField();

	//DOB
	JComboBox cmbdobd=new JComboBox();
	JComboBox cmbdobm=new JComboBox();
	JComboBox cmbdoby=new JComboBox();

	String mon[]={"--SELECT--","JANUARY","FEBRUARY","MARCH","APRIL","MAY","JUNE","JULY","AUGUST","SEPTEMBER","OCTOBER","NOVEMBER","DECEMBER"};
	JComboBox cmbmonth=new JComboBox(mon);

	JButton bnew=new JButton("New");
	JButton bsearch=new JButton("Search");
	JButton bok=new JButton("Ok");
	JButton bcancel=new JButton("Cancel");

	public payslip()
	{
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setUndecorated(true);
		setLayout(null);
		setVisible(true);
		setSize(1368,790);

		setResizable(false);
		setLocationRelativeTo(null);

		//dob
		cmbdobd.addItem("dd");
		for(int d=1;d<=31;d++)
		{ 
			if(d<10) {
				cmbdobd.addItem("0"+ d);
			}
			else {
				cmbdobd.addItem(""+ d);
			}
			//cmbdobd.addItem(""+d);
		}

		cmbdobm.addItem("mm");
		for(int m=1;m<=12;m++)
		{
			if(m<10) {
				cmbdobm.addItem("0"+m);
			}
			else {
				cmbdobm.addItem(""+m);
			}
			//cmbdobm.addItem(""+m);
		}

		cmbdoby.addItem("yyyy");
		for(int y=2019	;y>=1850;y--)
		{
			cmbdoby.addItem(""+y);
		}

		add(teid);
		add(tname);
		add(cmbmonth);
		add(tbasic);

		add(cmbdoby);
		add(cmbdobm);
		add(cmbdobd);
        add(head);
		add(eid);
		add(name);
		add(fm);
		add(bsal);
		add(dep);
		add(dob);

		add(cmbdept);

		add(bnew);
		add(bsearch);
		add(bok);
		add(bcancel);

		add(l_back);

		
		l_back.setBounds(-100,-30,1528,830);
		
		teid.setBounds(340,221,170,32);
		//head.setBounds(110,50,170,35);
		head.setBounds(450,100,500,35);
		eid.setBounds(150,220,170,35);
		name.setBounds(150,310,170,35);
		fm.setBounds(150,400,170,35);
		bsal.setBounds(810,400,170,35);
		dep.setBounds(810,220,170,35);
		dob.setBounds(810,310,170,35);

		cmbmonth.setBounds(337,400,180,32);
		//tbasic.setBounds(210,330,170,35);
		//tname.setBounds(670,150,170,35);

		//teid.setBounds(923,600,180,34);
		tname.setBounds(337,315,180,32);		
		tbasic.setBounds(980,400,180,32);
		

		cmbdobd.setBounds(980,310,50,35);
		cmbdobm.setBounds(1035,310,60,35);
		cmbdoby.setBounds(1100,310,60,35);
		cmbdept.setBounds(975,225,180,34);

		cmbdept.setFont(new Font("Times New Roman",Font.PLAIN,20));
		cmbdobd.setFont(new Font("Times New Roman",Font.PLAIN,17));
		cmbdobm.setFont(new Font("Times New Roman",Font.PLAIN,17));
		cmbdoby.setFont(new Font("Times New Roman",Font.PLAIN,15));
        bnew.setFont(new Font("Times New Roman",Font.PLAIN,20));
		bsearch.setFont(new Font("Times New Roman",Font.PLAIN,20));
		bok.setFont(new Font("Times New Roman",Font.PLAIN,20));
		bcancel.setFont(new Font("Times New Roman",Font.PLAIN,20));
		cmbmonth.setFont(new Font("Times New Roman",Font.PLAIN,17));
		bnew.setBounds(252,560,126,44);
		bsearch.setBounds(460,560,126,44);
		bok.setBounds(665,560,125,44);
		bcancel.setBounds(875,560,125,44);

		bnew.addActionListener(this);
		bsearch.addActionListener(this);
		bok.addActionListener(this);
		bcancel.addActionListener(this);

		teid.addFocusListener(this);
		tname.addFocusListener(this);
		tbasic.addFocusListener(this);

		head.setFont(new Font("Courier",Font.BOLD,41));
		eid.setFont(new Font("Courier",Font.BOLD,18));
		name.setFont(new Font("Courier",Font.BOLD,18));
		fm.setFont(new Font("Courier",Font.BOLD,18));
		bsal.setFont(new Font("Courier",Font.BOLD,18));
		dep.setFont(new Font("Courier",Font.BOLD,18));
		dob.setFont(new Font("Courier",Font.BOLD,18));

		teid.setFont(new Font("Times New Roman",Font.PLAIN,18));
		tname.setFont(new Font("Times New Roman",Font.PLAIN,18));
		tbasic.setFont(new Font("Times New Roman",Font.PLAIN,18));

	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==bnew)
		{
			try
			{
				int ctr=1;
			    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hrms","root","");
				String str="select * from emp";
				PreparedStatement ps=con.prepareStatement(str);
				Statement st=con.createStatement();
				ResultSet res=st.executeQuery(str);	
				while(res.next())
				{
					ctr++;
				}				
				if(ctr>0&&ctr<=9)
				{
					teid.setText("E00");
				}
				else if(ctr>=10&&ctr<=99)
				{
					teid.setText("E0");
				}
				else if(ctr>=100)
				{
					teid.setText("E");
				}
				tname.setText("");				
				tbasic.setText("");

				cmbdept.setSelectedIndex(0);
				cmbdobd.setSelectedIndex(0);
				cmbdobm.setSelectedIndex(0);
				cmbdoby.setSelectedIndex(0);

				cmbmonth.setSelectedIndex(0);

			}
			catch(Exception ex)
			{
				System.out.print(ex);
			}
		}
		if(e.getSource()==bsearch)
		{
			int flag=0;
			try
			{
			    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hrms","root","");
				Statement st=con.createStatement();
				String eid=JOptionPane.showInputDialog(null,"Enter Employee Type:");
				ResultSet res=st.executeQuery("select * from emp where eid='"+eid+"'");
				while(res.next())
				{
					flag=1;
					teid.setText(res.getString(1));
					tname.setText(res.getString(2));					
					cmbdept.setSelectedItem(res.getString(3));

					//dob
					String arr[]=res.getString(5).toString().split("-");
					cmbdobd.setSelectedItem(arr[2]);
					cmbdobm.setSelectedItem(arr[1]);
					cmbdoby.setSelectedItem(arr[0]);
					String year=(arr[2]);				

					tbasic.setText(res.getString(13));
				}
				if(flag==0)
					{
						JOptionPane.showMessageDialog(null,"Please Enter Valid ID");
					}
			}
			catch(Exception ex)
			{
				System.out.print(ex);
			}
		}
		if(e.getSource()==bok)
		{
			try
			{
				int flag=1;
				if(cmbmonth.getSelectedItem().equals("--SELECT--"))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Select Month!");
				}
				else if(teid.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter ID!");
				}
				else if(cmbdept.getSelectedItem().equals("  Select Department"))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Select Department!");
				}
				else if(tname.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Name!");
				}
				else if(cmbdoby.getSelectedItem().equals("yyyy")||cmbdobm.getSelectedItem().equals("mm")||cmbdobd.getSelectedItem().equals("dd"))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Date Properly!");
				}
				else if(tbasic.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Basic Salary!");
				}

				if(flag==1)
				{
				    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hrms","root","");
					Statement st=con.createStatement();
					String str="select * from emp where eid='"+teid.getText()+"'";
					ResultSet res=st.executeQuery(str);
					PrintWriter pw=new PrintWriter("report.txt");
				
					while(res.next())
					{
						int basic=Integer.parseInt(res.getString(13));
						int da=Integer.parseInt(res.getString(14));
						da=da*basic/100;
						int hra=Integer.parseInt(res.getString(15));
						hra=hra*basic/100;
						int wa=Integer.parseInt(res.getString(16));
						wa=wa*basic/100;
						int totall=Integer.parseInt(res.getString(17));
						totall=totall*basic/100;

						int gpf=Integer.parseInt(res.getString(18));
						gpf=gpf*basic/100;
						int it=Integer.parseInt(res.getString(19));
						it=it*basic/100;
						int gs=Integer.parseInt(res.getString(20));
						gs=gs*basic/100;
						int pf=Integer.parseInt(res.getString(21));
						pf=pf*basic/100;					
						int lic=Integer.parseInt(res.getString(22));
						lic=lic*basic/100;
						int totded=Integer.parseInt(res.getString(23));
						totded=totded*basic/100;

						int net=totall-totded+basic;
				
						pw.println("				HR MANAGEMENT SYSTEM");					
						pw.println("				______________________");
						pw.println();
						pw.println("EMPLOYEE CODE:"+res.getString(1)+"		EMPLOYEE NAME:"+res.getString(2));
						pw.println("DESIGNATION:"+res.getString(3)+"		FOR MONTH:"+cmbmonth.getSelectedItem()+"		YEAR:2019");

						pw.println("_____________________________");
						//pw.println();
						pw.println("EARNINGS:	AMOUNT");
					
						pw.println("DA : 		 "+da);
						pw.println("HRA:		 "+hra);
						pw.println("WA :		 "+wa);
						pw.println();
						pw.println("TOTAL EARNINGS: "+totall);

						pw.println("_____________________________");
						pw.println("DEDUCTIONS:	AMOUNT");
						pw.println("GPF: 		"+gpf);
						pw.println("IT : 		"+it);
						pw.println("GS : 		"+gs);
						pw.println("PF : 		"+pf);
						pw.println("LIC:		"+lic);
						pw.println();
						pw.println("TOTAL DEDUCTIONS: "+totded);
						pw.println("_____________________________");
						pw.println("NET SALARY: "+net);
					}
					pw.close();
					Process p=Runtime.getRuntime().exec("Notepad report.txt");
				}
			}
			catch(Exception ee)
			{
				System.out.print(e);
			}
		}
		if(e.getSource()==bcancel)
		{
			this.dispose();
		}
	}

	public void focusGained(FocusEvent f)
	{
	}
	public void focusLost(FocusEvent f)
	{
		if(f.getComponent()==teid)
		{
			int flag=0;
			try
			{
				Connection con=DriverManager.getConnection("jdbc:odbc:hrdsn");
				Statement st=con.createStatement();
				ResultSet res=st.executeQuery("select * from emp where eid='"+teid.getText()+"'");
				while(res.next())
				{
					flag=1;
					tname.setText(res.getString(2));					
					cmbdept.setSelectedItem(res.getString(3));

					//dob
					String arr[]=res.getString(5).toString().split("/");
					cmbdobd.setSelectedItem(arr[0]);
					cmbdobm.setSelectedItem(arr[1]);
					cmbdoby.setSelectedItem(arr[2]);
					String year=(arr[2]);				

					tbasic.setText(res.getString(13));
				}
				if(flag==0)
					{
						JOptionPane.showMessageDialog(null,"Please Enter Valid ID");
					}
			}
			catch(Exception ex)
			{
				System.out.print(ex);
			}
		}
		if(f.getComponent()==tname)
		{
			String s=tname.getText();
			if(s.equals(""))
			{
			}
			else
			{
				for( int i=0;i<s.length();i++)
				{
					if(s.charAt(i)>='a' && s.charAt(i)<='z'||s.charAt(i)>='A' && s.charAt(i)<='Z'||s.charAt(i)==' ')
					{
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Invalid Format!");
						tname.setText("");
						break;
					}
				}
			}
		}
		if(f.getComponent()==tbasic)
		{
			String s=tbasic.getText();
			if(s.equals(""))
			{
			}
			else
			{
				for( int i=0;i<s.length();i++)
				{
					if(s.charAt(i)=='0'||s.charAt(i)=='1'||s.charAt(i)=='2'||s.charAt(i)=='3'||s.charAt(i)=='4'||s.charAt(i)=='5'||s.charAt(i)=='6'||s.charAt(i)=='7'||s.charAt(i)=='8'||s.charAt(i)=='9')
					{
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Invalid Format!");
						tbasic.setText("");
						break;
					}
				}
			}
		}
	}

	public static void main(String args[])throws IOException
	{
		payslip obj=new payslip();
	}
}