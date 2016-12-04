package com.office365.automation.webapp.office.userhome;

import org.openqa.selenium.NoSuchElementException;

import com.office365.automation.core.Base;
import com.office365.automation.core.log.Logger;
import com.office365.automation.webapp.interfaces.Activity;
import com.office365.automation.webapp.office.admin.AdminHome;

public class UserHome implements Activity {
	public UserHomeObjects userHomeObjects = new UserHomeObjects();


	public UserHome clickMenuButton(){
		try{
			Base.webApp.officeapp.userHome.userHomeObjects.userHomeMenuButton().clickElement();
			return Base.webApp.officeapp.userHome;
		}catch(NoSuchElementException e){
			throw new AssertionError("cannot get userHome menu Button Element, element absent or not visible");
		}
	}
	
	public AdminHome clickAdminButton(){
		try{
			Base.webApp.officeapp.userHome.userHomeObjects
						.userHomeInsideAdmin().waitToAppear(30).clickElement();
			return Base.webApp.officeapp.adminHome;
		}catch(NoSuchElementException e){
			throw new AssertionError("cannot get userHome admin inside Element, element absent or not visible");
		}
	}
	
	@Override
	public UserHome waitToLoad() {
		try{
			Logger.log.info("Waiting for UserHome activity");
			userHomeObjects.userHomeMenuButton().waitToAppear(30);
			return Base.webApp.officeapp.userHome;
		}catch(AssertionError e){
			throw new AssertionError("User Home activity failed to load/open");
		}
	}
	
}
