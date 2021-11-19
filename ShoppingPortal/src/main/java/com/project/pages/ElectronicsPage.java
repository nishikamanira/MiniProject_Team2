package com.project.pages;

import java.util.concurrent.TimeUnit;

import com.project.base.Common;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElectronicsPage extends Common{
	
	public WebElement elecCatAccess()
	{

		WebElement electronics = driver.findElement(By.xpath("//*[@id=\"mc-horizontal-menu-collapse\"]/div/ul/li[3]/a"));
		js.executeScript("arguments[0].setAttribute('style', 'background: black; border: 2px solid red;');", electronics);
		return(electronics);

	}
	
	
	public WebElement elecMobilesAccess()
	{
		WebElement elecMobiles = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[1]/div/nav/ul/li/a[3]"));
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", elecMobiles);
//		Thread.sleep(1000);
		return(elecMobiles);

	}
	
	
	public WebElement prodImagePresent()
	{
		js.executeScript("window.scrollBy(0,450)", "");
//		Thread.sleep(2000);
		
		WebElement mobileImage = driver.findElement(By.xpath("//*[@id=\"grid-container\"]/div/div/div[2]/div/div/div[1]/div/a/img"));
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", mobileImage);
        return(mobileImage);
		
	}
	
	public void addToWishlist()
	{		
		WebElement addWishlist = driver.findElement(By.xpath("//*[@id=\"grid-container\"]/div/div/div[2]/div/div/div[3]/div/ul/li[2]/a/i"));
//		WebElement addWishlist = driver.findElement(By.id("grid-container"));
		js.executeScript("arguments[0].setAttribute('style', 'background: black; border: 2px solid red;');", addWishlist);
//		Thread.sleep(1000);
		addWishlist.click();


	}
	
	public void closeBrowser()
	{
		driver.quit();
	}

}
