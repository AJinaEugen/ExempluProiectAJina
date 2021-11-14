package BaseClass;

import HelperClass.ElementInteraction;
import HelperClass.RetryRule;
import ObjectModelClass.HomePage;
import ObjectModelClass.ItemPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.sun.net.httpserver.Authenticator;
import com.sun.org.glassfish.gmbal.Description;
import org.junit.*;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDate;

public class Base {

    public WebDriver driver;
    static public ExtentReports report;
    static public ExtentTest  test;
    public ElementInteraction interact;


    @Rule public TestName name= new TestName();
//    @Rule public RetryRule retryRule = new RetryRule(1);


    @BeforeClass
    static public void reportBuildUP(){
        LocalDate date = LocalDate.now();
        report = new ExtentReports(date + "QAReport.html",true);
    }

    @AfterClass
    static public void reportFlush(){
       report.flush();
    }


    @Before
    public void setUp(){
        interact= new ElementInteraction(driver,test);
        test = report.startTest(name.getMethodName());
        test.assignAuthor("Jina Alexandru");

        System.setProperty("webdriver.chrome.driver","C:\\Automation\\Chrome driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://practice.automationtesting.in/");
        driver.navigate().to("http://practice.automationtesting.in/");

        Assert.assertEquals("Pagina incorecta - check title", "Automation Practice Site",driver.getTitle());

    }

    @After
    public void tearDown(){
        report.endTest(test);
        driver.close();
        driver.quit();
    }

}
