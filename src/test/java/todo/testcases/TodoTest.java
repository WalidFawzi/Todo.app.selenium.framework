package todo.testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigUtils;

public class TodoTest extends BaseTest {
    @Test
    public void shouldBeAbleToAddNewTodo () {
        LoginPage loginPage = new LoginPage(driver);
        String actualResult =  loginPage
                .load()
                .login(ConfigUtils.getInstance().getEmail(),ConfigUtils.getInstance().getPassword())
                .clickOnAddBtn().addNewTodo("Learn Javaa")
                .todoItemGettext();
        Assert.assertEquals(actualResult,"Learn Javaa");
    }
    @Test (enabled = false)
    public void shouldBeAbleToDeleteTodo (){
        LoginPage loginPage = new LoginPage(driver);
        boolean actualResult = loginPage
                .load()
                .login(ConfigUtils.getInstance().getEmail(),ConfigUtils.getInstance().getPassword())
                .clickOnAddBtn()
                .addNewTodo("New Course")
                .clickOnDeleteBtn()
                .isTodosMsgDisplayed();
        Assert.assertEquals(actualResult,true);
    }
}
