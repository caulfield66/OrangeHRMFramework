package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    static public WebDriver driver;
    public Properties p;


    @BeforeClass
    @Parameters({"os", "browser"})
    public void setup(String os, String browser) throws IOException {

        FileReader propertiesFile = new FileReader("./src/test/resources/config.properties");
        p = new Properties();
        p.load(propertiesFile);

        switch (browser.toLowerCase()){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
            default:
                System.out.println("No such browser");
                return;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get(p.getProperty("appUrl"));


    }


    @AfterClass
    public void teardown(){
        driver.close();
    }

}
