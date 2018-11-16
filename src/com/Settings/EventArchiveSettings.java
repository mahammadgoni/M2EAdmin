package com.Settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.BaseSetup.BaseSetUp;
import com.CommonActions.LoginToAccount;

public class EventArchiveSettings extends BaseSetUp{
	
//	Event Archive Elements
	
	By settings = By.xpath("//li[@id='ET']//a[@class='menu-item has-submneu']");
	
	By eventArchive = By.xpath("//a[@class='ChangeArrow'][contains(text(),'Event Archive Settings')]");
	
	By selectClientDD = By.xpath("//select[@id='ContentPlaceHolder1_ddlClient']");
	
	By enableEventArchiveYesBtn = By.xpath("//*[@id='ContentPlaceHolder1_rblEventArchive_0']");
	
	By dateTextBox = By.xpath("//*[@id='txtNumber']");
	
	By archiveSaveBtn = By.xpath("//*[@id='ContentPlaceHolder1_btnSave']");
	
	

	public EventArchiveSettings(WebDriver driver) {
		super(driver);
		
	}
	
//	Event Archive Method
	
	public EventArchiveSettings verifyEventArchive(String EmailId,String Password,String ClientName,String Date) throws InterruptedException{
		
//		Creating Object for Login Class to call Login Method
		
		LoginToAccount login = new LoginToAccount(driver);
		
//		Login To Account 
		
		login.loginToAccount(EmailId, Password);
		
		Thread.sleep(5000);
		
		System.out.println("Clicking On Settings Menu");
		
		waitForClickabilityOf(settings);
		
		driver.findElement(settings).click();
		
		Thread.sleep(5000);
		
		System.out.println("Clicking On Event Archive Settings");
		
		waitForClickabilityOf(eventArchive);
		
		driver.findElement(eventArchive).click();
		
		Thread.sleep(5000);
		
		System.out.println("Selecting Client from Drop Down");
		
		waitForClickabilityOf(selectClientDD);
		
		Thread.sleep(5000);
		
//		Selecting Client form Drop Down
		
		Select dropDown = new Select(driver.findElement(selectClientDD));
		
		dropDown.selectByVisibleText(ClientName);
		
		Thread.sleep(5000);
		
//		Checking If Yes Button is selected or not
		
		boolean yesBtn = driver.findElement(enableEventArchiveYesBtn).isSelected();
		
		System.out.println(yesBtn);
		
		if (yesBtn==false) {
			
			System.out.println("Clicking On Event Archive Settings Yes Button");
			
			waitForClickabilityOf(enableEventArchiveYesBtn);
			
			driver.findElement(enableEventArchiveYesBtn).click();
			
		} else {
			
			System.out.println("Yes Button is already Selected");

		}
		
		Thread.sleep(5000);
		
		System.out.println("Entering Date to the Text Box");
		
		waitForClickabilityOf(dateTextBox);
		
		driver.findElement(dateTextBox).clear();
		
		driver.findElement(dateTextBox).sendKeys(Date);
		
		Thread.sleep(5000);
		
		System.out.println("Clicking On Save Button");
		
		waitForClickabilityOf(archiveSaveBtn);
		
		driver.findElement(archiveSaveBtn).click();
		
		Thread.sleep(5000);
		
		try {
			
			popUpHandeling();
			
		} catch (Exception e) {
			
		}
		

		
		System.out.println("Successfully Saved the Archive Settings");
		
		
		
		
		
		return new EventArchiveSettings(driver);
		
		
	}
	
	

}
