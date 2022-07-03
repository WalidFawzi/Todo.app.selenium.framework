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
        loginPage.load();
        TodoPage todoPage = loginPage.login("hatem@example.com","123456");
        NewTodoPage newTodoPage = todoPage.clickOnAddBtn();
        newTodoPage.addNewTodo("Learn Javaa");
        String actualResult = todoPage.todoItemGettext();
        Assert.assertEquals(actualResult,"Learn Javaa");
    }
    @Test
    public void shouldBeAbleToDeleteTodo (){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.load();
        TodoPage todoPage = loginPage.login("hatem@example.com","123456");
        NewTodoPage newTodoPage = todoPage.clickOnAddBtn();
        //New Todo page
        newTodoPage.addNewTodo("New Course");
        todoPage.clickOnDeleteBtn();
        boolean actualResult = todoPage.isTodosMsgDisplayed();
        Assert.assertEquals(actualResult,true);
    }
}
