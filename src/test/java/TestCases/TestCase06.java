package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.BrowserFactory;
import utils.BrowserUtils;

//Test case #6 Step 1. Go to https://practice-cybertekschool.herokuapp.com
// 2. Click on “Registration Form”Step
// 3. Enter “user” into username input box.Step
// 4. Verify that warning message is displayed:
// “The username must be more than 6 and less than 30 characters long”
public class TestCase06 {

    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//a [@href=\"/registration_form\"]")).click();
        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("user");
        BrowserUtils.wait(2);
        WebElement errorMessage= driver.findElement(By.xpath("//small[@data-bv-result=\"INVALID\"]"));
        String expectedResult = "The username must be more than 6 and less than 30 characters long";
         String actualResult=errorMessage.getText();
Assert.assertEquals(expectedResult,actualResult,"title is wrong");
driver.close();

    }
}
