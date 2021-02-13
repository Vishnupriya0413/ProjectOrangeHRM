package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class tc3_employeesearch {
	WebDriver driver;
	WebElement username,password,login,confirmpassword;
	
	
	@Given("^User is in the PIM tab$")
	public void user_is_in_the_PIM_tab() throws Throwable {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		 username = driver.findElement(By.name("txtUsername"));
         username.sendKeys("Admin");
         password = driver.findElement(By.name("txtPassword"));
         password.sendKeys("admin123");
         login = driver.findElement(By.xpath("//*[@id=\"btnLogin\"]"));
         login.click();
                  
         
		 WebElement pim = driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]/b"));
	     pim.click();
	   
	}

	@When("^the user wants to search for an employee$")
	public void the_user_wants_to_search_for_an_employee() throws Throwable {
		
		WebElement employeename = driver.findElement(By.name("empsearch[employee_name][empName]"));
         employeename.sendKeys("Lakshmi Reddy");
		
		 WebElement search = driver.findElement(By.xpath("//*[@id=\"searchBtn\"]"));
	     search.click();
	    Thread.sleep(3000);
	}

	@Then("^user can get the employee details$")
	public void user_can_get_the_employee_details() throws Throwable {
	    driver.quit();
	}



}