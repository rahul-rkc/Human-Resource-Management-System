//package project;

import java.io.*;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class performance extends JFrame implements ActionListener,FocusListener
{
	int flag=0;

	JLabel l_back=new JLabel(new ImageIcon("F:/Project/pics/aa.png"));

	JLabel l_title=new JLabel("PERFORMACE");
	JLabel l_eid=new JLabel("Employee ID");
	JLabel l_ename=new JLabel("Name");
	JLabel l_training=new JLabel("Training");
	JLabel l_to=new JLabel("To");
	JLabel l_amtpaid=new JLabel("Amount Paid");
	JLabel l_status=new JLabel("Status");
	JLabel l_designation=new JLabel("Designation");
	JLabel l_address=new JLabel("Address");
	JLabel l_from=new JLabel("From");
	JLabel l_reimbursed=new JLabel("Amount Reimbursed");
	
	JTextField t_eid=new JTextField();
	JTextField t_ename=new JTextField();
	JTextField t_training=new JTextField();
	JTextField t_paid=new JTextField();
	JTextField t_reimbursed=new JTextField();
	JTextField t_addr=new JTextField();

	
	//designation		
	String des[]={"Select","BA","BCOM","BSC","BBA","BCA","BTECH","MA","MCOM","MSC","MBA","MCA","MTECH"};
	JComboBox cmbdes=new JComboBox(des);

	JComboBox cmbfromd=new JComboBox();
	JComboBox cmbfromm=new JComboBox();
	JComboBox cmbfromy=new JComboBox();

	JComboBox cmbtod=new JComboBox();
	JComboBox cmbtom=new JComboBox();
	JComboBox cmbtoy=new JComboBox();

	String stat[]={"--SELECT--","CERTIFIED","NOT CERTIFIED","INCOMPLETE"};
	JComboBox cmbstatus=new JComboBox(stat);	
	
	JButton bnew=new JButton("New");
	JButton bsubmit=new JButton("Submit");
	JButton bcancel=new JButton("cancel");
	
	public performance()
	{
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setUndecorated(true);
		setLayout(null);
		setVisible(true);
		setSize(1350,740);

		setResizable(false);
		setLocationRelativeTo(null);

		// t_eid.setBorder(null);
		// t_eid.setOpaque(false);

		// t_ename.setBorder(null);
		// t_ename.setOpaque(false);

		// t_training.setBorder(null);
		// t_training.setOpaque(false);

		// t_paid.setBorder(null);
		// t_paid.setOpaque(false);

		// t_reimbursed.setBorder(null);
		// t_reimbursed.setOpaque(false);

		// t_addr.setBorder(null);
		// t_addr.setOpaque(false);

		// bnew.setContentAreaFilled(false);
		// bsubmit.setContentAreaFilled(false);
		// bcancel.setContentAreaFilled(false);

		//from
		cmbfromd.addItem("dd");
		for(int d=1;d<=31;d++)
		{
			cmbfromd.addItem(""+d);
		}

		cmbfromm.addItem("mm");
		for(int m=1;m<=12;m++)
		{
			cmbfromm.addItem(""+m);
		}

		cmbfromy.addItem("yyyy");
		for(int y=2010;y<=2019;y++)
		{
			cmbfromy.addItem(""+y);
		}

		//to
		cmbtod.addItem("dd");
		for(int d=1;d<=31;d++)
		{
			cmbtod.addItem(""+d);
		}

		cmbtom.addItem("mm");
		for(int m=1;m<=12;m++)
		{
			cmbtom.addItem(""+m);
		}

		cmbtoy.addItem("yyyy");
		for(int y=2010;y<=2019;y++)
		{
			cmbtoy.addItem(""+y);
		}

		add(l_title);
		add(l_eid);
		add(l_ename);
		add(l_training);
		add(l_to);
		add(l_amtpaid);
		add(l_status);
		add(l_designation);
		add(l_address);
		add(l_from);
		add(l_reimbursed);
		
		add(t_eid);
		add(t_ename);
		add(t_training);
		add(t_paid);
		add(t_reimbursed);
		add(t_addr);


		add(cmbdes);

		add(cmbfromd);
		add(cmbfromm);
		add(cmbfromy);

		add(cmbtod);
		add(cmbtom);
		add(cmbtoy);

		add(cmbstatus);
			
		add(bnew);
		add(bsubmit);
		add(bcancel);

		add(l_back);

		bnew.addActionListener(this);
		bsubmit.addActionListener(this);
		bcancel.addActionListener(this);

		l_title.setBounds(545,20,700,50);
		l_eid.setBounds(150,130,140,50);
		l_ename.setBounds(150,180,140,50);
		l_training.setBounds(150,230,140,50);
		l_to.setBounds(150,280,400,50);
		l_amtpaid.setBounds(150,330,400,50);
		l_status.setBounds(150,380,400,50);
		l_designation.setBounds(800,130,140,50);
		l_address.setBounds(800,200,140,50);
		l_from.setBounds(800,310,140,50);
		l_reimbursed.setBounds(800,370,170,50);

		t_eid.setBounds(350,140,181,33);
		t_ename.setBounds(350,190,181,33);
		t_training.setBounds(350,240,181,35);		
		t_paid.setBounds(350,340,181,35);
		t_reimbursed.setBounds(1000,380,181,35);
		t_addr.setBounds(1000,210,317,83);

		//designation
		cmbdes.setBounds(1000,140,181,33);
		
		cmbtod.setBounds(350,290,50,30);
		cmbtom.setBounds(410,290,50,30);
		cmbtoy.setBounds(470,290,60,30);

		cmbfromd.setBounds(1000,310,60,35);
		cmbfromm.setBounds(1100,310,61,35);
		cmbfromy.setBounds(1200,310,60,35);
		
		cmbstatus.setBounds(350,390,181,35);

		bnew.setBounds(430,550,125,41);
		bsubmit.setBounds(615,550,125,41);
		bcancel.setBounds(800,550,125,41);

		l_back.setBounds(-100,-30,1528,830);

		
		t_eid.addFocusListener(this);
		t_ename.addFocusListener(this);
		t_paid.addFocusListener(this);
		t_reimbursed.addFocusListener(this);

		l_title.setFont(new Font("Courier", Font.BOLD,50));
		l_eid.setFont(new Font("Courier",Font.BOLD,20));
		l_ename.setFont(new Font("Courier",Font.BOLD,20));
		l_training.setFont(new Font("Courier",Font.BOLD,20));
		l_to.setFont(new Font("Courier",Font.BOLD,20));
		l_amtpaid.setFont(new Font("Courier",Font.BOLD,20));
		l_status.setFont(new Font("Courier",Font.BOLD,20));
		l_designation.setFont(new Font("Courier",Font.BOLD,20));
		l_address.setFont(new Font("Courier",Font.BOLD,20));
		l_from.setFont(new Font("Courier",Font.BOLD,20));
		l_reimbursed.setFont(new Font("Courier",Font.BOLD,16));

		t_eid.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_ename.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_addr.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_training.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_paid.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_reimbursed.setFont(new Font("Times New Roman",Font.PLAIN,18));

		cmbtod.setFont(new Font("Times New Roman",Font.PLAIN,17));
		cmbtom.setFont(new Font("Times New Roman",Font.PLAIN,17));
		cmbtoy.setFont(new Font("Times New Roman",Font.PLAIN,17));

		bnew.setFont(new Font("Courier",Font.BOLD,20));
		bsubmit.setFont(new Font("Courier",Font.BOLD,20));
		bcancel.setFont(new Font("Courier",Font.BOLD,20));
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==bnew)
		{
			try
			{
				int ctr=1;
		    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hrms","root","");
				String str="select * from performance";
				PreparedStatement ps=con.prepareStatement(str);
				Statement st=con.createStatement();
				ResultSet res=st.executeQuery(str);	
				while(res.next())
				{
					ctr++;
				}				
				if(ctr>0&&ctr<=9)
				{
					t_eid.setText("E00"+ctr);
				}
				else if(ctr>=10&&ctr<=99)
				{
					t_eid.setText("E0"+ctr);
				}
				else if(ctr>=100)
				{
					t_eid.setText("E"+ctr);
				}
				t_ename.setText("");
				t_training.setText("");
				t_paid.setText("");
				t_reimbursed.setText("");
				t_addr.setText("");
			
				cmbdes.setSelectedIndex(0);

				cmbfromd.setSelectedIndex(0);
				cmbfromm.setSelectedIndex(0);
				cmbfromy.setSelectedIndex(0);

				cmbtod.setSelectedIndex(0);
				cmbtom.setSelectedIndex(0);
				cmbtoy.setSelectedIndex(0);

				cmbstatus.setSelectedIndex(0);
			}
			catch(Exception ex)
			{
				System.out.print(ex);
			}
		}
		if(e.getSource()==bsubmit)
		{
			try
			{
				int flag=1;

				//validation
					if(t_ename.getText().equals(""))
					{
						flag=0;
						JOptionPane.showMessageDialog(null,"Enter Name!");
					}
					else if(cmbdes.getSelectedItem().equals("Select"))
					{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Designation!");
					}					
					else if(t_eid.getText().equals(""))
					{
						flag=0;
						JOptionPane.showMessageDialog(null,"Enter Employee ID!");
					}
					else if(t_training.getText().equals(""))
					{
						flag=0;
						JOptionPane.showMessageDialog(null,"Enter Training In!");
					}
					else if(t_paid.getText().equals(""))
					{
						flag=0;
						JOptionPane.showMessageDialog(null,"Enter Amount Paid!");
					}
					else if(t_reimbursed.getText().equals(""))
					{
						flag=0;
						JOptionPane.showMessageDialog(null,"Enter Amount Reimbursed!");
					}
					else if(t_addr.getText().equals(""))
					{
						flag=0;
						JOptionPane.showMessageDialog(null,"Enter Address!");
					}
					else if(cmbtoy.getSelectedItem().equals("yyyy")||cmbfromy.getSelectedItem().equals("yyyy")||cmbtom.getSelectedItem().equals("mm")||cmbfromm.getSelectedItem().equals("mm")||cmbtod.getSelectedItem().equals("dd")||cmbfromd.getSelectedItem().equals("dd"))
					{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Date Properly!");
					}
					else if(cmbstatus.getSelectedItem().equals("--SELECT--"))
					{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Status!");
					}



					//save
					if(flag==1)
					{
					
				    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hrms","root","");
					String str="insert into performance(eid,ename,des,training,cstatus,cfrom,cto,paid,reimbursed,addr)values(?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(str);
					ps.setString(1,t_eid.getText());
					ps.setString(2,t_ename.getText());
					ps.setString(3,""+cmbdes.getSelectedItem());
					ps.setString(4,t_training.getText());
					ps.setString(5,""+cmbstatus.getSelectedItem());
					String from=cmbfromy.getSelectedItem()+"-"+cmbfromm.getSelectedItem()+"-"+cmbfromd.getSelectedItem();
					ps.setString(6,from);

					String to=cmbtoy.getSelectedItem()+"-"+cmbtom.getSelectedItem()+"-"+cmbtod.getSelectedItem();
					ps.setString(7,to);
					ps.setString(8,t_paid.getText());
					ps.setString(9,t_reimbursed.getText());
					ps.setString(10,t_addr.getText());
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null,"Submitted!");			
				}
			}
			catch(Exception ex)
			{
				System.out.print(ex);
			}
		}
		if(e.getSource()==bcancel)
		{
			this.dispose();
		}
	}
	public void focusLost(FocusEvent f)
	{
		if(f.getComponent()==t_eid)
		{
			try
			{
		    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hrms","root","");
				Statement st=con.createStatement();
				ResultSet res=st.executeQuery("select * from emp where eid='"+t_eid.getText()+"'");
				while(res.next())
				{
					flag=1;
					t_ename.setText(res.getString(2));
					t_addr.setText(res.getString(8));
					cmbdes.setSelectedItem(res.getString(9));
				}
			}
			catch(Exception ex)
			{
				System.out.print(ex);
			}
		}
		if(f.getComponent()==t_ename)
		{
			String s=t_ename.getText();
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
						t_ename.setText("");
						break;
					}
				}
			}
		}
		if(f.getComponent()==t_paid)
		{
			String s=t_paid.getText();
			int l=s.length();
			
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
						t_paid.setText("");
						break;
					}
				}
			}		
		}
		if(f.getComponent()==t_reimbursed)
		{
			String s=t_reimbursed.getText();
			int l=s.length();
			
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
						t_reimbursed.setText("");
						break;
					}
				}
			}		
		}
	}
	public void focusGained(FocusEvent f)
	{
		
	}
	public static void main(String args[])throws IOException
	{
		performance obj=new performance();
	}
}