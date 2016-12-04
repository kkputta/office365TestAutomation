package com.office365.automation.core.utils;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.office365.automation.core.Base;
import com.office365.automation.core.log.Logger;
import com.office365.automation.core.manager.DriverManager;

public class ElementUtils {
	
	public static WebElement getElement(WebDriver driver,String elementLocationString){
		return driver.findElement(getLocator(elementLocationString));
	}
	
	public static By getLocator(String elementLocationString){
		
		By locator = null;
		Properties prop = getElementKeys();
		
		String elementType = elementLocationString.split("\\.")[1];
		Logger.log.info("elementType = "+elementType);
		if(elementType.equalsIgnoreCase("id")){
			locator = By.id(prop.getProperty(elementLocationString));
			Logger.log.info("locator = "+locator.toString());
		}else if(elementType.equalsIgnoreCase("name")){
			locator = By.name(prop.getProperty(elementLocationString));
			Logger.log.info("locator = "+locator.toString());
		}else if(elementType.equalsIgnoreCase("link")){
			locator = By.linkText(prop.getProperty(elementLocationString));
			Logger.log.info("locator = "+locator.toString());
		}else if(elementType.equalsIgnoreCase("partial_link")){
			locator = By.partialLinkText(prop.getProperty(elementLocationString));
			Logger.log.info("locator = "+locator.toString());
		}else if(elementType.equalsIgnoreCase("tag_name")){
			locator = By.tagName(prop.getProperty(elementLocationString));
			Logger.log.info("locator = "+locator.toString());
		}else if(elementType.equalsIgnoreCase("class")){
			locator = By.className(prop.getProperty(elementLocationString));
			Logger.log.info("locator = "+locator.toString());
		}else if(elementType.equalsIgnoreCase("css_selector")){
			locator = By.cssSelector(prop.getProperty(elementLocationString));
			Logger.log.info("locator = "+locator.toString());
		}else if(elementType.equalsIgnoreCase("xpath")){
			locator = By.xpath(prop.getProperty(elementLocationString));
			Logger.log.info("locator = "+locator.toString());
		}
		return locator;
	}
	
	public static String getStartUrl(String urlString){
		Properties prop = new Properties();
		String url=null;
		try {
			prop.load(DriverManager.class.getResourceAsStream("/url.properties"));
			url = prop.getProperty(urlString);
		} catch (Exception e) {
			Logger.log.error("Url Properties file not loded properly");
			e.printStackTrace();
		}
		return url;
	}
	
	private static Properties getElementKeys(){
		Properties prop = new Properties();
		try {
			prop.load(ElementUtils.class.getResourceAsStream("/ElementKeys.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	public static void waitTo(int seconds){
		Timer timer = new Timer();
		timer.start();
		while(!timer.expired(seconds)) ;
		
	}
	
	public static Properties loadElementData(){
		Properties prop = new Properties();
		try {
			prop.load(ElementUtils.class.getResourceAsStream("/ElementData.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	public static void waitForPageLoad(int seconds) {

	    Wait<WebDriver> wait = new WebDriverWait(Base.driver, seconds);
	    wait.until(new Function<WebDriver, Boolean>() {
	        public Boolean apply(WebDriver driver) {
	            Logger.log.info("Current Window State       : "
	                + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
	            return String
	                .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
	                .equals("complete");
	        }
	    });
	}
}