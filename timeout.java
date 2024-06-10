//package project;

import java.io.*;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
public class timeout extends JFrame implements ActionListener,ItemListener
{
	JLabel l_back=new JLabel(new ImageIcon("F:/Project/pics/aa.png"));

	JLabel l_title=new JLabel("TIMEOUT");
	JLabel l_date=new JLabel("Date");
	JLabel l_dept=new JLabel("Department");

	JTextField t_date=new JTextField();

	JButton brefresh=new JButton("Refresh");
	JButton bsave=new JButton("Save");
	JButton bcancel=new JButton("Cancel");
	JButton bleft=new JButton("Timeout");

	String des[]={"SELECT"};
	JComboBox cmbdept=new JComboBox(des);

	///table 1
	String col1[]={"ID","NAME"};
	Object[][] data1={{"l_eid","l_ename"}};
	DefaultTableModel model1=new DefaultTableModel(col1,0);
	JTable tbl1;
	JScrollPane scrlpn1;

	//table 2
	String col2[]={"ID","NAME","TIME OUT"};
	Object[][] data2={{"r_eid","r_ename","time_out"}};
	DefaultTableModel model2=new DefaultTableModel(col2,0);
	JTable tbl2;
	JScrollPane scrlpn2;

	String l_eid,l_ename,r_eid,r_ename,time_out;
	public timeout()
	{
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setUndecorated(true);
		//setLayout(null);
		setVisible(true);
		setSize(1370,820);

		setResizable(false);
		setLocationRelativeTo(null);

		//adding contents in department
		try
		{
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hrms","root","");
			Statement st=con.createStatement();
			ResultSet res=st.executeQuery("select distinct dept from emp");
			while(res.next())
			{
				cmbdept.addItem(res.getString(1));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

		add(l_title);
		add(l_date);		
		add(l_dept);
		
		add(t_date);

		add(cmbdept);

		add(brefresh);
		add(bsave);
		add(bcancel);
		add(bleft);
				
		brefresh.addActionListener(this);
		bsave.addActionListener(this);
		bcancel.addActionListener(this);
		bleft.addActionListener(this);
		
		cmbdept.addItemListener(this);
		
		l_title.setBounds(570,20,700,50);
		l_date.setBounds(250,120,181,33);
		l_dept.setBounds(700,120,181,33);

		t_date.setBounds(340,120,110,33);

		cmbdept.setBounds(860,120,150,33);

		brefresh.setBounds(450,600,120,41);
		bsave.setBounds(620,600,120,41);
		bcancel.setBounds(790,600,120,41);
		bleft.setBounds(580,390,100,30);
		
		//DATE
		Calendar cal=Calendar.getInstance();
		String sdate=cal.get(Calendar.YEAR)+"/"+cal.get(Calendar.MONTH)+"/"+cal.get(Calendar.DATE);
		t_date.setText(sdate);
        
        //FIRST TABLE
		tbl1=new JTable(data1,col1);
		scrlpn1=new JScrollPane(tbl1);
		add(scrlpn1);
		scrlpn1.setBounds(250,300,312,215);
		tbl1.setModel(model1);

		//SECOND TABLE
		tbl2=new JTable(data2,col2);
		scrlpn2=new JScrollPane(tbl2);
		add(scrlpn2);
		scrlpn2.setBounds(700,300,456,215);
		tbl2.setModel(model2);

		add(l_back);	

		l_title.setFont(new Font("Courier", Font.BOLD,50));
		l_date.setFont(new Font("Courier",Font.BOLD,20));
		l_dept.setFont(new Font("Courier",Font.BOLD,20));
		
		l_back.setBounds(-100,-30,1530,830);

		brefresh.setFont(new Font("Courier",Font.BOLD,20));
		bsave.setFont(new Font("Courier",Font.BOLD,20));
		bcancel.setFont(new Font("Courier",Font.BOLD,20));
		bleft.setFont(new Font("Courier",Font.BOLD,15));
 
		
		
		
        repaint();        
	}
	public void itemStateChanged(ItemEvent ie)
	{
		if(ie.getSource()==cmbdept)
		{
			try
			{
				//adding item to table
			    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hrms","root","");
				Statement st=con.createStatement();
				ResultSet res=st.executeQuery("select * from attendance where dept='"+cmbdept.getSelectedItem()+"'");
																		
				model1.setRowCount(0);
				model2.setRowCount(0);
				while(res.next())
				{
					Vector v=new Vector();
					v.add(res.getString(3));
				    v.add(res.getString(4));
				    model1.addRow(v);	
				 }
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==brefresh)
		{
			cmbdept.setSelectedIndex(0);
			model1.setRowCount(0);
			model2.setRowCount(0);
		}
		if(e.getSource()==bsave)
		{
			try
			{
				int flag=1;
				if(cmbdept.getSelectedItem().equals("--SELECT--"))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Select Department!");
				}
				else if(t_date.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Date!");
				}
				else if(tbl2.getRowCount()==0)
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"No Data!");
				}
				if(flag==1)
				{
				    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hrms","root","");
					Statement st=con.createStatement();
					for(int i=0;i<tbl1.getRowCount();i++)
					{
						String t=""+tbl2.getValueAt(i,2);
						String str="Update attendance set time_out='"+tbl2.getValueAt(i,2)+"' where eid='"+tbl1.getValueAt(i,0)+"' and time_out is null";
						st.executeUpdate(str);
					}
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
		if(e.getSource()==bleft)
		{
			int k=tbl1.getSelectedRow();
			for(int j=0;j<tbl1.getRowCount();j++)
			{
				Calendar cal=Calendar.getInstance();

				String tout=cal.get(Calendar.HOUR)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND);
				Vector v2=new Vector();
				v2.add(tbl1.getValueAt(k,0));
				v2.add(tbl1.getValueAt(k,1));
				v2.add(tout);
				model2.addRow(v2);
			}	
		}
	}
	public static void main(String args[])throws IOException
	{
		timeout obj=new timeout();
	}
}