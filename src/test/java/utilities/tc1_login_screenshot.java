package utilities;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class tc1_login_screenshot {
	static int i=1;
	static WebDriver driver;
	WebElement username,password,login;
    
	@Given("^open the application$")
	public void open_the_application() throws Throwable {
		System.out.println("Started");
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
       driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		captureScreenshot();
	}
	
	@When("^the user wants to login$")
	public void the_user_wants_to_login() throws Throwable {
		username = driver.findElement(By.name("txtUsername"));
        username.sendKeys("Admin");
        password = driver.findElement(By.name("txtPassword"));
        password.sendKeys("admin123");
        Thread.sleep(1000);
        captureScreenshot();
        login = driver.findElement(By.xpath("//*[@id=\"btnLogin\"]"));
        login.click();
        Thread.sleep(2000);
	}

	@Then("^user can login to the application$")
	public void user_can_login_to_the_application() throws Throwable {
		System.out.println("User is able to login to the application");
       driver.quit();
	    
	}
    
	@Given("^open application$")
	public void open_application() throws Throwable {
		System.out.println("Started");
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
       driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		
	}
	@When("^user enters invalid credentials$")
	public void user_enters_invalid_credentials() throws Throwable {
		username = driver.findElement(By.xpath("//*[@id=\"txtUsername\"]"));
        username.sendKeys("Admin123");
        password = driver.findElement(By.xpath("//*[@id=\"txtPassword\"]"));
        password.sendKeys("admin123");
        Thread.sleep(1000);
        captureScreenshot();
        login = driver.findElement(By.xpath("//*[@id=\"btnLogin\"]"));
        login.click();
      
        
        Thread.sleep(2000);
	}
	
	@Then("^the system throws an error message$")
	public void the_system_throws_an_error_message() throws Throwable {
		System.out.println("User is not able to login to the application");
	}
	
	@When("^user didnot enter any credentials$")
	public void user_didnot_enter_any_credentials() throws Throwable {
		username = driver.findElement(By.name("txtUsername"));
		 username.sendKeys("");
	        password = driver.findElement(By.name("txtPassword"));
	        password.sendKeys("");
        Thread.sleep(1000);
        captureScreenshot();
        login = driver.findElement(By.xpath("//*[@id=\"btnLogin\"]"));
        login.click();
        Thread.sleep(2000);
	   
	}
	@Then("^the system to throw an error message$")
	public void the_system_to_throw_an_error_message() throws Throwable {
		System.out.println("User is not able to login to the application");
        driver.quit();
	}

	
    static void captureScreenshot() throws Exception
    {
        File scrFile;
        scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Files.copy(scrFile, new File("C:\\screenshots\\loginscreenshots\\step" + i + ".jpeg"));
        
        i++;
    }
    
	
}