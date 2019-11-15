package utils2;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

    public static WebDriver getDriver(String browser){
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) { // for windows users only** if using mac than just return null;
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        }else if (browser.equalsIgnoreCase("safari")){
            // WebDriverManager.safaridriver().setup(); don't do this part!
            return null; // activate automation through settings
        }
        return null;
    }}
