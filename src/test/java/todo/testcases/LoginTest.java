package todo.testcases;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.TodoPage;


public class LoginTest extends BaseTest {

    @Test
    public void shouldBeAbleToLoginWithEmailAndPassword (){
        LoginPage loginPage = new LoginPage(driver);
        boolean isWelcomeDisplayed =
         loginPage
                 .load()
                .login("hatem@example.com","123456")
                 .isWelcomeMsgDisplayed();

        Assert.assertTrue(isWelcomeDisplayed,"The Welcome Message is not displayed");
    }


}
