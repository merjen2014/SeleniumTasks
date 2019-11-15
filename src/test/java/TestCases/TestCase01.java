package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils2.BrowserFactory;
import utils2.StringUtil;

public class TestCase01 {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get(" https://practice-cybertekschool.herokuapp.com");


        WebElement Signup= driver.findElement(By.linkText("Sign Up For Mailing List"));
        Signup.click();
        WebElement fullname= driver.findElement(By.name("full_name"));
        fullname.sendKeys("anyName");
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("m.rejepowa1988@gmail.com");
        WebElement signupButton= driver.findElement(By.name("wooden_spoon"));
        signupButton.click();
        String expectedRes1 = "Thank you for signing up. Click the button below to return to the home page.";
        String expectedRes2 = "Home";

        WebElement message=driver.findElement(By.name("signup_message"));
        String actualResult01=message.getText();
        WebElement homeButton = driver.findElement(By.id("wooden_spoon"));
        String actualResult02=homeButton.getText();
        System.out.println("First verification");
        StringUtil.VerifyEquals(expectedRes1,actualResult01);
        System.out.println("second verification");
        StringUtil.VerifyEquals(expectedRes2,actualResult02);
        driver.close();
    }
}
