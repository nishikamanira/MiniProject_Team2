package com.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.project.base.Common;



public class SearchPage extends Common {

	public static String expectedProduct = "No Product Found";
	
	public WebElement ProductNotFound()
	{
		WebElement noProduct = driver.findElement(By.xpath("//*[@id=\"grid-container\"]/div/div/div/h3"));
		return(noProduct);
	}
	
	public WebElement ProductName()
	{
		WebElement product = driver.findElement(By.xpath("//*[@id=\"grid-container\"]/div/div/div/div/div/div[2]/h3/a"));
		return (product);
	}
	
	
	public WebElement SearchFunctionality()
	{
		WebElement searchBar = driver.findElement(By.xpath("//*[@class='search-field']"));
		return(searchBar);
	}


}
