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

public class tc6_logout_screenshot {

	static WebDriver driver;
	static int i=1;
    WebElement login, username, password,logoutmenu,logout;
    
	@Given("^User is in the dashboard$")
	public void user_is_in_the_dashboard() throws Throwable {
		
         System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver = new ChromeDriver();
         driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
         username = driver.findElement(By.name("txtUsername"));
         username.sendKeys("Admin");
         password = driver.findElement(By.name("txtPassword"));
         password.sendKeys("admin123");
         login = driver.findElement(By.xpath("//*[@id=\"btnLogin\"]"));
         login.click();
         captureScreenshot();
         Thread.sleep(2000);
		
	}

	@When("^the user wants to logout$")
	public void the_user_wants_to_logout() throws Throwable {
		 logoutmenu = driver.findElement(By.xpath("//*[@id=\"welcome\"]"));
         logoutmenu.click();
         Thread.sleep(1000);
         captureScreenshot();
         logout = driver.findElement(By.xpath("//*[@id=\"welcome-menu\"]/ul/li[2]/a"));
         logout.click();
         Thread.sleep(1000);
	    	    	}

	@Then("^user can logout from the application$")
	public void user_can_logout_from_the_application() throws Throwable {
		driver.quit();
	   
	}

	static void captureScreenshot() throws Exception
    {
        File scrFile;
        scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
     
		Files.copy(scrFile, new File("C:\\screenshots\\logoutscreenshots\\step" + i + ".jpeg"));
        
        i++;
    }
	
}