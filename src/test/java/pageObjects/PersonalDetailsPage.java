package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalDetailsPage extends BasePage {
    public PersonalDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement txtFirstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement txtLastName;

    @FindBy(xpath = "//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//button[@type='submit'][normalize-space()='Save']")
    WebElement btnSave;

    @FindBy(xpath = "//div[@class='oxd-toast oxd-toast--success oxd-toast-container--toast']")
    WebElement msgSuccess;

    public void setFirstName(String firstname) {
        txtFirstName.sendKeys(Keys.COMMAND + "a");
        txtFirstName.sendKeys(Keys.DELETE);
        txtFirstName.sendKeys(firstname);
    }

    public void setLastName(String lastname) {
        txtLastName.sendKeys(Keys.COMMAND + "a");
        txtLastName.sendKeys(Keys.DELETE);
        txtLastName.sendKeys(lastname);
    }

    public void clickSave() {
        btnSave.click();
    }

    public boolean isSuccessMsgAppears() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            return wait.until(ExpectedConditions.visibilityOf(msgSuccess)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
