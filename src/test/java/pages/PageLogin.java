package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class PageLogin {
    private WebDriver driver;
    private By userfield;
    private By passfield;
    private By loginbtn;



    public PageLogin(WebDriver driver){
        this.driver = driver;
        this.userfield = By.name("userName");
        this.passfield = By.name("password");
        this.loginbtn = By.name("login");
    }

    public void login(String user,String pass){
        driver.findElement(userfield).sendKeys(user);
        driver.findElement(passfield).sendKeys(pass);
        driver.findElement(loginbtn).click();
       // Helpers helper = new Helpers();
       // helper.sleepSeconds(3);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
