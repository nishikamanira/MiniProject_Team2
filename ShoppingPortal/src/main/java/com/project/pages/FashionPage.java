package com.project.pages;

import com.project.base.Common;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FashionPage extends Common
	{
	
	WebElement fashion;
	WebElement fashionFootwear;
	WebElement productRating;
	WebElement productMrp;
	

		public WebElement fashionCatAccess()
		{
			fashion = driver.findElement(By.xpath("//*[@id=\"mc-horizontal-menu-collapse\"]/div/ul/li[2]/a"));
			js.executeScript("arguments[0].setAttribute('style', 'background: black; border: 2px solid red;');",fashion);
			return(fashion);

		}
		
		public WebElement fashionFootwearAccess()
		{
			fashionFootwear = driver.findElement(By.cssSelector(".sidebar .side-menu nav .nav >li a"));
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", fashionFootwear);	
			return(fashionFootwear);
		}
		
		public WebElement checkProductRating()
		{
			productRating = driver.findElement(By.id("rateit-range-2"));
			js.executeScript("window.scrollBy(0,450)", "");
			js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", productRating);
			return(productRating);
		}
		
		public WebElement checkMrp()
		{
			productMrp = driver.findElement(By.xpath("//*[@id=\"grid-container\"]/div/div/div[1]/div/div/div[2]/div[3]/span[2]"));
			js.executeScript("arguments[0].setAttribute('style', 'background: black; border: 2px solid red;');", productMrp);
			return(productMrp);
			
		}

		public void closeBrowser()
		{
			driver.quit();
		}

}
