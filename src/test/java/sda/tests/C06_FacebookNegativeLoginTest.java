package sda.tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import sda.pages.Practice.FacebookLoginPage;
import sda.utilities.ConfigReader;
import sda.utilities.Driver;


public class C06_FacebookNegativeLoginTest {

@Test
public void testNegativeLogin() {
    Faker faker = new Faker();
    FacebookLoginPage facebookLoginPage = new FacebookLoginPage();
    Driver.getDriver().get(ConfigReader.getProperty("facUrl"));
    String randomEmail = faker.internet().emailAddress();
    String randomPassword = faker.internet().password();
    facebookLoginPage.login(randomEmail, randomPassword);

  // Assert.assertTrue(true, "This is a placeholder assertion. Replace it with the actual error message check.");
   //facebookLoginPage.setErrorMessage();
    facebookLoginPage.assertErrorMessageVisible();
}
    @Test
    public void testNegativeLogin2() {
        Faker faker = new Faker();
        FacebookLoginPage facebookLoginPage = new FacebookLoginPage();
        Driver.getDriver().get(ConfigReader.getProperty("facUrl"));
        // Combining faker data to create more unique email and password
        String randomEmail = faker.name().firstName().toLowerCase() + "." + faker.number().digits(4) + "@fakeemail.com";
        String randomPassword = "Pwd!" + faker.lorem().characters(10, 20);
        facebookLoginPage.login(randomEmail, randomPassword);
        facebookLoginPage.assertErrorMessageVisible();
    }

}
