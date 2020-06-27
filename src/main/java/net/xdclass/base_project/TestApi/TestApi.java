package net.xdclass.base_project.TestApi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TestApi {

	public String load(String url, String query) throws Exception {
		URL restURL = new URL(url);
		/*
		 * 此处的urlConnection对象实际上是根据URL的请求协议(此处是http)生成的URLConnection类
		 * 的子类HttpURLConnection
		 */
		HttpURLConnection conn = (HttpURLConnection) restURL.openConnection();
		// 请求方式
		conn.setRequestMethod("POST");
		// 设置是否从httpUrlConnection读入，默认情况下是true; httpUrlConnection.setDoInput(true);
		conn.setDoOutput(true);
		// allowUserInteraction 如果为 true，则在允许用户交互（例如弹出一个验证对话框）的上下文中对此 URL 进行检查。
		conn.setAllowUserInteraction(false);
		// 这三行是bug,忘了当初是测试打印日志，忘了屏蔽，感谢 黄邦锁 同学提醒 2019-12-31
		// PrintStream ps = new PrintStream(conn.getOutputStream());
		// ps.print(query);

		// ps.close();

		BufferedReader bReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

		String line, resultStr = "";

		while (null != (line = bReader.readLine())) {
			resultStr += line;
		}
		System.out.println("3412412---" + resultStr);
		bReader.close();

		return resultStr;
	}

	public static void main(String[] args) {
		try {
			TestApi restUtil = new TestApi();
			String content = "您的验证码是:123456";
			String account = "dh90204";// 用户名（必填）
			String password = "bfd590c5a969fa4215fa579632b3f39c";// 密码（必填,明文）
			String phone = "18252723970"; // 手机号码（必填,多条以英文逗号隔开）
			String sign = "【UABC】"; // 短信签名（必填）
			String subcode = ""; // 子号码（可选）
			String msgid = UUID.randomUUID().toString().replace("-", ""); // 短信id，查询短信状态报告时需要，（可选）
			String sendtime = ""; // 定时发送时间（可选）
			String resultString = restUtil.load("http://www.dh3t.com/json/sms/Submit", "account="+account+"&password="+password+"&msgid="+msgid+"&phones="+phone+"&content="+content+"&sign="+sign+"&subcode="+subcode+"&sendtime="+sendtime);
		} catch (Exception e) { // TODO: handle exception System.out.print(e.getMessage());}}
		}
	}
}