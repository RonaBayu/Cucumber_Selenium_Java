package StepDefinition;

import Runner.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObject.DashboardPage;
import pageObject.LandingPage;

import static Runner.Hooks.properties;

public class Login {
    private WebDriver driver;
    LandingPage landingPage;

    public Login() {
        super();
        this.driver = Hooks.driver;
    }

    @Given("I am on OrangeHRM landing page")
    public void iAmOnOrangeHRMLandingPage() {
        Assert.assertEquals(driver.getCurrentUrl(),"http://employee.sdcillsy.my.id/web/index.php/auth/login");
    }

    @When("I input valid Username And Password")
    public void iInputValidUsernameAndPassword() {
        landingPage = new LandingPage(driver);

        landingPage.inputUsernameField(properties.getProperty("username"));
        landingPage.inputPasswordField(properties.getProperty("password"));
    }

    @And("I click login button on login page")
    public void iClickLoginButtonOnLoginPage()  {
        landingPage = new LandingPage(driver);

        landingPage.clickLoginButton();

    }

    @Then("I will be directed to logged in dashboard page")
    public void iWillBeDirectedToLoggedIn() throws Throwable{
        Assert.assertEquals(driver.getCurrentUrl(),"http://employee.sdcillsy.my.id/web/index.php/dashboard/index");

        Thread.sleep(3000);
    }


    @When("^I input invalid ([^”]*) And invalid ([^”]*)$")
    public void iInputUsernameAndPassword(String username,String password) throws Throwable{
        landingPage = new LandingPage(driver);

        landingPage.inputUsernameField(username);
        landingPage.inputPasswordField(password);

    }

    @Then("I could not login and show {string} message")
    public void iCouldNotLoginAndShowMessage(String arg0) throws Throwable{
        Assert.assertTrue(driver.getPageSource().contains("Invalid credentials"));
        Assert.assertEquals(driver.getCurrentUrl(),"http://employee.sdcillsy.my.id/web/index.php/auth/login");

        Thread.sleep(3000);
    }

    @Then("I cannot login and show {string} message")
    public void iCannotLoginAndShowRequiredMessage(String arg0) throws Throwable{
        Assert.assertTrue(driver.getPageSource().contains("Required"));
        Assert.assertEquals(driver.getCurrentUrl(),"http://employee.sdcillsy.my.id/web/index.php/auth/login");

        Thread.sleep(3000);
    }
}
