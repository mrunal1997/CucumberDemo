package stepsDefinations;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationSteps {
    WebDriver driver;

    @Given("User is on Registration page")
    public void user_is_on_registration_page() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
    }

    @When("User enters first name, last name, email, password and confirms password")
    public void registration_details() {
    	driver.findElement(By.xpath("https://demo.nopcommerce.com/")).click();
    	driver.findElement(By.xpath("//input[@id='gender-male']")).click();
        driver.findElement(By.id("FirstName")).sendKeys("John");
        driver.findElement(By.id("LastName")).sendKeys("Doe");
        
        Select dateSelect = new Select(driver.findElement(By.name("DateOfBirthDay")));
        dateSelect.selectByVisibleText("5");
        
        Select monthSelect = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        monthSelect.selectByVisibleText("May");
        
        Select yearSelect = new Select(driver.findElement(By.name("DateOfBirthYear")));
        yearSelect.selectByVisibleText("1998");
        
        driver.findElement(By.id("Email")).sendKeys("john.doe@example.com");
        driver.findElement(By.id("Password")).sendKeys("Password123");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Password123");
    }

    @When("User selects newsletter checkbox")
    public void newsletter_checkbox() {
        driver.findElement(By.id("Newsletter")).click();
    }

    @When("User clicks on Register button")
    public void click_register_button() {
        driver.findElement(By.id("register-button")).click();
    }

    @Then("User should be registered successfully and see a confirmation message")
    public void confirmation_message() {
        String message = driver.findElement(By.className("result")).getText();
        Assert.assertTrue(message.contains("Your registration completed"));
        driver.quit();
    }
}
