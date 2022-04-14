package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage {
    protected WebDriver driver;

    @FindBy(id = "finish")
    WebElement finishButton;

    public OverviewPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //this method completes the order process
    public void finishCheckout(){
        finishButton.click();
    }
}