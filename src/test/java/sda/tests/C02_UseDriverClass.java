package sda.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import sda.utilities.ConfigReader;
import sda.utilities.Driver;

public class C02_UseDriverClass {
    //Go to URL: https://opensource-demo.orangehrmlive.com/
    //Verify title contains OrangeHRM.
    //Use Driver Class
    @Test
    public void driverClassTest() {
        Driver.getDriver().get(ConfigReader.getProperty("base_url"));
       // Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/"); // Navigate to the URL
        String title = Driver.getDriver().getTitle();
        Assert.assertTrue(title.contains("OrangeHRM"), "Title does not contain 'OrangeHRM'");// Verify title contains "OrangeHRM"
        Driver.closeDriver();
    }
}
