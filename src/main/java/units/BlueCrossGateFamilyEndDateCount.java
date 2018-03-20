package units;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class BlueCrossGateFamilyEndDateCount {

	private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public BlueCrossGateFamilyEndDateCount(String date, int days) throws ParseException{
		run(date, days);
	}
	
	@Test
	public void getFamilyEndDate() throws ParseException {
		int days = 486;
		String date = "2017-09-20";
		run(date, days);
	}
	
	public static void main(String[] args) {
		try {
			new BlueCrossGateFamilyEndDateCount("2017-09-20", 486);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void run(String date, int days) throws ParseException{
		Date d = sdf.parse(date);
		
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		c.add(Calendar.DATE, days);
		
		System.out.println(sdf.format(c.getTime()));
	}
	
}
