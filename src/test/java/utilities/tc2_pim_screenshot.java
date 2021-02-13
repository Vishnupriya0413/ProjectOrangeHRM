package utilities;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class tc2_pim_screenshot {

	static int i=1;
	static WebDriver driver;
	WebElement username,password,login;
	
    
	@Given("^User is logged in$")
	public void user_is_logged_in() throws Throwable {
		 
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
     

	    
	
	}

	@When("^the user wants to navigate to PIM$")
	public void the_user_wants_to_navigate_to_PIM() throws Throwable {
		
		 username = driver.findElement(By.name("txtUsername"));
         username.sendKeys("Admin");
         password = driver.findElement(By.name("txtPassword"));
         password.sendKeys("admin123");
        login = driver.findElement(By.xpath("//*[@id=\"btnLogin\"]"));
         login.click();
     
        WebElement pim = driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]/b"));
	     pim.click();
	     captureScreenshot();
	     WebElement add = driver.findElement(By.id("btnAdd"));
         add.click();
         Thread.sleep(1000);
         captureScreenshot();
        
         WebElement firstname=driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
         firstname.sendKeys("Lakshmi");
         WebElement lastname=driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
         lastname.sendKeys("Reddy");
         Thread.sleep(2000);
         WebElement employeeID=driver.findElement(By.xpath("//*[@id=\"employeeId\"]"));
         employeeID.sendKeys("123");
         
         WebElement checkbox=driver.findElement(By.id("chkLogin"));
         checkbox.click();
         Thread.sleep(2000);
         
         WebElement username1 = driver.findElement(By.name("user_name"));
         username1.sendKeys("lakshmi@123456");
         
         WebElement password1 = driver.findElement(By.name("user_password"));
         password1.sendKeys("$8106243172Ch");
         Thread.sleep(2000);
         
         WebElement confirmpassword1 = driver.findElement(By.name("re_password"));
         confirmpassword1.sendKeys("$8106243172Ch");
         
         Select status = new Select(driver.findElement(By.name("status")));
         status.selectByVisibleText("Enabled");
         captureScreenshot();
         
         WebElement save = driver.findElement(By.xpath("//*[@id=\"btnSave\"]"));
	     save.click();
         
	}

	@Then("^user can navigate to PIM$")
	public void user_can_navigate_to_PIM() throws Throwable {
	  driver.quit();
	}


	 static void captureScreenshot() throws Exception
	    {
	        File scrFile;
	        scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        Files.copy(scrFile, new File("C:\\screenshots\\pimscreenshots\\step" + i + ".jpeg"));
	        
	        i++;
	    }
	    
		
	}

