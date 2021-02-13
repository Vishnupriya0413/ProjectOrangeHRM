package testcases;





import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class tc2_PIM {
	WebDriver driver;
	WebElement username,password,login,confirmpassword;
	
    
	@Given("^User is logged in$")
	public void user_is_logged_in() throws Throwable {
		 
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
     Thread.sleep(1000);  

	    
	
	}

	@When("^the user wants to navigate to PIM$")
	public void the_user_wants_to_navigate_to_PIM() throws Throwable {
		
		 username = driver.findElement(By.name("txtUsername"));
         username.sendKeys("Admin");
         password = driver.findElement(By.name("txtPassword"));
         password.sendKeys("admin123");
         Thread.sleep(1000); 
         login = driver.findElement(By.xpath("//*[@id=\"btnLogin\"]"));
         login.click();
                  
         
		 WebElement pim = driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]/b"));
	     pim.click();
	     Thread.sleep(1000); 
	   
	     WebElement add = driver.findElement(By.id("btnAdd"));
         add.click();
         Thread.sleep(2000);
         WebElement firstname=driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
         firstname.sendKeys("VishnuPriya");
         WebElement lastname=driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
         lastname.sendKeys("J P");
         WebElement employeeID=driver.findElement(By.xpath("//*[@id=\"employeeId\"]"));
         employeeID.sendKeys("123");
         
         WebElement checkbox=driver.findElement(By.id("chkLogin"));
         checkbox.click();
         
         WebElement username1 = driver.findElement(By.name("user_name"));
         username1.sendKeys("Vishnupriya@1234");
         
         WebElement password1 = driver.findElement(By.name("user_password"));
         password1.sendKeys("$8106243172Ch");
         
         WebElement confirmpassword1 = driver.findElement(By.name("re_password"));
         confirmpassword1.sendKeys("$8106243172Ch");
         
         Select status = new Select(driver.findElement(By.name("status")));
         status.selectByVisibleText("Enabled");
         
         WebElement save = driver.findElement(By.xpath("//*[@id=\"btnSave\"]"));
	     save.click();
	     
	     Thread.sleep(3000);
	     driver.quit();
         	}

	@Then("^user can navigate to PIM$")
	public void user_can_navigate_to_PIM() throws Throwable {
	  System.out.println("application closed");
	}
}