//package project;

//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//import com.mysql.jdbc.ResultSetMetaData;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.util.Vector;
import java.sql.*;

public class DB{
	Connection con=null;
	java.sql.PreparedStatement pst;
	public static Connection dbconnect()
	{
	try{
	//Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hrms","root","");
	System.out.println("Connected");
	return conn;
	}
	catch(Exception e){
	System.out.println(e);
	return null;
	}
	}
}