package sample;

import java.net.URLEncoder;
import java.sql.*;
import java.util.UUID;

public class JDBCSample {
	private static Connection dbCon = null;

	public static void main(String [] arg){
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			System.out.println("載入驅動程式成功");
			dbCon = DriverManager.getConnection("jdbc:sqlserver://chehao.database.windows.net:1433;database=chehao;user=xup65k6cl6@chehao;password=1qaz!QAZ;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
			System.out.println("與database連線成功");
			String id = UUID.randomUUID().toString();
			String name = URLEncoder.encode("林哲豪");
			ResultSet rs = dbCon.createStatement().executeQuery("INSERT INTO [chehao].[datematcher].[user] ([id], [user_account], [user_name]) VALUES ('"+id+"', 'xup65k6cl6@hotmail.com', '"+name+"');");
			
			
		}catch(SQLException e){
			System.out.println("SQLException :" + e.getMessage());
		}catch(ClassNotFoundException cfe){
			System.out.println("找不到驅動程式");
		}catch(IllegalAccessException iae){
			System.out.println("無法讀取驅動程式");
		}catch(InstantiationException ie){
			System.out.println("無法載入驅動程式");
		}finally{
			try {
				if (dbCon != null)
					dbCon.close();// 中斷與database連線
			} catch (Exception e) {
			}
			dbCon = null; // 把物件資源釋放
		}
	}
}
