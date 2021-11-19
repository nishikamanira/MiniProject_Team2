package com.project.pages;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.project.base.Common;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CartHomePage extends Common{
	
	WebElement cartValue;
	WebElement dropDown;
	WebElement cartColor;


	public String addToCart()
	{
		WebElement books = driver.findElement(By.xpath("//*[@id=\"mc-horizontal-menu-collapse\"]/div/ul/li[2]/a"));
		js.executeScript("arguments[0].setAttribute('style', 'background: black; border: 2px solid red;');", books);
		books.click();
		
		WebElement booksComic = driver.findElement(By.xpath("//html/body/div[1]/div/div[1]/div[1]/div[1]/div/nav/ul/li/a"));
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", booksComic);
		booksComic.click();
	
		WebElement bookCart = driver.findElement(By.xpath("//*[@id=\"grid-container\"]/div/div/div[1]/div/div/div[3]/div/ul/li[1]/a/button"));
		js.executeScript("window.scrollBy(0,450)", "");
		js.executeScript("arguments[0].setAttribute('style', 'background: black; border: 2px solid red;');", bookCart);
		bookCart.click();

        Alert alert = driver.switchTo().alert();		    
        String alertMessage= driver.switchTo().alert().getText();
        alert.accept();
        return(alertMessage);

	}


	public WebElement myCartValue()
	{
		cartValue = driver.findElement(By.xpath("/html/body/header/div[2]/div/div/div[3]/div/a/div/div[1]/span[2]/span[2]"));
		js.executeScript("arguments[0].setAttribute('style', 'background: black; border: 2px solid red;');", cartValue);
		return(cartValue);
		
	}
	
	public WebElement dropDownDisplayed()
	{
		dropDown = driver.findElement(By. xpath("/html/body/header/div[2]/div/div/div[3]/div/ul"));
		return(dropDown);			
	}
	
	public String myCartOldColour()
	{	
		cartColor = driver.findElement(By.xpath("/html/body/header/div[2]/div/div/div[3]/div/ul/li/div[3]/a"));
		String s = cartColor.getCssValue("background-color");
		return (s);
	}
	
	public String myCartNewColour() 
	{
		cartColor = driver.findElement(By.xpath("/html/body/header/div[2]/div/div/div[3]/div/ul/li/div[3]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(cartColor).perform();	
		String s = cartColor.getCssValue("background-color");
		return (s);
		
	}
	
	
	public void closeBrowser()
	{
		driver.quit();
	}
	
	
	
}
