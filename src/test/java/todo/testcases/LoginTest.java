package todo.testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigUtils;


public class LoginTest extends BaseTest {

    @Test
    public void shouldBeAbleToLoginWithEmailAndPassword (){
        LoginPage loginPage = new LoginPage(getDriver());
        boolean isWelcomeDisplayed =
         loginPage
                 .load()
                 .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
                 .isWelcomeMsgDisplayed();

        Assert.assertTrue(isWelcomeDisplayed,"The Welcome Message is not displayed");
    }


}
