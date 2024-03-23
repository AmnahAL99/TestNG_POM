package sda.tests;


import org.testng.annotations.Test;
import sda.pages.Bank.Customer;
import sda.utilities.BaseClass;

public class Customer_TestCase extends BaseClass {

    @Test
    public void test(){
        driver.get(baseURL);

        Customer CustomerPage = new Customer(driver);

        CustomerPage.customerLogin();
        CustomerPage.chooseAccount();
        CustomerPage.depositMoney("50000");
        CustomerPage.withdrawMoney("3000");
        CustomerPage.withdrawMoney("2000");
        CustomerPage.depositMoney("5000");
        CustomerPage.withdrawMoney("10000");
        CustomerPage.withdrawMoney("15000");
        CustomerPage.depositMoney("1500");
    }
}
