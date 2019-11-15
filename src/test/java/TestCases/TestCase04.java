package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils2.BrowserFactory;
import utils2.BrowserUtilsTime;

/*
Test case #4 Step 1. Go to https://practice-cybertekschool.herokuapp.comStep
2. Click on “Registration Form”Step
3. Enter “123” into first name input box.
Step 4. Verify that warning message is displayed: “first name can only consist of alphabetical letters”
 */
public class TestCase04 {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");

        WebElement RegForm = driver.findElement(By.linkText("Registration Form"));
        RegForm.click();
WebElement firstName= driver.findElement(By.name("firstname"));
firstName.sendKeys("123");
        BrowserUtilsTime.wait(3);
WebElement errorMes = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[1]/div/small[3]"));
        String expectedResult ="first name can only consist of alphabetical letters";
        String actualResult = errorMes.getText();
        if(actualResult.equalsIgnoreCase(expectedResult)){
            System.out.println("test passed");
        }
        else{
            System.out.println("test failed");
        }

        driver.quit();

    }
}
