package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.MyInfoPage;
import pageObjects.PersonalDetailsPage;
import testBase.BaseClass;

public class TC_002_UpdateMyInfo extends BaseClass {

    @Test
    public void update_personal_details(){
        try {
            LoginPage lp = new LoginPage(driver);
            lp.setUsername("Admin");
            lp.setPassword("admin123");
            lp.clickLogin();

            DashboardPage dp = new DashboardPage(driver);
            dp.clickMyInfo();

            MyInfoPage mip = new MyInfoPage(driver);
            mip.clickPersonalDetails();
            Thread.sleep(2000);
            PersonalDetailsPage pdp = new PersonalDetailsPage(driver);
            pdp.setFirstName("Test");
            pdp.setLastName("Tester");
            pdp.setDriverLicense("K1209875612");
            pdp.setDlExpirationDate("2024-01-05");
            pdp.setNationality("Armenian");

            pdp.clickSave();


            boolean actualSuccessMsg = pdp.isSuccessMsgAppears();
            Assert.assertEquals(actualSuccessMsg, true);

        }
        catch(Exception e){
            System.out.println("Something went wrong");
        }


    }


}
