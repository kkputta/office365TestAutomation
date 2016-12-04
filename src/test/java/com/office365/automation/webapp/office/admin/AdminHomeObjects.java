package com.office365.automation.webapp.office.admin;

import com.office365.automation.core.ElementObject;
import com.office365.automation.core.ElementSelector;

public class AdminHomeObjects {
	public static ElementObject
			adminHomeGoToOldAdmin,
			adminPopupEscape;
	
	public ElementObject adminHomeGoToOldAdmin(){
		if(adminHomeGoToOldAdmin==null){
			adminHomeGoToOldAdmin = new ElementSelector().makeLocator("adminHomeGoToOldAdmin.id").makeElementObject();
		}
		return adminHomeGoToOldAdmin;
	}
	
}
