package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class tc4_recruitment {
	
	WebDriver driver;
	WebElement username,password,login,confirmpassword;
	
	
	@Given("^User is in the recritment tab$")
	public void user_is_in_the_recritment_tab() throws Throwable {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		 username = driver.findElement(By.name("txtUsername"));
         username.sendKeys("Admin");
         password = driver.findElement(By.name("txtPassword"));
         password.sendKeys("admin123");
         login = driver.findElement(By.xpath("//*[@id=\"btnLogin\"]"));
         login.click();
         
         WebElement recruitment = driver.findElement(By.xpath("//*[@id=\"menu_recruitment_viewRecruitmentModule\"]/b"));
         recruitment.click();
         
                    
	}

	@When("^the user wants to add new candidate deatils$")
	public void the_user_wants_to_add_new_candidate_deatils() throws Throwable {
		WebElement addCandidate = driver.findElement(By.xpath("//*[@id=\"btnAdd\"]"));
        addCandidate.click();
        WebElement firstname = driver.findElement(By.name("addCandidate[firstName]"));
        firstname.sendKeys("kavya");
        
        WebElement lastname = driver.findElement(By.name("addCandidate[lastName]"));
        lastname.sendKeys("Reddy");
        
        WebElement email = driver.findElement(By.name("addCandidate[email]"));
        email.sendKeys("kavya@gmail.com");
        
        Select jobvacancy = new Select(driver.findElement(By.name("addCandidate[vacancy]")));
        jobvacancy.selectByVisibleText("Payroll Administrator");
        
        WebElement checkbox1=driver.findElement(By.id("addCandidate_consentToKeepData"));
        checkbox1.click();
        
        WebElement saveaddCandidate = driver.findElement(By.xpath("//*[@id=\"btnSave\"]"));
        saveaddCandidate.click();
        
        Thread.sleep(3000);
		
	   
	}


	@Then("^user can add the new candidate details$")
	public void user_can_add_the_new_candidate_details() throws Throwable {
		 driver.quit();
	}
}
