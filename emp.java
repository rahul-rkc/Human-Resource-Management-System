//package project;

import java.io.*;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class emp extends JFrame implements ActionListener,FocusListener
{
	int flag=0;

	JLabel l_back=new JLabel(new ImageIcon("F:/Project/pics/aa.png"));
	
	JTextField t_eid=new JTextField();
	JTextField t_ename=new JTextField();
	JTextField t_cont=new JTextField();
	JTextField t_adh=new JTextField();
	JTextField t_addr=new JTextField();
	JTextField t_last=new JTextField();
	JTextField t_basic=new JTextField();
	
	//department		
	String dept[]={"Select Department","Sales","Analyst","Purchase","EDP","Developer","Programmer","Designer"};
	JComboBox cmbdpt=new JComboBox(dept);

	//DOJ
	JComboBox cmbdojd=new JComboBox();
	JComboBox cmbdojm=new JComboBox();
	JComboBox cmbdojy=new JComboBox();

	//DOB
	JComboBox cmbdobd=new JComboBox();
	JComboBox cmbdobm=new JComboBox();		
	JComboBox cmbdoby=new JComboBox();

	//DESIGNATION
	String des[]={"Select","BA","BCOM","BSC","BBA","BCA","BTECH","MA","MCOM","MSC","MBA","MCA","MTECH"};
	JComboBox cmbdes=new JComboBox(des);

	//YEAR OF EXPERIENCE
	String exp[]={"Select","04","05","06","07","08","09","10+"};
	JComboBox cmbexp=new JComboBox(exp);

    JRadioButton rbmale=new JRadioButton("M");
	JRadioButton rbfemale=new JRadioButton("F");
	ButtonGroup gen=new ButtonGroup();
	
	JButton bnew=new JButton("New");
	JButton bsave=new JButton("Save");
	JButton bsearch=new JButton("Search");
	JButton bedit=new JButton("Edit");
	JButton bcancel=new JButton("Cancel");
	JButton epri=new JButton("Privilage Form -->");
	
	public emp()
	{
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setUndecorated(true);
		setLayout(null);
		setVisible(true);
		setSize(1350,740);

		setResizable(false);
		setLocationRelativeTo(null);


		// epri.setContentAreaFilled(false);


		//dob
		cmbdobd.addItem("dd");
		for(int d=1;d<=31;d++)
		{ if(d<10) {
			cmbdobd.addItem("0"+ d);
		}
		else {
			cmbdobd.addItem(""+ d);
		}
		}

		cmbdobm.addItem("mm");
		for(int m=1;m<=12;m++)
		{ if(m<10) {
			cmbdobm.addItem("0"+m);
		}
		else {
			cmbdobm.addItem(""+m);
		}
		}

		cmbdoby.addItem("yyyy");
		for(int y=1985;y<=2021;y++)
		{
			cmbdoby.addItem(""+y);
		}

		//doj
		cmbdojd.addItem("dd");
		for(int d=1;d<=31;d++)
		{ if(d<10) {
			cmbdojd.addItem("0"+ d);
		}
		else {
			cmbdojd.addItem(""+ d);
		}
		}

		cmbdojm.addItem("mm");
		for(int m=1;m<=12;m++)
		{ if(m<10) {
			cmbdojm.addItem("0"+m);
		}
		else {
			cmbdojm.addItem(""+m);
		}
		}

		cmbdojy.addItem("yyyy");
		for(int y=2005;y<=2021;y++)
		{
			cmbdojy.addItem(""+y);
		}

		JLabel l_title=new JLabel("EMPLOYEE DETAILS");
		JLabel l_eid=new JLabel("Employee ID");
		JLabel l_ename=new JLabel("Name");
		JLabel l_gen=new JLabel("Gender");
		JLabel l_cont=new JLabel("Contact No.");
		JLabel l_adh=new JLabel("Aadhar No.");
		JLabel l_addr=new JLabel("Address");
		JLabel l_last=new JLabel("Previous Workplace");
		JLabel l_basic=new JLabel("Basic");
		JLabel l_dpt=new JLabel("Department");
		JLabel l_dob=new JLabel("DOB");
		JLabel l_doj=new JLabel("DOJ");
		JLabel l_des=new JLabel("Designation");
		JLabel l_exp=new JLabel("Experience");

		add(l_title);
		add(l_eid);
		add(l_ename);
		add(l_gen);
		add(l_cont);
		add(l_adh);
		add(l_addr);
		add(l_last);
		add(l_basic);
		add(l_dpt);
		add(l_dob);
		add(l_doj);
		add(l_des);
		add(l_exp);

		add(t_eid);
		add(t_ename);
		add(t_cont);
		add(t_adh);
		add(t_addr);
		add(t_last);
		add(t_basic);
		
		add(cmbdpt);
		add(cmbdobd);
		add(cmbdobm);
		add(cmbdoby);
		add(cmbdojd);
		add(cmbdojm);
		add(cmbdojy);
		add(cmbdes);
		add(cmbexp);
		
		add(rbmale);
		add(rbfemale);
		gen.add(rbmale);
		gen.add(rbfemale);
	
		add(bnew);
		add(bsave);
		add(bsearch);
		add(bedit);
		add(bcancel);
		add(epri);
		add(l_back);

		bnew.addActionListener(this);
		bsave.addActionListener(this);
		bsearch.addActionListener(this);
		bedit.addActionListener(this);
		bcancel.addActionListener(this);
		epri.addActionListener(this);

		t_ename.addFocusListener(this);
		t_cont.addFocusListener(this);
		t_last.addFocusListener(this);
		t_basic.addFocusListener(this);
		t_adh.addFocusListener(this);

		l_back.setBounds(-100,-30,1528,830);

		bedit.setEnabled(false);
		
		l_title.setBounds(470,40,700,35);
        l_eid.setBounds(120,150,180,34);
		l_ename.setBounds(120,200,180,34);
		l_gen.setBounds(120,260,180,34);
		l_des.setBounds(120,320,180,34);
        l_cont.setBounds(770,210,180,34);
        l_addr.setBounds(120,380,180,34);
        l_last.setBounds(770,500,250,34);
		l_basic.setBounds(120,490,180,34);
		l_dpt.setBounds(770,150,180,34);
		l_dob.setBounds(770,270,180,34);
		l_adh.setBounds(770,335,181,34);
		l_doj.setBounds(770,390,180,34);
		l_exp.setBounds(770,440,180,34);

		t_eid.setBounds(340,150,180,34);
		t_ename.setBounds(340,200,180,33);
		t_cont.setBounds(1050,210,180,34);
		t_adh.setBounds(1050,335,180,34);
		t_addr.setBounds(340,380,180,83);
		t_last.setBounds(1050,500,180,34);
		t_basic.setBounds(340,490,180,34);

		//department
		cmbdpt.setBounds(1050,150,180,33);

		//dob
		cmbdobd.setBounds(1050,270,50,35);
		cmbdobm.setBounds(1110,270,50,35);
		cmbdoby.setBounds(1170,270,60,35);

		//doj
		cmbdojd.setBounds(1050,380,50,35);
		cmbdojm.setBounds(1110,380,50,35);
		cmbdojy.setBounds(1170,380,60,35);
		cmbexp.setFont(new Font("Times New Roman",Font.PLAIN,15));
		//DESIGNATION
		cmbdes.setBounds(340,320,180,33);
		
		//YEAR OF EXPERIENCE
		cmbexp.setBounds(1050,440,98,40);
		cmbexp.setFont(new Font("Times New Roman",Font.PLAIN,15));
		
		
		rbmale.setBounds(340,270,50,20);
		rbfemale.setBounds(420,270,50,20);

		bnew.setBounds(200,600,125,41);
		bsave.setBounds(350,600,125,41);
		bsearch.setBounds(500,600,125,41);
		bedit.setBounds(650,600,125,41);
		bcancel.setBounds(800,600,125,41);

		epri.setBounds(950,600,140,41);

		l_title.setFont(new Font("Courier", Font.BOLD,42));
		l_eid.setFont(new Font("Courier",Font.BOLD,18));
		l_ename.setFont(new Font("Courier",Font.BOLD,18));
		l_cont.setFont(new Font("Courier",Font.BOLD,18));
		l_gen.setFont(new Font("Courier",Font.BOLD,18));
		l_adh.setFont(new Font("Courier",Font.BOLD,18));
		l_addr.setFont(new Font("Courier",Font.BOLD,18));
		l_last.setFont(new Font("Courier",Font.BOLD,18));
		l_basic.setFont(new Font("Courier",Font.BOLD,18));
		l_dpt.setFont(new Font("Courier",Font.BOLD,18));
		l_dob.setFont(new Font("Courier",Font.BOLD,18));
		l_doj.setFont(new Font("Courier",Font.BOLD,18));
		l_des.setFont(new Font("Courier",Font.BOLD,18));
		l_exp.setFont(new Font("Courier",Font.BOLD,18));
		
		t_eid.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_ename.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_addr.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_adh.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_basic.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_cont.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_last.setFont(new Font("Times New Roman",Font.PLAIN,18));

		cmbdojd.setFont(new Font("Times New Roman",Font.PLAIN,15));
		cmbdojm.setFont(new Font("Times New Roman",Font.PLAIN,15));
		cmbdojy.setFont(new Font("Times New Roman",Font.PLAIN,15));
		cmbexp.setFont(new Font("Times New Roman",Font.PLAIN,15));
		cmbdes.setFont(new Font("Times New Roman",Font.PLAIN,15));
		cmbdobd.setFont(new Font("Times New Roman",Font.PLAIN,15));
		cmbdobm.setFont(new Font("Times New Roman",Font.PLAIN,15));
		cmbdoby.setFont(new Font("Times New Roman",Font.PLAIN,15));
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
				t_cont.setText("");
				t_adh.setText("");
				t_addr.setText("");
				t_last.setText("");
				t_basic.setText("");	

				cmbdpt.setSelectedIndex(0);
				cmbdobd.setSelectedIndex(0);
				cmbdobm.setSelectedIndex(0);
				cmbdoby.setSelectedIndex(0);
				cmbdojd.setSelectedIndex(0);
				cmbdojm.setSelectedIndex(0);
				cmbdojy.setSelectedIndex(0);
				cmbexp.setSelectedIndex(0);
				cmbdes.setSelectedIndex(0);

				gen.clearSelection();
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
				if(cmbdojy.getSelectedItem().equals("yyyy")||cmbdoby.getSelectedItem().equals("yyyy")||cmbdojm.getSelectedItem().equals("mm")||cmbdobm.getSelectedItem().equals("mm")||cmbdojd.getSelectedItem().equals("dd")||cmbdobd.getSelectedItem().equals("dd"))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Date Properly!");
					cmbdobd.setSelectedIndex(0);
					cmbdobm.setSelectedIndex(0);
					cmbdoby.setSelectedIndex(0);
					cmbdojd.setSelectedIndex(0);
					cmbdojm.setSelectedIndex(0);
					cmbdojy.setSelectedIndex(0);
				}	
				else if(t_ename.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Name!");
				}	
				else if((rbmale.isSelected()==false)&&(rbfemale.isSelected()==false))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Select Gender!");
				}
				else if(cmbdpt.getSelectedItem().equals("Select Department"))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Department!");
				}
				else if(cmbdes.getSelectedItem().equals("Select"))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Designation!");
				}
				else if(t_addr.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Address!");
				}
				else if(t_cont.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Contact Number!");
				}
				else if(t_adh.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Adhaar Number!");
				}
				else if(t_last.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Last Worked At!");
				}
				else if(cmbexp.getSelectedItem().equals("Select"))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Years Of Experience!");
				}
				else if(t_basic.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Basic Salary!");
				}

				//save
				if(flag==1)
				{
				    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hrms","root","");
					String str="Insert into emp(eid,empname,dept,gen,dob,con,adhar,addr,des,doj,last,exp,basicsal,da,hra,wa,tot_allowance,gpf,it,gs,pf,lic,tot_deduction,casual,sick,medical,annual)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(str);
					ps.setString(1,t_eid.getText());
					ps.setString(2,t_ename.getText());
					ps.setString(3,""+cmbdpt.getSelectedItem());
					String gen="";
					if(rbmale.isSelected())
						gen="MALE";
					else
						gen="FEMALE";
					ps.setString(4,gen);
					String dob=cmbdoby.getSelectedItem()+"-"+cmbdobm.getSelectedItem()+"-"+cmbdobd.getSelectedItem();
					ps.setString(5,dob);
					ps.setString(6,t_cont.getText());
					ps.setString(7,t_adh.getText());
					ps.setString(8,t_addr.getText());
					ps.setString(9,(String)cmbdes.getSelectedItem());
					ps.setString(12,(String)cmbexp.getSelectedItem());
					ps.setString(11,t_last.getText());
					String doj=cmbdojy.getSelectedItem()+"-"+cmbdojm.getSelectedItem()+"-"+cmbdojd.getSelectedItem();
					ps.setString(10,doj);
					ps.setString(13,t_basic.getText());
					ps.setString(14, "");
					ps.setString(15, "");
					ps.setString(16, "");
					ps.setString(17, "");
					ps.setString(18, "");
					ps.setString(19, "");
					ps.setString(20, "");
					ps.setString(21, "");
					ps.setString(22, "");
					ps.setString(23, "");
					ps.setString(24, "");
					ps.setString(25, "");
					ps.setString(26, "");
					ps.setString(27, "");
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null,"Saved!");
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
				bedit.setEnabled(true);
			    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hrms","root","");
				Statement st=con.createStatement();
				String eid=JOptionPane.showInputDialog(null,"Enter Employee Type:");
				ResultSet res=st.executeQuery("select * from emp where eid='"+eid+"'");
				while(res.next())
				{
					flag=1;
					t_eid.setText(res.getString(1));
					t_ename.setText(res.getString(2));
					cmbdpt.setSelectedItem(res.getString(3));
					String gen=res.getString(4);
					if(gen.equals("MALE"))
						rbmale.setSelected(true);
					else
						rbfemale.setSelected(true);
				
					//dob
					String arr[]=res.getString(5).toString().split("-");
					cmbdobd.setSelectedItem(arr[2]);
					cmbdobm.setSelectedItem(arr[1]);
					cmbdoby.setSelectedItem(arr[0]);

					t_cont.setText(res.getString(6));
					t_adh.setText(res.getString(7));
					t_addr.setText(res.getString(8));

					cmbdes.setSelectedItem(res.getString(9));

					//doj
					String arr1[]=res.getString(10).toString().split("-");
					cmbdojd.setSelectedItem(arr1[2]);
					cmbdojm.setSelectedItem(arr1[1]);
					cmbdojy.setSelectedItem(arr1[0]);

					t_last.setText(res.getString(11));
					cmbexp.setSelectedItem(res.getString(12));
					t_basic.setText(res.getString(13));
				}
				if(flag==0)
					{
						JOptionPane.showMessageDialog(null,"No Such Record");
					}

			}
			catch(Exception ex)
			{
				System.out.print(ex);
			}
		}
		if(e.getSource()==bedit)
		{
			try
			{
				int flag=1;

				//validation
				if(cmbdojy.getSelectedItem().equals("yyyy")||cmbdoby.getSelectedItem().equals("yyyy")||cmbdojm.getSelectedItem().equals("mm")||cmbdobm.getSelectedItem().equals("mm")||cmbdojd.getSelectedItem().equals("dd")||cmbdobd.getSelectedItem().equals("dd"))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Date Properly!");
					cmbdobd.setSelectedIndex(0);
					cmbdobm.setSelectedIndex(0);
					cmbdoby.setSelectedIndex(0);
					cmbdojd.setSelectedIndex(0);
					cmbdojm.setSelectedIndex(0);
					cmbdojy.setSelectedIndex(0);
				}
				else if(t_eid.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter ID!");
				}
				else if(t_eid.getText().equals(""))
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
				else if(cmbdes.getSelectedItem().equals("Select"))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Designation!");
				}
				else if(t_addr.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Address!");
				}
				else if(t_cont.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Contact Number!");
				}
				else if(t_adh.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Adhaar Number!");
				}
				else if(t_last.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Last Worked At!");
				}
				else if(cmbexp.getSelectedItem().equals("Select"))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Years Of Experience!");
				}
				else if(t_basic.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Basic Salary!");
				}

				//update
				if(flag==1)
				{
				    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hrms","root","");
					Statement st=con.createStatement();
					String g;
					if(rbmale.isSelected())
						g="MALE";
					else
						g="FEMALE";
					String str="Update emp set empname='"+t_ename.getText()+"',dept='"+cmbdpt.getSelectedItem()+"',dob='"+cmbdoby.getSelectedItem()+"-"+cmbdobm.getSelectedItem()+"-"+cmbdobd.getSelectedItem()+"',con='"+t_cont.getText()+"',adhar='"+t_adh.getText()+"',addr='"+t_addr.getText()+"',des='"+cmbdes.getSelectedItem()+"',doj='"+cmbdojy.getSelectedItem()+"-"+cmbdojm.getSelectedItem()+"-"+cmbdojd.getSelectedItem()+"',last='"+t_last.getText()+"',exp='"+cmbexp.getSelectedItem()+"',basicsal='"+t_basic.getText()+"',gen='"+g+"'where eid='"+t_eid.getText()+"'";
					st.executeUpdate(str);
					JOptionPane.showMessageDialog(null,"RECORD UPDATED");
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
		if(e.getSource()==epri)
		{
			privileges obj=new privileges();
		}
			
	}
	public void focusLost(FocusEvent f)
	{
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
		if(f.getComponent()==t_last)
		{
			String s=t_last.getText();
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
						t_last.setText("");
						break;
					}
				}
			}
		}
		if(f.getComponent()==t_cont)
		{
			String s=t_cont.getText();
			int l=s.length();
			if(l==10)
			{
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
							t_cont.setText("");
							break;
						}
					}
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Invalid Format!");
				t_cont.setText("");
			}
		}
		if(f.getComponent()==t_basic)
		{
			String s=t_basic.getText();
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
						t_basic.setText("");
						break;
					}
				}
			}
		}
		if(f.getComponent()==t_adh)
		{			
			String s=t_adh.getText();
			int l=s.length();
			if(l==12)
			{
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
							t_adh.setText("");
							break;
						}
					}
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Invalid Format!");
				t_adh.setText("");
			}
		}

	}
	public void focusGained(FocusEvent f)
	{
		
	}

	public static void main(String args[])throws IOException
	{
		emp obj=new emp();
	}
}