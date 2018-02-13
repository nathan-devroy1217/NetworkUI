import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO reference object we will use to interact
 * with data in home_network_tst database
 * @author Nathan Devroy
 * @version 2/5/18
 *
 */
public class NetworkDAO {

	/** DB connection pointer */
	private Connection conn;

	/**
	 * Constructor for NetworkDAO
	 */
	public NetworkDAO() {
		DBConnect connectionRef = new DBConnect();
		conn = connectionRef.connectDB();
	}
	
	/**
	 * Run query on packet data with user devices
	 * @return list with above data
	 */
	public List<Packet> getAllPacketData() {
		List<Packet> packetData = new ArrayList<Packet>();
		Statement statement;
		try {
			statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(QueryConstants.GET_ALL_PACKET_DATA);
			
			while(rs.next()) {
				Packet packet = new Packet();
				packet.setAccessDttm(rs.getString("access_dttm"));
				packet.setDeviceName(rs.getString("device_name"));
				packet.setSrcIp(rs.getString("src_ip"));
				packet.setResolvedUri(rs.getString("resolved_url"));
				
				packetData.add(packet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return packetData;
	}
}
