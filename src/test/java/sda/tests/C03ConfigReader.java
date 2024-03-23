package sda.tests;

import org.testng.annotations.Test;
import sda.utilities.ConfigReader;
import sda.utilities.Driver;

public class C03ConfigReader {

// Go to Amazon
// Go to google
// Use configReader class

    @Test
    public void ConfigReader() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("amazonurl"));
        Thread.sleep(3000);
        Driver.getDriver().get(ConfigReader.getProperty("googleurl"));
        Thread.sleep(2000);
        Driver.closeDriver();
    }

}

