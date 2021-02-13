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

public class tc5_myinfo_screenshot {
	static int i=1;
	static WebDriver driver;
	WebElement username,password,login;

	@Given("^User is in the myinfo tab$")
	public void user_is_in_the_myinfo_tab() throws Throwable {
	    driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		 username = driver.findElement(By.name("txtUsername"));
         username.sendKeys("Admin");
         password = driver.findElement(By.name("txtPassword"));
         password.sendKeys("admin123");
         login = driver.findElement(By.xpath("//*[@id=\"btnLogin\"]"));
         login.click();
         
         WebElement myinfo = driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]/b"));
         myinfo.click();
         captureScreenshot();
         
	    
	}

	@When("^the user wants to edit personal details$")
	public void the_user_wants_to_edit_personal_details() throws Throwable {
		 WebElement edit = driver.findElement(By.xpath("//*[@id=\"btnSave\"]"));
         edit.click();
         
         
         driver.findElement(By.name("personal[txtEmpFirstName]")).clear();
         driver.findElement(By.name("personal[txtEmpFirstName]")).sendKeys("Lakshmi");
         
         driver.findElement(By.name("personal[txtEmpLastName]")).clear();
         driver.findElement(By.name("personal[txtEmpLastName]")).sendKeys("Reddy");
         
         driver.findElement(By.name("personal[txtEmployeeId]")).clear();
         driver.findElement(By.name("personal[txtEmployeeId]")).sendKeys("123");
         captureScreenshot();
         
         WebElement radio2= driver.findElement(By.id("personal_optGender_2"));
         radio2.click();
         Thread.sleep(2000);
         WebElement checkbox=driver.findElement(By.id("personal_chkSmokeFlag"));
         checkbox.click();
         Thread.sleep(1000);
         captureScreenshot();
         
         WebElement save = driver.findElement(By.xpath("//*[@id=\"btnSave\"]"));
         save.click();
         Thread.sleep(1000);
         captureScreenshot();
         }

	@Then("^user can edit personal details$")
	public void user_can_edit_personal_details() throws Throwable {
	    
		driver.quit();
		
	}
	 static void captureScreenshot() throws Exception
	    {
	        File scrFile;
	        scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        Files.copy(scrFile, new File("C:\\screenshots\\myinfoscreenshots\\step" + i + ".jpeg"));
	        
	        i++;
	    }
	    


}
