package com.office365.automation.core.manager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.office365.automation.core.Base;
import com.office365.automation.core.log.Logger;

public class DriverManager {
	
	public static DriverManager CreateDriver(String browser){
		
		if(browser.equalsIgnoreCase("firefox")){
			Logger.log.info("Creating firefox  driver....");
			Base.driver = new FirefoxDriver();
		}else if (browser.equalsIgnoreCase("chrome")){
			Logger.log.info("Creating chrome  driver....");
			Base.driver = new ChromeDriver();
		}else{
			throw new RuntimeException(browser+" : This browser String is not supported. only \"firefox\" or \"chrome\" Strings are supported.");
		}
		return new DriverManager();
	}
	
	public DriverManager setImplicitWait(int seconds){
		Base.driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
		return this;
	}
	
	public DriverManager maximizeWindow(){
		Base.driver.manage().window().maximize();
		return this;
	}
	
	public static void killDriver(){
		if(Base.driver != null) {
			Logger.log.info("Killing  driver....");
			Base.driver.quit();
		}else Logger.log.info("Driver is not initialised, nothing to kill");
	}
}