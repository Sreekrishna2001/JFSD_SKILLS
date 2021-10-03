package workers;
import java.sql.*;

import dbConnection.DbConnection;
public class Managers {
	static Connection db = DbConnection.getDbConn();
	public boolean addManager(String managername,String pass) throws SQLException {
		PreparedStatement p = db.prepareStatement("insert into managers values(?,?)");
		p.setString(1, managername);p.setString(2, pass);
		if(p.executeUpdate() == 1)return true;
		return false;
	}
	public boolean authmanager(String mname,String pass) throws SQLException{
		PreparedStatement p = db.prepareStatement("select count(*) from managers where managername = ? and password = ?");
		p.setString(1, mname);p.setString(2, pass);
		ResultSet rs = p.executeQuery();
		rs.next();
		if(rs.getInt(1)==1)return true;
		return false;
	}
}
