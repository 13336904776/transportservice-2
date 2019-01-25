package Controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import Config.AppConfig;
import Dao.Sandbox;
import Util.NetStream;


/**************************
* 说明：    红绿灯子系统控制器
***************************
* 类名：    TrafficLightController
* 包名：    Controllers
***************************/
@Controller
public class TrafficLightController {
	
	
	/**************************************************
	 * 限定符：	公开
	 * 说明：	查询红绿灯配置信息
	 * 方法名：	getLightMsg
	 **************************************************
	 * 参数表：
	 * @param request
	 * @param response
	 * @throws IOException 	void
	 **************************************************/
	@RequestMapping(value = "/type/jason/action/" + AppConfig.GET_LIGHT_MSG)
	public void getLightMsg(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String content = NetStream.read(request);
		System.out.println("接收：" + content);
		
		JSONObject jsonObj = JSONObject.fromObject(content);
		int lightId = jsonObj.getInt(AppConfig.KEY_TRAFFIC_LIGHT_ID) - 1;
		int redTime = Sandbox.trafficLightList.get(lightId).getRedTime();
		int greenTime = Sandbox.trafficLightList.get(lightId).getGreenTime();
		int yellowTime = Sandbox.trafficLightList.get(lightId).getYellowTime();
		
		String result = "{serverinfo:{'" + AppConfig.KEY_LIGHT_RED + "':" + Integer.toString(redTime) + ","
						+ "'" + AppConfig.KEY_LIGHT_GREEN + "':" + Integer.toString(greenTime) + ","
						+ "'" + AppConfig.KEY_LIGHT_YELLOW + "':" + Integer.toString(yellowTime) + "}}";
		
		System.out.println("发送：" + result);
		NetStream.write(response, result);
	}
	
}