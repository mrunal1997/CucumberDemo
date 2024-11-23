package stepsDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.junit.Assert;

public class AddToCartSteps {
    WebDriver driver;

    @Given("User is logged in")
    public void user_is_logged_in() {
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/login");
        driver.manage().window().maximize();
        driver.findElement(By.id("Email")).sendKeys("john.doe@example.com");
        driver.findElement(By.id("Password")).sendKeys("Password123");
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
    }

    @When("User searches for a product {string}")
    public void user_searches_for_product(String productName) {
        driver.findElement(By.id("small-searchterms")).sendKeys(productName);
        driver.findElement(By.xpath("//button[contains(text(),'Search')]")).click();
    }

    @When("User clicks on the Add to Cart button for the product")
    public void user_clicks_add_to_cart() {
        driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]")).click();
    }

    @Then("The product should be added to the cart successfully")
    public void product_should_be_added_to_cart() {
        Assert.assertTrue(driver.findElement(By.className("cart-qty")).getText().contains("(1)"));
        driver.quit();
    }
}

