package pageObject;

import com.ronabayu.base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends Base {

    public DashboardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

//    public HomePage(WebDriver driver){
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }

    @FindBy(xpath = "//aside[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]")
    private WebElement pimButton;

    public void clickPimButton(){
        pimButton.click();
    }

    @FindBy(xpath = "//aside[1]/nav[1]/div[2]/ul[1]/li[3]/a[1]")
    private WebElement myInfoButton;

    public void clickMyInfoButton(){
        myInfoButton.click();
    }

    @FindBy(xpath = "//div[2]/div[1]/div[2]/button")
    private WebElement punchInButton;

    public void clickPunchInButton(){
        punchInButton.click();
    }

}