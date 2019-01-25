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
* ˵����    ��·��ϵͳ������
***************************
* ������    RoadController
* ������    Controllers
***************************/
@Controller
public class RoadController {
	
	
	/**************************************************
	 * �޶�����	����
	 * ˵����	��ѯ��·״̬
	 * ��������	getRoadStatus
	 **************************************************
	 * ������
	 * @param request
	 * @param response
	 * @throws IOException 	void
	 **************************************************/
	@RequestMapping(value = "/type/jason/action/" + AppConfig.GET_ROAD_STATION_INFO)
	public void getRoadStatus(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String content = NetStream.read(request);
		System.out.println("���գ�" + content);
		
		JSONObject jsonObj = JSONObject.fromObject(content);
		int roadId = jsonObj.getInt(AppConfig.KEY_ROAD_ID) - 1;
		int status = Sandbox.roadList.get(roadId).getStatus();
		
		String result = "{serverinfo:{'" + AppConfig.KEY_STATUS + "':" + Integer.toString(status) + "}}";
		
		System.out.println("���ͣ�" + result);
		NetStream.write(response, result);
	}
}