import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils extends BasePage {
    public static String currentDateTime(){
        DateFormat dateFormat=new SimpleDateFormat("yyyyMMddHHMMSS");
        Date date=new Date();
        String date1=dateFormat.format(date);
        System.out.println("Current date and time is "+date1);
        return date1;
    }

    public static void clickElement(By by){
        driver.findElement(by).click();
    }

    public static void enterText (By by, String text){
        driver.findElement(by).sendKeys(text);
    }

    public static void selectElementByVisibleText (By by, String text){
        Select select=new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }

    public static void selectElementByIndex(By by, int index){
        Select select=new Select(driver.findElement(by));
        select.selectByIndex(index);
    }

    public static void selectElementByValue(By by, String value){
        Select select=new Select(driver.findElement(by));
        select.selectByValue(value);
    }

    public static String getTxt(By by, String textContainer){
        String captureText=driver.findElement(by).getText();
        return captureText;
    }

    public static void waitForVisibleElement(By by,int time){
        WebDriverWait wait=new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
