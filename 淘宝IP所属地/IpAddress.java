package com.system.util.ipAddress;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 淘宝ip地址分析
 * 
 * @author 王嘉明
 * @cerateTime 2013/11/22
 */
@SuppressWarnings("deprecation")
public class IpAddress {
	/**
	 * ip地区鉴定
	 * 
	 * @param ip
	 *            登录ip
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public String ipAddressJson(String ip) throws ClientProtocolException,
			IOException {
		HttpClient httpClient = new DefaultHttpClient();// httpClient实例
		HttpPost httpPost = new HttpPost(
				"http://ip.taobao.com/service/getIpInfo.php?ip=" + ip);// post实例
		HttpResponse response = httpClient.execute(httpPost);
		HttpEntity entity = response.getEntity();// 获取响应实例
		if (entity != null) {
			return EntityUtils.toString(entity);
		} else {
			return null;
		}
	}
    /**
     * 获取json
     * @param ip 登录ip
     * @return map对象
     * @throws ClientProtocolException
     * @throws IOException
     */
	public static Map<String, String> checkIpAddress(String ip)
			throws ClientProtocolException, IOException {
		JSONObject json = JSON.parseObject(new IpAddress().ipAddressJson(ip));
		if (json.getString("code").equals("0")) {// 返回成功
			Map<String, String> ipAddress = new HashMap<String, String>();//封装数据
			JSONObject data = json.getJSONObject("data");
			ipAddress.put("country", data.getString("country"));
			ipAddress.put("region", data.getString("region"));
			ipAddress.put("city", data.getString("city"));
			ipAddress.put("isp", data.getString("isp"));
			return ipAddress;
		} else {
			return null;
		}
	}
}
