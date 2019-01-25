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
* ˵����    ������ϵͳ������
***************************
* ������    SenseController
* ������    Controllers
***************************/
@Controller
public class SenseController {
	
	
	/**************************************************
	 * �޶�����	����
	 * ˵����	��ѯ���մ�������ֵ
	 * ��������	getLightSenseValue
	 **************************************************
	 * ������
	 * @param request
	 * @param response
	 * @throws IOException 	void
	 **************************************************/
	@RequestMapping(value = "/type/jason/action/" + AppConfig.GET_SENSOR_LIGHT)
	public void getLightSenseValue(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String content = NetStream.read(request);
		System.out.println("���գ�" + content);
		
		String result = "{serverinfo:{'" + AppConfig.KEY_LIGHT_DOWN + "':" 
						+ Integer.toString(Sandbox.lightSense.getDown()) + ","
						+ "'" + AppConfig.KEY_LIGHT_UP + "':"
						+ Integer.toString(Sandbox.lightSense.getUp()) + "}}";
		
		System.out.println("���ͣ�" + result);
		NetStream.write(response, result);
	}
	
	
	/**************************************************
	 * �޶�����	����
	 * ˵����	��ѯ���д�������ǰֵ
	 * ��������	getAllSense
	 **************************************************
	 * ������
	 * @param request
	 * @param response
	 * @throws IOException 	void
	 **************************************************/
	@RequestMapping(value = "/type/jason/action/" + AppConfig.GET_ALL_SENSOR)
	public void getAllSense(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String content = NetStream.read(request);
		System.out.println("���գ�" + content);
		
//		String result = "{serverinfo:{'" + AppConfig.KEY_SENSOR_PM + "':" 
//						+ Integer.toString(Sandbox.allSense.getPm()) + ","
//						+ "'" + AppConfig.KEY_SENSOR_CO2 + "':"
//						+ Integer.toString(Sandbox.allSense.getCo2())  + ","
//						+ "'" + AppConfig.KEY_SENSOR_TEMP + "':"
//						+ Integer.toString(Sandbox.allSense.getTemp())  + ","
//						+ "'" + AppConfig.KEY_SENSOR_LIGHT + "':"
//						+ Integer.toString(Sandbox.allSense.getLightIntensity())  + ","
//						+ "'" + AppConfig.KEY_SENSOR_HUMI + "':"
//						+ Integer.toString(Sandbox.allSense.getHumidity()) + "}}";
		
		Random rd = new Random();
		
		String result = "{serverinfo:{'" + AppConfig.KEY_SENSOR_PM + "':" 
		+ Integer.toString(rd.nextInt(300)) + ","
		+ "'" + AppConfig.KEY_SENSOR_CO2 + "':"
		+ Integer.toString(rd.nextInt(10000))  + ","
		+ "'" + AppConfig.KEY_SENSOR_TEMP + "':"
		+ Integer.toString(rd.nextInt(50))  + ","
		+ "'" + AppConfig.KEY_SENSOR_LIGHT + "':"
		+ Integer.toString(rd.nextInt(3000))  + ","
		+ "'" + AppConfig.KEY_SENSOR_HUMI + "':"
		+ Integer.toString(rd.nextInt(70) - 10) + "}}";
		
		System.out.println("���ͣ�" + result);
		NetStream.write(response, result);
	}
}