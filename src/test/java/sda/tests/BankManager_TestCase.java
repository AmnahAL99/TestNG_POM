package sda.tests;

import org.testng.Assert;
import org.testng.annotations.Test;


import sda.pages.Bank.BankManager;
import sda.utilities.BaseClass;

public class BankManager_TestCase extends BaseClass {

    @Test
    public void test() throws Exception{
        driver.get(baseURL);

        BankManager BankPage = new BankManager(driver);

        BankPage.managerLogin();
        BankPage.clickAddCustomerMenu();

        BankPage.addCustomer();
        BankPage.verifyCustomerInserted();

        BankPage.deleteCustomers();

            boolean isCustomerInserted = BankPage.verifyCustomerInserted();
            Assert.assertTrue(isCustomerInserted, "Customer insertion verification failed");

        boolean isDeleteSuccessful = BankPage.deleteCustomers();
        Assert.assertTrue(isDeleteSuccessful, "Customer deletion verification failed");
        }
    }


