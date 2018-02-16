import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * CSV Utility class to format data and generate reports
 * @author Nathan Devroy
 * @version 2/14/18
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
		this.fromDate = formatDate(fromDate);
		this.toDate = formatDate(toDate);
		this.fromTime = formatTime(fromTime);
		this.toTime = formatTime(toTime);
	}
	
	public boolean isDateRangeValid() {
		
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // From and to dateTimes formatted as DateTimeObjects
        LocalDateTime formatFromDateTime = LocalDateTime.parse((fromDate + " " + fromTime), formatter); 
        LocalDateTime formatToDateTime = LocalDateTime.parse((toDate + " " + toTime), formatter); 
       
        // Generate current dateTime
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Now: " + formatter.format(now));
        // Test fromDateTime > Now
        
        if(formatFromDateTime.compareTo(now) >= 1) {
        		return false;
        }
        
        // Test toDateTime > Now
        if(formatToDateTime.compareTo(now) >= 1) {
    			return false;
    		}
        
        // Test fromDateTime > toDateTime
        if(formatToDateTime.compareTo(formatFromDateTime) <= -1) {
    			return false;
    		}
        
        return true;
	}
	
	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getFromTime() {
		return fromTime;
	}

	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}

	public String getToTime() {
		return toTime;
	}

	public void setToTime(String toTime) {
		this.toTime = toTime;
	}

	public String formatDate(String date) {
		System.out.println(date);
		String[] dateVals = date.split("/");
		return dateVals[2] + "-" + dateVals[0] + "-" + dateVals[1];
	}
	
	public String formatTime(String time) {
		time = time.replaceAll("\\s+","");
		String[] timeVals = time.split(":");
		System.out.println(timeVals[0] + "hoo");
		String hour = timeVals[0].length() == 1 ? "0" + timeVals[0] : timeVals[0]; 
		hour = timeVals[1].contains("PM") ? String.valueOf((Integer.parseInt(hour) + 12)) : hour;
		String minute = timeVals[1].substring(0, 2);
		String second = "00";

		return hour + ":" + minute + ":" + second;
	}
	
	public String getFormattedOutputString(String date, String time) {
		return date + " " + time;
	}
}
