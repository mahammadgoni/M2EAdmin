package com.ClientManagement;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.BaseSetup.BaseSetUp;
import com.CommonActions.LoginToAccount;

public class Client extends BaseSetUp{
	
	By clientManagement = By.xpath("//li[@id='top1_menu_CM']//a[@class='menu-item has-submneu']");
	
	By client = By.xpath("//li[@id='top1_menu_CM']/div/ul/li[1]");
	
	By newClient = By.xpath("//a[@id='ContentPlaceHolder1_A1']");
	
	By clientUserList = By.xpath("//a[@id='ContentPlaceHolder1_A2']");
	
	By addClientUser = By.xpath("//a[@id='ContentPlaceHolder1_A1']");
	
	By clientUser1 = By.xpath("//*[@class='BgColorWhite']");
	
	By clientUser2 = By.xpath("//*[@class='BgColorLightGrey']");
	
	By clientNameDropDown = By.xpath("//select[@id='ContentPlaceHolder1_ddlClientName']");
	
	By clientName = By.xpath("//*[@class='BgColorLightGrey']");
	
	By clientUserEmail = By.xpath("//input[@id='ContentPlaceHolder1_txtEmail']");
	
	By saveClientUser = By.xpath("//input[@id='ContentPlaceHolder1_btnSave']");
	
//	Lazy Loading Elements
	
	By footer = By.xpath("//footer[@id='footer']");
	
//	By client = By.xpath("//li[@id='top1_menu_CM']/div/ul/li[1]");
	
	

	public Client(WebDriver driver) {
		super(driver);
		
	}
	
//	Verify Client list Method
	
	public Client verifyClientList(String EmailId,String Password) throws InterruptedException{
		
//		Creating Object for Login Class to call Login Method
		
		LoginToAccount login = new LoginToAccount(driver);
		
//		Login To Account 
		
		login.loginToAccount(EmailId, Password);
		
//		Click On Client Management 
		
		Thread.sleep(5000);
		
		System.out.println("Clicking on Client Management ");
		
		waitForClickabilityOf(clientManagement);
		
		driver.findElement(clientManagement).click();
		
		Thread.sleep(5000);
		
		System.out.println("Clicking on Client ");
		
		waitForClickabilityOf(client);
		
		driver.findElement(client).click();
		
		Thread.sleep(5000);
		
		System.out.println("Clicking on Client User List");
		
		waitForClickabilityOf(clientUserList);
		
		driver.findElement(clientUserList).click();
		
		Thread.sleep(5000);
		
		System.out.println("Verifying Client User List");
		
		List<WebElement> ClientUsers = driver.findElements(clientUser1);
		
		int users = ClientUsers.size();
		
		System.out.println(users);
		
		if (users==19) {
			
			System.out.println("Successfully Verified Client User List");
			
		} else {
			
			System.out.println("Failed to Verify Client User List");

		}
		
		
		
		return new Client(driver);
	}
	
//	Add new Client User Method
	
	public Client addNewClientUser(String EmailId,String Password,String ClientName,String ClientUserEmail) throws InterruptedException{
		
//		Creating Object for Login Class to call Login Method
		
		LoginToAccount login = new LoginToAccount(driver);
		
//		Login To Account 
		
		login.loginToAccount(EmailId, Password);
		
//		Click On Client Management 
		
		Thread.sleep(5000);
		
		System.out.println("Clicking on Client Management ");
		
		waitForClickabilityOf(clientManagement);
		
		driver.findElement(clientManagement).click();
		
		Thread.sleep(5000);
		
		System.out.println("Clicking on Client ");
		
		waitForClickabilityOf(client);
		
		driver.findElement(client).click();
		
		Thread.sleep(5000);
		
		System.out.println("Clicking on Client User List");
		
		waitForClickabilityOf(clientUserList);
		
		driver.findElement(clientUserList).click();
		
		Thread.sleep(5000);
		
		System.out.println("Clicking on Add Client User List");
		
		waitForClickabilityOf(addClientUser);
		
		driver.findElement(addClientUser).click();
		
		Thread.sleep(5000);
		
//		Selecting the Client Name
		
		System.out.println("Selecting the Client As : "+ClientName);
		
		Select dropDown = new Select(driver.findElement(clientNameDropDown));
		
		dropDown.selectByVisibleText(ClientName);
		
		Thread.sleep(5000);
		
		System.out.println("Entering the Email id for this client user "+ClientUserEmail );
		
		waitForClickabilityOf(clientUserEmail);
		
		driver.findElement(clientUserEmail).sendKeys(ClientUserEmail);
		
		Thread.sleep(5000);
		
		System.out.println("Clicking on Save Button to Add Client User");
		
		waitForClickabilityOf(saveClientUser);
		
		driver.findElement(saveClientUser).click();
		
		Thread.sleep(5000);
		
		popUpHandeling();
		
		System.out.println("Succesfully Added  Added Client User");
		
		
		
		
		
		return new Client(driver);
	}
	
//	 Client Admin Lazy Loading Test
	
	public Client clientUserLazyLoading(String EmailId,String Password) throws InterruptedException, AWTException{
		
//		Creating Object for Login Class to call Login Method
		
		LoginToAccount login = new LoginToAccount(driver);
		
//		Login To Account 
		
		login.loginToAccount(EmailId, Password);
		
//		Click On Client Management 
		
		Thread.sleep(5000);
		
		System.out.println("Clicking on Client Management ");
		
		waitForClickabilityOf(clientManagement);
		
		driver.findElement(clientManagement).click();
		
		Thread.sleep(5000);
		
		System.out.println("Clicking on Client ");
		
		waitForClickabilityOf(client);
		
		driver.findElement(client).click();
		
		Thread.sleep(5000);
		
//		scroll Down
		
		scrollDown();
		
		Thread.sleep(5000);
		
//		Change the value of i if needed 
		
		for (int i = 0; i < 10; i++) {
			
			scrollDown();
			
		}
		
		boolean ftr = driver.findElement(footer).isDisplayed();
		
		if (ftr==true) {
			
			System.out.println("Successfully Verified Lazy Loading For Client User List");
			
		} else {
			
			System.out.println("Failed to Verify Lazy Loading Client User List");

		}
		

		
		
		
		
		
		
		return new Client(driver);
	}

}
