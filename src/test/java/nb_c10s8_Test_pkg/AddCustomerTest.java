
// Selenium Class 9.g:- July 9, 2023, Sunday with Instructor Shihabul Khandakar (Shibab) 



package nb_c10s8_Test_pkg;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import nb_c10s8_Page_pkg.AddCustomerPage;
import nb_c10s8_Page_pkg.DashboardPage;
import nb_c10s8_Page_pkg.LoginPage;
import nb_c10s8_Util_pkg.BrowserFactory;
import nb_c10s8_Util_pkg.ExcelReader;


public class AddCustomerTest {

	
	
	
	// each rows will have their various cells inside it...so if 2 cells then the first row will have first cell and second cell in the same row....
	// next row will have other cells third and forth and so on....
	
	
	// IQA 1: Have you worked with excel file? How do you read it?
		// ==> We need the filing dependencies like apache POI and apache po -ooxml.
				// Now if I dealing with reading 2010 version or newer then I will have to use XSSSF Workbook filing system
				// If I am dealing with 2007 or older, then I will use HSSF filing system
	
	
	// Link to access Shihab's github code for today's project: 
		// https://github.com/techfios-git/exlProjectFeb23.git
	
	
	// =============================================================================
	
	
	WebDriver driver;
	
	// testData or mockData:
	ExcelReader exlRead = new ExcelReader("src/main/java/TestData/TF_TestData.xlsx");
	
	String userName = exlRead.getCellData("LoginInfo", "UserName", 2);
	String password = exlRead.getCellData("LoginInfo", "Password", 2);
	String dashboardValidationText = exlRead.getCellData("DashboardInfo", "DashboardHeader", 2);
	String addCustomerValidationText = exlRead.getCellData("AddContactInfo", "AddContactValidationText", 2);
	String fullName = exlRead.getCellData("AddContactInfo", "FullName", 2);
	String company = exlRead.getCellData("AddContactInfo", "CompanyName", 2);
	String email = exlRead.getCellData("AddContactInfo", "Email", 2);
	String phone = exlRead.getCellData("AddContactInfo", "Phone", 2);
	String address = exlRead.getCellData("AddContactInfo", "Address", 2);
	String city = exlRead.getCellData("AddContactInfo", "City", 2);
	String state = exlRead.getCellData("AddContactInfo", "State", 2);
	String zip = exlRead.getCellData("AddContactInfo", "Zip", 2);
	String country = exlRead.getCellData("AddContactInfo", "Country", 2);

	
	
	@Test
	public void userShouldBeAbleToAddCustomer() throws InterruptedException {
		
		// we need to relaunch this over again to first launch driver, then login, then validation which was already done previously
		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.performLogin(userName, password);
		
//		// validating dashboard page again and clicking on customers and clicking on add customer button
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage(dashboardValidationText);
		dashboardPage.clickCustomerButton();
		dashboardPage.clickAddCustomer();
	
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.validateAddCustomerPage(addCustomerValidationText);
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.insertEmail(email);
		addCustomerPage.insertPhone(phone);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
		addCustomerPage.insertZip(zip);
		addCustomerPage.selectCountry(country);
		addCustomerPage.clickOnSaveButton();
		
		dashboardPage.clickListCustomersButton();
//		addCustomerPage.validateInsertedNameThenDelete();
//		addCustomerPage.clickOnOkButton();
		
	}
		
}
