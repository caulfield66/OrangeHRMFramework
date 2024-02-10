package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{
    public DashboardPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//h6[normalize-space()='Dashboard']")
    WebElement msgHeading;

    @FindBy(xpath = "//span[normalize-space()='My Info']")
    WebElement lnkMyInfo;

    public boolean isDashboardExists(){
        try{
            return msgHeading.isDisplayed();
        }
        catch(Exception e){
            return false;
        }
    }

    public void clickMyInfo(){
        lnkMyInfo.click();
    }

}
