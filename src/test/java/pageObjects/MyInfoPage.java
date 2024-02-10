package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyInfoPage extends BasePage{

    public MyInfoPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//a[normalize-space()='Personal Details']")
    WebElement lnkPersonalDetails;


    public void clickPersonalDetails(){
        lnkPersonalDetails.click();
    }


}
