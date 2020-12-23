package config;
import java.sql.*;
public class JDBCConnection {
	static String url="jdbc:mysql://localhost:3306/pcsdb";
	static String username="root";
	static String password="Rahul&1802";
	public static Connection conn=null;
	public static Connection getDBConnection()
	{
		try {
		Class.forName("com.mysql.jdbc.Driver");//loading driver
	   conn=DriverManager.getConnection(url,username,password);
	}
	catch(ClassNotFoundException ex)
		{
			System.out.println(ex);
		}
	catch(SQLException ex)
		{
			System.out.println(ex);
		}
		return conn;
	}
}
