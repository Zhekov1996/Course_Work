package qa.automation;

import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import java.time.Duration;
import java.util.Collections;
import java.util.NoSuchElementException;

public class AddToCart extends TestUtil {
    @Test
    public void selectDifferentOrder() throws InterruptedException {
        WebElement username = driver.findElement(By.id("user-name"));
        username.click();
        username.sendKeys("standard_user");

        WebElement passwordInput = driver.findElement(By.xpath("(//input[@class='input_error form_input'])[2]"));
        passwordInput.click();
        passwordInput.sendKeys("secret_sauce");

        WebElement loginBtn = driver.findElement(By.cssSelector("[value=Login]"));
        loginBtn.click();


        FluentWait fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoreAll(Collections.singleton(NoSuchElementException.class));
        WebElement lowToHighPriceOption = driver.findElement(By.cssSelector("[value=lohi]"));

        fluentWait.until(ExpectedConditions.elementToBeClickable(lowToHighPriceOption));
        lowToHighPriceOption.click();
    }
    @Test
    public void addItemToTheCart(){
        LoginPage loginPage = new LoginPage(driver);
      ProductsPage productsPage = loginPage.login("standard_user","secret_sauce");
      productsPage.addItemToTheCart("onesie");

        Assert.assertEquals(productsPage.getItemsInTheCart(), 1, "Because we have only one item so far");
    }

}