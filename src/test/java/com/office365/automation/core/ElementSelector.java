package com.office365.automation.core;

import org.openqa.selenium.By;

import com.office365.automation.core.utils.ElementUtils;

public class ElementSelector {
	
	private By locator;
	
	public ElementSelector makeLocator(String elementLocationString){
		locator = ElementUtils.getLocator(elementLocationString);
		return this;
	}
	
	public ElementObject makeElementObject(){
		return new ElementObject(locator);
	}
}