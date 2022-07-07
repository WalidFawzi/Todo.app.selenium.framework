package base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;


public class BaseTest {

    protected ThreadLocal <WebDriver> driver = new ThreadLocal<>();

    public void setDriver(WebDriver driver) {
        this.driver.set(driver);
    }
    public WebDriver getDriver(){
        return this.driver.get();
    }
    public static ExtentReports extent;
    public static ExtentTest test;
    @BeforeTest
    public void startReport()
    {
        extent = new ExtentReports(System.getProperty("user.dir") +"/test-output/MyOwnReport.html", true);
        extent
                .addSystemInfo("User Name", "Walid");
        extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
    }



    @BeforeMethod
    public void setup (){
        WebDriver driver = new DriverFactory().initializeDriver();
         setDriver(driver);

    }

    @AfterMethod
    public void tearDown (ITestResult result){
        if(result.getStatus()== ITestResult.FAILURE)
        {
            test.log(LogStatus.FAIL, result.getThrowable());

        }
        extent.endTest(test);
        getDriver().quit();
    }
    @AfterTest
    public void endReport()
    {
        extent.flush();
        extent.close();
    }
}
