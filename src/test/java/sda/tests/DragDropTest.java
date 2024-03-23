package sda.tests;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.pages.Practice.DragDropPage;
import sda.utilities.ConfigReader;
import sda.utilities.Driver;

public class DragDropTest {

    @Test
    public void testDragAndDrop() {
        DragDropPage dragDropPage = new DragDropPage();
        Actions action = new Actions(Driver.getDriver());
        Driver.getDriver().get(ConfigReader.getProperty("draganaddrop"));
        action.dragAndDrop(dragDropPage.oslo, dragDropPage.norway).perform();
        action.dragAndDrop(dragDropPage.stockholm, dragDropPage.sweden).perform();
        action.dragAndDrop(dragDropPage.washington, dragDropPage.unitedStates).perform();
        action.dragAndDrop(dragDropPage.copenhagen, dragDropPage.denmark).perform();
        action.dragAndDrop(dragDropPage.seoul, dragDropPage.southKorea).perform();
        action.dragAndDrop(dragDropPage.rome, dragDropPage.italy).perform();
        action.dragAndDrop(dragDropPage.madrid, dragDropPage.spain).perform();
        // Assert that the Y coordinate of Madrid is greater than or equal to the top Y coordinate of Spain
        WebElement madridAfterDrop = dragDropPage.madrid;
        Point madridLocation = madridAfterDrop.getLocation();
        Point spainLocation = dragDropPage.spain.getLocation();
        Assert.assertTrue(madridLocation.getY() >= spainLocation.getY(), "Madrid was not dropped in Spain.");
    }


    }

