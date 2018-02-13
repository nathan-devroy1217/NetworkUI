/**
 * Query constants for UI
 * @author Nathan Devroy
 * @version 2/5/18
 */
public class QueryConstants {

	/** Query to pull packet data with device name */
	public static final String GET_ALL_PACKET_DATA = 
			"select \n" + 
			"packet.access_dttm, \n" + 
			"device.device_name,\n" + 
			"packet.src_ip, \n" + 
			"packet.resolved_url \n" + 
			"from packet\n" + 
			"inner join device\n" + 
			"on (device.ip_address = packet.src_ip) "
			+ "order by access_dttm desc limit 4000;";
	public static final String FILE_PATH = "/Users/emilydevroy/Desktop";
}
