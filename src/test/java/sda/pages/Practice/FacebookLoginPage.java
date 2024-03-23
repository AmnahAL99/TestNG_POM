package sda.pages.Practice;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import sda.utilities.Driver;

import java.time.Duration;

public class FacebookLoginPage {
    public FacebookLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(id = "email") WebElement emailField;
    @FindBy(id = "pass") WebElement passwordField;
    @FindBy(name = "login") WebElement loginButton;
    @FindBy(partialLinkText = "Find your account")
   WebElement errorMessageElement ;
    public void login(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
    }
  //  public void setErrorMessage(){
      //  Assert.assertTrue(errorMessageElement.isDisplayed());
  public void assertErrorMessageVisible() {
      WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10)); // 10 seconds wait
      wait.until(ExpectedConditions.visibilityOf(errorMessageElement));
      Assert.assertTrue(errorMessageElement.isDisplayed(), "Error message is not displayed as expected.");
  }
    }



