package com.works.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

/**
 * 发送GET、Post请求
 * @author DerrickZheng
 * 
 * @version 1.0
 */
public class HttpRequest {
	

	/**
	 * 向指定URL发送GET方法的请求
	 * 
	 * @param url
	 *            发送请求的URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * 
	 * @author DerrickZheng
	 * @return URL 所代表远程资源的响应结果
	 */
	public static String sendGet(String url, String param) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url;

			if (null != param) {
				urlNameString += "?" + param;
			}

			URL realUrl = new URL(urlNameString);
			// // 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();

			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 向指定 URL 发送POST方法的请求
	 * 
	 * @param url
	 *            发送请求的 URL
	 * @param param
	 *            请求参数 格式取决于 contentType
	 * @param signature
	 *            放在头里的权限签名 不需要 就传 null
	 * @param contentType
	 *            不需要 就传 null 传参方式 
	 *            1.application/json 传参数也是json 格式的；
	 *            2.application/x-www-form-urlencoded 参数形式是字符串格式(如下示例所示)
	 *            	“image_content=xxx&pictype=xxx&appid=xxx&sig=xxx”
	 *            3.multipart/form-data; boundary=----+随机串
	 * @author DerrickZheng
	 * @return 所代表远程资源的响应结果
	 * 
	 */
	public static String sendPost(String url, String param, String signature, String contentType) {

		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			if (null != contentType)
				conn.setRequestProperty("Content-Type", contentType);

			if (null != signature)
				conn.setRequestProperty("signature", signature);

			conn.setConnectTimeout(5000 * 60);
			conn.setReadTimeout(5000 * 60);
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}
	
	/**
	 * 生成form-data数据
	 * @param map    需要提交的数据 key和value
	 * @param random 自定义字符串，只要不与其他字符串冲突就行
	 * @author DerrickZheng
	 * @return
	 */
	public static String formData(Map<String, Object> map,String random) {
		
		if (map.isEmpty()) {
			return "";
		}
		
		StringBuffer buffer = new StringBuffer();
		for (String key : map.keySet()) {
			buffer.append("------"+random+"\r\n");
			buffer.append("Content-Disposition: form-data; name=\"");
			buffer.append(key);
			buffer.append("\"\r\n\r\n");
			buffer.append(map.get(key));
			buffer.append("\r\n");
		}
			buffer.append("------"+random+"--\r\n");

		return buffer.toString();
	}

}