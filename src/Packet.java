/**
 * Packet class defines packet details transmitted 
 * via home network
 * @author Nathan
 * @version 2/5/18
 */
public class Packet {
	
	/** Device name */
	private String deviceName;
	
	/** File key for packet */
	private int fileKey;
	
	/** HTTP host ID for packet */
	private String httpHost;
	
	/** HTTP URI designated to packet */
	private String httpRequestUri;
	
	/** Source IP address */
	private String srcIp;
	
	/** Destination IP address */
	private String dstIp;
	
	/** Source TCP port */
	private String tcpSrcPort;
	
	/** Destination TCP port */
	private String tcpDstPort;
	
	/** URI of packet transmitted */
	private String resolvedUri;
	
	/** Time packet inserted into DB */
	private String accessDttm;
		
	/**
	 * Getter for accessDttm
	 */
	public String getAccessDttm() {
		return accessDttm;
	}

	/**
	 * Setter for deviceName
	 */
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	/**
	 * Getter for deviceName
	 */
	public String getDeviceName() {
		return deviceName;
	}
	
	
	/**
	 * Setter for accessDttm
	 */
	public void setAccessDttm(String accessDttm) {
		this.accessDttm = accessDttm;
	}

	/**
	 * Setter for fileKey
	 */
	public void setFileKey(int fileKey) {
		this.fileKey = fileKey;
	}

	/**
	 * Getter for fileKey
	 */
	public int getFileKey() {
		return fileKey;
	}

	/**
	 * Setter for httpHost
	 */
	public void setHttpHost(String httpHost) {
		this.httpHost = httpHost;
	}

	/**
	 * Getter for httpHost
	 */
	public String getHttpHost() {
		return httpHost;
	}

	/**
	 * setter for httpRequestUri
	 */
	public void setHttpRequestUri(String httpRequestUri) {
		this.httpRequestUri = httpRequestUri;
	}
	
	/**
	 * Getter for httpRequestUri
	 */
	public String getHttpRequestUri() {
		return httpRequestUri;
	}

	/**
	 * Setter for srcIp
	 */
	public void setSrcIp(String srcIp) {
		this.srcIp = srcIp;
	}
	
	/**
	 * Getter for srcIp
	 */
	public String getSrcIp() {
		return srcIp;
	}

	/**
	 * Setter for dstIp
	 */
	public void setDstIp(String dstIp) {
		this.dstIp = dstIp;
	}

	/**
	 * Getter for dstIp
	 */
	public String getDstIp() {
		return dstIp;
	}

	/**
	 * Setter for tcpSrcPort
	 */
	public void setTcpSrcPort(String tcpSrcPort) {
		this.tcpSrcPort = tcpSrcPort;
	}

	/**
	 * Getter for tcpSrcPort
	 */
	public String getTcpSrcPort() {
		return tcpSrcPort;
	}

	/**
	 * Setter for tcpDstPort
	 */
	public void setTcpDstPort(String tcpDstPort) {
		this.tcpDstPort = tcpDstPort;
	}

	/**
	 * Getter for tcpDstPort
	 */
	public String getTcpDstPort() {
		return tcpDstPort;
	}

	/**
	 * Setter for resolvedUri
	 */
	public void setResolvedUri(String resolvedUri) {
		this.resolvedUri = resolvedUri;
	}

	/**
	 * Getter for resolvedUri
	 */
	public String getResolvedUri() {
		return resolvedUri;
	}
}