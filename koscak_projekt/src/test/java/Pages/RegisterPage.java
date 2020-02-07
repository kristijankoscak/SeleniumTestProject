package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    WebDriver driver = null;

    //--- Declaring driver instance using constructor
    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    //--- Declaring elements

    By btn_register = By.id("join-form-submit");
    By text_error = By.className("alert-content");
    By input_email = By.name("email-address");
    By input_password = By.xpath("//*[@id=\"password\"]");

    //--- Declaring methods

    public void SubmitRegister (){

        driver.findElement(btn_register).submit();
    }
    public String GetErrorMessage (){

        return driver.findElement(text_error).getText();
    }
    public void EnterEmailAndPassword(String email,String password){
        driver.findElement(input_email).sendKeys(email);
        driver.findElement(input_password).sendKeys(password);
    }
}
