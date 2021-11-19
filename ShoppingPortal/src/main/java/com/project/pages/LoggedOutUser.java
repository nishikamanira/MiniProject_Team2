package com.project.pages;

import static org.testng.Assert.assertEquals;

import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.project.base.Common;

public class LoggedOutUser extends Common
{
     
    public WebElement trackorder;
	public String expectedUrl;
	public String actualUrl;

	public  void getUrl()
	{	
		expectedUrl = "http://localhost/shopping/track-orders.php";
//		http://localhost/shopping/index.php
		actualUrl = driver.getCurrentUrl();
		
	}
	public WebElement findtrack()
	{
		trackorder = driver.findElement(By.xpath("//span[text() = 'Track Order']"));
		return (trackorder);
		
	}
	
}
