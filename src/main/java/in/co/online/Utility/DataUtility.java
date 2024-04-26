package in.co.online.Utility;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtility {

	public static final String APP_DATE_FORMATE = "MM/dd/yyyy";
	public static final SimpleDateFormat Dateformatter = new SimpleDateFormat(APP_DATE_FORMATE);

	public static final String APP_TIME_FORMATE = "HH:mm:ss";
	public static final SimpleDateFormat Timeformatter = new SimpleDateFormat(APP_TIME_FORMATE);

	public static String getString(String val) {
		if (DataValidater.isNotNull(val)) {
			return val.trim();
		} else {
			return val;
		}
	}

	public static int getInt(String val) {
		if (DataValidater.isInteger(val)) {
			return Integer.parseInt(val);
		} else {
			return 0;
		}
	}

	public static String getStringData(Object val) {

		if (val != null) {
			return val.toString();
		} else {
			return "";
		}
	}

	public static long getlong(String val) {
		if (DataValidater.isLong(val)) {
			return Long.parseLong(val);
		} else {
			return 0;
		}
	}

	public static Date getDate(String val) {
		Date date = null;
		try {
			date = Dateformatter.parse(val);
		} catch (Exception e) {
		}
		return date;
	}

	public static Date getDate1(String val) {
		Date date = null;

		try {
			date = Dateformatter.parse(val);

		} catch (Exception e) {
		}
		return date;
	}
	
	public static String getDateString(Date date) {
		try {
			if (date != null) {
				return Dateformatter.format(date);
			} else {
				return "";
			}
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * Converts Time into String
	 * 
	 * @param time
	 * @return
	 */
	public static String getTimeString(Time time){

		try {
			if (time != null) {
				return Timeformatter.format(time);
			} else {
				return "";
			}
		} catch (Exception e) {
			return "";
		}

	}

	public static Time getTime(String val) {
		Time time = null;
		try {
			time = (Time) Timeformatter.parse(val);
			System.out.println("time is :"+time);
		} catch (Exception e) {

		}
		return time;
	}
	
	public static Date getDate(Date date, int day) {
		return null;
	}

	public static Timestamp getTimestamp(long l) {

		Timestamp timeStamp = null;
		try {
			timeStamp = new Timestamp(l);
		} catch (Exception e) {
			return null;
		}
		return timeStamp;
	}

	public static long getTimestamp(Timestamp tm) {
		try {
			return tm.getTime();
		} catch (Exception e) {
			return 0;
		}
	}

	public static Timestamp getCurrentTimestamp() {
		Timestamp timeStamp = null;
		try {
			timeStamp = new Timestamp(new Date().getTime());
		} catch (Exception e) {
		}
		return timeStamp;

	}
}
