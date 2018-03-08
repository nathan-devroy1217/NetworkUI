import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnect {

	/** JDBC connection string */
	//private String url = "jdbc:mysql://192.168.1.15:3306/home_network_tst";
	private String url = "jdbc:mysql://127.0.0.1:3306/home_network_tst";
	
	/** User name for DB connection */
	private String user = "root";

	/** Password for DB connection */
	private final String password = "Elijah1027";

	/** DB connection */
	private Connection conn = null;

	/**
	 * Constructor for DBConnect
	 * @return connection object
	 * @version 2/5/18
	 */
	public Connection connectDB() {
		System.out.println("Attempting to connect to database....");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println(conn.getMetaData().getURL().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Connection successful!");
		return conn;
	}
	
	public void closeDB() {
		if (conn != null) {
			System.out.println("Closing database connection....");
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
