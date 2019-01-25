package Controllers;

import java.io.IOException;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Config.*;
import Dao.Sandbox;
import Models.Car;
import Util.NetStream;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**************************
* 说明：    小车子系统控制器
***************************
* 类名：    CarController
* 包名：    Controllers
***************************/
@Controller
public class CarController {
	
	
	/**************************************************
	 * 限定符：	公开
	 * 说明：	查询小车速度
	 * 方法名：	getCarSpeed
	 **************************************************
	 * 参数表：
	 * @param request
	 * @param response
	 * @throws IOException 	void
	 **************************************************/
	@RequestMapping(value = "/type/jason/action/" + AppConfig.GET_CAR_SPEED)
	public void getCarSpeed(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String content = NetStream.read(request);
		System.out.println("接收：" + content);
		
		JSONObject jsonObj = JSONObject.fromObject(content);
		int carId = jsonObj.getInt(AppConfig.KEY_CAR_ID) - 1;
		int carSpeed = "Move".equals(Sandbox.carList.get(carId).getAction()) 
						? Sandbox.carList.get(carId).getSpeed()
						: 0;

		String result = "{serverinfo:{'" + AppConfig.KEY_CAR_SPEED + "':" + Integer.toString(carSpeed) + "}}";
		System.out.println("发送：" + result);
		NetStream.write(response, result);
	}
	
	
	/**************************************************
	 * 限定符：	公开
	 * 说明：	设置小车动作
	 * 方法名：	setCarMove
	 **************************************************
	 * 参数表：
	 * @param request
	 * @param response
	 * @throws IOException 	void
	 **************************************************/
	@RequestMapping(value = "/type/jason/action/" + AppConfig.SET_CAR_ACTION)
	public void setCarMove(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String content = NetStream.read(request);
		System.out.println("接收：" + content);
		
		JSONObject jsonObj = JSONObject.fromObject(content);
		int carId = jsonObj.getInt(AppConfig.KEY_CAR_ID) - 1;
		String carAction = jsonObj.getString(AppConfig.KEY_CAR_ACTION);
		
		Sandbox.carList.get(carId).setAction(carAction);
		
		String result = "{serverinfo:{'result':'ok'}}";
		System.out.println("发送：" + result);
		NetStream.write(response, result);
	}
	
	
	/**************************************************
	 * 限定符：	公开
	 * 说明：	查询小车账户余额
	 * 方法名：	getCarBalance
	 **************************************************
	 * 参数表：
	 * @param request
	 * @param response
	 * @throws IOException 	void
	 **************************************************/
	@RequestMapping(value = "/type/jason/action/" + AppConfig.GET_CAR_BALANCE)
	public void getCarBalance(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String content = NetStream.read(request);
		System.out.println("接收：" + content);
		
		JSONObject jsonObj = JSONObject.fromObject(content);
		int carId = jsonObj.getInt(AppConfig.KEY_CAR_ID) - 1;
		int carBalance = Sandbox.carList.get(carId).getBanlance();
		
		String result = "{serverinfo:{'" + AppConfig.KEY_CAR_BALANCE + "':'" 
						+ Integer.toString(carBalance) +"'}}";
		
		System.out.println("发送：" + result);
		NetStream.write(response, result);
	}
	
	
	/**************************************************
	 * 限定符：	公开
	 * 说明：	设置小车账户余额
	 * 方法名：	setCarBalance
	 **************************************************
	 * 参数表：
	 * @param request
	 * @param response
	 * @throws IOException 	void
	 **************************************************/
	@RequestMapping(value = "/type/jason/action/" + AppConfig.SET_CAR_BALANCE)
	public void setCarBalance(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String content = NetStream.read(request);
		System.out.println("接收：" + content);
		
		JSONObject jsonObj = JSONObject.fromObject(content);
		int carId = jsonObj.getInt(AppConfig.KEY_CAR_ID) - 1;
		int carBalance = jsonObj.getInt(AppConfig.KEY_MONEY);
		
		Sandbox.carList.get(carId).setBanlance(Sandbox.carList.get(carId).getBanlance() + carBalance);
		
		String result = "{serverinfo:{'result':'ok'}}";
		System.out.println("发送：" + result);
		NetStream.write(response, result);
	}
}
