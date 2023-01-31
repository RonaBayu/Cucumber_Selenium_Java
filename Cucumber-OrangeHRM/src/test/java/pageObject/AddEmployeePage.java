package pageObject;

import com.ronabayu.base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployeePage extends Base {

    public AddEmployeePage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[2]/div[1]/div[2]/input[1]")
    private WebElement firstNameField;

    public void inputFirstNameField(String keyword){
        firstNameField.sendKeys(keyword);
    }

    @FindBy(xpath = "//div[2]/div[2]/div[2]/input[1]")
    private WebElement middleNameField;

    public void inputMiddleNameField(String keyword){
        middleNameField.sendKeys(keyword);
    }

    @FindBy(xpath = "//div[2]/div[3]/div[2]/input[1]")
    private WebElement lastNameField;

    public void inputLastNameField(String keyword){
        lastNameField.sendKeys(keyword);
    }

    @FindBy(xpath = "//label[1]/span[1]")
    private WebElement switchButton;

    public void clickSwitchButton(){
        switchButton.click();
    }

    @FindBy(xpath = "//div[3]/div[1]/div[1]/div[1]/div[2]/input[1]")
    private WebElement usernameField;

    public void inputUsernameField(String keyword){
        usernameField.sendKeys(keyword);
    }

    @FindBy(xpath = "//div[4]/div[1]/div[1]/div[1]/div[2]/input[1]")
    private WebElement passwordField;

    public void inputPasswordField(String keyword){
        passwordField.sendKeys(keyword);
    }

    @FindBy(xpath = "//div[4]/div[1]/div[2]/div[1]/div[2]/input[1]")
    private WebElement confirmPasswordField;

    public void inputConfirmPasswordField(String keyword){
        confirmPasswordField.sendKeys(keyword);
    }

    @FindBy(xpath = "//form[1]/div[2]/button[2]")
    private WebElement saveButton;

    public void clickSaveButton(){
        saveButton.click();
    }

}
