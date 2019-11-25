package Homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class testCase7_FileUpload {
    /*
    Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
    Step 2. And click on “File Upload".
    Step 3. Upload any file with .txt extension from your computer.
    Step 4. Click “Upload” button.
    tep 5. Verify that subject is: “File Uploaded!”
    Step 6. Verify that uploaded file name is displayed.Note: use element.sendKeys(“/file/path”) with specifying path to the file for uploading. Run this method against “Choose File” button.
     */
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
    }
    @Test(description = "Verify that uploaded file name is displayed")
    public void testCase7(){
        driver.findElement(By.linkText("File Upload")).click();
        //path to the file
        driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\mreje\\Desktop\\ggggg.txt");
        driver.findElement(By.id("file-submit")).click();
        BrowserUtils.wait(3);
        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        String expectedFileName="ggggg.txt";
        Assert.assertEquals(actualFileName,expectedFileName);
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}

