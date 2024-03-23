package sda.tests;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class C07_FindByFindBydFindAll {
// @FindBy, @FindBys, and @FindAll are annotations used in the Java programming language
// and Selenium test automation tool to locate elements on web pages.
// - @FindBy is used to locate a single element.
// - @FindBys is used to locate elements that combine multiple criteria.
// - @FindAll is used to locate elements that meet any of multiple criteria.

    @FindBy(xpath = "//input[@id='twotabsearchtextbox' and @type='text']")
    public WebElement search;
    // The element can also be handled without the need for @FindBys

    //AND -FindBys
    @FindBys({
            @FindBy(id = "twotabsearchtextbox"),
            @FindBy(xpath = "//input[@type='text']")})
    public WebElement findBys;

    //OR -FindAll

    @FindAll({
            @FindBy(),
            @FindBy(),
            @FindBy(),
            @FindBy()
    })
    public List<WebElement> findAll;
}
