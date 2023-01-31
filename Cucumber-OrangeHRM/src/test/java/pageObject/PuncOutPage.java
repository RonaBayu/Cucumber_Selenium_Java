package pageObject;

import com.ronabayu.base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PuncOutPage extends Base {

    public PuncOutPage(WebDriver driver) {
            super(driver);
            PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//form[1]/div[3]/button[1]")
    private WebElement outButton;

    public void clickOutButton(){
        outButton.click();
    }
}
