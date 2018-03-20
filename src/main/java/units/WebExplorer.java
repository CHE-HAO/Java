package units;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

@SuppressWarnings("unused")
public class WebExplorer {

	private static final String WEB_PATH = "https://www.google.com.tw";
	
	String a;
	
	@Test
	public void main(){
		getWeb();
		getJsoupWeb();
	}
	
	private void getJsoupWeb(){
		try {
			Document d = Jsoup.connect(WEB_PATH).get();
//			Element e = d.getElementById("main");
//			System.out.println(e.toString());
//			Elements es = d.getElementsByClass("gb_b");
//			for(Iterator<Element> it = es.iterator(); it.hasNext();){
//				Element e = it.next();
//				System.out.println(e.data());
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void getWeb(){
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null; 
		try {
			// 将string转成url对象
			URL url = new URL(WEB_PATH);
			// 初始化一个链接到那个url的连接
			URLConnection connection = url.openConnection();
			// 开始实际的连接
			connection.connect();
			// 初始化 BufferedReader输入流来读取URL的响应
			br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			// 用来临时存储抓取到的每一行的数据
			String line;
			while ((line = br.readLine()) != null){
				// 遍历抓取到的每一行并将其存储到result里面
				sb.append(line);
			}
			a = sb.toString();
			System.out.println(sb.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br != null){
				try {
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
