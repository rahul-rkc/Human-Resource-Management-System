//package project; 

import java.io.*;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;

//@SuppressWarnings("serial") 
public class attendance extends JFrame implements ActionListener,ItemListener
{
	int flg=0;
	
	JLabel l_back=new JLabel(new ImageIcon("F:/Project/pics/a6.png"));	
	JLabel att=new JLabel("ATTENDANCE");
   

	//JLabel l_back=new JLabel(new ImageIcon("F:/Project/pics/a6.png"));


	JTextField t_date=new JTextField();
	JLabel date=new JLabel("DATE");
	JLabel dep=new JLabel("DEPARTMENT");



	JButton brefresh=new JButton("REFRESH");
	JButton bsave=new JButton("SAVE");
	JButton bcancel=new JButton("CANCEL");
	JButton bright=new JButton("TIME IN");
	JButton btimeout=new JButton("TIME OUT");

	String dept[]={"--SELECT--"};
	JComboBox cmbdept=new JComboBox(dept);

	///table 1
	String col1[]={"ID","NAME","STATUS"};
	Object[][] data1={{"l_eid","l_ename","l_status"}};
	DefaultTableModel model1=new DefaultTableModel(col1,0);
	JTable tbl1;
	JScrollPane scrlpn1;

	//table 2
	String col2[]={"ID","NAME","TIME IN"};
	Object[][] data2={{"r_eid","r_ename","time_in"}};
	DefaultTableModel model2=new DefaultTableModel(col2,0);
	JTable tbl2;
	JScrollPane scrlpn2;

	String l_eid,l_ename,l_status,r_eid,r_ename,time_in;
	public attendance()
	{
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setUndecorated(false);
		setLayout(null);
		setVisible(true);
		setSize(1400,840);


		setResizable(false);
		setLocationRelativeTo(null);

		//l_back.setBounds(-200,0,0,0);
		//t_date.setBorder(null);
		//t_date.setOpaque(false);
		t_date.setEditable(false);

	/*	bright.setContentAreaFilled(false);	
		btimeout.setContentAreaFilled(false);
		brefresh.setContentAreaFilled(false);
		bsave.setContentAreaFilled(false);
		bcancel.setContentAreaFilled(false);
*/
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

		add(t_date);
		add(att);
		add(dep);
		add(date);

		add(cmbdept);

		add(brefresh);
		add(bsave);
		add(bcancel);
		add(bright);
		add(btimeout);

		brefresh.addActionListener(this);
		bsave.addActionListener(this);
		bcancel.addActionListener(this);
		bright.addActionListener(this);
		btimeout.addActionListener(this);
        cmbdept.addItemListener(this);

		l_back.setBounds(0,0,1400,840);
		date.setBounds(80,210,200,100);
		date.setFont(new Font("Courier", Font.BOLD,22));
		dep.setBounds(770,210,300,100);
		dep.setFont(new Font("Courier", Font.BOLD,22));
		att.setBounds(570,100,300,50);
		att.setFont(new Font("Courier", Font.BOLD,42));
		t_date.setBounds(185,240,140,33);

		cmbdept.setBounds(960,240,150,33);

		bright.setBounds(630,405,130,38);		
		btimeout.setBounds(630,560,130,38);
		brefresh.setBounds(430,686,125,41);
		bsave.setBounds(632,686,125,41);
		bcancel.setBounds(834,686,125,41);

		//DATE
		Calendar cal=Calendar.getInstance();
		String ss=""+(1+(Integer.valueOf(""+cal.get((Calendar.MONTH)))));
		String sdate=cal.get(Calendar.YEAR)+"/"+ss+"/"+cal.get(Calendar.DATE);
		t_date.setText(sdate);
        
        //FIRST TABLE
		tbl1=new JTable(data1,col1);
		scrlpn1=new JScrollPane(tbl1);
		add(scrlpn1);
		scrlpn1.setBounds(80,353,548,275);
		tbl1.setModel(model1);

		//SECOND TABLE
		tbl2=new JTable(data2,col2);
		scrlpn2=new JScrollPane(tbl2);
		add(scrlpn2);
		scrlpn2.setBounds(764,353,548,275);
		tbl2.setModel(model2);

		add(l_back);
		//l_back.setBounds(0,1,1528,830);

		t_date.setFont(new Font("Times New Roman",Font.PLAIN,18));
		//date.setFont(new Font("Times New Roman",Font.PLAIN,18));
		bright.setFont(new Font("Times New Roman",Font.PLAIN,18));
		btimeout.setFont(new Font("Times New Roman",Font.PLAIN,18));
		brefresh.setFont(new Font("Times New Roman",Font.PLAIN,18));
		bsave.setFont(new Font("Times New Roman",Font.PLAIN,18));
		bcancel.setFont(new Font("Times New Roman",Font.PLAIN,18));
		cmbdept.setFont(new Font("Times New Roman",Font.PLAIN,15));

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
				ResultSet res=st.executeQuery("select * from emp where dept='"+cmbdept.getSelectedItem()+"'");
				model1.setRowCount(0);
				model2.setRowCount(0);
				while(res.next())
				{
					Vector v=new Vector();
					v.add(res.getString(1));
				    v.add(res.getString(2));
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
				//	Connection con=DriverManager.getConnection("jdbc:odbc:hrdsn");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hrms","root","");
					String str="select * from holiday where hdate='"+t_date.getText()+"'";
					Statement st=con.createStatement();
					ResultSet res=st.executeQuery(str);
					while(res.next())
					{
						flg=1;
					}
					if(flg==1)
					{
						JOptionPane.showMessageDialog(null,"Today Is Holiday!");
						bsave.setEnabled(false);
						this.dispose();
					}
					else
					{   
						//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hrms","root","");
						String str2="insert into attendance(cdate,dept,eid,ename,time_in,time_out)values(?,?,?,?,?,?)";
						PreparedStatement ps=con.prepareStatement(str2);
						for(int i=0;i<tbl2.getRowCount();i++)
						{
							ps.setString(1,t_date.getText());
							ps.setString(2,""+cmbdept.getSelectedItem());
					
							ps.setString(3,""+tbl1.getValueAt(i,0));
							ps.setString(4,""+tbl1.getValueAt(i,1));
							ps.setString(5,""+tbl2.getValueAt(i,2));
						    ps.setString(6,"00:00:00");
							ps.executeUpdate();
						}			
							
						JOptionPane.showMessageDialog(null,"Submitted!");
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
		if(e.getSource()==bright)
		{
			int flag=0;
			int k=tbl1.getSelectedRow();

			for(int j=0;j<tbl2.getRowCount();j++)
			{
				if(tbl2.getValueAt(j,0).equals(tbl1.getValueAt(k,0)))
				{   
				
					flag=0;
					break;
				}			
				else
				{
					flag=1;

				}
			}
			if((flag==1)||(tbl2.getRowCount()==0))
			{
				Calendar cal=Calendar.getInstance();

				String tin=cal.get(Calendar.HOUR)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND);
				Vector v2=new Vector();
				v2.add(tbl1.getValueAt(k,0));
				v2.add(tbl1.getValueAt(k,1));
				v2.add(tin);
				model2.addRow(v2);
				tbl1.setValueAt("PRESENT",k,2);	
			}		
		}
		if(e.getSource()==btimeout)
		{
			new timeout();
			this.dispose();
		}
	}

	
	public static void main(String args[])throws IOException
	{
	  attendance obj=new attendance();
		/*DB db=new DB();
		try {
			Connection con=db.dbconnect();
			Statement st=con.createStatement();
			String sql="select * from attendance";
			ResultSet res=st.executeQuery(sql);
			while(res.next()) {
				System.out.println("HI");
				//System.out.println("Username: "+res.getString(1)+"PassWord: "+res.getString(2));
			}
			res.close();
			st.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();*/
		//}
	}
}