package Tests;

import Pages.RegisterPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegisterTest {

    //-----------------------------------Global Variables-----------------------------------
    //Declare a Webdriver variable
    public WebDriver driver;
    //Declare a test URL variable
    public String testURL = "https://www.linkedin.com/signup/cold-join?trk=guest_homepage-basic_nav-header-join";
    //Declare RegisterPage object (POM)
    RegisterPage registerPage;


    //-----------------------------------Test Setup-----------------------------------
    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.operadriver().setup();
        WebDriverManager.edgedriver().setup();
        WebDriverManager.iedriver().setup();
    }
    @BeforeMethod
    public void setupTest() {

        //-------- Uncomment driver you want and comment ChromeDriver...
        //--- Google Chrome driver
        driver = new ChromeDriver();
        //--- Internet explorer driver
        //driver = new InternetExplorerDriver();
        //--- Opera driver
        //driver = new OperaDriver();
        //--- Firefox driver
        //driver = new FirefoxDriver();
        //--- Edge driver
        //driver = new EdgeDriver();

        //Go to www.swtestacademy.com
        driver.navigate().to(testURL);
        driver.manage().window().maximize();
        //Initialize RegisterPage object
        registerPage = new RegisterPage(driver);
    }

    @Test
    public void RegisterWithInvalidEmail() throws InterruptedException {
        registerPage.EnterEmailAndPassword(".com@gmail.kristijan", "xaxa1234");
        registerPage.SubmitRegister();
        driver.manage().timeouts().implicitlyWait(1500, TimeUnit.MILLISECONDS);
        Assert.assertEquals(registerPage.GetErrorMessage().isEmpty(), false);
        //-- Note: Error message is expected.
    }
    @Test
    public void RegisterWithShortPassword() throws InterruptedException {
        registerPage.EnterEmailAndPassword("kristijan.koscak16@gmail.com", "xaxa1");
        registerPage.SubmitRegister();
        driver.manage().timeouts().implicitlyWait(1500, TimeUnit.MILLISECONDS);
        Assert.assertEquals(registerPage.GetErrorMessage().isEmpty(), false);
        //-- Note: Error message is expected.
    }
    @Test
    public void RegisterWithLongPassword() throws InterruptedException {
        registerPage.EnterEmailAndPassword("kristijan.koscak16@gmail.com", "xaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxaxa143");
        registerPage.SubmitRegister();
        driver.manage().timeouts().implicitlyWait(1500, TimeUnit.MILLISECONDS);
        Assert.assertEquals(registerPage.GetErrorMessage().isEmpty(), false);
        //-- Note: Error message is expected.
    }
    @Test
    public void RegisterWithExistingEmail() throws InterruptedException {
        registerPage.EnterEmailAndPassword("kristijan.koscak16@gmail.com", "xaxa1234");
        registerPage.SubmitRegister();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        Assert.assertEquals(registerPage.GetErrorMessage().isEmpty(), false);
        //-- Note: Error message is expected.
    }
    @AfterMethod
    public void teardownTest() {
        //Close browser and end the session
        driver.quit();
    }
}
