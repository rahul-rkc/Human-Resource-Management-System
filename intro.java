//package project;

import java.io.*;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class intro extends JFrame implements ActionListener
{
	JLabel l_back=new JLabel(new ImageIcon("F:/Project/pics/aa1.png"));

	JButton bnext=new JButton("Next");
	JButton bcancel=new JButton();

	public intro()
	{
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setUndecorated(true);
		setLayout(null);
		setVisible(true);
		setSize(1300,700);

		setResizable(false);
		setLocationRelativeTo(null);

		//bnext.setContentAreaFilled(false);
		bcancel.setContentAreaFilled(false);

		add(bnext);
		//add(bcancel);
		add(l_back);

		bnext.addActionListener(this);
		bcancel.addActionListener(this);

		bnext.setBounds(540,550,185,50);
		bcancel.setBounds(1778,990,98,80);
		bnext.setFont(new Font("Courier", Font.BOLD,50));

		l_back.setBounds(-0162,-64,1500,755);
	}	

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==bnext)
		{
			new login();
			this.dispose();
		}
		if(e.getSource()==bcancel)
		{
			this.dispose();
		}
	}	

	public static void main(String args[])throws IOException
	{
		intro obj=new intro();
	}
}