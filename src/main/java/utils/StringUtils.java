package utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

public class StringUtils extends org.apache.commons.lang3.StringUtils {

	@Test
	public void test(){
		
	}
	
	public static String getRandomNumString(int len) {
		StringBuilder sb = new StringBuilder();
		String n;
		while (sb.length() < len) {
			n = String.valueOf((int)(Math.random()*10));
			sb.append(n);
		}
		return sb.toString();
	}
	
	public static String getString(String str) {
		try {
			return new String(str.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("deprecation")
	public static String URLEncoder(String text){
		return URLEncoder.encode(text);
	}
	
	@SuppressWarnings("deprecation")
	public static String URLDecoder(String text){
		return URLDecoder.decode(text);
	}
	
	public static String MD5encoder(String text) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("md5");  
			byte[] cipherData = md5.digest(text.getBytes());  
			StringBuilder builder = new StringBuilder();  
			for(byte cipher : cipherData) {  
				String toHexStr = Integer.toHexString(cipher & 0xff);  
				builder.append(toHexStr.length() == 1 ? "0" + toHexStr : toHexStr);  
			}  
			return builder.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
}
