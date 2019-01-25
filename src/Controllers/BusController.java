package Controllers;

import java.io.IOException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import Config.AppConfig;
import Dao.Sandbox;
import Util.NetStream;


/**************************
* 说明：    公交子系统控制器
***************************
* 类名：    BusController
* 包名：    Controllers
***************************/
@Controller
public class BusController {
	
	
	/**************************************************
	 * 限定符：	公开
	 * 说明：	查询公交站台信息
	 * 方法名：	getBusStationInfo
	 **************************************************
	 * 参数表：
	 * @param request
	 * @param response
	 * @throws IOException 	void
	 **************************************************/
	@RequestMapping(value = "/type/jason/action/" + AppConfig.GET_BUS_STATION_INFO)
	public void getBusStationInfo(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String content = NetStream.read(request);
		System.out.println("接收：" + content);
		
		JSONObject jsonObj = JSONObject.fromObject(content);
		int busStationId = jsonObj.getInt(AppConfig.KEY_BUS_STATION_ID) - 1;
		
		Random rd = new Random();
		
		int distance1 = rd.nextInt(5001);
		int distance2 = rd.nextInt(5001);
		
		String result = "{serverinfo:[{'" + AppConfig.KEY_BUS_ID + "':1,'" + AppConfig.KEY_DISTANCE 
						+ "':" + Integer.toString(distance1) + "},{'" + AppConfig.KEY_BUS_ID + "':2,'" 
						+ AppConfig.KEY_DISTANCE + "':" + Integer.toString(distance2) + "}]}";
		
		System.out.println("发送：" + result);
		NetStream.write(response, result);
	}
}
