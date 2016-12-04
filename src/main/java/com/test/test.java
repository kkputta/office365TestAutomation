package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class test {
	public static void main(String[] args){
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		driver.get("https://www.northeastern.edu/graduate/programs/#/master/-/-/-/-/-/-/-/-/-");
		System.out.println(driver.findElement(By.xpath("//*[@id='content']/div[2]/section/div/div/div/ng-include/table/tbody/tr[1]/td[2]/a/h4")).getText());
		driver.quit();
	}
}
