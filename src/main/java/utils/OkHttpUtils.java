package utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * Http連線呼叫公用程式<br/>
 * (採用OkHttp且以singleton實作, 現只有post)
 */
public class OkHttpUtils {

	private static Logger log = LoggerFactory.getLogger(OkHttpUtils.class);
			
	public final static String STATUS_CODE = "statusCode";
	public final static String MESSAGE = "message";
	public final static String BODY = "body";
	
	private static OkHttpClient singleton;

	private OkHttpUtils() { }
	
	public static OkHttpClient getInstance() {
		if (singleton == null) {
			synchronized (OkHttpUtils.class) {
				if (singleton == null) {
					
//					OkHttpClient mBuilder = new OkHttpClient.Builder();
//		            // mBuilder.sslSocketFactory(DummySecureProtocolSocketFactory.createSSLSocketFactory());
//					mBuilder.sslSocketFactory(DummySecureProtocolSocketFactory.createSSLSocketFactory(), new DummySecureProtocolSocketFactory.TrustAllCerts());
//		            mBuilder.hostnameVerifier(new DummySecureProtocolSocketFactory.TrustAllHostnameVerifier());
//		            mBuilder.connectTimeout(PropUtils.OK_CONNECT_TIMEOUT, TimeUnit.SECONDS);
//		            mBuilder.readTimeout(PropUtils.OK_READ_TIMEOUT, TimeUnit.SECONDS);
//		            mBuilder.writeTimeout(PropUtils.OK_WRITE_TIMEOUT, TimeUnit.SECONDS);
		            
//					singleton = mBuilder.build();
				}
			}
		}
		return singleton;
	}

	/**
	 * get
	 */
	/*public static void requestGet() {
		// Request
		final Request request = new Request.Builder().url(req.getRequestUrl()).build();
		OkHttpUtils.getInstance().newCall(request);
	}*/

	/**
	 * post
	 */
	public static Map<String, Object> requestPost(final String url, final Map<String, String> headers, final RequestBody body) {
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		Response response = null;
		try {
			Request.Builder builder = new Request.Builder();
			
			// url
			builder.url(url);
			
			// header
			for (Entry<String, String> mEntry : headers.entrySet()) {
				String mEntryKey = mEntry.getKey();
				Object mEntryValue = mEntry.getValue();
				if (StringUtils.isBlank(mEntryKey)) {
					continue;
				}
				builder.addHeader(mEntryKey, mEntryValue.toString());
			}
			
			// body
			builder.post(body);
			
			Request request = builder.build();
			log.debug("===============================request info start==============================");
			log.debug("request url=" + org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString(request.url()));
			log.debug("request method=" + request.method());
			log.debug("request headers=" + org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString(request.headers()));
			log.debug("===============================request info end================================");
			
			// call
			response = OkHttpUtils.getInstance().newCall(request).execute();
			
			int statusCode = response.code();
			String message = response.message();
			String bodyStr = response.body().string();
			
			result.put(STATUS_CODE, statusCode);
			result.put(MESSAGE, message);
			result.put(BODY, bodyStr);
			
			log.debug("statusCode=" + statusCode);
			log.debug("message=" + message);
			log.debug("bodyStr=" + bodyStr);
			
		} catch (Exception e) {
			log.error("error:" + e.getMessage());
			
			if (result.isEmpty()) {
				result.put(MESSAGE, e.getMessage());
			}
		} finally {
			if (response != null) {
				try {
					response.body().close();
				} catch(Exception ex) { }
			}
		}
		
		return result;
	}
	
	/**
	 * 取得呼叫status code
	 * 
	 * @param respResult
	 * @return
	 */
	public static int getCode(Map<String, Object> respResult) {
		return MapUtils.getIntValue(respResult, STATUS_CODE);
	}
	
	/**
	 * 取得呼叫http message
	 * 
	 * @param respResult
	 * @return
	 */
	public static String getMessage(Map<String, Object> respResult) {
		return MapUtils.getString(respResult, MESSAGE);
	}
	
	/**
	 * 取得呼叫回覆結果
	 * 
	 * @param respResult
	 * @return
	 */
	public static String getBody(Map<String, Object> respResult) {
		return MapUtils.getString(respResult, BODY);
	}
	
	
}
