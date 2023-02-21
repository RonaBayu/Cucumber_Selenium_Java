package stepDefinition;

import runner.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.AppointmentPage;

public class Logout {
    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    AppointmentPage appointmentPage;

    public Logout() {
        super();
        this.driver = Hooks.driver;
    }
    @Given("^User is already logged in to the HerokuApp website$")
    public void alreadyLogin() throws Throwable {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);

        homePage.getHomeUrl();
        homePage.clickMakeAppointmentButton();
        loginPage.inputUsername("John Doe");
        loginPage.inputPassword("ThisIsNotAPassword");
        loginPage.clickLoginButton();
    }

    @When("^I click logout button$")
    public void clickLogout() throws Throwable{
        appointmentPage = new AppointmentPage(driver);

        appointmentPage.clickHamburgerIcon();
        appointmentPage.clickLogoutButton();

    }
    @Then("^I will be directed to HerokuApp home page$")
    public void homePage() throws Throwable{
        Assert.assertEquals("https://katalon-demo-cura.herokuapp.com/", driver.getCurrentUrl());
    }
}
