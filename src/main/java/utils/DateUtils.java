package utils;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils extends org.apache.commons.lang3.time.DateUtils{
	
	public static String format(Date date, String format){
		return new SimpleDateFormat(format).format(date);
	}
	
	public static boolean isDate(String dttm, String format) {
	    if (dttm == null || dttm.isEmpty() || format == null || format.isEmpty()) {
	        return false;
	    }

	    if (format.replaceAll("'.+?'", "").indexOf("y") < 0) {
	        format += "/yyyy";
	        DateFormat formatter = new SimpleDateFormat("/yyyy");
	        dttm += formatter.format(new Date());
	    }

	    DateFormat formatter = new SimpleDateFormat(format);
	    formatter.setLenient(false);
	    ParsePosition pos = new ParsePosition(0);
	    Date date = formatter.parse(dttm, pos);

	    if (date == null || pos.getErrorIndex() > 0) {
	        return false;
	    }
	    if (pos.getIndex() != dttm.length()) {
	        return false;
	    }

	    if (formatter.getCalendar().get(Calendar.YEAR) > 9999) {
	        return false;
	    }

	    return true;
	}
}
