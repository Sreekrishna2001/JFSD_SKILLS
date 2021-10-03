package workers;
import java.sql.*;
import dbConnection.DbConnection;
public class AuthCustormer{
	static Connection db = DbConnection.getDbConn();
	public boolean registerCustormer(String username,String password,String mobile_no,String useremail) {
		try {
			PreparedStatement stmt=db.prepareStatement("insert into customers values(?,?,?,?)");
			stmt.setString(1, username);stmt.setString(2, password);stmt.setString(3, mobile_no);stmt.setString(4, useremail);
			if(!stmt.execute())return true;
		}
		catch(Exception e){e.printStackTrace();}
		return false;
	}
	public boolean loginCustomer(String uname,String pass) {
		try {
			PreparedStatement stmt=db.prepareStatement("select count(*) from customers where username = ? and password = ? ");
			stmt.setString(1, uname);stmt.setString(2, pass);
			System.out.println(uname+pass);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			System.out.println(rs.getInt(1));
			if(rs.getInt(1)==1)return true;
		}
		catch(Exception e) {e.printStackTrace();}
		return false;
	}
}
