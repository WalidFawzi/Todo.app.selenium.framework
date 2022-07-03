package todo.testcases;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NewTodoPage;
import pages.TodoPage;

public class TodoTest extends BaseTest {
    @Test
    public void shouldBeAbleToAddNewTodo () {
        LoginPage loginPage = new LoginPage(driver);
        String actualResult =  loginPage
                .load()
                .login("hatem@example.com","123456")
                .clickOnAddBtn().addNewTodo("Learn Javaa")
                .todoItemGettext();
        Assert.assertEquals(actualResult,"Learn Javaa");
    }
    @Test (enabled = false)
    public void shouldBeAbleToDeleteTodo (){
        LoginPage loginPage = new LoginPage(driver);
        boolean actualResult = loginPage
                .load()
                .login("hatem@example.com","123456")
                .clickOnAddBtn()
                .addNewTodo("New Course")
                .clickOnDeleteBtn()
                .isTodosMsgDisplayed();
        Assert.assertEquals(actualResult,true);
    }
}
