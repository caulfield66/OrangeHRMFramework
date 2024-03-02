package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
    public void verify_loginDDT(String username, String password, String res){

        LoginPage lp = new LoginPage(driver);
        lp.setUsername(username);
        lp.setPassword(password);
        lp.clickLogin();

        DashboardPage dp = new DashboardPage(driver);
        boolean actualMsg = dp.isDashboardExists();

        try {
            if (res.equals("Valid")) {
                if (actualMsg == true) {
                    dp.clickLogOut();
                    Assert.assertTrue(true);
                } else {
                    Assert.assertTrue(false);
                }
            }
            if (res.equals("Invalid")) {
                if (actualMsg == true) {
                    dp.clickLogOut();
                    Assert.assertTrue(false);
                } else {
                    Assert.assertTrue(true);
                }
            }
        }catch(Exception e){
            Assert.fail();
        }
    }
}
