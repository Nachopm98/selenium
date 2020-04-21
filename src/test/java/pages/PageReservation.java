package pages;

import helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PageReservation {
    private WebDriver driver;
    private By titleText;
    private By toDrop;
    private By passengersdrop;
    private By fromDrop;

    public PageReservation(WebDriver driver) {
        this.fromDrop = By.name("fromPort");
        this.driver = driver;
        this.passengersdrop = By.name("passCount");
        this.titleText = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[1]/td/font/font/b/font/font");
        this.toDrop = By.name("toPort");
    }

    public void assertReservationPage(){
        Assert.assertTrue(driver.findElement(titleText).getText().contains("Flight Details"));
    }

    public void selectPassagers(int cant){
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement cantidadPasajeros = wait.until(ExpectedConditions.presenceOfElementLocated(passengersdrop));
        Select selectasajeros = new Select(cantidadPasajeros);
        selectasajeros.selectByVisibleText(Integer.toString(cant));
    }

    public void selectFromPort(int index){
        Select selectFrom = new Select(driver.findElement(fromDrop));
        selectFrom.selectByIndex(index);
    }

    public void selectToPort(String city){
        Select selectTo = new Select(driver.findElement(toDrop));
        selectTo.selectByValue(city);
        Helpers helpers = new Helpers();
        helpers.sleepSeconds(3);
    }
}
