package com.office365.automation.core;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.office365.automation.core.utils.Timer;

public class ElementObject {
	
	private By locator;
	
	ElementObject(By locator){
		this.locator = locator;
	}
	
	public boolean exists(){
		try{
			WebElement element = Base.driver.findElement(locator);
			return element.isDisplayed();
		}catch(NoSuchElementException e){
			return false;
		}
	}
	
	public ElementObject clearText(){
		Base.driver.findElement(locator).clear();
		return this;
	}
	
	public ElementObject clickElement(){
		Base.driver.findElement(locator).click();
		return this;
	}
	
	public WebElement findElement(By locator){
		return Base.driver.findElement(locator);
	}
	
	public List<WebElement> findElements(By locaotr){
		return Base.driver.findElements(locaotr);
	}
	
	public String getAttribute(String attributeName){
		return Base.driver.findElement(locator).getAttribute(attributeName);
	}
	
	public String getCssValue(String propertyName){
		return Base.driver.findElement(locator).getCssValue(propertyName);
	}
	
	public Point getLocation(){
		return Base.driver.findElement(locator).getLocation();
	}
	
	public Rectangle getRect(){
		return Base.driver.findElement(locator).getRect();
	}
	
	public Dimension getSize(){
		return Base.driver.findElement(locator).getSize();
	}
	
	public String getTagName(){
		return Base.driver.findElement(locator).getTagName();
	}
	
	public String getText(){
		return Base.driver.findElement(locator).getText();
	}
	
	public boolean isDisplayed(){
		return Base.driver.findElement(locator).isDisplayed();
	}
	
	public boolean isEnabled(){
		return Base.driver.findElement(locator).isEnabled();
	}
	
	public boolean isSelected(){
		return Base.driver.findElement(locator).isSelected();
	}
	
	public ElementObject typeText(String text){
		Base.driver.findElement(locator).sendKeys(text);
		return this;
	}
	
	public ElementObject sendKeysToElement(java.lang.CharSequence... keysToSend){
		Base.driver.findElement(locator).sendKeys(keysToSend);
		return this;
	}
	
	public void submitElement(){
		Base.driver.findElement(locator).submit();
	}
	
	public ElementObject waitTo(int seconds){
		Timer timer = new Timer();
		timer.start();
		while(!timer.expired(seconds)){}
		return this;
	}
	
	public ElementObject waitToElementClickable(int seconds){
		WebDriverWait wait = new WebDriverWait(Base.driver,seconds);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		return this;
	}
	
	public ElementObject activeElementSendKeys(java.lang.CharSequence... keysToSend){
		Base.driver.switchTo().activeElement().sendKeys(keysToSend);
		return this;
	}
	
	public ElementObject activeElementTypeText(String text){
		Base.driver.switchTo().activeElement().sendKeys(text);
		return this;
	}
	
	public ElementObject activeElementClick(){
		Base.driver.switchTo().activeElement().click();
		return this;
	}
	
	public ElementObject waitToAppear(int seconds){
		Timer timer = new Timer();
		timer.start();
		while(!timer.expired(seconds)) if(exists()) break;
		if(timer.expired(seconds) && !exists()) throw new AssertionError("Element "+locator+" failed to appear within "+seconds+" seconds");
		return this;
	}
	
	public ElementObject waitToDisappear(int seconds){
		Timer timer = new Timer();
		timer.start();
		while(!timer.expired(seconds)) if(!exists()) break;
		if(timer.expired(seconds) && exists()) throw new AssertionError("Element "+locator+" failed to disappear within "+seconds+" seconds");
		return this;
	}
}