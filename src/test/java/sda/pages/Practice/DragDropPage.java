package sda.pages.Practice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sda.utilities.Driver;
public class DragDropPage {
    /* *************************************************************************************
    Go to URL : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
Fill in capitals by country.
  *************************************************************************************  */
    public DragDropPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Capitals
    @FindBy(id = "box1")
    public WebElement oslo;
    @FindBy(id = "box2")
    public WebElement stockholm;
    @FindBy(id = "box3")
    public WebElement washington;
    @FindBy(id = "box4")
    public WebElement copenhagen;
    @FindBy(id = "box5")
    public WebElement seoul;
    @FindBy(id = "box6")
    public WebElement rome;
    @FindBy(id = "box7")
    public WebElement madrid;
    // Countries
    @FindBy(id = "box101")
    public WebElement norway;
    @FindBy(id = "box102")
    public WebElement sweden;
    @FindBy(id = "box103")
    public WebElement unitedStates;
    @FindBy(id = "box104")
    public WebElement denmark;
    @FindBy(id = "box105")
    public WebElement southKorea;
    @FindBy(id = "box106")
    public WebElement italy;
    @FindBy(id = "box107")
    public WebElement spain;
}
