package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestCase05 {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement RegForm = driver.findElement(By.linkText("Registration Form"));
        RegForm.click();
        WebElement LastName= driver.findElement(By.name("lastname"));
        LastName.sendKeys("123");
        BrowserUtils.wait(2);
        WebElement errorMes=driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[2]/div/small[3]"));
        String expectedResult= "The last name can only consist of alphabetical letters and dash";
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
