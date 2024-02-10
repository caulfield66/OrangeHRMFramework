package testCases;

import org.testng.annotations.Test;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class LoginTest extends BaseClass {

    @Test
    public void verify_login(){
        LoginPage lp = new LoginPage(driver);
        lp.setUsername("Admin");
        lp.setPassword("admin123");
        lp.clickLogin();
    }


}
