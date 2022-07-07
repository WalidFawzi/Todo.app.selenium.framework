package todo.testcases;

import base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigUtils;

public class LoginTest extends BaseTest {

    @Test
    public void shouldBeAbleToLoginWithEmailAndPassword (){
        test = extent.startTest("The user should be able to login with valid credentials");
        LoginPage loginPage = new LoginPage(getDriver());
        boolean isWelcomeDisplayed =
         loginPage
                 .load()
                 .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
                 .isWelcomeMsgDisplayed();
        test.log(LogStatus.PASS, "Assert Pass as condition is True");

        Assert.assertTrue(isWelcomeDisplayed,"The Welcome Message is not displayed");
    }


}
