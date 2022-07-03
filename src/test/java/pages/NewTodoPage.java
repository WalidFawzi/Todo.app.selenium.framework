package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewTodoPage extends BasePage {
    public NewTodoPage (WebDriver driver){
        super(driver);
    }
    @FindBy (xpath = "//input[@data-testid='new-todo']")
    private WebElement newTodoInput;

    @FindBy (xpath = "//button[@data-testid='submit-newTask']")
    private WebElement submitBtn;

    public TodoPage addNewTodo (String item){
        newTodoInput.sendKeys(item);
        submitBtn.click();
        return new TodoPage(driver);
    }

}
