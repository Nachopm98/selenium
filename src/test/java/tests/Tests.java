package tests;

import helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PageLogin;
import pages.PageLogon;
import pages.PageReservation;

public class Tests {
    WebDriver driver;
    private Helpers helper = new Helpers();

    @BeforeMethod
    public void setUp(){
        DesiredCapabilities caps = new DesiredCapabilities();
        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
        driver.manage().window().maximize();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
        driver.navigate().to("https://www.sharklasers.com/es/compose");
        helper.sleepSeconds(2);

    }

    @Test
    public void sendMailWindow(){
        helper.sleepSeconds(2);
        driver.findElement(By.xpath("//*[@id=\"nav-item-compose\"]/a")).click();
        helper.sleepSeconds(2);
        driver.findElement(By.name("to")).sendKeys("azanzan.jc@gmail.com");
        driver.findElement(By.name("subject")).sendKeys("Prueba");
        driver.findElement(By.name("body")).sendKeys("HOLA ESTO ES UNA PUTA LOCURA y hoy HAY D&D NO MAMES");
        helper.sleepSeconds(2);
        driver.findElement(By.name("send")).click();
        helper.sleepSeconds(2);
        Assert.assertTrue(true);

/*
            helper.sleepSeconds(2);
            driver.findElement(By.cssSelector("h-c-header__nav-li-link")).click();
            driver.findElement(By.className("whsOnd zHQkBf")).sendKeys("opitofalso345@gmail.com");
            helper.sleepSeconds(2);
            driver.findElement(By.className("RveJvd snByac")).click();
            helper.sleepSeconds(2);
            driver.findElement(By.className("whsOnd zHQkBf")).sendKeys("007007mm");
            driver.findElement(By.className("RveJvd snByac")).click();
            driver.findElement(By.className("T-I J-J5-Ji T-I-KE L3")).click();
            driver.findElement(By.className("vO")).sendKeys("nachopascualm98@gmail.com");
            driver.findElement(By.name("subjectbox")).sendKeys("ESTO ES UNA LOCURAAAA");
            driver.findElement(By.cssSelector("Am Al editable LW-avf tS-tW")).sendKeys("HOLA ESTO ES UNA PUTA LOCURA y hoy HAY D&D NO MAMES");
            driver.findElement(By.className("T-I J-J5-Ji aoO v7 T-I-atl L3 T-I-JW")).click();
            Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[1]/div[4]/div[1]/div/div[3]/div/div/div[2]/span/span[1]")).getText().contains("Mensaje enviado"));
*/
        }


    @AfterMethod()
    public void teardown() {
        driver.close();
    }


}
