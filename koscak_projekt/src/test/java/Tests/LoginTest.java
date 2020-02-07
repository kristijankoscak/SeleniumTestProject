package Tests;

import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    //-----------------------------------Global Variables-----------------------------------
    //Declare a Webdriver variable
    public WebDriver driver;
    //Declare a test URL variable
    public String testURL = "https://www.linkedin.com/login?fromSignIn=true&trk=guest_homepage-basic_nav-header-signin";
    //Declare RegisterPage object (POM)
    LoginPage loginPage;

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
        //Initialize LoginPage object
        loginPage = new LoginPage(driver);
    }

    @Test
    public void LoginWithValidPhoneNumber() throws InterruptedException {
        loginPage.EnterUsernameAndPassword("0923286134", "Test123test");
        loginPage.SubmitLogin();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        loginPage.TriggerDropDown();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        loginPage.SubmitLogOff();
        //-- Note: If he user can log off then login is correct.
    }
    @Test
    public void LoginWithInvalidPhoneNumber() throws InterruptedException {
        loginPage.EnterUsernameAndPassword("1242ab?13aaa21241", "Test123test");
        loginPage.SubmitLogin();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        Assert.assertEquals(loginPage.GetEmailErrorMessage().isEmpty(),false );
        //-- Note: Error message is expected.
    }
    @Test
    public void LoginWithInvalidPassword() throws InterruptedException {
        loginPage.EnterUsernameAndPassword("kristijan.koscak16@gmail.com", "test123");
        loginPage.SubmitLogin();
        Thread.sleep(3000);
        Assert.assertEquals(loginPage.GetPasswordErrorMessage().isEmpty(),false );
        //-- Note: Error message is expected.
    }
    @Test
    public void LoginWithValidEmailAndPassword() throws InterruptedException {
        loginPage.EnterUsernameAndPassword("kristijan.koscak16@gmail.com", "Test123test");
        loginPage.SubmitLogin();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        loginPage.TriggerDropDown();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        loginPage.SubmitLogOff();
        //-- Note: If he user can log off then login is correct.
    }

    @AfterMethod
    public void teardownTest() {
        //Close browser and end the session
        driver.quit();
    }

}


