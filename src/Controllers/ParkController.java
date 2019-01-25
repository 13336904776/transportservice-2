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
* ˵����    ͣ������ϵͳ������
***************************
* ������    ParkController
* ������    Controllers
***************************/
@Controller
public class ParkController {
	
	
	/**************************************************
	 * �޶�����	����
	 * ˵����	��ѯͣ����������Ϣ
	 * ��������	getParkRate
	 **************************************************
	 * ������
	 * @param request
	 * @param response
	 * @throws IOException 	void
	 **************************************************/
	@RequestMapping(value = "/type/jason/action/" + AppConfig.GET_PARK_RATE)
	public void getParkRate(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String content = NetStream.read(request);
		System.out.println("���գ�" + content);
		
		String rateType = Sandbox.park.getRateType();
		int money = Sandbox.park.getMoney();
		
		String result = "{serverinfo:{'" + AppConfig.KEY_RATE_TYPE +"':'" + rateType + ","
						+ "'" + AppConfig.KEY_MONEY + "':" + Integer.toString(money) + "}}";
		
		System.out.println("���ͣ�" + result);
		NetStream.write(response, result);
	}
	
	
	/**************************************************
	 * �޶�����	����
	 * ˵����	����ͣ����������Ϣ
	 * ��������	setParkRate
	 **************************************************
	 * ������
	 * @param request
	 * @param response
	 * @throws IOException 	void
	 **************************************************/
	@RequestMapping(value = "/type/jason/action/" + AppConfig.SET_PARK_RATE)
	public void setParkRate(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String content = NetStream.read(request);
		System.out.println("���գ�" + content);
		
		JSONObject jsonObj = JSONObject.fromObject(content);
		String rateType = jsonObj.getString(AppConfig.KEY_RATE_TYPE);
		int money = jsonObj.getInt(AppConfig.KEY_MONEY);

		Sandbox.park.setRateType(rateType);
		Sandbox.park.setMoney(money);
		
		String result = "{serverinfo:{'result':'ok'}}";
		System.out.println("���ͣ�" + result);
		NetStream.write(response, result);
	}
	
	
	/**************************************************
	 * �޶�����	����
	 * ˵����	��ѯͣ�������г�λ
	 * ��������	getParkFree
	 **************************************************
	 * ������
	 * @param request
	 * @param response
	 * @throws IOException 	void
	 **************************************************/
	@RequestMapping(value = "/type/jason/action/" + AppConfig.GET_FREE_LOCATION)
	public void getParkFree(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String content = NetStream.read(request);
		System.out.println("���գ�" + content);
		
		String result = "{serverinfo:[{'" + AppConfig.KEY_PARK_FREE_ID +"':1}]}";
		
		System.out.println("���ͣ�" + result);
		NetStream.write(response, result);
	}
}
