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

    @FindBy(xpath="//span[@class='oxd-userdropdown-tab']")
    WebElement btnMenu;

    @FindBy(xpath="//a[normalize-space()='Logout']")
    WebElement lnkLogOut;


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

    public void clickLogOut(){
        btnMenu.click();
        lnkLogOut.click();
    }

}
