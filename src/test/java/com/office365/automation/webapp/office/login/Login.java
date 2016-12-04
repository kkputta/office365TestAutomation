package com.office365.automation.webapp.office.login;

import org.openqa.selenium.NoSuchElementException;

import com.office365.automation.core.Base;
import com.office365.automation.core.log.Logger;
import com.office365.automation.core.utils.ElementUtils;
import com.office365.automation.webapp.interfaces.Activity;
import com.office365.automation.webapp.office.userhome.UserHome;


public class Login implements Activity{
	
	public LoginObjects loginObject = new LoginObjects();

	public Login loadUsername(){
		try{
			Base.webApp.officeapp.login.loginObject
				.loginUsername().clearText().typeText(ElementUtils.loadElementData().getProperty("loginPageUsername"));
			return Base.webApp.officeapp.login;
		}catch(NoSuchElementException e){
			throw new AssertionError("cannot get login username Element, element absent or not visible");
		}
	}
	
	public Login loadPassword(){
		try{
			Base.webApp.officeapp.login.loginObject
				.loginPassword().typeText(ElementUtils.loadElementData().getProperty("loginPagePassword"));
			return Base.webApp.officeapp.login;
		}catch(NoSuchElementException e){
			throw new AssertionError("cannot get login password Element, element absent or not visible");
		}
	}
	
	public UserHome clickSignIn() throws InterruptedException{
		try{
			
			Base.webApp.officeapp.login.loginObject.loginSignin().waitToElementClickable(10).clickElement();
			return Base.webApp.officeapp.userHome;
		}catch(NoSuchElementException e){
			throw new AssertionError("cannot get login sign Element, element absent or not visible");
		}
	}
	
	@Override
	public Login waitToLoad() {
		try{
			Logger.log.info("Waiting for login activity");
			loginObject.loginSignin().waitToAppear(30);
			return Base.webApp.officeapp.login;
		}catch(AssertionError e){
			throw new AssertionError("Login activity failed to load/open");
		}
	}
}
