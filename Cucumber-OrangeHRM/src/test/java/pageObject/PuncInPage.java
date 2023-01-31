package pageObject;

import com.ronabayu.base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PuncInPage extends Base {

    public PuncInPage (WebDriver driver) {
            super(driver);
            PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//form[1]/div[3]/button[1]")
    private WebElement inButton;

    public void clickInButton(){
        inButton.click();
    }
}
