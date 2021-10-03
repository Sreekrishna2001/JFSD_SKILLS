package dbConnection;
import java.sql.*;
public class DbConnection {
	public static Connection getDbConn() {
		Connection con = null;
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jfsd_skills","root","kittu2001");  			
			}catch(Exception e){ System.out.println(e);}  
		return con;
		}
	} 