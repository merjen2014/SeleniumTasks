package com.cbt;

import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class NavigationTests {
    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://google.com");

        String expected = driver.getTitle();

        driver.navigate().to("https://etsy.com");
        String expected2 = driver.getTitle();
        driver.navigate().back();

        String actual = driver.getTitle();

        if (actual.equals(expected)) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        driver.navigate().forward();
        String actual2 = driver.getTitle();

        if (actual2.equals(expected2)) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }


        driver.close();
    }
}