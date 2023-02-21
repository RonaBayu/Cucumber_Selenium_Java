package stepDefinition;

import runner.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObject.HomePage;
import pageObject.LoginPage;

public class Login {
    private WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    String urlAppointment = "https://katalon-demo-cura.herokuapp.com/#appointment";

    public Login() {
        super();
        this.driver = Hooks.driver;
    }
    @Given("^User on HerokuApp home page$")
    public void getLink() {
        homePage = new HomePage(driver);
        homePage.getHomeUrl();
    }
    @When("^User click make an appointment button$")
    public void clickButton() {
        homePage = new HomePage (driver);
        homePage.clickMakeAppointmentButton();
    }
    @And("^User input valid Username And Password$")
    public void input() throws Throwable {
        loginPage = new LoginPage(driver);
        loginPage.inputUsername("John Doe");
        loginPage.inputPassword("ThisIsNotAPassword");
    }
    @And("^User click login button$")
    public void clickLogin() throws Throwable {
        loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
    }
    @Then("^User will be directed to appointment page$")
    public void verifyResult() throws Throwable {
        Assert.assertEquals(driver.getCurrentUrl(), urlAppointment);
    }

    @When("^User input invalid Username And Password$")
    public void inputInvalid() throws Throwable{
        loginPage = new LoginPage(driver);
        loginPage.inputUsername("Nama salah");
        loginPage.inputPassword("PasswordSalah");
    }
    @Then("^login is failed and still in the same page$")
    public void loginFailed() {
        String loginURL = "https://katalon-demo-cura.herokuapp.com/profile.php#login";
        Assert.assertEquals(driver.getCurrentUrl(), loginURL);
    }
}
