package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    static public WebDriver driver;
    public Properties p;


    @BeforeClass
    public void setup() throws IOException {

        FileReader propertiesFile = new FileReader("./src/test/resources/config.properties");
        p = new Properties();
        p.load(propertiesFile);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get(p.getProperty("appUrl"));


    }

}
