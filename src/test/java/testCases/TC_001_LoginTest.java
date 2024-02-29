package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_001_LoginTest extends BaseClass {

    @Test
    public void verify_login(){

        try {
            LoginPage lp = new LoginPage(driver);
            lp.setUsername("Admin");
            lp.setPassword("admin123");
            lp.clickLogin();

            DashboardPage dp = new DashboardPage(driver);
            boolean actualMsg = dp.isDashboardExists();


            Assert.assertEquals(actualMsg, true);

        }
        catch(Exception e){
            System.out.println("Something went wrong");
        }



    }


}
