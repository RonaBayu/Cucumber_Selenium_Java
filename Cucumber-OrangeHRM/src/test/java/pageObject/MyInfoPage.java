package pageObject;

import com.ronabayu.base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyInfoPage extends Base {

    public MyInfoPage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[.='-- Select --']")
    private WebElement selectNationality;

    public void clickSelectNationality() {
        selectNationality.click();
    }

    @FindBy(xpath = "//div[.='-- Select --']")
    private WebElement selectMarital;

    public void clickSelectMarital() {
        selectMarital.click();
    }

    @FindBy(xpath = "//div[.='Indonesian']")
    private WebElement nationalityOptionIndonesia;

    public void clickIndonesian() {
        nationalityOptionIndonesia.click();
    }

    @FindBy(xpath = "//div[.='Single']")
    private WebElement maritalStatusOptionSingle;

    public void clickMaritalStatusOptionSingle() {
        maritalStatusOptionSingle.click();
    }

    @FindBy(xpath = "//div[2]/div[1]/div[2]/div[1]/label[1]/span[1]")
    private WebElement genderRadioButtonMale;

    public void clickGenderRadioButtonMale() {
        genderRadioButtonMale.click();
    }

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveButton;

    public void clickSaveButton() {
        saveButton.click();
    }

}
