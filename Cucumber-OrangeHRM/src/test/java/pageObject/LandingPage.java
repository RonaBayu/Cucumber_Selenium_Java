package pageObject;

import com.ronabayu.base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends Base {

    public LandingPage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//form/div[1]/div/div[2]/input")
    private WebElement usernameField;

    public void inputUsernameField(String keyword){
        usernameField.sendKeys(keyword);
    }

    @FindBy(xpath = "//div[2]/div[1]/div[2]/input[1]")
    private WebElement passwordField;

    public void inputPasswordField(String keyword){
        passwordField.sendKeys(keyword);
    }

    @FindBy(xpath = "//form[1]/div[3]/button[1]")
    private WebElement loginButton;

    public void clickLoginButton(){
        loginButton.click();
    }
}
