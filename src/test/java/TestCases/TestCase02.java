package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils2.BrowserFactory;
import utils2.StringUtil;

public class TestCase02 {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get(" https://practice-cybertekschool.herokuapp.com");
        int expectedResult=48;
        int actualResult = driver.findElements(By.className("list-group-item")).size();
        System.out.println("Expected result "+expectedResult);
        System.out.println("Actual result "+actualResult);
        StringUtil.VerifyEquals(expectedResult,actualResult);
        driver.close();


    }
}
