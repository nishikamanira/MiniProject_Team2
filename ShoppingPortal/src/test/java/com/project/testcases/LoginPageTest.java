package com.project.testcases;

import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.project.pages.BooksPage;
import com.project.pages.LoginPage;
import org.testng.annotations.BeforeClass;
import org.dom4j.DocumentException;
import org.testng.annotations.AfterClass;

	public class LoginPageTest {
	
	public Logger log = Logger.getLogger(BooksPage.class.getName());
	
	LoginPage loginObj;
	@Test(priority=1)
	public void loginWithValidCredentials() throws DocumentException, InterruptedException {
		// loginObj.LoginDataCredentials();
		// log.info((loginObj.emailid+loginObj.password));
		loginObj.LoginDataCredentials("valid");
		loginObj.logIn(loginObj.emailId,loginObj.password);	
		String s1=(loginObj.getTitle());
//		loginObj.logIn("nirmal@yahoo.com", "1234");
//		log.info(loginObj.getTitle());

		if(s1!=loginObj.getTitle())
		{
		log.info("login successful");
		loginObj.logOut();
		}
		else
		log.info("Invalid Credentials");
	
	
	}
	@Test(priority=2)
	public void loginWithInvalidUserid() throws DocumentException {
		
//		loginObj.logIn("nirmalyahoo.com", "12345");
		loginObj.LoginDataCredentials("InvalidEmail");
		loginObj.logIn(loginObj.emailId,loginObj.password);	
		if(loginObj.errorMessage().isDisplayed())
		log.info("Invalid UserId");
		else
		loginObj.logOut();
		
		}
		@Test(priority=3)
		public void loginWithInvalidPassword() throws DocumentException {
//		loginObj.logIn("nirmal@yahoo.com", "12345");
			loginObj.LoginDataCredentials("invalidPassword");
			loginObj.logIn(loginObj.emailId,loginObj.password);	
		if(loginObj.errorMessage().isDisplayed())
		log.info("Invalid Password");
		else
		loginObj.logOut();
	
	}
	@Test(priority=4)
	public void loginWithInvalidUseridOrPassword() throws DocumentException {
		
//		loginObj.logIn("nirmal@yahoo.com", "12345");
		loginObj.LoginDataCredentials("InvalidEmailandPassword");
		loginObj.logIn(loginObj.emailId,loginObj.password);	
		if(loginObj.errorMessage().isDisplayed())
		log.info("Invalid Userid or Password");
		else
		loginObj.logOut();
		
		}
		@BeforeClass
		public void beforeClass() {
		loginObj = new LoginPage();
		loginObj.initializeBrowser();
		loginObj.driver.get(loginObj.baseUrl);

	
	}
	
	@AfterClass
	public void afterClass() {
		
		loginObj.closeBrowser();
	
	}
	
	

}