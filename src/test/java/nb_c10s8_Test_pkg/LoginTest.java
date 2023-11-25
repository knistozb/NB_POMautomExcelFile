
// Selenium Class 10.c:- July 10, 2023, Saturday with Instructor Shihabul Khandakar (Shibab) 

package nb_c10s8_Test_pkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import nb_c10s8_Page_pkg.DashboardPage;
import nb_c10s8_Page_pkg.LoginPage;
import nb_c10s8_Util_pkg.BrowserFactory;
import nb_c10s8_Util_pkg.ExcelReader;

public class LoginTest {

	
	
	// Teamwork chat:
		// Market prep group
		// individual personal group chat:
			// ask them in group if anyone can give some suggestions 
	
	// Bootcamp is done --> mock interview --> resume prep -->projects --> first day market
		// tell me about urself
		// tell me about your current project
	
	// Resume prep:
		// teamwork project, there are sample resumes and we will make one using those samples
		// resume first draft qill not have any company names (projects)
		// after reviewing the resume, Enrico will give you the names
	
	// Once your resume is finalized, you will work with someone from TF- Narayan. He is going to put your resume in all job portal
		// job market application (gmail account and password we emailed)
		// once he is done creating all job portal accounts- he will share the documents with all username and password with you
	
	// JD (Job Description): 
	
	// First Conversation: 
		// If they say I am working for ABC, and I am looking for this client. 
		// make sure to ask them what client they are representing
			// make sure to avoid conflicts. Ask them what domain it is so you know in advance?
			// Rate: $65/hour on W2: means
				// or 1099 (nobody is paying tax right away, but paying later during tax filing)
				// if you feel good, don't ask less than $55/hour
				// ask for full time w2 105k-110k/year; not less than 90k/year
				// could be permanent or contract or contract to hire
			// Work status: citizen or green card
			// Why change or when can you join?
			// must ask: who is the client?
	
	// Do you have an employer?
		// Yes, I am currently working under 1099. My employer name is ________??? will be given to me by Enrico. 
			// I can get you the details. Do you need it right now?
	// Will you be able to pass the background check?
		// Yes. Whatever the document you require, I can work with you absolutely
	
	// if they are asking for XYZ document like paystub, employment history, etc., consult with Enrico first.
		// just tell them I can get you know....but since there is no job offer rn, why do you need it now? 
			// I would highly prefer if we do that once we are moving further in the hiring process.
		// whenever they ask you any sensitive data like greencard, USCIS #, year of date of birth, etc. dont show them yet.
		// If they ask you silly questions like how did you get the citizenship or greencard, etc. 
			// I dont think it really matters for our ongoing process....How does that affect this or have anythign to do with this?
		// If they ask you what rate you working atm? I am also looking for a new challenge and a better compensataion as well. 
			// I am currently working for $65, so I am definitely looking for a higher rate on my next one.
		// 
		
	// RTR: Right To Represent
	
	// 2nd: Technical Interview Setup
	
	// 3rd: offer or another round of interview
		// I am already looking, so I dont want them to know now. 
		// I can give it now, but only if you would not contact them, and do it later once I am hired if you really need to
		// Whenever they ask for references, ask in the personalized group chat 
		// I will have to talk to my reference first, and I can email back to you as soon as I get a okay from them. Will that be okay?
		// if they don't answer, could you reach out alternative way? I will have to get in touch with them to remind them as they already are aware about your chance of contacting them.
		
	// if they want my green card before interview, I would not feel comfortable sharing that with you because I do get lots of calls from several recruiters.
		// I wouldn't want them all to have it if we are not going somewhere safe with it.
		// tell them we could call over the whatsapp or viber and I can show you right away if this is really that important.
	
	// you can even drop the call politely telling them you are not interested anymore looking at the way this is going. 
	
	
	
	
	
	// ================================================================================================

	
	WebDriver driver;
	
	ExcelReader exlRead = new ExcelReader("src/main/java/TestData/TF_TestData.xlsx");
	
	String userName = exlRead.getCellData("LoginInfo", "UserName", 2);
	String password = exlRead.getCellData("LoginInfo", "Password", 2);
	String dashboardHeaderText = exlRead.getCellData("DashboardInfo", "DashboardHeader", 2);
// 	String dashboardHeaderText = exlRead.getCellData(sheetName, colName, rowNum);
	
	public void validUserShouldBeAbleToLogin() throws InterruptedException {
		
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickOnSignInButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage(dashboardHeaderText);
		
		BrowserFactory.tearDown();
	}
	
	
}
	

