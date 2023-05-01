import java.sql.*;
public class Jdbc_StatmentInterface_SelectableExample {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver found successful");
			String url = "jdbc:mysql://localhost:3306/studentDetails";
			String username = "root";
			String password = "root";
			Connection con;
			con =DriverManager.getConnection(url,username,password);
			System.out.println("connected with database successfully");
			
			Statement st = con.createStatement();
			//ResultSet rs = st.executeUpdate();(to update the database)
			ResultSet rs = st.executeQuery("select*from world.city"); //(to get data from the data base)
			while(rs.next()) {
			System.out.println(rs.getInt("ID")+"  "+rs.getString("Name"));}
			con.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println("unable to find the driver");
		}
		catch (SQLException e) {
			System.out.println("unable to connect with database");
		}

	}

}

//URL with IP address.
//jdbc:mysql:192.168.10.44:portNumber/databasename

//URL with local host
//jdbc:mysql://localhost:portNumber/databasename
