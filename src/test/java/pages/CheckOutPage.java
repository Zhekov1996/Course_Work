package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
    protected WebDriver driver;

    @FindBy(id = "first-name")
    static
    WebElement firstNameInput;

    @FindBy(id = "last-name")
    static
    WebElement lastNameInput;

    @FindBy(id = "postal-code")
    static
    WebElement postalCodeInput;

    @FindBy(id="continue")
    static
    WebElement buttonContinue;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static void fillCheckOutInfo(String firstName, String lastName, String postalCode) {

        firstNameInput.click();
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);

        lastNameInput.click();
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);

        postalCodeInput.click();
        postalCodeInput.clear();
        postalCodeInput.sendKeys(postalCode);

        buttonContinue.click();
    }
}
