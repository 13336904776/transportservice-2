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
* 说明：    道路子系统控制器
***************************
* 类名：    RoadController
* 包名：    Controllers
***************************/
@Controller
public class RoadController {
	
	
	/**************************************************
	 * 限定符：	公开
	 * 说明：	查询道路状态
	 * 方法名：	getRoadStatus
	 **************************************************
	 * 参数表：
	 * @param request
	 * @param response
	 * @throws IOException 	void
	 **************************************************/
	@RequestMapping(value = "/type/jason/action/" + AppConfig.GET_ROAD_STATION_INFO)
	public void getRoadStatus(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String content = NetStream.read(request);
		System.out.println("接收：" + content);
		
		JSONObject jsonObj = JSONObject.fromObject(content);
		int roadId = jsonObj.getInt(AppConfig.KEY_ROAD_ID) - 1;
		int status = Sandbox.roadList.get(roadId).getStatus();
		
		String result = "{serverinfo:{'" + AppConfig.KEY_STATUS + "':" + Integer.toString(status) + "}}";
		
		System.out.println("发送：" + result);
		NetStream.write(response, result);
	}
}