package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Base{

    public HomePage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id ="btn-make-appointment")
    private WebElement makeAppointmentButton;

    public void clickMakeAppointmentButton() {
        makeAppointmentButton.click();
    }

    public void getHomeUrl(){
        driver.get("https://katalon-demo-cura.herokuapp.com/");
    }
}