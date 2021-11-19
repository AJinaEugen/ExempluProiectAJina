package HelperClass;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ElementInteraction {

    public WebDriver driver;
    public ExtentTest test;

    public ElementInteraction (WebDriver driver,ExtentTest test){
        this.driver=driver;
        this.test=test;
    }



    public void clickElement(WebElement element, String elementTxt){
            waitUntillElementVisible(element);
            element.click();
            test.log(LogStatus.PASS,"Clicked on "+elementTxt);
    }

    public void sendText(String text, WebElement element){
        waitUntillElementVisible(element);
        element.sendKeys(text);
    }

    public String gatherText(WebElement element){
        waitUntillElementVisible(element);
        return element.getText();
    }

    public void hoverElement(WebElement element){
        waitUntillElementVisible(element);
        Actions hover = new Actions(driver);
        hover.moveToElement(element).build().perform();
    }

    public void validateElementMessage( String errordesciption, String expectederrormessage, WebElement element) {
        waitUntillElementVisible(element);
        String actualerrormessage  =element.getText();
        Assert.assertEquals( errordesciption,expectederrormessage,actualerrormessage );
    }

    public void selectElementbytxt(WebElement element, String value) {
        waitUntillElementVisible(element);
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    public void selectElementbyvalue(WebElement element, String value) {
        waitUntillElementVisible(element);
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public  void forceWait(){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void assertText(WebElement element, String expected){
       try {
           waitUntillElementVisible(element);
           Assert.assertEquals("Actual text does not match expected text" + element.getText() + " != " + expected, expected, element.getText());
           test.log(LogStatus.PASS, "The correct elements are displayed");
       }
       catch(AssertionError e){
           test.log(LogStatus.FAIL, "Assertion failed");
       }

    }
    public void assertText(String element, String expected){

            Assert.assertEquals("Actual text does not match expected text"+element +" != "+ expected,expected,element);

    }







    public void waitUntillElementVisible(WebElement element){

        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntillElementVisible(List<WebElement> element, int numarElemente){

        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(element.get(numarElemente)));
    }

}
