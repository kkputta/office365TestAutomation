package com.office365.automation.webapp.office;

import com.office365.automation.core.Base;
import com.office365.automation.core.utils.ElementUtils;
import com.office365.automation.webapp.interfaces.Application;
import com.office365.automation.webapp.office.admin.AdminHome;
import com.office365.automation.webapp.office.admin.AdminSettings;
import com.office365.automation.webapp.office.login.Login;
import com.office365.automation.webapp.office.userhome.UserHome;

public class Office365WebApp implements Application{
		
	public Login login = new Login();
	public UserHome userHome = new UserHome();
	public AdminHome adminHome = new AdminHome();
	public AdminSettings adminSetting = new AdminSettings();
	
	@Override
	public Office365WebApp open() {
		Base.driver.get(ElementUtils.getStartUrl("office365"));
		return Base.webApp.officeapp;
	}
	
}
