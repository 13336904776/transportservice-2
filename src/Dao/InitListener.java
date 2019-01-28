package Dao;

import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import Config.AppConfig;
import Models.Car;
import Models.Park;
import Models.TrafficLight;

public class InitListener implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	public void contextInitialized(ServletContextEvent arg0) {
//		Thread thread = new MyThread();
//		thread.start();
		
		Car car = new Car();
		car.setAction("Move");
		car.setBanlance(100);
		car.setSpeed(20);
		Sandbox.carList.add(car);
		Sandbox.carList.add(car);
		Sandbox.carList.add(car);
		Sandbox.carList.add(car);
		
		TrafficLight light = new TrafficLight();
		light.setRedTime(20);
		light.setGreenTime(15);
		light.setYellowTime(5);
		Sandbox.trafficLightList.add(light);
		
		TrafficLight light1 = new TrafficLight();
		light1.setRedTime(10);
		light1.setGreenTime(40);
		light1.setYellowTime(10);
		Sandbox.trafficLightList.add(light1);
		
		TrafficLight light2 = new TrafficLight();
		light2.setRedTime(5);
		light2.setGreenTime(10);
		light2.setYellowTime(3);
		Sandbox.trafficLightList.add(light2);
		
		TrafficLight light3 = new TrafficLight();
		light3.setRedTime(15);
		light3.setGreenTime(5);
		light3.setYellowTime(2);
		Sandbox.trafficLightList.add(light3);
		
		TrafficLight light4 = new TrafficLight();
		light4.setRedTime(5);
		light4.setGreenTime(20);
		light4.setYellowTime(8);
		Sandbox.trafficLightList.add(light4);
		
		Park park = new Park();
		park.setMoney(5);
		park.setRateType("Count");
		Sandbox.park = park;
	}

}

class MyThread extends Thread {
	public void run() {
		while (true) {
			System.out.println(new Date());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}