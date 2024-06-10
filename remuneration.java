//package project;

import java.io.*;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class remuneration extends JFrame implements ActionListener,ItemListener,FocusListener
{
	JLabel l_back=new JLabel(new ImageIcon("F:/Project/pics/aa.png"));

	String dept[]={"Select Department","Sales","Analyst","Purchase","EDP","Developer","Programmer","Designer"};
	JComboBox cmbdpt=new JComboBox(dept);
	
	JLabel l_title=new JLabel("REMUNERATION");
	JLabel l_emp=new JLabel("Employee Type");
	JLabel l_da=new JLabel("DA");
	JLabel l_hra=new JLabel("HRA");
	JLabel l_wa=new JLabel("WA");
	JLabel l_gpf=new JLabel("GPF");
	JLabel l_it=new JLabel("IT");
	JLabel l_gs=new JLabel("GS");
	JLabel l_pf=new JLabel("PF");
	JLabel l_lic=new JLabel("LIC");
	JLabel l_cas=new JLabel("Casual Leave");
	JLabel l_sick=new JLabel("Sick Leave");
	JLabel l_med=new JLabel("Medical Leave");
	JLabel l_ann=new JLabel("Annual Leave");

	JTextField t_da=new JTextField();
	JTextField t_hra=new JTextField();
	JTextField t_wa=new JTextField();
	JTextField t_gpf=new JTextField();
	JTextField t_it=new JTextField();
	JTextField t_gs=new JTextField();
	JTextField t_pf=new JTextField();
	JTextField t_lic=new JTextField();
	JTextField t_cas=new JTextField();
	JTextField t_sick=new JTextField();
	JTextField t_med=new JTextField();
	JTextField t_ann=new JTextField();

	JButton bnew=new JButton("New");
	JButton bsave=new JButton("Save");
	JButton bedit=new JButton("Edit");
	JButton bsearch=new JButton("Search");
	JButton bcancel=new JButton("Cancel");

	public remuneration()
	{
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setUndecorated(true);
		setLayout(null);
		setVisible(true);
		setSize(1350,740);

		setResizable(false);
		setLocationRelativeTo(null);

		bedit.setEnabled(false);
		
		add(cmbdpt);

		add(l_title);
		add(l_emp);
		add(l_da);
		add(l_hra);
		add(l_wa);
		add(l_gpf);
		add(l_it);
		add(l_gs);
		add(l_pf);
		add(l_lic);
		add(l_cas);
		add(l_sick);
		add(l_med);
		add(l_ann);

		add(t_da);
		add(t_hra);
		add(t_wa);
		add(t_gpf);
		add(t_it);
		add(t_gs);
		add(t_pf);
		add(t_lic);
		add(t_cas);
		add(t_sick);
		add(t_med);
		add(t_ann);

		add(bnew);
		add(bsave);
		add(bsearch);
		add(bedit);
		add(bcancel);

		add(l_back);

		l_back.setBounds(-100,-30,1528,830);

		bnew.addActionListener(this);
		bsave.addActionListener(this);		
		bsearch.addActionListener(this);
		bedit.addActionListener(this);
		bcancel.addActionListener(this);

		t_hra.addFocusListener(this);
		t_da.addFocusListener(this);
		t_wa.addFocusListener(this);
		t_gpf.addFocusListener(this);
		t_it.addFocusListener(this);
		t_gs.addFocusListener(this);
		t_pf.addFocusListener(this);
		t_lic.addFocusListener(this);
		t_cas.addFocusListener(this);
		t_med.addFocusListener(this);
		t_ann.addFocusListener(this);
		t_sick.addFocusListener(this);

		cmbdpt.addItemListener(this);

		cmbdpt.setBounds(640,140,150,33);
		cmbdpt.setFont(new Font("Times New Roman",Font.PLAIN,20));

		l_title.setBounds(520,20,700,50);
		l_emp.setBounds(450,130,160,50);
		l_da.setBounds(180,250,140,50);
		l_hra.setBounds(180,300,140,50);
		l_wa.setBounds(180,350,140,50);
		l_gpf.setBounds(520,250,140,50);
		l_it.setBounds(520,300,140,50);
		l_gs.setBounds(520,350,140,50);
		l_pf.setBounds(520,400,140,50);
		l_lic.setBounds(520,450,140,50);
		l_cas.setBounds(920,250,140,50);
		l_sick.setBounds(920,300,140,50);
		l_med.setBounds(920,350,140,50);
		l_ann.setBounds(920,400,140,50);

		l_title.setFont(new Font("Courier", Font.BOLD,50));
		l_emp.setFont(new Font("Courier",Font.BOLD,20));
		l_da.setFont(new Font("Courier",Font.BOLD,20));
		l_hra.setFont(new Font("Courier",Font.BOLD,20));
		l_wa.setFont(new Font("Courier",Font.BOLD,20));
		l_gpf.setFont(new Font("Courier",Font.BOLD,20));
		l_it.setFont(new Font("Courier",Font.BOLD,20));
		l_gs.setFont(new Font("Courier",Font.BOLD,20));
		l_pf.setFont(new Font("Courier",Font.BOLD,20));
		l_lic.setFont(new Font("Courier",Font.BOLD,20));
		l_cas.setFont(new Font("Courier",Font.BOLD,18));
		l_sick.setFont(new Font("Courier",Font.BOLD,18));
		l_med.setFont(new Font("Courier",Font.BOLD,17));
		l_ann.setFont(new Font("Courier",Font.BOLD,18));


		t_da.setBounds(260,260,181,33);
		t_hra.setBounds(260,310,181,33);
		t_wa.setBounds(260,360,181,33);
		t_gpf.setBounds(600,260,181,33);
		t_it.setBounds(600,310,181,33);
		t_gs.setBounds(600,360,181,33);
		t_pf.setBounds(600,410,181,33);
		t_lic.setBounds(600,460,181,33);
		t_cas.setBounds(1090,260,181,33);
		t_sick.setBounds(1090,310,181,33);
		t_med.setBounds(1090,360,181,33);
		t_ann.setBounds(1090,410,181,33);

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

		t_hra.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_da.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_wa.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_gpf.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_it.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_gs.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_pf.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_lic.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_cas.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_sick.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_med.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_ann.setFont(new Font("Times New Roman",Font.PLAIN,18));


		bnew.setBounds(340,600,123,42);
		bsave.setBounds(480,600,123,42);
		bsearch.setBounds(620,600,123,42);
		bedit.setBounds(760,600,123,42);
		bcancel.setBounds(900,600,123,42);

		bnew.setFont(new Font("Courier",Font.BOLD,20));
		bsave.setFont(new Font("Courier",Font.BOLD,20));
		bsearch.setFont(new Font("Courier",Font.BOLD,20));
		bedit.setFont(new Font("Courier",Font.BOLD,20));
		bcancel.setFont(new Font("Courier",Font.BOLD,20));

		repaint();

	}
	public void actionPerformed(ActionEvent e)
	{

		if(e.getSource()==bnew)
		{
			
				t_da.setText("");
				t_hra.setText("");
				t_wa.setText("");
				t_gpf.setText("");
				t_it.setText("");
				t_gs.setText("");
				t_pf.setText("");
				t_lic.setText("");
				t_cas.setText("");
				t_sick.setText("");
				t_med.setText("");
				t_ann.setText("");

				cmbdpt.setSelectedIndex(0);
			
		}
    	if(e.getSource()==bsearch)
    	{
    		try
    		{
    			bedit.setEnabled(true);
    			int flg=0;
			    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hrms","root","");
				Statement st=con.createStatement();
    			String tempcode=JOptionPane.showInputDialog(null,"Enter Employee Type:");
    			ResultSet res=st.executeQuery("Select * from remuneration where Emp_Type='"+tempcode+"'");
    			while(res.next())
    			{
    				cmbdpt.setSelectedItem(res.getString(1));
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
            catch(Exception ee)
            {
            	System.out.println(ee);
			}
		}
		if(e.getSource()==bcancel)
		{
                this.dispose();
		}
		if(e.getSource()==bedit)
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
				//edit	
				if(flag==1)
				{
					
				    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hrms","root","");
					ResultSet res;
					Statement st=con.createStatement();
					res=st.executeQuery("select * from remuneration");
					String Str="update remuneration set hra="+Integer.parseInt(t_hra.getText())+",da="+Integer.parseInt(t_da.getText())+",wa="+Integer.parseInt(t_wa.getText())+",gpf="+Integer.parseInt(t_gpf.getText())+",it="+Integer.parseInt(t_it.getText())+",gis="+Integer.parseInt(t_gs.getText())+",pf="+Integer.parseInt(t_pf.getText())+",lic="+Integer.parseInt(t_lic.getText())+",casual="+Integer.parseInt(t_cas.getText())+",sick="+Integer.parseInt(t_sick.getText())+",medical="+Integer.parseInt(t_med.getText())+",annual="+Integer.parseInt(t_ann.getText())+" where Emp_Type='"+cmbdpt.getSelectedItem()+"'";
					st.executeUpdate(Str);
					JOptionPane.showMessageDialog(null,"Updated Successfully");
				}  
			}  
            catch(Exception ex)
            {
            	System.out.println(ex);
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
	        		String str="insert into remuneration(Emp_Type,Hra,Da,Wa,Gpf,It,Gis,Pf,Lic,casual,sick,medical,annual)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	        		PreparedStatement ps=con.prepareStatement(str);
	        		ps.setString(1,""+cmbdpt.getSelectedItem());
	        		ps.setString(2,""+t_hra.getText());
	        		ps.setString(3,t_da.getText());
	        		ps.setString(4,t_wa.getText());
	        		ps.setString(5,t_gpf.getText());
	        		ps.setString(6,t_it.getText());
	        		ps.setString(7,t_gs.getText());
	        		ps.setString(8,t_pf.getText());
	        		ps.setString(9,t_lic.getText());
	        		ps.setString(10,t_cas.getText());
	        		ps.setString(11,t_sick.getText());
	        		ps.setString(12,t_med.getText());
	        		ps.setString(13,t_ann.getText());
	        		ps.executeUpdate();
	        		JOptionPane.showMessageDialog(null,"Saved Successfully");
	        	}
	        }
        	catch(Exception ee)
        	{
        		System.out.println(ee);
        	}
        }
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
	public void focusLost(FocusEvent f)
	{
		if(f.getComponent()==t_hra)
		{
			String s=t_hra.getText();
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
						t_hra.setText("");
						break;
					}
				}
			}		
		}
		if(f.getComponent()==t_da)
		{
			String s=t_da.getText();
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
						t_da.setText("");
						break;
					}
				}
			}		
		}
		if(f.getComponent()==t_wa)
		{
			String s=t_wa.getText();
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
						t_wa.setText("");
						break;
					}
				}
			}		
		}
		if(f.getComponent()==t_gpf)
		{
			String s=t_gpf.getText();
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
						t_gpf.setText("");
						break;
					}
				}
			}		
		}
		if(f.getComponent()==t_it)
		{
			String s=t_it.getText();
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
						t_it.setText("");
						break;
					}
				}
			}		
		}
		if(f.getComponent()==t_gs)
		{
			String s=t_gs.getText();
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
						t_gs.setText("");
						break;
					}
				}
			}		
		}
		if(f.getComponent()==t_pf)
		{
			String s=t_pf.getText();
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
						t_pf.setText("");
						break;
					}
				}
			}		
		}
		if(f.getComponent()==t_lic)
		{
			String s=t_lic.getText();
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
						t_lic.setText("");
						break;
					}
				}
			}		
		}
		if(f.getComponent()==t_cas)
		{
			String s=t_cas.getText();
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
						t_cas.setText("");
						break;
					}
				}
			}		
		}
		if(f.getComponent()==t_sick)
		{
			String s=t_sick.getText();
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
						t_sick.setText("");
						break;
					}
				}
			}		
		}
		if(f.getComponent()==t_med)
		{
			String s=t_med.getText();
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
						t_med.setText("");
						break;
					}
				}
			}		
		}
		if(f.getComponent()==t_ann)
		{
			String s=t_ann.getText();
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
						t_ann.setText("");
						break;
					}
				}
			}		
		}
	}
	public void focusGained(FocusEvent f)
	{		
	}
    public static void main(String argv[])throws IOException
    {
    	remuneration obj=new remuneration();
    }
}