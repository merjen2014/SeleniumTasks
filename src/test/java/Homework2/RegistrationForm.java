package Homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class RegistrationForm {
    private WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();

    }
       @Test(description="Verify that DOB error message is displayed")
    public void testCase1(){
        driver.findElement(By.name("birthday")).sendKeys("wrong_dob");
           BrowserUtils.wait(1);
           String expectedResult="The date of birth is not valid";
           String actualResult=driver.findElement(By.xpath("//small[@style='display: block;']")).getText();
           Assert.assertEquals(actualResult,expectedResult,"Error message is not displayed");

       }
       @Test(description = "Verify that c++. java and Javascript is displayed")
       public void testCase2(){
     WebElement cPlusPlus=driver.findElement(By.xpath("//label[@for='inlineCheckbox1']"));
     WebElement Java=driver.findElement(By.xpath("//label[@for='inlineCheckbox2']"));
     WebElement js=driver.findElement(By.xpath("//label[@for='inlineCheckbox3']"));
           Assert.assertTrue(cPlusPlus.isDisplayed(),"C++ is not displayed");
           Assert.assertTrue(Java.isDisplayed(), "Java is not displayed");
           Assert.assertTrue(js.isDisplayed(), "JavaScript is not displayed");
       }

@Test(description = "Verify that invalid input to first name box gives error message")
public void testCase3(){
        driver.findElement(By.name("firstname")).sendKeys("a");
        BrowserUtils.wait(2);
    String expectedResult = "first name must be more than 2 and less than 64 characters long";
    String actualResult = driver.findElement(By.xpath("//small[text( )='first name must be more than 2 and less than 64 characters long']")).getText();
    WebElement errorMessage = driver.findElement(By.xpath("//small[text( )='first name must be more than 2 and less than 64 characters long']"));
    Assert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed");
    Assert.assertEquals(actualResult, expectedResult, "Warning Message is not correct");
}
    @Test(description = "Verify that invalid input to last name box gives error message")
    public void testCase4() {
        String expectedResult = "The last name must be more than 2 and less than 64 characters long";
        driver.findElement(By.name("lastname")).sendKeys("a");
        BrowserUtils.wait(1);
        String actualResult = driver.findElement(By.xpath("//small[text( )='The last name must be more than 2 and less than 64 characters long']")).getText();
        WebElement errorMessage = driver.findElement(By.xpath("//small[text( )='The last name must be more than 2 and less than 64 characters long']"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed");
        Assert.assertEquals(actualResult, expectedResult, "Warning Message is not correct");

    }

    @Test(description = "Verify that after successful sign up verification message is displayed")
    public void testCase5(){
        driver.findElement(By.name("firstname")).sendKeys("Will");
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        driver.findElement(By.name("username")).sendKeys("WSmith");
        driver.findElement(By.name("email")).sendKeys("dronaghan8v@google.ca");
        driver.findElement(By.name("password")).sendKeys("dronaghan");
        driver.findElement(By.name("phone")).sendKeys("333-444-5566");
        driver.findElement(By.cssSelector("input[value='male']")).click();
        driver.findElement(By.cssSelector("input[name='birthday']")).sendKeys("01/05/1992");
        driver.findElement(By.cssSelector("[id='inlineCheckbox2']")).click();
        Select department = new Select(driver.findElement(By.name("department")));
        department.selectByValue("TO");
        Select job= new Select(driver.findElement(By.name("job_title")));
        job.selectByVisibleText("Manager");
        driver.findElement(By.cssSelector("label[for='inlineCheckbox2']")).click();

        driver.findElement(By.id("wooden_spoon")).click();
        BrowserUtils.wait(2);
        String expectedResult = "You've successfully completed registration!";
        String actualResult = driver.findElement(By.xpath("//p[contains(text(),'You')]")).getText();
        WebElement verificationMessage = driver.findElement(By.xpath("//p[contains(text(),'You')]"));
        Assert.assertTrue(verificationMessage.isDisplayed(), "Message is not displayed");
        Assert.assertEquals(actualResult, expectedResult, "Verification message is not displayed properly");
    }
    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
