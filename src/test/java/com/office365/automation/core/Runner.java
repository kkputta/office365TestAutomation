package com.office365.automation.core;

import com.office365.automation.core.manager.DriverManager;


public class Runner {
	public static void main(String[] args) throws InterruptedException {
		DriverManager.CreateDriver("chrome").maximizeWindow().setImplicitWait(30);
		Base.webApp.officeapp.open()
				.login.loadUsername()
				.loadPassword()
				.clickSignIn()
				.clickMenuButton()
				.clickAdminButton()
				.clickOldAdmin()
				.clickUserTree()
				//.clickActiveUsers()
				//.clickAddActiveUser()
				//.loadAddUser()
				//.deleteAddUser()
				.clickDeletedUsers()
				.restoreDeletedAddUser()
				.clickActiveUsers()
				.signOut();
				
		
		DriverManager.killDriver();
		
	}
}
