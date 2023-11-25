
// Selenium Class 10.a:- July 10, 2023, Saturday with Instructor Shihabul Khandakar (Shibab) 


package nb_c10s8_Util_pkg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserFactory {

	
	// Software Development Technology:
			// TDD :
			// DDT or Data Driven Testing Framework: Data Driven framework is used to drive test cases and suites from an external data feed. The data feed can be data sheets like xls, xlsx, and csv files. 
						// A Data Driven Framework in Selenium is a technique of separating the “data set” from the actual “test case” (code).
			// BDD : 
				// Behavior Driven Development Framework:
		
		// Gherkin: is a set of grammar rules that makes plain text structured enough for Cucumber to understand. 
			// The scenario above is written in Gherkin. Gherkin serves multiple purposes: Unambiguous executable specification. Automated testing using Cucumber.
		
		// Types of Test Automation Framework"
			// 
		  
	
	
	// ================================================================================================

	
	static WebDriver driver;
	WebDriverWait wait;

	
	public static WebDriver init() {   // changing the method into WebDriver return type

		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://techfios.com/billing/?ng=login/after/dashboard");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public static void tearDown() {
		
		driver.close();
		driver.quit();

	}

}
	
