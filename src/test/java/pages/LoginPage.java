package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ConfigUtils;

import java.util.Properties;

import static java.sql.DriverManager.getDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (xpath = "//input[@id='login']")
    private WebElement emailInput;
    @FindBy (xpath = "//input[@data-testid='password']")
    private WebElement passwordInput;
    @FindBy (xpath = "//span[contains(text(),'Login')]")
    private WebElement loginBtn;



    public TodoPage login(String email , String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginBtn.click();
        return new TodoPage(driver);
    }
    public LoginPage load (){
        driver.get(ConfigUtils.getInstance().getBaseUrl());
        return this;
    }
}
