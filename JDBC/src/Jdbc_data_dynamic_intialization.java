import java.sql.*;
import java.util.Scanner;
public class Jdbc_data_dynamic_intialization {
	public static void main(String[] args) {
		try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    System.out.println("Driver Found Successfully..");
		    
		    String url = "jdbc:mysql://localhost:3306/cijd_12";
		    String username = "root";
		    String password = "root";
		    
		    Connection con;
		    
		    con = DriverManager.getConnection(url,username,password);
		    
		    System.out.println("Connected with Database Successfully...");
		    
		    Scanner scan = new Scanner(System.in);
		    
		    System.out.println("Enter the Course Id ");
		    int cid = scan.nextInt();
		    scan.nextLine();
		    System.out.println("Enter the Course Name ");
		    String cname = scan.nextLine();
		    
		    System.out.println("Enter Course Duration ");
		    int duration = scan.nextInt();
		    System.out.println("Enter Course fee ");
		    double fee = scan.nextDouble();
		    System.out.println("Course Status ");
		    String status = scan.next();
		    
		    String query = "insert into course values(?,?,?,?,?)";
		    
		    PreparedStatement ps = con.prepareStatement(query);
		    ps.setInt(1, cid);
		    ps.setString(2, cname);
		    ps.setInt(3, duration);
		    ps.setDouble(4, fee);
		    ps.setString(5, status);
		    ps.execute();
		    
		    System.out.println("Data has been inserted Successfully...");
		    
		}catch(ClassNotFoundException e) {
			System.out.println("Unable to find the Driver class.");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
