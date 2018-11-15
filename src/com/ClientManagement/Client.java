package com.ClientManagement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	
	

}
