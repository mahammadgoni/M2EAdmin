package com.e2m.TestCases;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ClientManagement.Client;
import com.EventDashboard.EventDashboard;
import com.Settings.EventArchiveSettings;
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
	
//	@Test (priority = 1,alwaysRun=true)
//	public void verifyClientUserListTest() throws InterruptedException, InvalidFormatException, IOException{
//		
//		 String EmailId = getCellData(1, 5);
//			
//		 String Password = getCellData(1, 6);
//		
//		 System.out.println("Executing : Verify Client User List Test");
//		 
//		 new Client(driver).verifyClientList(EmailId, Password);
//		 
//		 
//	}
//	
//	@Test (priority = 2,alwaysRun=true)
//	public void addClientUserTest() throws InterruptedException, InvalidFormatException, IOException{
//		
//		 String EmailId = getCellData(1, 5);
//			
//		 String Password = getCellData(1, 6);
//		 
//		 String ClienName = getCellData(1, 7);
//		 
//		 String ClienUserEmail = getCellData(1, 8);
//		
//		 System.out.println("Executing : Add Client User Test");
//		 
//		 new Client(driver).addNewClientUser(EmailId, Password, ClienName, ClienUserEmail);
//		 
//		 
//	}
//	
//	@Test (priority = 3,alwaysRun=true)
//	public void lazyLoadingClientUserTest() throws InterruptedException, InvalidFormatException, IOException, AWTException{
//		
//		 String EmailId = getCellData(1, 5);
//			
//		 String Password = getCellData(1, 6);
//		 		
//		 System.out.println("Executing : Lazy Loading Client User Test");
//		 
//		 new Client(driver).clientUserLazyLoading(EmailId, Password);
//		 
//		 
//	}
//	
//	@Test (priority = 4,alwaysRun=true)
//	public void downloadReportsTest() throws InterruptedException, InvalidFormatException, IOException, AWTException{
//		
//		 String EmailId = getCellData(1, 5);
//			
//		 String Password = getCellData(1, 6);
//		 
//		 String ClientName = getCellData(1, 7);
//		 		
//		 System.out.println("Executing : Download Reports Test");
//		 
//		 new EventDashboard(driver).verifyDownloadReport(EmailId, Password,ClientName);
//		 
//		 
//	}
	
	@Test (priority = 5,alwaysRun=true)
	public void verifyEventArchiveTest() throws InterruptedException, InvalidFormatException, IOException{
		
		 String EmailId = getCellData(1, 5);
			
		 String Password = getCellData(1, 6);
		 
		 String ClientName = getCellData(1, 7);
		 
//		 String NoOfDays = getCellData(1, 10);
		
		 System.out.println("Executing : Verify Event Archive  Test");
		 
		 new EventArchiveSettings(driver).verifyEventArchive(EmailId, Password, ClientName, "1005");
		
	}

}
