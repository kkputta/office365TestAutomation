package com.office365.automation.webapp.office.userhome;

import com.office365.automation.core.ElementObject;
import com.office365.automation.core.ElementSelector;

public class UserHomeObjects {
	
	public static ElementObject
			userHomeMenuButton,
			userHomeInsideAdmin;
	
	public ElementObject userHomeMenuButton(){
		if(userHomeMenuButton == null){
			userHomeMenuButton = new ElementSelector().makeLocator("userHomeMenuButton.id").makeElementObject();
		}
		return userHomeMenuButton;
	}
	
	public ElementObject userHomeInsideAdmin(){
		if(userHomeInsideAdmin == null){
			userHomeInsideAdmin = new ElementSelector().makeLocator("userHomeInsideAdmin.xpath").makeElementObject();
		}
		return userHomeInsideAdmin;
	}
}
