package StepDefinition;

import Runner.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pageObject.DashboardPage;
import pageObject.LandingPage;
import pageObject.MyInfoPage;

public class EditProfile {

    private WebDriver driver;

    public EditProfile() {
        super();
        this.driver = Hooks.driver;
    }
    LandingPage landingPage;
    DashboardPage dashboardPage;
    MyInfoPage myInfoPage;

    @Given("I am already login with user that has been created")
    public void iAmAlreadyLoginWithUserThatHasBeenCreated() throws Throwable{
        landingPage = new LandingPage(driver);

        landingPage.inputUsernameField("Mudryk10");
        landingPage.inputPasswordField("Mudryk10*");
        landingPage.clickLoginButton();
        Thread.sleep(3000);
    }

    @When("I click my info side menu")
    public void iClickMyInfoSideMenu() {
        dashboardPage = new DashboardPage(driver);

        dashboardPage.clickMyInfoButton();
    }

    @And("I choose Nationality, marital status and gender option")
    public void iChooseNationalityMaritalStatusAndGenderOption() throws Throwable{
        myInfoPage = new MyInfoPage(driver);

        myInfoPage.clickSelectNationality();
        myInfoPage.clickIndonesian();

        myInfoPage.clickSelectMarital();
        myInfoPage.clickMaritalStatusOptionSingle();

        myInfoPage.clickGenderRadioButtonMale();
        Thread.sleep(4000);
    }

    @And("I click save button on my info page")
    public void iClickSaveButtonOnMyInfoPage() {
        myInfoPage = new MyInfoPage(driver);

        myInfoPage.clickSaveButton();
    }

    @Then("profile is successfully updated and show success popup messages")
    public void profileIsSuccessfullyUpdatedAndShowSuccessPopupMessages() throws Throwable{
        WebElement message = driver.findElement(By.xpath("//div[@id='oxd-toaster_1']/div"));
        Assert.assertTrue(message.isDisplayed());
        Thread.sleep(3000);
    }
}
