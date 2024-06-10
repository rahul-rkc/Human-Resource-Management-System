//package project;

import java.io.*;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class register extends JFrame implements ActionListener
{ 
	int ctr=0;

	JLabel l_back=new JLabel(new ImageIcon("F:/Project/pics/aa.png"));

	JLabel l_title=new JLabel("REGISTER FORM");	
	JLabel l_user=new JLabel("Username");
	JLabel l_phone=new JLabel("Phone No.");
	JLabel l_email=new JLabel("Email");
	JLabel l_pass=new JLabel("Password");
	JLabel l_cnfrmpass=new JLabel("Confirm Password");

	JTextField t_name=new JTextField();
	JTextField t_email=new JTextField();
	JTextField t_phn=new JTextField();

	JPasswordField t_pass=new JPasswordField("");
	JPasswordField t_con=new JPasswordField("");

	JButton breg=new JButton("Register");
	// JButton bcancel=new JButton("X");
	JButton blog=new JButton("Login");
	
	public register()
	{
		// setUndecorated(true);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);
		
		setSize(700,465);
		setResizable(false);
		setLocationRelativeTo(null);

		// t_name.setBorder(null);
		//t_name.setOpaque(false);

		// t_phn.setBorder(null);
		//t_phn.setOpaque(false);

		// t_email.setBorder(null);
		//t_email.setOpaque(false);

		// t_pass.setBorder(null);
		//t_pass.setOpaque(false);

		// t_con.setBorder(null);
		//t_con.setOpaque(false);

		// blog.setContentAreaFilled(false);
		// breg.setContentAreaFilled(false);
		// bcancel.setContentAreaFilled(false);

		//blog.setBorder(null);

		add(l_title);
		add(l_user);
		add(l_phone);
		add(l_email);
		add(l_pass);
		add(l_cnfrmpass);
		add(t_pass);
		add(t_con);
		add(t_name);
		add(t_email);
		add(t_phn);

		add(blog);
		add(breg);
		// add(bcancel);

		add(l_back);

		t_pass.setEchoChar('*');
		t_con.setEchoChar('*');
		
		l_back.setBounds(0,0,this.getWidth(),this.getHeight());

		breg.addActionListener(this);
		// bcancel.addActionListener(this);
		blog.addActionListener(this);

		l_title.setBounds(190,20,700,50);
		l_user.setBounds(130,110,120,30);
		l_phone.setBounds(130,160,120,30);
		l_email.setBounds(130,210,120,30);
		l_pass.setBounds(130,260,120,30);
		l_cnfrmpass.setBounds(130,310,180,30);

		t_name.setBounds(350,110,146,23);
		t_phn.setBounds(350,160,146,23);
		t_email.setBounds(350,210,146,23);
		t_pass.setBounds(350,260,146,23);
		t_con.setBounds(350,310,146,23);
		
		breg.setBounds(140,360,140,50);
		blog.setBounds(350,360,140,50);
		// bcancel.setBounds(630,9,50,32);

		l_title.setFont(new Font("Courier",Font.BOLD,40));
		l_user.setFont(new Font("Courier",Font.BOLD,20));
		l_phone.setFont(new Font("Courier",Font.BOLD,20));
		l_email.setFont(new Font("Courier",Font.BOLD,20));
		l_pass.setFont(new Font("Courier",Font.BOLD,20));
		l_cnfrmpass.setFont(new Font("Courier",Font.BOLD,17));

		t_name.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_email.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_phn.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_pass.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_con.setFont(new Font("Times New Roman",Font.PLAIN,18));

		breg.setFont(new Font("Times New Roman",Font.BOLD,20));
		blog.setFont(new Font("Times New Roman",Font.BOLD,20));
		// bcancel.setFont(new Font("Times New Roman",Font.BOLD,18));

		repaint();
	}

	public void actionPerformed(ActionEvent e)
	{
		
		// if(e.getSource()==bcancel)
		// {
		// 	this.dispose();
		// }
		if(e.getSource()==blog)
		{
			new login();
			this.dispose();
		}
		if(e.getSource()==breg)
		{
			try
		    {
		    	int flag=1;
		    	if((t_name.getText().equals(""))||t_pass.getPassword().equals("")||t_con.getPassword().equals("")||t_email.getText().equals("")||t_phn.getText().equals(""))
		    	{
		    		flag=0;
		    	}
		    	if(flag==1)
		    	{
		    		if(new String(t_pass.getPassword()).equals(new String(t_con.getPassword())))
		    		{
					    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hrms","root","");
			    		String str="Insert into login(username,password,email,phone)values(?,?,?,?)";
						PreparedStatement ps=con.prepareStatement(str);
						ps.setString(1,t_name.getText());
						ps.setString(2,new String(t_pass.getPassword()));
						ps.setString(3,t_email.getText());
						ps.setString(4,t_phn.getText());
						ps.executeUpdate();
					
						JOptionPane.showMessageDialog(null,"Registered!");
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Password Not Matched!");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Enter Value!");
				}			
		    }	

			catch(Exception ex)
			{
				System.out.print(ex);
			}
		}
	}
	public static void main(String args[])throws IOException
	{
		register obj=new register();
	}
}