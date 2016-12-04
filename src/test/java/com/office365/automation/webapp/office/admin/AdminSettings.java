package com.office365.automation.webapp.office.admin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.office365.automation.core.Base;
import com.office365.automation.core.log.Logger;
import com.office365.automation.webapp.interfaces.Activity;

public class AdminSettings implements Activity {
	
	public AdminSettingsObjects adminSettingObject = new AdminSettingsObjects();

	public AdminSettings clickUserTree(){
		try{
			Base.webApp.officeapp.adminSetting.adminSettingObject
					.adminSettingsUsersTree().clickElement();
			return Base.webApp.officeapp.adminSetting;
		}catch(NoSuchElementException e){
			throw new AssertionError("Admin user tree element cannot load.");
		}
	}
	
	public AdminSettings clickActiveUsers(){
		try{
			
			Base.webApp.officeapp.adminSetting.adminSettingObject
							.adminSettingsActiveUsers().waitToAppear(30).clickElement();
			Base.webApp.officeapp.adminSetting.adminSettingObject
			.adminSettingsActiveUsers().waitTo(6);
			return Base.webApp.officeapp.adminSetting;
		}catch(NoSuchElementException e){
			throw new AssertionError("Admin Active users element cannot load.");
		}
	}
	
	public AdminSettings clickDeletedUsers(){
		try{
			
			Base.webApp.officeapp.adminSetting.adminSettingObject
							.adminSettingsDeletedUsers().waitToAppear(30).clickElement();
			Base.webApp.officeapp.adminSetting.adminSettingObject
			.adminSettingsDeletedUsers().waitTo(5);
			return Base.webApp.officeapp.adminSetting;
		}catch(NoSuchElementException e){
			throw new AssertionError("Admin Deleted users element cannot load.");
		}
	}
	
	public AdminSettings clickAddActiveUser() throws InterruptedException{
		
		try{
			
		    WebElement frameElement=null;
			List<WebElement> elements = Base.driver.findElements(By.tagName("iframe"));
		    
			for(WebElement ele:elements){
		    	 if(ele.getAttribute("src").contains("/UserManagement/ActiveUsers.aspx?embedded=1")){
		    		 frameElement = ele;
		    	 }
		     }
		    
			Base.driver.switchTo().frame(frameElement);
			Base.webApp.officeapp.adminSetting.adminSettingObject
							.adminSettingsAddActiverUserImg().waitToAppear(30).clickElement();
			Base.driver.switchTo().defaultContent();
			return Base.webApp.officeapp.adminSetting;
		}catch(NoSuchElementException e){
			throw new AssertionError("Admin add active users element cannot load.");
		}
	}
	
	public AdminSettings loadAddUser() throws InterruptedException{
		try{
			Base.driver.switchTo().frame("PopupIFrame");
			
			Base.webApp.officeapp.adminSetting.adminSettingObject.addUserFirstname().typeText("kanti");
			Base.webApp.officeapp.adminSetting.adminSettingObject.addUserLastname().typeText("pind");
			Base.webApp.officeapp.adminSetting.adminSettingObject.addUserDisplayname().typeText("k pind");
			Base.webApp.officeapp.adminSetting.adminSettingObject.addUserUsername().typeText("k pind");
			Base.webApp.officeapp.adminSetting.adminSettingObject.addUserCreateButton().clickElement();
			
			/*
			Base.driver.findElement(By.id("wizardFormSheet_contentContainer_step1_txtFirstName")).sendKeys("kanti");
			Base.driver.findElement(By.id("wizardFormSheet_contentContainer_step1_txtLastName")).sendKeys("pind");
			Base.driver.findElement(By.id("wizardFormSheet_contentContainer_step1_txtDisplayName")).sendKeys("k pind");
			Base.driver.findElement(By.id("wizardFormSheet_contentContainer_step1_txtUserName")).sendKeys("pind");
			Base.driver.findElement(By.id("ButtonsPanel_btnCommit")).click();
			*/
			
			Base.webApp.officeapp.adminSetting.adminSettingObject.addUserCloseButton().waitToElementClickable(40).clickElement();
			
			/*
			WebDriverWait wait = new WebDriverWait(Base.driver,40);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("ButtonsPanel_btnCancel"))).click();
			*/			
		    
			Base.driver.switchTo().defaultContent();
			//Thread.sleep(2000);
		    return Base.webApp.officeapp.adminSetting;
		}catch(NoSuchElementException e){
			
			e.printStackTrace();
			throw new AssertionError("Adminsettings add user method cannot load.");
		}
	}
	
	public AdminSettings deleteAddUser(){
		try{
			
			Base.driver.switchTo().defaultContent();
			Thread.sleep(2000);
			
			WebElement frameElement=null;
			List<WebElement> frameElements = Base.driver.findElements(By.tagName("iframe"));
		    for(WebElement ele:frameElements){
		    	 if(ele.getAttribute("src").contains("/UserManagement/ActiveUsers.aspx?embedded=1")){
		    		 frameElement = ele;
		    	 }
		    	 System.out.println("frame elements = "+ele.getTagName()+" : "+ele.getAttribute("id")+" : "+ele.getAttribute("src"));
		     }
		    
		    Base.driver.switchTo().frame(frameElement);
		    
		    WebElement tdElement = null;
		    
		    List<WebElement> tdElements = Base.driver.findElements(By.tagName("td"));
		    for(WebElement ele:tdElements){
		    	if(ele.getAttribute("title").equalsIgnoreCase("pind@gdtest05.onmicrosoft.com")){
		    		System.out.println("td elements = "+ele.getTagName()+" : "+ele.getAttribute("id")+" : "+ele.getAttribute("title"));
		    		tdElement = ele;
		    	}
		    }
		    tdElement.click();
		    
		    Base.driver.switchTo().frame("DetailPane_detailsFrame");
		    
		    Base.webApp.officeapp.adminSetting.adminSettingObject.deleteUserButton().clickElement();
		    
		    Base.driver.switchTo().defaultContent();
		    		   
		    List<WebElement> frame = Base.driver.findElements(By.tagName("iframe"));
		    for(WebElement ele:frame){
		    	 System.out.println("frame size"+frame.size());
		    	 System.out.println("frame elements = "+ele.getTagName()+" : "+ele.getAttribute("id")+" : "+ele.getAttribute("src"));
		     }
		    
		    
		    if(Base.driver.getClass().getName().equals("org.openqa.selenium.chrome.ChromeDriver")){
		    	Base.driver.switchTo().frame(2);
			}else{
				Base.driver.switchTo().frame(0);
			}
		    
		    //WebDriverWait wait = new WebDriverWait(Base.driver,40);
		    //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='remove-button']/span"))).click();
		    
		    Base.webApp.officeapp.adminSetting.adminSettingObject.deleteUserRemoveButton().waitToElementClickable(40)
		    												.clickElement();
		    
		    Base.driver.switchTo().defaultContent();
		    
		    if(Base.driver.getClass().getName().equals("org.openqa.selenium.chrome.ChromeDriver")){
		    	Base.driver.switchTo().frame(2);
			}else{
				Base.driver.switchTo().frame(0);
			}
		    
		    
			//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='delete-close-button']/span"))).click();
			
		    Base.webApp.officeapp.adminSetting.adminSettingObject.deleteUserCloseButton().waitToElementClickable(40)
															.clickElement();
		    
		    Base.driver.switchTo().defaultContent();
		    		    
		    return Base.webApp.officeapp.adminSetting;
		}catch(Exception e){
			e.printStackTrace();
			throw new AssertionError("Adminsettings delete user method cannot load.");
		}
	}
	
	public AdminSettings restoreDeletedAddUser(){
		
		try{
			
			WebElement frameElement=null;
			List<WebElement> frameElements = Base.driver.findElements(By.tagName("iframe"));
		    for(WebElement ele:frameElements){
		    	 if(ele.getAttribute("src").contains("EAdmin/User/DeletedUsers16.aspx?embedded=1")){
		    		 frameElement = ele;
		    	 }
		    	 System.out.println("frame elements = "+ele.getTagName()+" : "+ele.getAttribute("id")+" : "+ele.getAttribute("src"));
		     }
		    
		    Base.driver.switchTo().frame(frameElement);
		    
		    Base.webApp.officeapp.adminSetting.adminSettingObject.restoreUserSearchButton().waitToElementClickable(40)
		    												.clickElement();
		    Base.webApp.officeapp.adminSetting.adminSettingObject.restoreUserSearchBox().typeText("pind")
		    												.sendKeysToElement(Keys.ENTER);
		    
		    /*WebDriverWait wait = new WebDriverWait(Base.driver,40);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("EAdminDeletedUsersListView_ToolBar_MoveToToolbar"))).click();
		    
		    Base.driver.findElement(By.id("EAdminDeletedUsersListView_SearchBox")).sendKeys("pind");
		    Base.driver.findElement(By.id("EAdminDeletedUsersListView_SearchBox")).sendKeys(Keys.ENTER);*/
		    
		    Base.driver.switchTo().defaultContent();
		    //Thread.sleep(2000);
		    WebElement deleteframe=null;
			List<WebElement> deleteframeElements = Base.driver.findElements(By.tagName("iframe"));
		    for(WebElement ele:deleteframeElements){
		    	 if(ele.getAttribute("src").contains("EAdmin/User/DeletedUsers16.aspx?embedded=1")){
		    		 deleteframe = ele;
		    	 }
		    	 System.out.println("frame elements = "+ele.getTagName()+" : "+ele.getAttribute("id")+" : "+ele.getAttribute("src"));
		     }
		    
		    Base.driver.switchTo().frame(deleteframe);
		   
		    //Thread.sleep(2000);
		    
		    WebElement tdElement = null;
		    
		    List<WebElement> tdElements = Base.driver.findElements(By.tagName("td"));
		    for(WebElement ele:tdElements){
		    	if(ele.getAttribute("title").equalsIgnoreCase("pind@gdtest05.onmicrosoft.com")){
		    		System.out.println("td elements = "+ele.getTagName()+" : "+ele.getAttribute("id")+" : "+ele.getAttribute("title"));
		    		tdElement = ele;
		    	}
		    }
		    
		    tdElement.click();
		    
		    Base.driver.switchTo().frame("DetailPane_detailsFrame");
		    Base.driver.findElement(By.id("ViewDeletedUsers_contentContainer_lnkRestoreDeletedUser")).click();
		    Base.driver.switchTo().defaultContent();
		    Thread.sleep(10000);
		    Base.driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);
		    return Base.webApp.officeapp.adminSetting;
		}catch(Exception e){
			e.printStackTrace();
			throw new AssertionError("Adminsettings delete user method cannot load.");
		}
	}
	
	public void signOut() throws InterruptedException{
		
		Base.webApp.officeapp.adminSetting.adminSettingObject.signOutUserMenuButton().clickElement();
		//Base.driver.findElement(By.xpath("//*[@id='O365_TopMenu']//button[contains(@aria-label,'Use the down arrow to use the Me Control pane')]")).click();
	    //Thread.sleep(2000);
	    Base.webApp.officeapp.adminSetting.adminSettingObject.signOutUserSignOutLink().waitToElementClickable(30).clickElement();
		//Base.driver.findElement(By.id("O365_SubLink_ShellSignout")).click();
	}
	
	@Override
	public AdminSettings waitToLoad() {
		try{
			Logger.log.info("Waiting for Admin settings activity");
			adminSettingObject.adminSettingsUsersTree().waitToAppear(30);
			return Base.webApp.officeapp.adminSetting;
		}catch(AssertionError e){
			throw new AssertionError("User Home activity failed to load/open");
		}
	}
	
}
