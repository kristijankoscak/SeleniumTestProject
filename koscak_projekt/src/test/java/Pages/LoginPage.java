package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver = null;

    //--- Declaring driver instance using constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //--- Declaring elements

    By input_username = By.id("username") ;
    By input_password = By.name("session_password") ;
    By btn_singIn = By.xpath("//*[@id=\"app__container\"]/main/div/form/div[3]/button");
    By text_errorEmail = By.id("error-for-username");
    By text_errorPassword = By.id("error-for-password");
    By btn_dropDownMenu = By.id("nav-settings__dropdown-trigger");
    By btn_signOut = By.xpath("/html/body/header/div/nav/ul/li[6]/div/div/ul/li[5]/ul/li/a");

    //--- Declaring methods

    public void EnterUsernameAndPassword(String username, String password){
        driver.findElement(input_username).sendKeys(username);
        driver.findElement(input_password).sendKeys(password);
    }
    public void SubmitLogin(){
        driver.findElement(btn_singIn).click();
    }
    public String GetEmailErrorMessage (){
        return driver.findElement(text_errorEmail).getText();
    }
    public String GetPasswordErrorMessage (){
        return driver.findElement(text_errorPassword).getText();
    }
    public void TriggerDropDown(){
        driver.findElement(btn_dropDownMenu).click();
    }
    public void SubmitLogOff(){
        driver.findElement(btn_signOut).click();
    }
}
