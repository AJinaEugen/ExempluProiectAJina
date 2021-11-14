package ObjectModelClass;

import HelperClass.ElementInteraction;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

        public WebDriver driver;
        public ElementInteraction interact;
        public ExtentTest test;


    public HomePage (WebDriver driver, ExtentTest test){
        this.driver=driver;
        this.test=test;
        PageFactory.initElements(driver,this);

        interact = new ElementInteraction(driver,test);

    }

    @FindBy(css=".menu-item")
    public List<WebElement> menuitems;
    @FindBy(css="#content > nav > a")
    public WebElement home;
    @FindBy(css="div[class='woocommerce']")
    public List<WebElement> Arrivals;




    public HomePage clickOnShopMenu(){

        interact.clickElement(menuitems.get(0), "Menu button");
        return this;
    }

    public HomePage clickOnHomeMenu(){
        interact.clickElement(home,"Home button");
        return this;
    }

    public ItemPage clickOnArrival(int i){
        interact.clickElement(Arrivals.get(i),"Arrival button");
        return new ItemPage(driver,test);
    }



}
