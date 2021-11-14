package TestClass;

import BaseClass.Base;
import ObjectModelClass.HomePage;
import ObjectModelClass.ItemPage;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.Assert;
import org.junit.Test;

public class HomePageTests extends Base {

    public HomePage homePage;
    public ItemPage itemPage;

/*1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
3) Click on Shop Menu
4) Now click on Home menu button
5) Test whether the Home page has Three Arrivals only
6) The Home page must contains only three Arrivals
7) Now click the image in the Arrivals
8) Test whether it is navigating to next page where the user can add that book into his basket.
9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
10) Click on the Add To Basket button which adds that book to your basket
11) User can view that Book in the Menu item with price.
12) User can add a book by clicking on Add To Basket button which adds that book in to his Basket
 */

@Test
public void HomePageTest6(){
    homePage = new HomePage(driver,test);
    itemPage = new ItemPage(driver,test);

    test.log(LogStatus.INFO,"Home Page - Arrivals - Images - Add to Basket");
    homePage.clickOnShopMenu();
    homePage.clickOnHomeMenu();
    homePage.clickOnArrival(0);
    itemPage.clickOnAddtoBasket();

}


}
