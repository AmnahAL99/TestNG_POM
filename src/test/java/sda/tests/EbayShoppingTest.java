package sda.tests;

import org.testng.annotations.Test;
import sda.pages.Ebay.EBayPage;
import sda.utilities.Driver;

public class EbayShoppingTest {

    @Test
    public void testEBayShopping() throws InterruptedException {
        Driver.getDriver().get("https://www.ebay.com/");
        EBayPage ebayPage = new EBayPage();

        // Search for a laptop
        ebayPage.searchFor("laptop");

        // Add the first item to the cart
        ebayPage.addFirstItem();

        // Increase the quantity to 3 and verify the total amount
        ebayPage.increaseQuantity(3);

        // Close the browser
        Driver.closeDriver();
    }
}
