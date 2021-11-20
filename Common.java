package utility;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Common {
	
	WebDriver driver;
	String baseurl = "http://localhost/shopping";
	public String emailid;
	public String password;
	
	public void getsite() 
	{
		 System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get(baseurl);
		 driver.manage().window().maximize();
	}
	
	public void login() throws DocumentException
	{
		LoginValidCredentials();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement loginpage = driver.findElement(By.xpath("//li[4]/a[@href='login.php']"));
		loginpage.click();
		WebElement login= driver.findElement(By.name("login"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",login); 
		
		driver.findElement(By.id("exampleInputEmail1")).sendKeys(emailid);
		driver.findElement(By.id("exampleInputPassword1")).sendKeys(password);
		login.click();
	}
	
	public void LoginValidCredentials() throws DocumentException
	{
		File inputFile = new File(System.getProperty("user.dir") + "\\src\\properties.xml");
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(inputFile);
		emailid = document.selectSingleNode("//valid/email").getText().toString();
		password = document.selectSingleNode("//valid/password").getText().toString();
	}
	
	public void closeBrowser()
	{
		driver.quit();
	}
	
}
