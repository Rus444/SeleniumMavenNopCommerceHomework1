import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MavenNopCommerceHomework extends Utils {

 @Test
    public void userShouldBeRegisteredSuccessfully() {
        //click on Register button
        clickElement(By.xpath("//div[2]/div[1]/ul/li[1]/a"));
        //select Male (Female) Gender
        WebElement maleRadioButton = driver.findElement(By.xpath("//*[@id=\"gender-male\"]"));
        maleRadioButton.click();
        //WebElement femaleRadioButton = driver.findElement(By.xpath("//*[@id=\"gender-female\"]"));
        //femaleRadioButton.click();

        //find First Name field and enter a value
        enterText(By.xpath("//*[@id=\"FirstName\"]"),"rus" + currentDateTime());
        //find Last Name field and enter a value
        enterText(By.xpath("//*[@id=\"LastName\"]"),"crow" + currentDateTime());
        //select day of birth
        selectElementByIndex((By.name("DateOfBirthDay")), 1);
        //select month of birth
        selectElementByIndex((By.name("DateOfBirthMonth")), 1);
        //select year of birth
        selectElementByVisibleText((By.name("DateOfBirthYear")), "2000");
        //find E-mail field and enter a value
        enterText(By.xpath("//*[@id=\"Email\"]"),"rus.charuh"+currentDateTime()+"@gmail.com");
        //find Company name field and enter a value
        enterText(By.xpath("//*[@id=\"Company\"]"),"lerus");
        //deselect Newsletter tick box if already ticked
        boolean newsLetterTickBox=driver.findElement(By.xpath("//*[@id=\"Newsletter\"]")).isSelected();
        if (newsLetterTickBox == true){
            clickElement(By.xpath("//*[@id=\"Newsletter\"]"));}
        //find Password field and enter a value
        enterText(By.xpath("//*[@id=\"Password\"]"),"ruscrowtest");
        //find Confirm Password fields and enter the same value as above
        enterText(By.xpath("//*[@id=\"ConfirmPassword\"]"),"ruscrowtest");
        //find and click on Registration button
        clickElement(By.xpath("//*[@id=\"register-button\"]"));
        //initialize a String to hold the ActualRegistration Success Message
        //captureText(By.xpath("//form/div/div[2]/div[1]"));
        String actRegSucMsg = driver.findElement(By.xpath("//form/div/div[2]/div[1]")).getText();
        //Assert Expected and Actual results
        Assert.assertEquals("Your registration completed", actRegSucMsg);
        }

    @Test(priority = 2)
    public void userShouldBeAbleToNavigateToNotebooksCategoryPageFromComputers(){
        //find Computers page link on homepage and click on it
        clickElement(By.xpath("//div[6]/div[2]/ul[1]/li[1]/a"));
        //find Notebooks link and click on it
        clickElement(By.xpath("//div[1]/div[2]/ul/li[1]/ul/li[2]/a"));
        //Capture actual result into a String
        String actual=driver.findElement(By.xpath("//h1")).getText();
        //expected result from requirements
        String expected="Notebooks";
        //Assert expected result against the actual
        Assert.assertEquals(expected, actual);
    }

    @Test(priority = 3)
    public void userShouldBeAbleToNavigateToCellPhonesViaElectronics(){
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
        //click on Login button
        clickElement(By.xpath("//div[2]/div[1]/ul/li[2]/a"));
        //find Email field and enter rus+555@gmail.com
        enterText(By.xpath("//*[@id=\"Email\"]"),"rus.charuh+555@gmail.com");
        //find Password field and enter Crowrustest
        enterText(By.xpath("//*[@id=\"Password\"]"),"Crowrustest");
        //find Login button and click on it
        clickElement(By.xpath("//form/div[3]/input"));

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
        //initialize Books path
        String pathBooks="//div[6]/div[2]/ul[1]/li[5]/a";
        //follow Books path and click on the link
        clickElement(By.xpath(pathBooks));
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
        clickElement(By.xpath(pathBook3));
        String actual=driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/p")).getText();
        String expected="The product has been added to your shopping cart";
        Assert.assertEquals(expected,actual);
    }

}