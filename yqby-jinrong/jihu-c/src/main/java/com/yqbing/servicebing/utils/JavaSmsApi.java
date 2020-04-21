package com.yqbing.servicebing.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.HttpClient;

/**
 * 短信http接口的java代码调用示例 依赖Apache HttpClient 3.1
 */
public class JavaSmsApi {

	// 查账户信息的http地址
	private static String URI_GET_USER_INFO = "http://yunpian.com/v1/user/get.json";

	// 通用发送接口的http地址
	private static String URI_SEND_SMS = "https://sms.yunpian.com/v2/sms/single_send.json";

	// 模板发送接口的http地址
	private static String URI_TPL_SEND_SMS = "https://sms.yunpian.com/v2/sms/tpl_single_send.json";

	// 状态报告获取
	private static String URI_PULL_STATUS = "http://yunpian.com/v1/sms/pull_status.json";

	// 编码格式。发送编码格式统一用UTF-8
	public static String ENCODING = "UTF-8";

	public static String APIKEY = "7f0ead5a230ff66947d098d0cfa7ba3d";

	public static void main(String[] args) throws IOException, URISyntaxException {
		// 修改为您的apikey
		String apikey = "7f0ead5a230ff66947d098d0cfa7ba3d";
		// 修改为您要发送的手机号
		String mobile = "15011238306";

		/**************** 查账户信息调用示例 *****************/
		// System.out.println(JavaSmsApi.getUserInfo(apikey));

		/**************** 使用通用接口发短信(推荐) *****************/
		// 设置您要发送的内容 (内容必须和某个模板匹配。以下例子匹配的是系统提供的1号模板）
		int code = (int) (Math.random() * 9000);
		String text = "【好赚钱】您的验证码是" + code;
		// 发短信调用示例
		// System.out.println(JavaSmsApi.sendSms(JavaSmsApi.APIKEY, text,
		// mobile));

		/**************** 使用模板接口发短信(不推荐) *****************/
		// 设置模板ID，如使用1号模板:【#company#】您的验证码是#code#
		long tpl_id = 1319237;
		// 设置对应的模板变量值
		// 如果变量名或者变量值中带有#&=%中的任意一个特殊符号，需要先分别进行urlencode编码
		// 如code值是#1234#,需作如下编码转换
		// int code = (int) (Math.random() * 9000);
		System.out.println(code);
		String codeValue = URLEncoder.encode("1234", ENCODING);
		String tpl_value = "#code#=" + codeValue;
		// 模板发送的调用示例
		 System.out.println(JavaSmsApi.sendSms(apikey, text, mobile));

	}

	/**
	 * 取账户信息
	 * 
	 * @return json格式字符串
	 * @throws java.io.IOException
	 */
	public static String getUserInfo(String apikey) throws IOException, URISyntaxException {
		Map<String, String> params = new HashMap<String, String>();
		params.put("apikey", apikey);
		return post(URI_GET_USER_INFO, params);
	}

	/**
	 * 通用接口发短信(推荐)
	 * 
	 * @param apikey
	 *            apikey
	 * @param text
	 *            　短信内容
	 * @param mobile
	 *            　接受的手机号
	 * @return json格式字符串
	 * @throws IOException
	 */
	public static String sendSms(String apikey, String text, String mobile) throws IOException {
		Map<String, String> params = new HashMap<String, String>();
		params.put("apikey", apikey);
		params.put("text", text);
		params.put("mobile", mobile);
		return post(URI_SEND_SMS, params);
	}

	/**
	 * 通过模板号发送短信(推荐)
	 * 
	 * @param apikey
	 *            apikey
	 * @param tpl_id
	 *            　模板id
	 * @param tpl_value
	 *            　模板变量值
	 * @param mobile
	 *            　接受的手机号
	 * @return json格式字符串
	 * @throws IOException
	 */
	public static String tplSendSms(String apikey, long tpl_id, String tpl_value, String mobile) throws IOException {
		Map<String, String> params = new HashMap<String, String>();
		params.put("apikey", apikey);
		params.put("tpl_id", String.valueOf(tpl_id));
		params.put("tpl_value", tpl_value);
		params.put("mobile", mobile);
		return post(URI_TPL_SEND_SMS, params);
	}

	/**
	 * 基于HttpClient 3.1的通用POST方法
	 * 
	 * @param url
	 *            提交的URL
	 * @param paramsMap
	 *            提交<参数，值>Map
	 * @return 提交响应
	 */
	public static String post(String url, Map<String, String> paramsMap) {
		HttpClient client = new HttpClient();
		try {
			PostMethod method = new PostMethod(url);
			if (paramsMap != null) {
				NameValuePair[] namePairs = new NameValuePair[paramsMap.size()];
				int i = 0;
				for (Map.Entry<String, String> param : paramsMap.entrySet()) {
					NameValuePair pair = new NameValuePair(param.getKey(), param.getValue());
					namePairs[i++] = pair;
				}
				method.setRequestBody(namePairs);
				HttpMethodParams param = method.getParams();
				param.setContentCharset(ENCODING);
			}
			client.executeMethod(method);
			return method.getResponseBodyAsString();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}