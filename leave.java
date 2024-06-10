//package project;

import java.io.*;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class leave extends JFrame implements ActionListener,FocusListener,ItemListener
{
	int flag=0;

	JLabel l_back=new JLabel(new ImageIcon("F:/Project/pics/aa.png"));

	//JLabel l_left=new JLabel("LEFT");

	JTextField t_eid=new JTextField();
	JTextField t_ename=new JTextField();
	JTextField t_no=new JTextField();
	JTextField t_rea=new JTextField();
	JTextField t_left=new JTextField();

	JLabel l_title=new JLabel("LEAVE APPLICATION FORM");
	JLabel l_eid=new JLabel("Employee ID");
	JLabel l_ename=new JLabel("Employee Name");
	JLabel l_lcode=new JLabel("Leave Code");
	JLabel l_start =new JLabel("Start Date");
	JLabel l_nod=new JLabel("No of Days");
	JLabel l_rol=new JLabel("Reason of Leave");
	JLabel l_dept=new JLabel("Department");
	JLabel l_left=new JLabel("Left");
	JLabel l_end=new JLabel("End Date");

	String leave_code[]={"SELECT","CASUAL","SICK","MEDICAL","ANNUAL"};
	JComboBox cmbcode=new JComboBox(leave_code);

	JComboBox cmbsd=new JComboBox();
	JComboBox cmbsm=new JComboBox();
	JComboBox cmbsy=new JComboBox();

	JComboBox cmbed=new JComboBox();
	JComboBox cmbem=new JComboBox();		
	JComboBox cmbey=new JComboBox();

	String des[]={"select department","Sales","Purchase","EDP","Developer","Programmer","Designer"};
	JComboBox cmbdpt=new JComboBox(des);

	JButton bnew=new JButton("New");
	JButton bsave=new JButton("Save");
	JButton bapply=new JButton("Apply");
	JButton bcancel=new JButton("Cancel");

	public leave()
	{
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setUndecorated(true);
		setLayout(null);
		setVisible(true);
		setSize(1368,800);

		setResizable(false);
		setLocationRelativeTo(null);

		//t_eid.setBorder(null);
		//t_eid.setOpaque(false);

		//t_ename.setBorder(null);
		//t_ename.setOpaque(false);

		//t_no.setBorder(null);
		//t_no.setOpaque(false);

		//t_rea.setBorder(null);
		//t_rea.setOpaque(false);

		//t_left.setBorder(null);
		//t_left.setOpaque(false);

		bsave.setEnabled(false);

		bnew.setContentAreaFilled(false);	
		bsave.setContentAreaFilled(false);
		bapply.setContentAreaFilled(false);
		bcancel.setContentAreaFilled(false);

		cmbsd.addItem("dd");
		for(int d=1;d<=31;d++)
		{
			cmbsd.addItem(""+d);
		}

		cmbsm.addItem("mm");
		for(int m=1;m<=12;m++)
		{
			cmbsm.addItem(""+m);
		}

		cmbsy.addItem("yyyy");
		for(int y=1995;y<=2019;y++)
		{
			cmbsy.addItem(""+y);
		}

		cmbed.addItem("dd");
		for(int d=1;d<=31;d++)
		{
			cmbed.addItem(""+d);
		}

		cmbem.addItem("mm");
		for(int m=1;m<=12;m++)
		{
			cmbem.addItem(""+m);
		}

		cmbey.addItem("yyyy");
		for(int y=2010;y<=2019;y++)
		{
			cmbey.addItem(""+y);
		}

		//add(l_left);

		add(t_eid);
		add(t_ename);
		add(t_no);
		add(t_rea);
		add(t_left);

		add(l_title);
		add(l_eid);
		add(l_ename);
		add(l_lcode);
		add(l_start);
		add(l_nod);
		add(l_rol);
		add(l_dept);
		add(l_left);
		add(l_end);

		add(cmbcode);
		add(cmbdpt);

		add(cmbsd);
		add(cmbsm);
		add(cmbsy);

		add(cmbed);
		add(cmbem);
		add(cmbey);

		add(bnew);
		add(bsave);
		add(bapply);
		add(bcancel);

		add(l_back);

		bnew.addActionListener(this);
		bsave.addActionListener(this);
		bapply.addActionListener(this);
		bcancel.addActionListener(this);

		t_eid.addFocusListener(this);
		t_ename.addFocusListener(this);
		t_left.addFocusListener(this);
		t_no.addFocusListener(this);
		t_rea.addFocusListener(this);

		cmbcode.addItemListener(this);

		//l_left.setBounds(450,170,150,35);

		t_eid.setBounds(440,180,180,34);
		t_ename.setBounds(440,230,180,33);
		t_no.setBounds(440,380,180,33);
		t_rea.setBounds(440,440,180,33);
		t_left.setBounds(1000,255,180,33);
		
		l_title.setBounds(350,65,700,35);
		l_eid.setBounds(240,180,180,34);
		l_ename.setBounds(240,230,180,34);
		l_lcode.setBounds(240,280,180,34);
		l_start.setBounds(240,330,180,34);
		l_nod.setBounds(240,380,180,34);
		l_rol.setBounds(240,440,180,34);
		l_dept.setBounds(800,205,180,34);
		l_left.setBounds(800,255,180,34);
		l_end.setBounds(800,305,180,34);

		cmbcode.setBounds(440,280,180,33);

		cmbdpt.setBounds(1000,205,180,33);		

		cmbsd.setBounds(440,330,48,30);
		cmbsm.setBounds(505,330,50,30);
		cmbsy.setBounds(570,330,50,30);

		cmbed.setBounds(1000,305,48,25);
		cmbem.setBounds(1065,305,50,25);
		cmbey.setBounds(1130,305,50,25);

		bnew.setBounds(340,570,124,41);
		bsave.setBounds(520,570,124,41);
		bapply.setBounds(700,570,124,41);
		bcancel.setBounds(880,570,124,41);

		l_title.setFont(new Font("Courier", Font.BOLD,42));
		
		t_eid.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_ename.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_no.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_rea.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_left.setFont(new Font("Times New Roman",Font.PLAIN,18));

		//l_title.setFont(new Font("Courier",Font.BOLD,18));
		l_eid.setFont(new Font("Courier",Font.BOLD,18));
		l_ename.setFont(new Font("Courier",Font.BOLD,18));
		l_lcode.setFont(new Font("Courier",Font.BOLD,18));
		l_start.setFont(new Font("Courier",Font.BOLD,18));
		l_nod.setFont(new Font("Courier",Font.BOLD,18));
		l_rol.setFont(new Font("Courier",Font.BOLD,18));
		l_dept.setFont(new Font("Courier",Font.BOLD,18));
		l_left.setFont(new Font("Courier",Font.BOLD,18));
		l_end.setFont(new Font("Courier",Font.BOLD,18));
		
		l_back.setBounds(-100,-30,1528,830);

		cmbdpt.setFont(new Font("Times New Roman",Font.PLAIN,18));	
		cmbsd.setFont(new Font("Times New Roman",Font.PLAIN,15));
   		cmbsm.setFont(new Font("Times New Roman",Font.PLAIN,15));
   		cmbsy.setFont(new Font("Times New Roman",Font.PLAIN,12));
   		cmbed.setFont(new Font("Times New Roman",Font.PLAIN,15));
   		cmbem.setFont(new Font("Times New Roman",Font.PLAIN,15));
   		cmbey.setFont(new Font("Times New Roman",Font.PLAIN,12));
		  			
		   bnew.setFont(new Font("Courier",Font.BOLD,20));
		   bsave.setFont(new Font("Courier",Font.BOLD,20));
		   bapply.setFont(new Font("Courier",Font.BOLD,20));
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
					t_eid.setText("E00");
				}
				else if(ctr>=10&&ctr<=99)
				{
					t_eid.setText("E0");
				}
				else if(ctr>=100)
				{
					t_eid.setText("E");
				}
				t_ename.setText("");
				t_no.setText("");
				t_rea.setText("");
			
				cmbcode.setSelectedIndex(0);

				cmbdpt.setSelectedIndex(0);

				cmbsd.setSelectedIndex(0);
				cmbsm.setSelectedIndex(0);
				cmbsy.setSelectedIndex(0);
				cmbed.setSelectedIndex(0);
				cmbem.setSelectedIndex(0);
				cmbey.setSelectedIndex(0);

				bapply.setEnabled(true);
			}
			catch(Exception ex)
			{
				System.out.print(ex);
			}
		}
		if(e.getSource()==bsave)
		{
			try
			{
				int flg=1;
				if(t_eid.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter ID!");
				}
				else if(t_ename.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Name!");
				}				
				else if(cmbdpt.getSelectedItem().equals("Select Department"))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Department!");
				}
				else if(cmbcode.getSelectedItem().equals("SELECT"))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Leave Code!");
				}				
				else if(t_left.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Leaves Left!");
				}
				else if(cmbsy.getSelectedItem().equals("yyyy")||cmbey.getSelectedItem().equals("yyyy")||cmbsm.getSelectedItem().equals("mm")||cmbem.getSelectedItem().equals("mm")||cmbsd.getSelectedItem().equals("dd")||cmbed.getSelectedItem().equals("dd"))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Date Properly!");				
				}
				else if(t_no.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Number Of Days!");
				}
				else if(t_rea.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Reason Of Leave!");
				}
				
				if (flg==1)
				{				
				    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hrms","root","");
					String str="Insert into leave(eid,ename,des,leave_code,start_date,end_date,no_of_days,reason)values(?,?,?,?,?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(str);
					ps.setString(1,t_eid.getText());
					ps.setString(2,t_ename.getText());
					ps.setString(3,""+cmbdpt.getSelectedItem());
					ps.setString(4,""+cmbcode.getSelectedItem());
					String start=cmbsd.getSelectedItem()+"/"+cmbsm.getSelectedItem()+"/"+cmbsy.getSelectedItem();
					ps.setString(5,start);
					String end=cmbed.getSelectedItem()+"/"+cmbem.getSelectedItem()+"/"+cmbey.getSelectedItem();
					ps.setString(6,end);
					ps.setString(7,t_no.getText());
					ps.setString(8,t_rea.getText());
					
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null,"Saved");
				}
			}
			catch(Exception ex)
			{
				System.out.print(ex);
			}
		}
		if(e.getSource()==bapply)
		{
			try
			{
				int flg=1;

				if(t_eid.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter ID!");
				}
				else if(t_ename.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Name!");
				}				
				else if(cmbdpt.getSelectedItem().equals("Select Department"))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Department!");
				}
				else if(cmbcode.getSelectedItem().equals("SELECT"))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Leave Code!");
				}				
				else if(t_left.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Leaves Left!");
				}
				else if(cmbsy.getSelectedItem().equals("yyyy")||cmbey.getSelectedItem().equals("yyyy")||cmbsm.getSelectedItem().equals("mm")||cmbem.getSelectedItem().equals("mm")||cmbsd.getSelectedItem().equals("dd")||cmbed.getSelectedItem().equals("dd"))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Date Properly!");				
				}
				else if(t_no.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Number Of Days!");
				}
				else if(t_rea.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Reason Of Leave!");
				}
				
				if(flg==1)
				{
					bsave.setEnabled(true);
							
				    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hrms","root","");
					Statement st=con.createStatement();
					ResultSet res=st.executeQuery("select * from emp where eid='"+t_eid.getText()+"'");
					int l=Integer.parseInt(t_left.getText());
					String ltype="";
					String code=cmbcode.getSelectedItem()+"";
					while(res.next())
					{
						if(code.equals("CASUAL"))
						{
							ltype=res.getString(24);		
						}
						else if(code.equals("SICK"))
						{
							ltype=res.getString(25);		
						}
						else if(code.equals("MEDICAL"))
						{
							ltype=res.getString(26);			
						}
						else
						{
							ltype=res.getString(27);		
						}	
					}
					int a=Integer.parseInt(ltype);
					int b=Integer.parseInt(t_no.getText());
					int c;
					c=a-b;
					if(a<=b)
					{
						JOptionPane.showMessageDialog(null,"Not Enough Leave Left!");
						t_no.setText("");
					}
					else
					{
						String str="Update emp set "+cmbcode.getSelectedItem()+"="+c+" where eid='"+t_eid.getText()+"'";
						st.executeUpdate(str);
						JOptionPane.showMessageDialog(null,"Request Sent!");
					}
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
					cmbdpt.setSelectedItem(res.getString(3));
				}
				if(flag==0)
				{
						JOptionPane.showMessageDialog(null,"Please Enter Valid ID");
						t_eid.setText("");
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
			int l=s.length();
			
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
		if(f.getComponent()==t_rea)
		{
			String s=t_rea.getText();
			int l=s.length();
			
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
						t_rea.setText("");
						break;
					}
				}
			}		
		}
		if(f.getComponent()==t_left)
		{
			String s=t_left.getText();
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
						t_left.setText("");
						break;
					}
				}
			}		
		}
		if(f.getComponent()==t_no)
		{
			String s=t_no.getText();
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
						t_no.setText("");
						break;
					}
				}
			}		
		}
	}
	public void focusGained(FocusEvent f)
	{
	}
	public void itemStateChanged(ItemEvent ie)
	{
		if(ie.getSource()==cmbcode)
		{
			try
			{
				//l_left.setVisible(true);
				//t_left.setVisible(true);
			    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hrms","root","");
				Statement st=con.createStatement();
				ResultSet res=st.executeQuery("select "+cmbcode.getSelectedItem()+"  from emp where eid='"+t_eid.getText()+"'");
				while(res.next())
				{
					t_left.setText(res.getString(1));
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
	public static void main(String args[])throws IOException
	{
		leave obj=new leave();
	}
}