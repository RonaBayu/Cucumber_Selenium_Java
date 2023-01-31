package StepDefinition;

import Runner.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObject.DashboardPage;
import pageObject.PuncInPage;
import pageObject.PuncOutPage;

public class PunchFeature {
    private WebDriver driver;

    public PunchFeature() {
        super();
        this.driver = Hooks.driver;
    }

    DashboardPage dashboardPage;
    PuncInPage puncInPage;
    PuncOutPage puncOutPage;

    @When("I click stopwatch icon or punch in button")
    public void iClickStopwatchIconOrInButton() {
        dashboardPage = new DashboardPage(driver);

        dashboardPage.clickPunchInButton();
    }

    @And("I click in button on punch in page")
    public void iClickInButtonOnPunchInPage() throws Throwable{
        puncInPage = new PuncInPage(driver);

        puncInPage.clickInButton();
        Thread.sleep(6000);
    }

    @And("I click out button on punch out page")
    public void iClickOutButtonOnPunchOutPage() {
        puncOutPage = new PuncOutPage(driver);

        puncOutPage.clickOutButton();
    }

    @Then("Punch feature is successfully saved and show success popup message")
    public void punchFeatureIsSuccessfullySavedAndShowSuccessPopupMessage() throws Throwable{
        WebElement message = driver.findElement(By.xpath("//div[@id='oxd-toaster_1']/div"));
        Assert.assertTrue(message.isDisplayed());
        Thread.sleep(6000);
    }
}
