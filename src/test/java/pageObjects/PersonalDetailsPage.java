package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PersonalDetailsPage extends BasePage {
    public PersonalDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement txtFirstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement txtLastName;

    @FindBy(xpath="//body/div[@id='app']/div[@class='oxd-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='orangehrm-card-container']/div[@class='orangehrm-edit-employee']/div[@class='orangehrm-edit-employee-content']/div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/form[@class='oxd-form']/div[@class='oxd-form-row']/div[2]/div[1]/div[1]/div[2]/input[1]")
    WebElement txtDriverLicense;

    @FindBy(xpath="//body/div[@id='app']/div[@class='oxd-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='orangehrm-card-container']/div[@class='orangehrm-edit-employee']/div[@class='orangehrm-edit-employee-content']/div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/form[@class='oxd-form']/div[@class='oxd-form-row']/div[@class='oxd-grid-3 orangehrm-full-width-grid']/div[2]/div[1]/div[2]/div[1]/div[1]/input[1]")
    WebElement txtDlExpDate;

    @FindBy(xpath="//body/div[@id='app']/div[@class='oxd-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='orangehrm-card-container']/div[@class='orangehrm-edit-employee']/div[@class='orangehrm-edit-employee-content']/div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/form[@class='oxd-form']/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]")
    WebElement txtNationality;

    @FindBy(xpath="//div[@role='listbox']//span")
    List<WebElement> lstNationalityOptions;

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

    public void setDriverLicense(String driverLicense){
        txtDriverLicense.sendKeys(Keys.COMMAND + "a");
        txtDriverLicense.sendKeys(Keys.DELETE);
        txtDriverLicense.sendKeys(driverLicense);
    }

    public void setDlExpirationDate(String dlExpirationDate){
        txtDlExpDate.sendKeys(Keys.COMMAND + "a");
        txtDlExpDate.sendKeys(Keys.DELETE);
        txtDlExpDate.sendKeys(dlExpirationDate);
    }

    public void setNationality(String nationality){
        txtNationality.click();
        for(WebElement option:lstNationalityOptions){
            System.out.println(option.getText());
            if(option.getText().equals(nationality)){
                option.click();
                break;
            }
        }

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
