package core.ddf.testCases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import core.ddf.base.BaseTest;
import core.ddf.dev.utility.DataUtil;

public class LoginTest extends BaseTest{
	
	String testCaseName="LoginTest";
			
	@Test(dataProvider = "getData")
	public void login(Hashtable<String,String> data)
	{
		test = extent.createTest(testCaseName);
		if(DataUtil.isRunnable(xls, testCaseName) || (data.get("runmode").equalsIgnoreCase("n")))
		{
			test.log(Status.SKIP,testCaseName+" skipped because the runmode is 'n' ");
			throw new SkipException("runmode is 'n' ");
		}
		
		openBrowser(data.get("browser"));
		zohoLogin(data.get("userName"), data.get("password"));
		zohoLogout();
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		return DataUtil.getTestData(xls, testCaseName);
	}

}
