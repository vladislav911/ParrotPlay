package SecondCase;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class LogginFirstPageRemote {

    static protected WebDriver driver;
    protected StringBuffer verificationErrors = new StringBuffer();
    private boolean acceptNextAlert = true;


    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "H:\\selenium tests\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(925, 985));
        driver.manage().window().setPosition(new Point(0,0));
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    @Test
    public void LogginToParrotplay1() throws Exception {
        driver.get("http://52.58.156.11:3000/?type=remote");
        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/app/login/div[1]/div/a/img")));
        Thread.sleep(2000);
        driver.findElement(By.id("username")).sendKeys("test2@gmail.com");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("te");
        driver.findElement(By.xpath("html/body/app/login/div[1]/div/div/form/button")).click();
        WebDriverWait wait2 = new WebDriverWait(driver, 30);
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='div-head-nav']")));
    }
}



