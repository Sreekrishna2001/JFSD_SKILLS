package workers;
import java.sql.*;

import dbConnection.DbConnection;
public class AuthSuperAmin {
	static Connection db = DbConnection.getDbConn();
	public boolean authaSuperAdmin(String adminame,String pass) throws SQLException {
		PreparedStatement p = db.prepareStatement("select count(*) from superadmin_movietickets where name = ? and passwrd = ?");
		p.setString(1, adminame);p.setString(2, pass);
		ResultSet rs = p.executeQuery();
		 rs.next();
		if(rs.getInt(1) == 1)return true;
		return false;
	}
	public static void main(String[] args) throws SQLException {
		AuthSuperAmin ad = new AuthSuperAmin();
		System.out.println(ad.authaSuperAdmin("kittu","kittu2001"));
		
	}
	
}
