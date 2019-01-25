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
* ˵����    ���̵���ϵͳ������
***************************
* ������    TrafficLightController
* ������    Controllers
***************************/
@Controller
public class TrafficLightController {
	
	
	/**************************************************
	 * �޶�����	����
	 * ˵����	��ѯ���̵�������Ϣ
	 * ��������	getLightMsg
	 **************************************************
	 * ������
	 * @param request
	 * @param response
	 * @throws IOException 	void
	 **************************************************/
	@RequestMapping(value = "/type/jason/action/" + AppConfig.GET_LIGHT_MSG)
	public void getLightMsg(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String content = NetStream.read(request);
		System.out.println("���գ�" + content);
		
		JSONObject jsonObj = JSONObject.fromObject(content);
		int lightId = jsonObj.getInt(AppConfig.KEY_TRAFFIC_LIGHT_ID) - 1;
		int redTime = Sandbox.trafficLightList.get(lightId).getRedTime();
		int greenTime = Sandbox.trafficLightList.get(lightId).getGreenTime();
		int yellowTime = Sandbox.trafficLightList.get(lightId).getYellowTime();
		
		String result = "{serverinfo:{'" + AppConfig.KEY_LIGHT_RED + "':" + Integer.toString(redTime) + ","
						+ "'" + AppConfig.KEY_LIGHT_GREEN + "':" + Integer.toString(greenTime) + ","
						+ "'" + AppConfig.KEY_LIGHT_YELLOW + "':" + Integer.toString(yellowTime) + "}}";
		
		System.out.println("���ͣ�" + result);
		NetStream.write(response, result);
	}
	
}