package units;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

@SuppressWarnings("unused")
public class WorkDays {
	/*
	 * refTaskId
		1:專案管理
		2:需求分析
		3:需求設計
		4:程式開發
		5:程式測試
		6:系統驗收
		7:人力支援
		8:維護服務
		9:備註說明
	 */
	private static String 
		pjCustCode = "CLI",
		refPjCode = "CLI_CHATBOT_20171101_P1",	// 專案代號
		refTaskId = "4",
		workhours = "8",
		workStartTime = "09:00",
		workEndTime = "18:00",
		whId = "",
		refCopCode = "TPI",
		empName = "林哲豪",		// 員工姓名
		empCode = "2015168",	// 員工編號
		pjDepName = "";			// 部門名稱
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	
	public static void main(String[] args) {
		ArrayList<String> workDates = getWorkDatesByMonth();
		String javascript = getJavascript(workDates);
		System.out.println(javascript);
	}
	
	private static ArrayList<String> getWorkDatesByMonth(){
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 1);
		c.set(Calendar.DATE, 0);
		int endDate = c.get(Calendar.DATE)+1;
		ArrayList<String> workDates = new ArrayList<String>();
		for (int i = 1 ; i < endDate ; i++) {
			c.set(Calendar.DATE, i);
			if (c.get(Calendar.DAY_OF_WEEK) != 1 && c.get(Calendar.DAY_OF_WEEK) != 7) {
				workDates.add(sdf.format(c.getTime()));
			}
		}
		return workDates;
	}
	
	private static String[] getWorkDatesByWeek(){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, 2);
		String[] workDates = new String[5];
		String day;
		for(int i = 0 ; i < 5 ; i++){
			day = sdf.format(c.getTime());
			workDates[i] = day;
			c.add(Calendar.DATE, 1);
		}
		return workDates;
	}
	
	private static String getJavascript(ArrayList<String> workDates){
		StringBuilder sb = new StringBuilder();
		sb.append("var workDates = [");
		for(int i = 0 ; i < workDates.size() ; i++){
			String workDate = workDates.get(i);
			sb.append("'").append(workDate).append("'");
			if(i != workDates.size()-1){
				sb.append(", ");
			}
		}
		sb.append("];  ");
		sb.append("for (var i = 0 ; i < workDates.length ; i++) { ");
		sb.append(	"$.ajax({ ");
		sb.append(		"url: '/erp/workHour/work/addWorkSubmit', ");
		sb.append(		"data: { ");
		sb.append(			"workDate : workDates[i], ");
		sb.append(			"pjCustCode : '"+pjCustCode+"', ");
		sb.append(			"refPjCode : '"+refPjCode+"', ");
		sb.append(			"refTaskId : '"+refTaskId+"', ");
		sb.append(			"workhours : '"+workhours+"', ");
		sb.append(			"workStartTime : '"+workStartTime+"', ");
		sb.append(			"workEndTime : '"+workEndTime+"', ");
		sb.append(			"whId : '"+whId+"', ");
		sb.append(			"refCopCode : '"+refCopCode+"', ");
		sb.append(			"empName : '"+empName+"', ");
		sb.append(			"empCode : '"+empCode+"', ");
		sb.append(			"pjDepName : '"+pjDepName+"' ");
		sb.append(		"}, ");
		sb.append(		"type: 'POST', ");
		sb.append(		"dataType: 'text', ");
		sb.append(		"async: true, ");
		sb.append(		"beforeSend: function() {}, ");					  
		sb.append(		"success: function(data){ ");
		sb.append(			"console.log('finish') ");
		sb.append(		"}, ");
		sb.append(		"error: function(xhr, ajaxOptions, thrownError){ ");
		sb.append(			"console.log('failed'); ");
		sb.append(		"} ");
		sb.append(	"}); ");
		sb.append("} ");
		return sb.toString();
	}
}
