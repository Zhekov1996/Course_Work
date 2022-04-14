package qa.automation;

import base.TestUtil;
import com.opencsv.exceptions.CsvException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;
import utils.CsvHelper;

import java.io.IOException;

public class CheckOut extends TestUtil {
    @DataProvider(name = "userCsv")
    public static Object[][] readUsersFromCsvFile() throws IOException, CsvException {
        return CsvHelper.readCsvFile("src/test/resources/rightuser.csv");
    }

    @Test(dataProvider = "userCsv")
    public void successfulLoginTest(String userName, String password){

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login(userName, password);

        productsPage.addItemToTheCart("fleece-jacket");
        productsPage.enterIntoCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.checkout();

        CheckOutPage checkoutpage = new CheckOutPage(driver);
        CheckOutPage.fillCheckOutInfo("Nikolay", "Zhekov", "0000");

        FinalPage FinalPage = new FinalPage(driver);
        Assert.assertTrue(FinalPage.getCheckoutHeader());


    }
}

