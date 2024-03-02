package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException {
        String path = "./testData/OrangeHRM_LoginData.xlsx";

        ExcelUtility exUtil = new ExcelUtility(path);
        int totalRows = exUtil.getRowCount("Sheet1");
        int totalCells = exUtil.getCellCount("Sheet1", 1);

        String[][] loginData = new String[totalRows][totalCells];

        for(int i = 1; i <= totalRows; i++){
            for(int j = 0; j< totalCells; j++){
                loginData[i-1][j] = exUtil.getCellData("Sheet1", i, j);
            }
        }
        return loginData;

    }


}
