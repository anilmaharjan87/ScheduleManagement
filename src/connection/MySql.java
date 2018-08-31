package connection;
	import java.sql.Connection;
	import java.sql.Connection;
	import java.sql.DriverManager;

	public class MySql {

		public static Connection createConnection() {
			Connection con = null;
			String url = "jdbc:mysql://localhost/timetablecollege"; // MySQL URL followed by the database name
			String username = "root"; // MySQL username
			String password = ""; // MySQL password

			try {

				Class.forName("com.mysql.jdbc.Driver"); // loading MySQL drivers. This differs for database servers
				System.out.println("Driver loaded");

				con = DriverManager.getConnection(url, username, password); // attempting to connect to MySQL database
				System.out.println("Printing connection object " + con);
				
				truncateClassTable();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("connection establish");
			return con;
		}

		private static void truncateClassTable() {
			// TODO Auto-generated method stub
			
		}
	}



