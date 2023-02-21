package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppointmentPage extends Base {

    public AppointmentPage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//body/a[@id='menu-toggle']/i[1]")
    private WebElement hamburgerIcon;

    public void clickHamburgerIcon(){
        hamburgerIcon.click();
    }

    @FindBy(xpath = "//a[.='Logout']")
    private WebElement logoutButton;

    public void clickLogoutButton(){
        logoutButton.click();
    }

    @FindBy(xpath = "//option[.='Tokyo CURA Healthcare Center']")
    private WebElement TokyoFacilityOption;

    public void clickTokyoFacilityOption() {
        TokyoFacilityOption.click();
    }

    @FindBy(id = "chk_hospotal_readmission")
    private WebElement readmissionRadioButton;

    public void clickReadmissionRadioButton() {
        readmissionRadioButton.click();
    }


    @FindBy(id = "txt_visit_date")
    private WebElement dateTable;

    public void clickDateTable(){
        dateTable.click();
    }

    @FindBy(xpath = "//tr[3]/td[3]")
    private WebElement dateNumber;

    public void clickDateNumber(){
        dateNumber.click();
    }

    @FindBy(id = "btn-book-appointment")
    private WebElement bookButton;

    public void clickBookButton()  {
        bookButton.click();
    }

}
