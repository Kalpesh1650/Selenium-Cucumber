package stepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SmokeTest {
	
	private WebDriver driver = null;
	public String siteURL = "http://executeautomation.com/demosite/Login.html";
	final String Username="admin";
	final String Password="adminpassw";
	
	@Before //Before Hook method will before every Cucumber Scenario
	public void beforTest(){
		System.out.println("In Before Hook....");
	}
	@After
	public void afterTest(){
		System.out.println("In After Hook....");
	}
	
	
	
	@Given("^Open Chrome and Start Application$")
	public void open_Chrome_and_Start_Application() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\Languages\\DataDrivenFramework\\DataDrivenFramework_WS\\"
				+ "\\src\\com\\selenium\\configuration\\Add-ons\\ChromeDriverServer_Win\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.navigate().to(siteURL);
		
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
	}

	@When("^I enter valid username and password$")
	public void i_enter_valid_username_and_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@id='userName']/p[1]/input")).sendKeys(Username);
		driver.findElement(By.xpath("//*[@id='userName']/p[2]/input")).sendKeys(Password);
		WebElement LogInBtn = driver.findElement(By.xpath("//*[@id='userName']/p[3]/input"));
		if(LogInBtn.isDisplayed())
			LogInBtn.click();
		else
			System.out.println("***Log In Button Not displayed***");
	    //throw new PendingException();
	}

	@Then("^User should be able to login to an Application$")
	public void user_should_be_able_to_login_to_an_Application() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		try{
			String exp_Result = "LOGOUT1";
			String act_Result = driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[1]/a/span")).getText();
		
			Assert.assertEquals(exp_Result, act_Result,"Mismatch in Exp. and Act. Results . ");
			System.out.println("** Test Passed **");
			WebElement logOutBtn = driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[1]/a/span"));
			logOutBtn.click();
			
			Thread.sleep(3000);
			if(driver!=null)
				driver.quit();
			
			
		}catch(AssertionError t){
			
			WebElement logOutBtn = driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[1]/a/span"));
			logOutBtn.click();
			
			Thread.sleep(3000);
			if(driver!=null)
				driver.quit();
			
			System.out.println("Test Failed "+t.getMessage());
			throw t;
			
		}
		catch(Throwable tt){
		
			WebElement logOutBtn = driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[1]/a/span"));
			logOutBtn.click();
			
			Thread.sleep(3000);
			if(driver!=null)
				driver.quit();
			
		System.out.println("Test Failed"+tt.getMessage());
		throw tt;
		
		}
		
	   // throw new PendingException();
	}


}
