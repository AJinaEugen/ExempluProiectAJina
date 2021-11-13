package ObjectModelClass;

import HelperClass.ElementInteraction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ItemPage {

    public WebDriver driver;
    public ElementInteraction interact;

    public ItemPage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        interact = new ElementInteraction(driver);
    }

    @FindBy(css=".single_add_to_cart_button.button.alt")
    private WebElement addToBasketElement;

    @FindBy(css=".menu-item")
    public List<WebElement> menuitems;

    public void clickOnAddtoBasket(){
        interact.clickElement(addToBasketElement);
    }


}
