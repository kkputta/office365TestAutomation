package com.office365.automation.webapp.office.admin;

import com.office365.automation.core.ElementObject;
import com.office365.automation.core.ElementSelector;

public class AdminSettingsObjects {
	public static ElementObject
			adminSettingsUsersTree,
			adminSettingsActiveUsers,
			adminSettingsDeletedUsers,
			adminSettingsAddActiverUserImg,
			addUserFirstname,
			addUserLastname,
			addUserDisplayname,
			addUserUsername,
			addUserCreateButton,
			addUserCloseButton,
			deleteUserButton,
			deleteUserRemoveButton,
			deleteUserCloseButton,
			restoreUserSearchButton,
			restoreUserSearchBox,
			signOutUserMenuButton,
			signOutUserSignOutLink;
	
	public ElementObject signOutUserSignOutLink(){
		if(signOutUserSignOutLink==null){
			signOutUserSignOutLink = new ElementSelector().makeLocator("signOutUserSignOutLink.id").makeElementObject();
		}
		return signOutUserSignOutLink;
	}
	
	public ElementObject signOutUserMenuButton(){
		if(signOutUserMenuButton==null){
			signOutUserMenuButton = new ElementSelector().makeLocator("signOutUserMenuButton.xpath").makeElementObject();
		}
		return signOutUserMenuButton;
	}
	
	public ElementObject restoreUserSearchBox(){
		if(restoreUserSearchBox==null){
			restoreUserSearchBox = new ElementSelector().makeLocator("restoreUserSearchBox.id").makeElementObject();
		}
		return restoreUserSearchBox;
	}
	
	public ElementObject restoreUserSearchButton(){
		if(restoreUserSearchButton==null){
			restoreUserSearchButton = new ElementSelector().makeLocator("restoreUserSearchButton.id").makeElementObject();
		}
		return restoreUserSearchButton;
	}
	
	public ElementObject deleteUserCloseButton(){
		if(deleteUserCloseButton==null){
			deleteUserCloseButton = new ElementSelector().makeLocator("deleteUserCloseButton.xpath").makeElementObject();
		}
		return deleteUserCloseButton;
	}
	
	public ElementObject deleteUserRemoveButton(){
		if(deleteUserRemoveButton==null){
			deleteUserRemoveButton = new ElementSelector().makeLocator("deleteUserRemoveButton.xpath").makeElementObject();
		}
		return deleteUserRemoveButton;
	}
	
	public ElementObject deleteUserButton(){
		if(deleteUserButton==null){
			deleteUserButton = new ElementSelector().makeLocator("deleteUserButton.id").makeElementObject();
		}
		return deleteUserButton;
	}
	
	public ElementObject addUserCloseButton(){
		if(addUserCloseButton==null){
			addUserCloseButton = new ElementSelector().makeLocator("addUserCloseButton.id").makeElementObject();
		}
		return addUserCloseButton;
	}
	
	public ElementObject addUserCreateButton(){
		if(addUserCreateButton==null){
			addUserCreateButton = new ElementSelector().makeLocator("addUserCreateButton.id").makeElementObject();
		}
		return addUserCreateButton;
	}
	
	public ElementObject addUserUsername(){
		if(addUserUsername==null){
			addUserUsername = new ElementSelector().makeLocator("addUserUsername.id").makeElementObject();
		}
		return addUserUsername;
	}
	
	public ElementObject addUserDisplayname(){
		if(addUserDisplayname==null){
			addUserDisplayname = new ElementSelector().makeLocator("addUserDisplayname.id").makeElementObject();
		}
		return addUserDisplayname;
	}
	
	public ElementObject addUserLastname(){
		if(addUserLastname==null){
			addUserLastname = new ElementSelector().makeLocator("addUserLastname.id").makeElementObject();
		}
		return addUserLastname;
	}
	
	public ElementObject addUserFirstname(){
		if(addUserFirstname==null){
			addUserFirstname = new ElementSelector().makeLocator("addUserFirstname.id").makeElementObject();
		}
		return adminSettingsUsersTree;
	}
	
	public ElementObject adminSettingsUsersTree(){
		if(adminSettingsUsersTree==null){
			adminSettingsUsersTree = new ElementSelector().makeLocator("adminSettingsUsersTree.xpath").makeElementObject();
		}
		return adminSettingsUsersTree;
	}
	
	public ElementObject adminSettingsActiveUsers(){
		if(adminSettingsActiveUsers==null){
			adminSettingsActiveUsers = new ElementSelector().makeLocator("adminSettingsActiveUsers.xpath").makeElementObject();
		}
		return adminSettingsActiveUsers;
	}
	
	public ElementObject adminSettingsDeletedUsers(){
		if(adminSettingsDeletedUsers==null){
			adminSettingsDeletedUsers = new ElementSelector().makeLocator("adminSettingsDeletedUsers.xpath").makeElementObject();
		}
		return adminSettingsDeletedUsers;
	}
	
	public ElementObject adminSettingsAddActiverUserImg(){
		if(adminSettingsAddActiverUserImg==null){
			adminSettingsAddActiverUserImg = new ElementSelector().makeLocator("adminSettingsAddActiverUserImg.id").makeElementObject();
		}
		return adminSettingsAddActiverUserImg;
	}
}
