package sda.pages.Ebay;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import sda.utilities.Driver;

import java.util.Iterator;
import java.util.Set;

public class EBayPage {
    /* ***********************************************************
     Navigate to https://www.ebay.com/
     Perform a search after typing {search_keyword} in the search box
     Add the first product in the search results to the cart
     Go to the cart
     Increase the quantity of the purchased product to {quantity}
     Verify the total amount in the cart should be calculated as unit productPrice * quantity
   ***********************************************************  */
    public EBayPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "gh-ac")
    WebElement searchBox;

    @FindBy(xpath = "//*[contains(@class,'srp-results')]/li[@data-viewport]/div/div")
    WebElement firstItem;

    @FindBy(xpath = "//*[@data-testid='ux-call-to-action']/span/span[.='Add to cart']")
    WebElement addToCartButton;

    @FindBy(xpath = "//*[@data-test-id='qty-dropdown']")
    WebElement quantityDropDown;

    @FindBy(xpath = "//*[@class='gh-cart-icon']")
    WebElement cartButton;

    @FindBy(xpath = "//*[@class='price-details']/div/span/span/span")
    WebElement itemPrice;

    @FindBy(xpath = "//*[@class= 'fake-link' and contains(@aria-label,'Remove')]")
    WebElement removeButton;

    public void searchFor(String searchKey){
        searchBox.sendKeys(searchKey, Keys.ENTER);
    }

    public void addFirstItem(){
        String mainPage = Driver.getDriver().getWindowHandle();
        firstItem.click();
        Set<String> handles = Driver.getDriver().getWindowHandles();
        String newHandle = getNewHandle(handles, mainPage);
        Driver.getDriver().switchTo().window(newHandle);
        addToCartButton.click();
        cartButton.click();
    }

    private String getNewHandle(Set<String> handles, String mainPage) {
        String newHandle = "";
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()) {
            String handle = iterator.next();
            if (!handle.equals(mainPage)) {
                newHandle = handle;
                break;
            }
        }
        return newHandle;
    }

    public void increaseQuantity(int quantity) throws InterruptedException {
        double unitPrice = Double.parseDouble(itemPrice.getText().substring(4));

        Select select = new Select(quantityDropDown);
        if (quantity >= 1 && quantity <= 6) {
            select.selectByValue(String.valueOf(quantity));
        } else {
            System.out.println("You can select only from 1-6");
            return;
        }
        Thread.sleep(1500);

        double totalPrice = unitPrice * quantity;
        double newPrice = Double.parseDouble(itemPrice.getText().substring(4));
        Assert.assertEquals(newPrice, totalPrice, "Total price calculation is incorrect");
        Thread.sleep(500);
        removeButton.click();
        Thread.sleep(2000);
    }

}


