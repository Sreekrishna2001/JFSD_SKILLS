package workers;
import java.sql.*;
import dbConnection.DbConnection;
public class MovieBookin{
	static Connection db = DbConnection.getDbConn();
	public boolean addMove(String moviename,String movieimgurl,String movieDesc) throws SQLException {
		PreparedStatement p = db.prepareStatement("insert into movies values(?,?,?)");
		p.setString(1, moviename); p.setString(2, movieimgurl); p.setString(3, movieDesc);
		if(p.executeUpdate() == 1)return true;
		return false;
	}
	public ResultSet getMovies() throws SQLException {
		Statement st = db.createStatement();
		return st.executeQuery("select * from movies");
	}
	public boolean MoveiTicketBooking(String nooftickets,String moviename,String date,String uname) throws SQLException {
		PreparedStatement p = db.prepareStatement("insert into moviebooking values(?,?,?,?)");
		p.setInt(1, Integer.parseInt(nooftickets));
		p.setString(2, uname); p.setString(3, date);p.setString(4, moviename);
		if(p.executeUpdate() == 1)return true;
		return false;
	}
	public boolean updateMoveiTicketBooking(int nooftickets,String moviename,String date,String uname) throws SQLException{
		PreparedStatement p = db.prepareStatement("update moviebooking set nooftickets = ? where uname = ? and date = ? and moviename = ?");
		p.setInt(1, nooftickets); p.setString(2, uname); p.setString(3, date);p.setString(4, moviename);
		if(p.executeUpdate() == 1)return true;
		return false;
	}
	public static void main(String[] args) throws SQLException {
		MovieBookin m = new MovieBookin();
//		System.out.println(m.addMove("one-piece 5","its a tale of pirate king"));
//		System.out.println(m.updateMoveiTicketBooking(5, "Sree Krishna", "12/05/2021", "naruto"));
		ResultSet rs = m.getMovies();
		while(rs.next())
			System.out.println(rs.getString(1)+" "+rs.getString(2));
	}
}
