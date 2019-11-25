package TestCases;
import utils.BrowserFactory;
import utils.StringUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class TestCase03 {
    public static void main(String[] args) {
        chromeTest();
        fireFoxTest();
    }
    public static void chromeTest(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        String expectedResult ="Clicked on button one!";

        driver.findElement(By.linkText("Multiple Buttons")).click();
        driver.findElement(By.tagName("button")).click();
        String actualResult = driver.findElement(By.id("result")).getText();

        System.out.println("Expected Result: " + expectedResult);
        System.out.println("Actual Result: " + actualResult);
        StringUtil.VerifyEquals(expectedResult,actualResult);

        driver.close();
    }

    public static void fireFoxTest(){
        WebDriver driver = BrowserFactory.getDriver("firefox");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        String expectedResult ="Clicked on button one!";

        driver.findElement(By.linkText("Multiple Buttons")).click();
        driver.findElement(By.tagName("button")).click();
        String actualResult = driver.findElement(By.id("result")).getText();

        System.out.println("Expected Result: " + expectedResult);
        System.out.println("Actual Result: " + actualResult);
        StringUtil.VerifyEquals(expectedResult,actualResult);

        driver.close();
    }

    public static void edgeTest(){
        WebDriver driver = BrowserFactory.getDriver("edge");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        String expectedResult ="Clicked on button one!";

        driver.findElement(By.linkText("Multiple Buttons")).click();
        driver.findElement(By.tagName("button")).click();
        String actualResult = driver.findElement(By.id("result")).getText();

        System.out.println("Expected Result: " + expectedResult);
        System.out.println("Actual Result: " + actualResult);
        StringUtil.VerifyEquals(expectedResult,actualResult);

        driver.close();
    }
}
