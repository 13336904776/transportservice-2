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
* 说明：    停车场子系统控制器
***************************
* 类名：    ParkController
* 包名：    Controllers
***************************/
@Controller
public class ParkController {
	
	
	/**************************************************
	 * 限定符：	公开
	 * 说明：	查询停车场费率信息
	 * 方法名：	getParkRate
	 **************************************************
	 * 参数表：
	 * @param request
	 * @param response
	 * @throws IOException 	void
	 **************************************************/
	@RequestMapping(value = "/type/jason/action/" + AppConfig.GET_PARK_RATE)
	public void getParkRate(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String content = NetStream.read(request);
		System.out.println("接收：" + content);
		
		String rateType = Sandbox.park.getRateType();
		int money = Sandbox.park.getMoney();
		
		String result = "{serverinfo:{'" + AppConfig.KEY_RATE_TYPE +"':'" + rateType + ","
						+ "'" + AppConfig.KEY_MONEY + "':" + Integer.toString(money) + "}}";
		
		System.out.println("发送：" + result);
		NetStream.write(response, result);
	}
	
	
	/**************************************************
	 * 限定符：	公开
	 * 说明：	设置停车场费率信息
	 * 方法名：	setParkRate
	 **************************************************
	 * 参数表：
	 * @param request
	 * @param response
	 * @throws IOException 	void
	 **************************************************/
	@RequestMapping(value = "/type/jason/action/" + AppConfig.SET_PARK_RATE)
	public void setParkRate(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String content = NetStream.read(request);
		System.out.println("接收：" + content);
		
		JSONObject jsonObj = JSONObject.fromObject(content);
		String rateType = jsonObj.getString(AppConfig.KEY_RATE_TYPE);
		int money = jsonObj.getInt(AppConfig.KEY_MONEY);

		Sandbox.park.setRateType(rateType);
		Sandbox.park.setMoney(money);
		
		String result = "{serverinfo:{'result':'ok'}}";
		System.out.println("发送：" + result);
		NetStream.write(response, result);
	}
	
	
	/**************************************************
	 * 限定符：	公开
	 * 说明：	查询停车场空闲车位
	 * 方法名：	getParkFree
	 **************************************************
	 * 参数表：
	 * @param request
	 * @param response
	 * @throws IOException 	void
	 **************************************************/
	@RequestMapping(value = "/type/jason/action/" + AppConfig.GET_FREE_LOCATION)
	public void getParkFree(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String content = NetStream.read(request);
		System.out.println("接收：" + content);
		
		String result = "{serverinfo:[{'" + AppConfig.KEY_PARK_FREE_ID +"':1}]}";
		
		System.out.println("发送：" + result);
		NetStream.write(response, result);
	}
}
