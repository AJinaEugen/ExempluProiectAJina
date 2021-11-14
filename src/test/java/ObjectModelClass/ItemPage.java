package ObjectModelClass;
import HelperClass.ElementInteraction;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ItemPage {

    public WebDriver driver;
    public ElementInteraction interact;
    public ExtentTest test;


    public ItemPage (WebDriver driver,ExtentTest test){
        this.driver=driver;
        this.test=test;
        interact = new ElementInteraction(driver,test);
        PageFactory.initElements(driver,this);
    }

    @FindBy(css=".single_add_to_cart_button.button.alt")
    private WebElement addToBasketElement;

    @FindBy(css=".menu-item")
    public List<WebElement> menuitems;

    public void clickOnAddtoBasket(){
        interact.clickElement(addToBasketElement,"Add to basket");

    }


}
