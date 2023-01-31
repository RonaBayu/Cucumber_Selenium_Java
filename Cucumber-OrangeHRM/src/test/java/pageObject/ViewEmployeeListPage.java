package pageObject;

import com.ronabayu.base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewEmployeeListPage extends Base {

    public ViewEmployeeListPage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[2]/div[1]/button[1]")
    private WebElement addButton;


    public void clickAddButton( ) {
        addButton.click();
    }
}
