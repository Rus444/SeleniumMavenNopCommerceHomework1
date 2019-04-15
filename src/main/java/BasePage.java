import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BasePage {
    protected static WebDriver driver;

    @BeforeMethod
    public void setUp(){
        //setting up WebDriver
        System.setProperty("webdriver.chrome.driver","src/test/BrowserDrivers/chromedriver.exe");
        driver=new ChromeDriver();
        //declare implicit wait to driver instance
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        //tell driver to fetch url
        driver.get("https://demo.nopcommerce.com/");
        //maximize browser window size
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown (){driver.close(); }
}
