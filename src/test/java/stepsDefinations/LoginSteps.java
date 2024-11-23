package stepsDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.junit.Assert;

public class LoginSteps {
    WebDriver driver;

    @Given("User is on Login page")
    public void user_is_on_login_page() {
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/login");
        driver.manage().window().maximize();
    }

    @When("User enters valid email and password")
    public void user_enters_valid_credentials() {
        driver.findElement(By.id("Email")).sendKeys("john.doe@example.com");
        driver.findElement(By.id("Password")).sendKeys("Password123");
    }

    @When("User clicks on Login button")
    public void user_clicks_on_login_button() {
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
    }

    @Then("User should be logged in successfully and see the My Account page")
    public void user_should_be_logged_in_successfully() {
        Assert.assertTrue(driver.findElement(By.className("account")).isDisplayed());
        driver.quit();
    }
}
