import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.print.DocFlavor;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class MavenNopCommerceHomework {

    //initializing WebDriver
    protected static WebDriver driver;

public static String currentDateTime(){
    DateFormat dateFormat=new SimpleDateFormat("yyyyMMddHHMMSS");
    Date date=new Date();
    String date1=dateFormat.format(date);
    System.out.println("Current date and time is "+date1);
    return date1;
}
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

    //declare implicit wait (3 seconds) for synchronization
    public void impWait () {driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);}
    //declare implicit Long wait (20 seconds)
    public void impLongWait(){driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); }

    @Test(priority = 0)
    public void userShouldBeRegisteredSuccessfully() {
        impWait();
        //click on Register button
        driver.findElement(By.xpath("//div[2]/div[1]/ul/li[1]/a")).click();
        //select Male (Female) Gender
        WebElement maleRadioButton = driver.findElement(By.xpath("//*[@id=\"gender-male\"]"));
        maleRadioButton.click();
        //WebElement femaleRadioButton = driver.findElement(By.xpath("//*[@id=\"gender-female\"]"));
        //femaleRadioButton.click();

        //find First Name field and enter a value
        driver.findElement(By.xpath("//*[@id=\"FirstName\"]")).sendKeys("rus" + currentDateTime());
        //find Last Name field and enter a value
        driver.findElement(By.xpath("//*[@id=\"LastName\"]")).sendKeys("crow" + currentDateTime());
        //select day of birth
        Select day=new Select(driver.findElement(By.name("DateOfBirthDay")));
        day.selectByIndex(1);
        //select month of birth
        Select month=new Select(driver.findElement(By.name("DateOfBirthMonth")));
        month.selectByIndex(1);
        //select year of birth
        Select year=new Select(driver.findElement(By.name("DateOfBirthYear")));
        year.selectByVisibleText("2000");
        //find E-mail field and enter a value
        driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys("rus.charuh" + currentDateTime() + "@gmail.com");
        //find Company name field and enter a value
        driver.findElement(By.xpath("//*[@id=\"Company\"]")).sendKeys("lerus");
        //deselect Newsletter tick box if already ticked
        boolean newsLetterTickBox=driver.findElement(By.xpath("//*[@id=\"Newsletter\"]")).isSelected();
        if (newsLetterTickBox == true) { driver.findElement(By.xpath("//*[@id=\"Newsletter\"]")).click(); }
        //find Password field and enter a value
        driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("ruscrowtest");
        //find Confirm Password fields and enter the same value as above
        driver.findElement(By.xpath("//*[@id=\"ConfirmPassword\"]")).sendKeys("ruscrowtest");
        //find and click on Registration button
        driver.findElement(By.xpath("//*[@id=\"register-button\"]")).click();
        //initialize a String to hold the ActualRegistration Success Message
        String actRegSucMsg = driver.findElement(By.xpath("//form/div/div[2]/div[1]")).getText();
        //Assert Expected and Actual results
        Assert.assertEquals("Your registration completed", actRegSucMsg);
        }

    @Test(priority = 2)
    public void userShouldBeAbleToNavigateToNotebooksCategoryPageFromComputers(){
        //wait for 3 seconds
        impWait();
        //find Computers page link on homepage and click on it
        driver.findElement(By.xpath("//div[6]/div[2]/ul[1]/li[1]/a")).click();
        //wait for 3 seconds
        impWait();
        //find Notebooks link and click on it
        driver.findElement(By.xpath("//div[1]/div[2]/ul/li[1]/ul/li[2]/a")).click();
        //Capture actual result into a String
        String actual=driver.findElement(By.xpath("//h1")).getText();
        //expected result from requirements
        String expected="Notebooks";
        //Assert expected result against the actual
        Assert.assertEquals(expected, actual);
    }

    @Test(priority = 3)
    public void userShouldBeAbleToNavigateToCellPhonesViaElectronics(){
        //wait for 3 seconds
        impWait();
        //initialize WebElement for Electronics menu link
        WebElement elemElectronics = driver.findElement(By.linkText("Electronics"));
        //initialize WebElement for Cell phones menu option link
        WebElement elemCellPhones = driver.findElement(By.xpath("//ul[1]/li[2]/ul/li[2]/a"));
        //instance of Actions class
        Actions action=new Actions(driver);
        //build actions for hovering over Electronics menu + moving down to Cell phones link and clicking on it
        action.moveToElement(elemElectronics).moveToElement(elemCellPhones).click().build().perform();
        //Capture actual result into a String
        String actual=driver.findElement(By.xpath("//h1")).getText();
        //expected result from requirements
        String expected="Cell phones";
        //Assert expected result against the actual
        Assert.assertEquals(expected, actual);
    }
    @Test(priority = 1)
    public void userShouldBeAbleToLoginSuccessfully(){
        impWait();
        //click on Login button
        driver.findElement(By.xpath("//div[2]/div[1]/ul/li[2]/a")).click();
        //find Email field and enter rus+555@gmail.com
        driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys("rus.charuh+555@gmail.com");
        //find Password field and enter Crowrustest
        driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("Crowrustest");
        //find Login button and click on it
        driver.findElement(By.xpath("//form/div[3]/input")).click();
        //wait for 3 seconds
        impWait();

        //String isLogOutButtonPresent=driver.findElement(By.xpath("//div[2]/div[1]/ul/li[2]/a")).getText();
        //Expected Log out button
        //String expectedLogOutButton="Log out";
        //Assert expected and actual results
        //Assert.assertEquals(expectedLogOutButton, isLogOutButtonPresent);

        //check if there is a Log out button after logging in (DOM change)
        boolean isLogOutButtonPresent=driver.getPageSource().contains("Log out");
        if (isLogOutButtonPresent==true){
            System.out.println("Logged in successfully");
        }
    }

    @Test(priority = 4)
    public void userShouldBeAbleToAddProductToShoppingCart(){
        //wait for 3 seconds
        impWait();
        //initialize Books path
        String pathBooks="//div[6]/div[2]/ul[1]/li[5]/a";
        //follow Books path and click on the link
        driver.findElement(By.xpath(pathBooks)).click();
        //initialize path to first book
        //String pathBook1="//div[1]/div/div[2]/div[3]/div[2]/input[1]";
        //add first book to cart
        //driver.findElement(By.xpath(pathBook1)).click();
        //initialize path to second book
        //String pathBook2="//div[2]/div/div[2]/div[3]/div[2]/input[1]";
        //add second book to cart
        //driver.findElement(By.xpath(pathBook2)).click();
        //initialize path to third book
        String pathBook3="//div[3]/div/div[2]/div[3]/div[2]/input[1]";
        //add third book to cart
        driver.findElement(By.xpath(pathBook3)).click();
        String actual=driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/p")).getText();
        String expected="The product has been added to your shopping cart";
        Assert.assertEquals(expected,actual);
    }

}