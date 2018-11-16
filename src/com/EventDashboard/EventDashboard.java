package com.EventDashboard;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.BaseSetup.BaseSetUp;
import com.CommonActions.LoginToAccount;

public class EventDashboard extends BaseSetUp{
	
	By eventDashboard = By.xpath("//li[@id='ED']//a[@class='menu-item']");
	
	By downloadReport = By.xpath("//a[@id='ContentPlaceHolder1_A1']");
	
	By downloadReport1 = By.xpath("//input[@id='lnkUserLoggedIn']");
	
	By dR1Savebtn = By.xpath("//input[@id='ContentPlaceHolder1_btnUserLoggedInEventwise']");
	
	By downloadReport2 = By.xpath("//input[@id='lnkUserMapping']");
	
	By dR2Savebtn = By.xpath("//input[@id='ContentPlaceHolder1_btnUserMapping']");
	
	By downloadReport3 = By.xpath("//input[@id='lnkUserMappingDetailed']");
	
	By dR3Savebtn = By.xpath("//input[@id='ContentPlaceHolder1_btnUserMappingDetailed']");
	
	By downloadReport4 = By.xpath("//input[@id='lnkmappedvsloggedIn']");
	
	By dR4Savebtn = By.xpath("//input[@id='ContentPlaceHolder1_btnMappedVsLoggedIn']");
	
	By downloadReport5 = By.xpath("//input[@id='ContentPlaceHolder1_btnDataTamplate']");
	
	By downloadReport6 = By.xpath("//input[@id='ContentPlaceHolder1_Button1']");
	
	By clientNameDropDown = By.xpath("//select[@id='ContentPlaceHolder1_ddlClient']");
	

	

	
	

	public EventDashboard(WebDriver driver) {
		super(driver);
		
	}
	
//	Event Dashboard
	
	public EventDashboard verifyDownloadReport(String EmailId,String Password,String ClientName) throws InterruptedException, AWTException{
		
//		Creating Object for Login Class to call Login Method
		
		LoginToAccount login = new LoginToAccount(driver);
		
//		Login To Account 
		
		login.loginToAccount(EmailId, Password);
		
//		Click On Client Management 
		
		Thread.sleep(5000);
		
		System.out.println("Clicking on Client Management ");
		
		waitForClickabilityOf(eventDashboard);
		
		driver.findElement(eventDashboard).click();
		
		Thread.sleep(5000);
		
//		scroll Down
		
		scrollDown();
		
		Thread.sleep(5000);
		
		System.out.println("Clicking on Download Report ");
		
		waitForClickabilityOf(downloadReport);
		
		driver.findElement(downloadReport).click();
		
		Thread.sleep(5000);
		
//		Selecting the Client Name
		
		System.out.println("Selecting the Client As : "+ClientName);
		
		Select dropDown = new Select(driver.findElement(clientNameDropDown));
		
		dropDown.selectByVisibleText(ClientName);
		
		Thread.sleep(5000);
		
		System.out.println("Clicking on Eventwise User Logged in Report");
		
		waitForClickabilityOf(downloadReport1);
		
		driver.findElement(downloadReport1).click();
		
		Thread.sleep(5000);
		
		System.out.println("Clicking on Save Button");
		
		waitForClickabilityOf(dR1Savebtn);
		
		driver.findElement(dR1Savebtn).click();
		
		Thread.sleep(5000);
		
		System.out.println("Clicking on Eventwise User Mapping Report");
		
		waitForClickabilityOf(downloadReport2);
		
		driver.findElement(downloadReport2).click();
		
		Thread.sleep(5000);
		
		System.out.println("Clicking on Save Button");
		
		waitForClickabilityOf(dR2Savebtn);
		
		driver.findElement(dR2Savebtn).click();
		
		Thread.sleep(5000);
		
		System.out.println("Clicking on Eventwise User Mapping Detailed Report");
		
		waitForClickabilityOf(downloadReport3);
		
		driver.findElement(downloadReport3).click();
		
		Thread.sleep(5000);
		
		System.out.println("Clicking on Save Button");
		
		waitForClickabilityOf(dR3Savebtn);
		
		driver.findElement(dR3Savebtn).click();
		
		Thread.sleep(5000);
		
		System.out.println("Clicking on Eventwise User Mapped Vs User Logged In report");
		
		waitForClickabilityOf(downloadReport4);
		
		driver.findElement(downloadReport4).click();
		
		Thread.sleep(5000);
		
		System.out.println("Clicking on Save Button");
		
		waitForClickabilityOf(dR4Savebtn);
		
		driver.findElement(dR4Savebtn).click();
		
		Thread.sleep(5000);
		
		System.out.println("Clicking on System Users report");
		
		waitForClickabilityOf(downloadReport5);
		
		driver.findElement(downloadReport5).click();
		
		try {
			
			popUpHandeling();
			
		} catch (Exception e) {
			
		}
				
		Thread.sleep(5000);
		
		System.out.println("Clicking on Events report");
		
		waitForClickabilityOf(downloadReport6);
		
		driver.findElement(downloadReport6).click();
		
		try {
			
			popUpHandeling();
			
		} catch (Exception e) {
			
		}
		
		System.out.println("Successfully Download the Reports");
		
		
		
		return new EventDashboard(driver);
	}

}
