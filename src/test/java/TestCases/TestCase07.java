package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils2.BrowserFactory;
import utils2.BrowserUtils;

/*
Step 1. Go to https://practice-cybertekschool.herokuapp.com
2. Click on “Registration Form”
Step 3. Enter “testers@email” into email input box.
Step 4. Verify that warning message is displayed: “email address is not a validEmail format is not correct”
 */
public class TestCase07 {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//a [@href=\"/registration_form\"]")).click();
        driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("testers@email");
        BrowserUtils.wait(3);
        WebElement errorm1=driver.findElement(By.xpath("//small[starts-with(text(), 'email address is n')]"));
        WebElement errorm2=driver.findElement(By.xpath("//small[starts-with(text(), 'Email format')]"));
        String expectedResult1="email address is not a valid";
        String expectedResult2="Email format is not correct";
        String actualResult=errorm1.getText();
        String actualResult2=errorm2.getText();
        if(expectedResult1.equals(actualResult)){
            if(expectedResult2.equals(actualResult2)){
                System.out.println("Test Passed");
            }else{
                System.out.println("Test failed ");
            }
            driver.quit();
        }

    }
}
