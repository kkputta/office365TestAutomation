package com.office365.automation.webapp.office.login;

import com.office365.automation.core.ElementObject;
import com.office365.automation.core.ElementSelector;

public class LoginObjects {
	
	private static ElementObject
					loginUsername,
					loginPassword,
					loginRemember,
					loginSignin;
	public ElementObject loginUsername(){
		if (loginUsername==null){
			loginUsername = new ElementSelector().makeLocator("loginPageUsername.id").makeElementObject();
		}
		return loginUsername;
	}
	
	public ElementObject loginPassword(){
		if (loginPassword==null){
			loginPassword = new ElementSelector().makeLocator("loginPagePassword.id").makeElementObject();
		}
		return loginPassword;
	}
	
	public ElementObject loginRemember(){
		if (loginRemember==null){
			loginRemember = new ElementSelector().makeLocator("loginPageRemember.id").makeElementObject();
		}
		return loginRemember;
	}
	
	public ElementObject loginSignin(){
		if (loginSignin==null){
			loginSignin = new ElementSelector().makeLocator("loginPageSignin.id").makeElementObject();
		}
		return loginSignin;
	}
}
