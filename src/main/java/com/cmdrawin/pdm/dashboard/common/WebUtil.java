package com.cmdrawin.pdm.dashboard.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;


public class WebUtil {
	  public static String doPost(String url, Map<String, String> params, int connectTimeout, int readTimeout)
			    throws IOException
			  {
			    return doPost(url, params, "UTF-8", connectTimeout, readTimeout);
			  }
	  public static String doPost(String url, Map<String, String> params, String charset, int connectTimeout, int readTimeout)
			    throws IOException
			  {
			    return doPost(url, params, charset, connectTimeout, readTimeout, null);
			  }
	  public static String doPost(String url, Map<String, String> params, String charset, int connectTimeout, int readTimeout, Map<String, String> headerMap) throws IOException
	  {
	    String ctype = new StringBuilder().append("application/x-www-form-urlencoded;charset=").append(charset).toString();
	    String query = buildQuery(params, charset);
	    byte[] content = new byte[0];
	    if (query != null) {
	      content = query.getBytes(charset);
	    }
	    return _doPost(url, ctype, content, connectTimeout, readTimeout, headerMap);
	  }
	  
	  public static String buildQuery(Map<String, String> params, String charset) throws IOException {
		    if ((params == null) || (params.isEmpty())) {
		      return null;
		    }

		    StringBuilder query = new StringBuilder();
		   // Set entries = params.entrySet();
		    boolean hasParam = false;

		    for (Map.Entry entry : params.entrySet()) {
		      String name = (String)entry.getKey();
		      String value = (String)entry.getValue();

		      if ((!isEmpty(name)) && (!isEmpty(value))) {
		        if (hasParam)
		          query.append("&");
		        else {
		          hasParam = true;
		        }

		        query.append(name).append("=").append(URLEncoder.encode(value, charset));
		      }
		    }
		    return query.toString();
		  }
	  
	  private static boolean isEmpty(String value) {
		    if (value == null) {
		      return true;
		    }
		    return false;
		  }
	  
	  private static String _doPost(String url, String ctype, byte[] content, int connectTimeout, int readTimeout, Map<String, String> headerMap) throws IOException {
		    HttpURLConnection conn = null;
		    OutputStream out = null;
		    String rsp = null;
		    try {
		      conn = getConnection(new URL(url), "POST", ctype, headerMap);
		      conn.setConnectTimeout(connectTimeout);
		      conn.setReadTimeout(readTimeout);
		      out = conn.getOutputStream();
		      out.write(content);
		      rsp = getResponseAsString(conn);
		    } catch (IOException e) {
		      throw e;
		    } finally {
		      if (out != null) {
		        out.close();
		      }
		      if (conn != null) {
		        conn.disconnect();
		      }
		    }
		    return rsp;
		  }
	  
	  private static HttpURLConnection getConnection(URL url, String method, String ctype, Map<String, String> headerMap) throws IOException {
		    HttpURLConnection conn = null;
		    if ("https".equals(url.getProtocol())) {
		      SSLContext ctx = null;
		      try {
		        ctx = SSLContext.getInstance("TLS");
		        ctx.init(new KeyManager[0], new TrustManager[] { new DefaultTrustManager() }, new SecureRandom());
		      } catch (Exception e) {
		        throw new IOException(e);
		      }
		      HttpsURLConnection connHttps = (HttpsURLConnection)url.openConnection();
		      connHttps.setSSLSocketFactory(ctx.getSocketFactory());
		      connHttps.setHostnameVerifier(new HostnameVerifier() {
		        public boolean verify(String hostname, SSLSession session) {
		          return true;
		        }
		      });
		      conn = connHttps;
		    } else {
		      conn = (HttpURLConnection)url.openConnection();
		    }

		    conn.setRequestMethod(method);
		    conn.setDoInput(true);
		    conn.setDoOutput(true);
		    conn.setRequestProperty("User-Agent", "longhz-sdk-java");
		    conn.setRequestProperty("Content-Type", ctype);
		    conn.setRequestProperty("Cookie", "PHPSESSID=mojgqkn1adkd73g4de2e4mqkl5");
		    if (headerMap != null) {
		      for (Map.Entry entry : headerMap.entrySet()) {
		        conn.setRequestProperty((String)entry.getKey(), (String)entry.getValue());
		      }
		    }
		    return conn;
		  }

	  protected static String getResponseAsString(HttpURLConnection conn) throws IOException
	  {
	    String charset = getResponseCharset(conn.getContentType());
	    InputStream es = conn.getErrorStream();
	    if (es == null) {
	      return getStreamAsString(conn.getInputStream(), charset);
	    }
	    String msg = getStreamAsString(es, charset);
	    if (isEmpty(msg)) {
	      throw new IOException(new StringBuilder().append(conn.getResponseCode()).append(":").append(conn.getResponseMessage()).toString());
	    }
	    throw new IOException(new StringBuilder().append(conn.getResponseCode()).append(":").append(conn.getResponseMessage()).append("\r\n").append(msg).toString());
	  }
	  
	  private static String getResponseCharset(String ctype)
	  {
	    String charset = "UTF-8";

	    if (!isEmpty(ctype)) {
	      String[] params = ctype.split(";");
	      for (String param : params) {
	        param = param.trim();
	        if (param.startsWith("charset")) {
	          String[] pair = param.split("=", 2);
	          if ((pair.length != 2) || 
	            (isEmpty(pair[1]))) break;
	          charset = pair[1].trim(); break;
	        }

	      }

	    }

	    return charset;
	  }
	  
	  private static String getStreamAsString(InputStream stream, String charset) throws IOException
	  {
	    try {
	      Reader reader = new InputStreamReader(stream, charset);
	      StringBuilder response = new StringBuilder();

	      char[] buff = new char[1024];
	      int read = 0;
	      while ((read = reader.read(buff)) > 0) {
	        response.append(buff, 0, read);
	      }

	      return response.toString();
	    } finally {
	      if (stream != null)
	        stream.close();
	    }
	  }
	  
	  private static class DefaultTrustManager
	    implements X509TrustManager
	  {
	    public X509Certificate[] getAcceptedIssuers()
	    {
	      return null;
	    }

	    public void checkClientTrusted(X509Certificate[] chain, String authType)
	      throws CertificateException
	    {
	    }

	    public void checkServerTrusted(X509Certificate[] chain, String authType)
	      throws CertificateException
	    {
	    }
	  }
	  
	  private static Map<String, String> parseParam(String contentString)
	  {
	    Map params = new HashMap();
	    if ((contentString == null) || (contentString.trim().equals(""))) {
	      return params;
	    }
	    String[] paramsArray = contentString.split("\\&");
	    if (paramsArray != null) {
	      for (String param : paramsArray) {
	        String[] keyValue = param.split("=");
	        if ((keyValue != null) && (keyValue.length == 2)) {
	          params.put(keyValue[0], keyValue[1]);
	        }
	      }
	    }
	    return params;
	  }	  

}
