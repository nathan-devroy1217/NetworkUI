/**
* CSV Utility class to format data and generate reports
*
*
*/
public class CSVUtility {
	
	/** From date for reports */
	private String fromDate;

	/** To date for reports */
	private String toDate;

	/** From time for reports */
	private String fromTime;

	/** To date for reports */
	private String toTime;
	
	
	public CSVUtility(String fromDate, String toDate, String fromTime, String toTime) {
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.fromTime = fromTime;
		this.toTime = toTime;
	}

}
