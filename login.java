//package project;

import java.io.*;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class login extends JFrame implements ActionListener
{ 
	int ctr=0;

	JLabel l_back=new JLabel(new ImageIcon("F:/Project/pics/aa.png"));
	JLabel l_title=new JLabel("WELCOME");
	JLabel l_user=new JLabel("Username");
    JLabel l_pass=new JLabel("Password");
    JTextField t_name=new JTextField();
	JPasswordField t_pass=new JPasswordField();

	
	JButton blogin=new JButton("LOG IN");
	JButton breg=new JButton("REGISTER");
	JButton bcan=new JButton("");
	
	public login()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);
		
		setSize(700,465);
		setResizable(false);
		setLocationRelativeTo(null);

		//t_name.setBorder(null);
		//t_name.setOpaque(false);

        //t_pass.setBorder(null);
		//t_pass.setOpaque(false);

		//blogin.setContentAreaFilled(false);
		//breg.setContentAreaFilled(false);
		//bcan.setContentAreaFilled(false);

		//setSize(getMaximumSize());

		add(t_pass);
		add(t_name);
		
		add(l_title);
		add(l_user);
		add(l_pass);

		add(blogin);
		add(breg);
		//add(bcan);

		add(l_back);

		blogin.addActionListener(this);
		breg.addActionListener(this);
		bcan.addActionListener(this);

		t_pass.setEchoChar('*');
		
		l_back.setBounds(0,0,this.getWidth(),this.getHeight());

		l_title.setBounds(250,20,200,80);
		t_name.setBounds(320,155,147,27);
		t_pass.setBounds(320,230,148,27);		
		l_user.setBounds(180,120,100,100);
		l_pass.setBounds(180,195,100,100);
        blogin.setBounds(220,320,100,40);
		breg.setBounds(350,320,100,40);
		//bcan.setBounds(663,9,30,32);

		l_title.setFont(new Font("Courier",Font.BOLD,40));
		l_user.setFont(new Font("Courier",Font.BOLD,20));
		l_pass.setFont(new Font("Courier",Font.BOLD,20));

		t_name.setFont(new Font("Times New Roman",Font.PLAIN,18));
		t_pass.setFont(new Font("Times New Roman",Font.PLAIN,18));

		repaint();
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==breg)
		{
			new register();
			//this.dispose();
		}
		if(e.getSource()==bcan)
		{
			this.dispose();
		}
		if(e.getSource()==blogin)
		{
			try
		    {
		    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hrms","root","");
				Statement st=con.createStatement();
             	String spass=new String(t_pass.getPassword());
				//String s1="select * from login where username='"+rahul+"' and password=0000";
				String s1="select * from login where username='"+t_name.getText()+"' and password='"+spass+"'";
				ResultSet res=st.executeQuery(s1);
				if(res.next())
				{
					ctr=0;
					JOptionPane.showMessageDialog(null,"Welcome!");
					new mastersdemo();
					this.dispose();
				}	
				else
				{
					JOptionPane.showMessageDialog(null,"Invalid Username or Password");
					//JOptionPane.showMessageDialog(null,.getText());

					ctr++;
				}
				if(ctr==3)
				{
					JOptionPane.showMessageDialog(null,"TRY AFTER SOMETIME!");
					this.dispose();
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
		login obj=new login();
	}
}