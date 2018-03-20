package utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IDUtils {
	
	public static void main(String[] args) {
//		System.out.println();
	}

	private static Map<String, Integer> mapping = new HashMap<String, Integer>();
	private static String[] random = new String[22];
	private static final String deprecated = "LRSY";

	public static String generateRandomID(){
		String resultID = "";
		String randomID;
		int iFirst = (int) (Math.random()*random.length);
		int sex = ((int) (Math.random()*2))+1;
		String after = StringUtils.getRandomNumString(7);
		randomID = random[iFirst] + sex + after;
		String tempID;
		for(int i = 1 ; i < 10 ; i++){
			tempID = randomID + i;
			if(verifyID(tempID)){
				resultID = tempID;
			} 
		}
		while(!verifyID(resultID)){
			resultID = generateRandomID();
		}
		return resultID;
	}
	
	public static boolean verifyID(String ID){
		if(StringUtils.isNotBlank(ID) && ID.trim().length() == 10){
			ID = ID.trim();
			String first = ID.substring(0, 1);
			if(mapping.containsKey(first)){
				int iFirst = mapping.get(first).intValue();
				ID = ID.replace(first, String.valueOf(iFirst));
				if(ID.length() == 11){
					char c;
					int total = 0;
					for(int i = 0 ; i < ID.length() ; i++){
						c = ID.charAt(i);
						if(i == 0 || i == ID.length()-1){
							total += Integer.parseInt(String.valueOf(c));
						}else{
							total += Integer.parseInt(String.valueOf(c)) * (10-i);
						}
					}
					return total % 10 == 0;
				}else{
					return false;
				}
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	static{
		mapping.put("A", 10);	// 臺北市
		mapping.put("B", 11);	// 臺中市
		mapping.put("C", 12);	// 基隆市
		mapping.put("D", 13);	// 臺南市
		mapping.put("E", 14);	// 高雄市
		mapping.put("F", 15);	// 新北市
		mapping.put("G", 16);	// 宜蘭縣
		mapping.put("H", 17);	// 桃園市
		mapping.put("I", 34);	// 嘉義市
		mapping.put("J", 18);	// 新竹縣
		mapping.put("K", 19);	// 苗栗縣
		mapping.put("M", 21);	// 南投縣
		mapping.put("N", 22);	// 彰化縣
		mapping.put("O", 35);	// 新竹市
		mapping.put("P", 23);	// 雲林縣
		mapping.put("Q", 24);	// 嘉義縣
		mapping.put("T", 27);	// 屏東縣
		mapping.put("U", 28);	// 花蓮縣
		mapping.put("V", 29);	// 臺東縣
		mapping.put("W", 32);	// 金門縣
		mapping.put("X", 30);	// 澎湖縣
		mapping.put("Z", 33);	// 連江縣
		mapping.put("L", 20);	// 臺中縣，2010年12月25日臺中市
		mapping.put("R", 25);	// 臺南縣，2010年12月25日臺南市
		mapping.put("S", 26);	// 高雄縣，2010年12月25日高雄市
		mapping.put("Y", 31);	// 陽明山管理局，1975年臺北市
		
		int i = 0;
		for(String key : mapping.keySet()){
			if(deprecated.indexOf(key) < 0){
				random[i] = key;
				i++;
			}
		}
		Arrays.sort(random);
	}
}
