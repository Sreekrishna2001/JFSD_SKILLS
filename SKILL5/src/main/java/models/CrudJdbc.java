package models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class CrudJdbc {
	public static Connection getDbConn() {
		Connection con = null;
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jfsd_skills","root","kittu2001");  			
			}catch(Exception e){ System.out.println(e);}  
		return con;
		}
	public static void display() throws SQLException {
		Connection db = getDbConn();
		PreparedStatement pst = db.prepareStatement("select * from skillexam");
		ResultSet rs = pst.executeQuery();
		while(rs.next())System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
		
	}
	public static void main(String[] args) throws SQLException {
		
		System.out.println("Crud using jdbc");
		while (true) {
		System.out.println("1.Create\n2.Read\n3.Update\n4.Delete");
		Scanner sc = new Scanner(System.in);
		int ch = sc.nextInt();
		Connection db = getDbConn();
		
		switch (ch) {
		case 1:	{
			System.out.println("enter id\nproduct\nprice\nproduct description\n in the above order");
			int id = sc.nextInt();String product = sc.next();int price = sc.nextInt();String desc = sc.next();
			PreparedStatement pst = db.prepareStatement("insert  into skillexam values(?,?,?,?)");
			pst.setInt(1, id);pst.setString(2, product);pst.setInt(3, price);pst.setString(4, desc);
			pst.execute();
			System.out.println("Displaying data after crud");
			display();
			break;
		}
		case 2:	{
			display();
			break;
		}
		case 3:	{
			
			System.out.println("enter id\nproduct\nprice\nproduct description\n in the above order");
			int id = sc.nextInt();int price = sc.nextInt();
			PreparedStatement pst = db.prepareStatement("update skillexam set price = ? where id = ?");
			pst.setInt(1, price);pst.setInt(2, id);
			pst.execute();
			System.out.println("Displaying data after crud");
			display();
			break;
		}
		case 4:	{
			
			System.out.println("enter id\nproduct\nprice\nproduct description\n in the above order");
			int id = sc.nextInt();
			PreparedStatement pst = db.prepareStatement("delete from skillexam where id = ?");
			pst.setInt(1, id);
			pst.execute();
			System.out.println("Displaying data after crud");
			display();
			break;
		}
		}
		}
	}
}
