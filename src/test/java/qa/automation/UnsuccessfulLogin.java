package qa.automation;

import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UnsuccessfulLogin extends TestUtil {

    @DataProvider(name = "wrongUsersList")
    public Object [][] getWrongUsers(){
        return new Object[][]{
                {"unusual_user", "secret_sauce"},
                {"standard_user", "wrong_password"},
                {"unspecified_user", "unspecified_password"}
        };

    }

    @Test (dataProvider = "wrongUsersList")
    public void UnsuccessfulLoginTest(String userName, String password){
        WebElement username = driver.findElement(By.id("user-name"));
        username.click();
        username.sendKeys(userName);

        WebElement passwordInput = driver.findElement(By.xpath("(//input[@class='input_error form_input'])[2]"));
        passwordInput.click();
        passwordInput.sendKeys(password);

        WebElement LoginBtn = driver.findElement(By.cssSelector("[value=Login"));
        LoginBtn.click();

        WebElement errorLoginLabel = driver.findElement(By.xpath("//*[text()='Epic sadface: Username and password do not match any user in this service']"));

        Assert.assertTrue(errorLoginLabel.isDisplayed());

    }

}