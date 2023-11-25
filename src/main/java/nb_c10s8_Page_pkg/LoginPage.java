
// Selenium Class 10.b:- July 10, 2023, Saturday with Instructor Shihabul Khandakar (Shibab) 


package nb_c10s8_Page_pkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	
	// we are defining attributes and the action of those attributes...
		// which is why we are creating an object that invokes/represents those specific attributes
		// those object are representing those each object page of that window...
	
	
	
	// ================================================================================================

	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"username\"]" ) WebElement USER_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"password\"]" ) WebElement PASSWORD_ELEMENT;
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/form/div[3]/button" ) WebElement Sign_In_Element;
	
	// we need to identify our intractable methods:
	public void insertUserName(String userName) {	
		USER_NAME_ELEMENT.sendKeys(userName);
	}
	
	public void insertPassword(String password) {
		PASSWORD_ELEMENT.sendKeys(password);
	}
	
	public void clickOnSignInButton() {
		Sign_In_Element.click();
	}
	
	// Combining Method:
	public void performLogin(String userName, String password) {
		
		USER_NAME_ELEMENT.sendKeys(userName);
		PASSWORD_ELEMENT.sendKeys(password);
		Sign_In_Element.click();	
	}
	
		
}
	


