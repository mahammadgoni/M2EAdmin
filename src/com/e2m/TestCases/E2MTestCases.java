package com.e2m.TestCases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ClientManagement.Client;
import com.Utils.BrowserSetUp;

public class E2MTestCases extends BrowserSetUp{
	
	
	// Browser Set Up Method
	@BeforeClass
	public void setUp() throws InterruptedException, InvalidFormatException, IOException {

		openBrowser();

	}

	// Browser Close Method
	@AfterClass
	public void tearDown() {

		quitAllBrowser();

	}

	// Logout Method
	@AfterMethod
	public void afterMethod() throws IOException, InvalidFormatException {

		logOut();

		methodSeparation();

	}
	
	@Test (priority = 1,alwaysRun=true)
	public void verifyClientUserListTest() throws InterruptedException, InvalidFormatException, IOException{
		
		 String EmailId = getCellData(1, 5);
			
		 String Password = getCellData(1, 6);
		
		 System.out.println("Executing : Verify Client User List Test");
		 
		 new Client(driver).verifyClientList(EmailId, Password);
		 
		 
	}

}
