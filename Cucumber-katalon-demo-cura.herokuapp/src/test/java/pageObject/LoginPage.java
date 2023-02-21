package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Base {

    public LoginPage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "txt-username")
    private WebElement usernameField;

    public void inputUsername(String keyword) throws InterruptedException {
        usernameField.sendKeys(keyword);
        Thread.sleep(2000);
    }

    @FindBy(id = "txt-password")
    private WebElement passwordField;

    public void inputPassword(String keyword) throws InterruptedException {
        passwordField.sendKeys(keyword);
        Thread.sleep(2000);
    }

    @FindBy(id = "btn-login")
    private WebElement loginButton;

    public void clickLoginButton() throws InterruptedException {
        loginButton.click();
        Thread.sleep(2000);
    }
}
