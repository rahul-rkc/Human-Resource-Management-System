//package project;
import java.io.*;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class privileges extends JFrame implements ActionListener,FocusListener,ItemListener
{
	int flag=0;	

	JLabel l_back=new JLabel(new ImageIcon("F:/Project/pics/aa.png"));

	JLabel l_title=new JLabel("PRIVILEGES");
	JLabel l_eid=new JLabel("Employee ID");
	JLabel l_ename=new JLabel("Name");
	JLabel l_dept=new JLabel("Department");
	JLabel l_da=new JLabel("DA");
	JLabel l_hra=new JLabel("HRA");
	JLabel l_wa=new JLabel("WA");
	JLabel l_totall=new JLabel("Total Allowances");
	JLabel l_gpf=new JLabel("GPF");
	JLabel l_it=new JLabel("IT");
	JLabel l_gs=new JLabel("GS");
	JLabel l_pf=new JLabel("PF");
	JLabel l_lic=new JLabel("LIC");
	JLabel l_totded=new JLabel("Total Deductions");
	JLabel l_cas=new JLabel("Casual Leave");
	JLabel l_sick=new JLabel("Sick Leave");
	JLabel l_med=new JLabel("Medical Leave");
	JLabel l_ann=new JLabel("Annual Leave");

	JTextField t_eid=new JTextField();
	JTextField t_ename=new JTextField();
	JTextField t_da=new JTextField();
	JTextField t_hra=new JTextField();
	JTextField t_wa=new JTextField();
	JTextField t_totall=new JTextField("  ");
	JTextField t_gpf=new JTextField();
	JTextField t_it=new JTextField();
	JTextField t_gs=new JTextField();
	JTextField t_pf=new JTextField();
	JTextField t_lic=new JTextField();
	JTextField t_totded=new JTextField("  ");
	JTextField t_cas=new JTextField();
	JTextField t_sick=new JTextField();
	JTextField t_med=new JTextField();
	JTextField t_ann=new JTextField();

	String dept[]={"Select Department","Sales","Analyst","Purchase","EDP","Developer","Programmer","Designer"};
	JComboBox cmbdpt=new JComboBox(dept);
	
	JButton bnew=new JButton("New");
	JButton bsave=new JButton("Save");
	JButton bsearch=new JButton("Search");
	JButton bcancel=new JButton("Cancel");
	JButton btotal=new JButton("Total");

	public privileges()
	{
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setUndecorated(true);
		setLayout(null);
		setVisible(true);
		setSize(1350,740);

		setResizable(false);
		setLocationRelativeTo(null);
		
		add(l_title);
		add(l_eid);
		add(l_ename);
		add(l_dept);
		add(l_da);
		add(l_hra);
		add(l_wa);
		add(l_totall);
		add(l_gpf);
		add(l_it);
		add(l_gs);
		add(l_pf);
		add(l_lic);
		add(l_totded);
		add(l_cas);
		add(l_sick);
		add(l_med);
		add(l_ann);

		add(t_eid);
		add(t_ename);
		add(t_da);
		add(t_hra);
		add(t_wa);
		add(t_totall);
		add(t_gpf);
		add(t_it);
		add(t_gs);
		add(t_pf);
		add(t_lic);
		add(t_totded);
		add(t_cas);
		add(t_sick);
		add(t_med);
		add(t_ann);

		add(bnew);
		add(bsave);
		add(bsearch);
		add(bcancel);
		add(btotal);

		add(cmbdpt);

		add(l_back);

		cmbdpt.addItemListener(this);

		l_title.setBounds(520,20,700,50);
		l_eid.setBounds(80,100,140,50);
		l_ename.setBounds(520,100,140,50);
		l_dept.setBounds(920,100,140,50);
		l_da.setBounds(180,250,140,50);
		l_hra.setBounds(180,300,140,50);
		l_wa.setBounds(180,350,140,50);
		l_totall.setBounds(420,540,160,50);
		l_gpf.setBounds(520,250,140,50);
		l_it.setBounds(520,300,140,50);
		l_gs.setBounds(520,350,140,50);
		l_pf.setBounds(520,400,140,50);
		l_lic.setBounds(520,450,140,50);
		l_totded.setBounds(920,530,160,50);
		l_cas.setBounds(920,250,140,50);
		l_sick.setBounds(920,300,140,50);
		l_med.setBounds(920,350,140,50);
		l_ann.setBounds(920,400,140,50);

		l_title.setFont(new Font("Courier", Font.BOLD,50));
		l_eid.setFont(new Font("Courier",Font.BOLD,20));
		l_dept.setFont(new Font("Courier",Font.BOLD,20));
		l_ename.setFont(new Font("Courier",Font.BOLD,20));
		l_da.setFont(new Font("Courier",Font.BOLD,20));
		l_hra.setFont(new Font("Courier",Font.BOLD,20));
		l_wa.setFont(new Font("Courier",Font.BOLD,20));
		l_totall.setFont(new Font("Courier",Font.BOLD,16));
		l_gpf.setFont(new Font("Courier",Font.BOLD,20));
		l_it.setFont(new Font("Courier",Font.BOLD,20));
		l_gs.setFont(new Font("Courier",Font.BOLD,20));
		l_pf.setFont(new Font("Courier",Font.BOLD,20));
		l_lic.setFont(new Font("Courier",Font.BOLD,20));
		l_totded.setFont(new Font("Courier",Font.BOLD,16));
		l_cas.setFont(new Font("Courier",Font.BOLD,18));
		l_sick.setFont(new Font("Courier",Font.BOLD,18));
		l_med.setFont(new Font("Courier",Font.BOLD,17));
		l_ann.setFont(new Font("Courier",Font.BOLD,18));

		t_eid.setBounds(260,110,181,33);
		t_ename.setBounds(615,110,181,33);
		t_da.setBounds(260,260,181,33);
		t_hra.setBounds(260,310,181,33);
		t_wa.setBounds(260,360,181,33);
		t_totall.setBounds(600,550,181,32);
		t_gpf.setBounds(600,260,181,33);
		t_it.setBounds(600,310,181,33);
		t_gs.setBounds(600,360,181,33);
		t_pf.setBounds(600,410,181,33);
		t_lic.setBounds(600,460,181,33);
		t_totded.setBounds(1090,540,181,32);	
		t_cas.setBounds(1090,260,181,33);
		t_sick.setBounds(1090,310,181,33);
		t_med.setBounds(1090,360,181,33);
		t_ann.setBounds(1090,410,181,33);

		cmbdpt.setBounds(1090,110,181,33);
		cmbdpt.setFont(new Font("Times New Roman",Font.PLAIN,20));

		t_eid.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_ename.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_da.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_hra.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_wa.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_gpf.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_gs.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_it.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_pf.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_lic.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_cas.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_sick.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_med.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_ann.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_totall.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_totded.setFont(new Font("Times New Roman",Font.PLAIN,18));

		l_back.setBounds(-100,-30,1528,830);

		bnew.addActionListener(this);
		bsave.addActionListener(this);
		bsearch.addActionListener(this);
		bcancel.addActionListener(this);
		btotal.addActionListener(this);

		t_eid.addFocusListener(this);
		t_totall.addFocusListener(this);
		t_totded.addFocusListener(this);

		bnew.setBounds(360,630,123,42);
		bsave.setBounds(500,630,123,42);
		bsearch.setBounds(640,630,123,42);
		bcancel.setBounds(780,630,123,42);
		btotal.setBounds(260,550,90,30);

		bnew.setFont(new Font("Courier",Font.BOLD,20));
		bsave.setFont(new Font("Courier",Font.BOLD,20));
		bsearch.setFont(new Font("Courier",Font.BOLD,20));
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
					//t_eid.setText("E00"+ctr);
				}
				else if(ctr>=10&&ctr<=99)
				{
					//t_eid.setText("E0"+ctr);
				}
				else if(ctr>=100)
				{
					//t_eid.setText("E"+ctr);
				}
				t_ename.setText("");
				t_da.setText("");
				t_hra.setText("");
				t_wa.setText("");
				t_totall.setText("");
				t_gpf.setText("");
				t_it.setText("");
				t_gs.setText("");
				t_pf.setText("");
				t_lic.setText("");
				t_totded.setText("");
				t_cas.setText("");
				t_sick.setText("");
				t_med.setText("");
				t_ann.setText("");

				cmbdpt.setSelectedIndex(0);
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
				int flag=1;
				//validation
				if(cmbdpt.getSelectedItem().equals("Select Department"))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Select Department!");
				}
				else if(t_ename.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Name!");
				}
				else if(t_eid.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter ID!");
				}					
				else if(t_da.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter DA!");
				}
				else if(t_hra.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter HRA");
				}
				else if(t_wa.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter WA!");
				}
				else if(t_gpf.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter GPF!");
				}				
				else if(t_it.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter IT!");
				}	
				else if(t_gs.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter GS!");
				}
				else if(t_pf.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter PF");
				}
				else if(t_lic.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter LIC!");
				}								
				else if(t_it.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter IT!");
				}
				else if(t_totall.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Total Allowances!");
				}
				else if(t_totded.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Total Deductions!");
				}
				else if(t_cas.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Casual Leave!");
				}
				else if(t_sick.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Sick Leave!");
				}
				else if(t_med.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Medical Leave!");
				}
				else if(t_ann.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Annual Leave!");
				}	
				//save	
				if(flag==1)		
				{
				    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hrms","root","");
					Statement st=con.createStatement();
					String str="Update emp set da='"+t_da.getText()+"',hra='"+t_hra.getText()+"',wa='"+t_wa.getText()+"',tot_allowance='"+t_totall.getText()+"',gpf='"+t_gpf.getText()+"',it='"+t_it.getText()+"',gs='"+t_gs.getText()+"',pf='"+t_pf.getText()+"',lic='"+t_lic.getText()+"',tot_deduction='"+t_totded.getText()+"',casual='"+t_cas.getText()+"',sick='"+t_sick.getText()+"',medical='"+t_med.getText()+"',annual='"+t_ann.getText()+"' where eid='"+t_eid.getText()+"'";
	
					st.executeUpdate(str);						
					JOptionPane.showMessageDialog(null,"Saved");
				}
			}
			catch(Exception ex)
			{
				System.out.print(ex);
			}
		}
		if(e.getSource()==bsearch)
		{
			try
    		{
    		int flg=0;
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hrms","root","");
			Statement st=con.createStatement();
    		String eid=JOptionPane.showInputDialog(null,"Enter Employee ID:");
    		ResultSet res=st.executeQuery("Select * from emp where eid='"+eid+"'");
    		while(res.next())
    			{	
    				t_eid.setText(res.getString(1));
    				t_ename.setText(res.getString(2));
    				cmbdpt.setSelectedItem(res.getString(3));			
                    t_da.setText(res.getString(14));
                    t_hra.setText(res.getString(15));
                    t_wa.setText(res.getString(16));
                    t_totall.setText(res.getString(17));
                    t_gpf.setText(res.getString(18));
                    t_it.setText(res.getString(19));
                    t_gs.setText(res.getString(20));
                    t_pf.setText(res.getString(21));
                    t_lic.setText(res.getString(22));
                    t_totded.setText(res.getString(23));
                    t_cas.setText(res.getString(24));
                    t_sick.setText(res.getString(25));
                    t_med.setText(res.getString(26));
                    t_ann.setText(res.getString(27)); 
                    flg=1;
                }
                if(flg==0)
                	JOptionPane.showMessageDialog(null,"No such Record present");
            }
            catch(Exception ee)
            {
            	System.out.println(ee);
			}
		}
		
		if(e.getSource()==bcancel)
		{
			this.dispose();
		}
		if(e.getSource()==btotal)
		{
			int da=Integer.parseInt(t_da.getText());
			int hra=Integer.parseInt(t_hra.getText());
			int wa=Integer.parseInt(t_wa.getText());

			int totall=da+hra+wa;

			t_totall.setText(""+totall);

			int gpf=Integer.parseInt(t_gpf.getText());
			int it=Integer.parseInt(t_it.getText());
			int gs=Integer.parseInt(t_gs.getText());
			int pf=Integer.parseInt(t_pf.getText());
			int lic=Integer.parseInt(t_lic.getText());

			int totded=gpf+it+gs+pf+lic;

			t_totded.setText(""+totded);
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
			}
			catch(Exception ex)
			{
				System.out.print(ex);
			}
		}
	}
	public void focusGained(FocusEvent f)
	{
	}

	public void itemStateChanged(ItemEvent ie)
	{
		if(ie.getSource()==cmbdpt)
		{
			try
			{
				int flg=1;
			    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hrms","root","");
				Statement st=con.createStatement();				
				String tempcode=""+cmbdpt.getSelectedItem();
				ResultSet res=st.executeQuery("Select * from remuneration where Emp_Type='"+tempcode+"'");
    			while(res.next())
    			{
					t_hra.setText(res.getString(2));
                    t_da.setText(res.getString(3));
                    t_wa.setText(res.getString(4));
                    t_gpf.setText(res.getString(5));
                    t_it.setText(res.getString(6));
                    t_gs.setText(res.getString(7));
                    t_pf.setText(res.getString(8));
                    t_lic.setText(res.getString(9));
                    t_cas.setText(res.getString(10));
                    t_sick.setText(res.getString(11));
                    t_med.setText(res.getString(12));
                    t_ann.setText(res.getString(13)); 
                    flg=1;
                }
                if(flg==0)
                	JOptionPane.showMessageDialog(null,"No such Record present");
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
	
	public static void main(String args[])throws IOException
	{
		privileges obj=new privileges();
	}
}