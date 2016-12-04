package com.office365.automation.webapp.office.admin;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;

import com.office365.automation.core.Base;
import com.office365.automation.core.log.Logger;
import com.office365.automation.webapp.interfaces.Activity;

public class AdminHome implements Activity{
	public AdminHomeObjects adminHomeObject = new AdminHomeObjects();
	
	public AdminSettings clickOldAdmin(){
		try{
			Base.webApp.officeapp.adminHome.adminHomeObject
			.adminHomeGoToOldAdmin().waitTo(5).sendKeysToElement(Keys.ESCAPE);
			Base.webApp.officeapp.adminHome.adminHomeObject
						.adminHomeGoToOldAdmin().clickElement();
			return Base.webApp.officeapp.adminSetting;
		}catch(NoSuchElementException e){
			throw new AssertionError("cannot get old admin click element could not load.");
		}
	}
	@Override
	public AdminHome waitToLoad() {
		try{
			Logger.log.info("Waiting for Admin Home activity");
			adminHomeObject.adminHomeGoToOldAdmin().waitToAppear(30);
			return Base.webApp.officeapp.adminHome;
		}catch(AssertionError e){
			throw new AssertionError("Admin Home activity failed to load/open");
		}
	}
	
}
