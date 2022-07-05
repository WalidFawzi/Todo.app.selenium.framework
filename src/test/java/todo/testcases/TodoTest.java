package todo.testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigUtils;

public class TodoTest extends BaseTest {
    @Test
    public void shouldBeAbleToAddNewTodo () {
        LoginPage loginPage = new LoginPage(getDriver());
        String actualResult =  loginPage
                .load()
                .login(ConfigUtils.getInstance().getEmail(),ConfigUtils.getInstance().getPassword())
                .clickOnAddBtn().addNewTodo("Learn Javaa")
                .todoItemGettext();
        Assert.assertEquals(actualResult,"Learn Javaa");
    }
    @Test (enabled = false)
    public void shouldBeAbleToDeleteTodo (){
        LoginPage loginPage = new LoginPage(getDriver());
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
