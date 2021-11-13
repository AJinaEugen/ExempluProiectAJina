package ObjectModelClass;

import HelperClass.ElementInteraction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

        public WebDriver driver;
        public ElementInteraction interact;

    public HomePage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        interact = new ElementInteraction(driver);
    }

    @FindBy(css=".menu-item")
    public List<WebElement> menuitems;
    @FindBy(css="#content > nav > a")
    public WebElement home;
    @FindBy(css="div[class='woocommerce']")
    public List<WebElement> Arrivals;


    public void clickOnShopMenu(){
        interact.clickElement(menuitems.get(0));
    }

    public void clickOnHomeMenu(){
        interact.clickElement(home);
    }

    public ItemPage clickOnArrival(int i){
        interact.clickElement(Arrivals.get(i));
        return new ItemPage(driver);
    }

}
