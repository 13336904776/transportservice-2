package Util;

import java.io.IOException;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NetStream {
	public static String read(HttpServletRequest request) throws IOException {
		ServletInputStream ris = request.getInputStream();
		StringBuilder content = new StringBuilder();
		byte[] b = new byte[1024];
		int lens = -1;
		while ((lens = ris.read(b)) > 0) {
			content.append(new String(b,0,lens));
		}
		return content.toString();
	}
	
	public static void write(HttpServletResponse response,String result) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);
	}
}
