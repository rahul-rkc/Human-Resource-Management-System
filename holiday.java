//package project;

import java.io.*;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
public class holiday extends JFrame implements ActionListener
{
	JLabel l_back=new JLabel(new ImageIcon("F:/Project/pics/aa.png"));

	JLabel l_title=new JLabel("HOLIDAY");
	JLabel l_date=new JLabel("Date");
	JLabel l_holiday=new JLabel("Holiday");

	JTextField thol=new JTextField();

	JButton badd=new JButton("Add");
	JButton brem=new JButton("Remove");
	JButton bsave=new JButton("Save");
	JButton bcancel=new JButton("Cancel");

	JComboBox cmbyear=new JComboBox();
	JComboBox cmbd=new JComboBox();
	JComboBox cmbm=new JComboBox();
	

	String col1[]={"DATE","NAME OF HOLIDAY"};
	String hdate,hname;
	Object[][] data1={{hdate,hname}};
	DefaultTableModel model1=new DefaultTableModel(col1,0);
	JTable tbl1;
	JScrollPane scrlpn1=new JScrollPane();

	public holiday()
	{
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setUndecorated(true);
		setLayout(null);
		setVisible(true);
		setSize(1368,800);


		setResizable(false);
		setLocationRelativeTo(null);

		//thol.setBorder(null);
		//thol.setOpaque(false);

		brem.setContentAreaFilled(false);	
		bsave.setContentAreaFilled(false);
		badd.setContentAreaFilled(false);
		bcancel.setContentAreaFilled(false);

		//date
		cmbd.addItem("Date");
		for(int d=1;d<=31;d++)
		{
			cmbd.addItem(""+d);
		}

		cmbm.addItem("Month");
		for(int d=1;d<=12;d++)
		{
			cmbm.addItem(""+d);
		}
		cmbyear.addItem("Year");
		for(int d=1999;d<=2050;d++)
		{
			cmbyear.addItem(""+d);
		}

		add(l_back);
		add(l_title);
		add(l_date);
		add(l_holiday);

		add(thol);

		add(badd);
		add(brem);
		add(bsave);
		add(bcancel);

		add(cmbd);
		add(cmbm);
		add(cmbyear);

		badd.addActionListener(this);
		brem.addActionListener(this);
		bsave.addActionListener(this);
		bcancel.addActionListener(this);

		l_title.setBounds(500,40,700,50);
 		l_date.setBounds(250,160,80,50);
		l_holiday.setBounds(250,220,140,50);

		cmbd.setBounds(400,170,60,25);
		cmbm.setBounds(480,170,75,25);
		cmbyear.setBounds(580,170,60,25);

		thol.setBounds(400,220,275,55);

		badd.setBounds(320,315,109,35);
		brem.setBounds(470,315,109,35);
		bsave.setBounds(550,650,123,41);
		bcancel.setBounds(710,650,123,41);
		
		//FIRST TABLE
		tbl1=new JTable(data1,col1);
		scrlpn1=new JScrollPane(tbl1);
		tbl1.setModel(model1);
		scrlpn1.setBounds(460,400,519,200);
		scrlpn1.setFont(new Font("Times New Roman",Font.PLAIN,18));
		add(scrlpn1);

		add(l_back);
		l_back.setBounds(-100,-30,1528,830);

		l_title.setFont(new Font("Courier", Font.BOLD,60));
		l_date.setFont(new Font("Courier",Font.BOLD,25));
		l_holiday.setFont(new Font("Courier",Font.BOLD,25));

		thol.setFont(new Font("Times New Roman",Font.PLAIN,18));

		cmbd.setFont(new Font("Times New Roman",Font.PLAIN,18));
		cmbm.setFont(new Font("Times New Roman",Font.PLAIN,18));
		cmbyear.setFont(new Font("Times New Roman",Font.PLAIN,18));

		
		badd.setFont(new Font("Courier",Font.BOLD,20));
		brem.setFont(new Font("Courier",Font.BOLD,20));
		bsave.setFont(new Font("Courier",Font.BOLD,20));
		bcancel.setFont(new Font("Courier",Font.BOLD,20));

		repaint();
		//LOAD
		  try
		  {
			Vector v1;
			int i=0;
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hrms","root","");
			String str="select * from holiday";
			Statement st=con.createStatement();
			ResultSet res=st.executeQuery(str);	
			while(res.next())
			{
				v1=new Vector();
				v1.add(res.getString(1));
				v1.add(res.getString(2));
				model1.addRow(v1);	
			}
			}
		  
		  catch(Exception e)
			{
				System.out.println(e);
			}
				
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==badd)
		{
			try
			{
				Vector v1=new Vector();
				String d=cmbyear.getSelectedItem()+"/"+cmbm.getSelectedItem()+"/"+cmbd.getSelectedItem();
				v1.add(d);
				v1.add(thol.getText());
				model1.addRow(v1);
				thol.setText("");
				cmbyear.setSelectedIndex(0);
				cmbm.setSelectedIndex(0);
				cmbd.setSelectedIndex(0);
				}
			catch(Exception ex)
			{
				System.out.print(ex);
			}
		}
		if(e.getSource()==brem)
		{
			try	
			{
				model1.removeRow(tbl1.getSelectedRow());
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
				if(cmbyear.getSelectedItem().equals("--Y--")||cmbm.getSelectedItem().equals("--M--")||cmbd.getSelectedItem().equals("--D--"))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Date Properly!");
				}
				else if(thol.getText().equals(""))
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Holiday Name!");
				}
				else if(tbl1.getRowCount()==0)
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Enter Holiday!");
				}
				if(flag==1)
				{
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hrms","root","");
					Statement st=con.createStatement();
					String str="Insert into holiday(hdate,hname)values(?,?)";
					PreparedStatement ps=con.prepareStatement(str);
					for(int i=0;i<tbl1.getRowCount();i++)
					{				
						ps.setString(1,""+tbl1.getValueAt(i,0));
						ps.setString(2,""+tbl1.getValueAt(i,1));
						ps.executeUpdate();
					
						
					}
					
					JOptionPane.showMessageDialog(null,"Saved!");				
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
		if(f.getComponent()==badd)
		{
			try
			{
				thol.setText("");
				cmbd.setSelectedIndex(0);
				cmbm.setSelectedIndex(0);
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

	public static void main(String args[])throws IOException
	{
		holiday obj=new holiday();
	}
}