package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodoPage extends BasePage {
    public TodoPage (WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//h2[contains(text(),' Hatem')]")
    private WebElement welcomeMessage;

    @FindBy (css = "[data-testid ='add']")
    private WebElement addNewTodoBtn;

    @FindBy (xpath = "//div[@data-testid = 'todo-item'][1]")
    private WebElement todoItem;

    @FindBy (xpath = "//button[@data-testid='delete']")
    private WebElement deleteBtn;
    @FindBy (xpath = "//h4[contains(text(),'No Available Todos')]")
    private WebElement noTodosMsg;

    public boolean isWelcomeMsgDisplayed(){
        return welcomeMessage.isDisplayed();

    }
    public NewTodoPage clickOnAddBtn (){
        addNewTodoBtn.click();
        return new NewTodoPage (driver);
    }
    public String todoItemGettext (){
        return todoItem.getText();
    }
    public TodoPage clickOnDeleteBtn (){
        deleteBtn.click();
        return this;
    }
    public boolean isTodosMsgDisplayed (){
        return noTodosMsg.isDisplayed();
    }
}
