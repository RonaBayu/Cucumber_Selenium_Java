package stepDefinition;

import runner.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObject.AppointmentPage;

public class MakeAppointment {
    private WebDriver driver;
    AppointmentPage appointmentPage;
    String urlAppointment = "https://katalon-demo-cura.herokuapp.com/#appointment";

    public MakeAppointment() {
        super();
        this.driver = Hooks.driver;
    }

    @When("^User input all fields with valid input$")
    public void validInput() {
        appointmentPage = new AppointmentPage(driver);

        appointmentPage.clickTokyoFacilityOption();
        appointmentPage.clickReadmissionRadioButton();
        appointmentPage.clickDateTable();
        appointmentPage.clickDateNumber();
    }
    @When("^User click book appointment button$")
    public void clickButton() {
        appointmentPage = new AppointmentPage(driver);

        appointmentPage.clickBookButton();
    }
    @Then("^Appointment is successfully created and show Appointment Confirmation message$")
    public void showMessage() {
        Assert.assertTrue(driver.findElement(By.xpath("//h2[.='Appointment Confirmation']")).isDisplayed());
    }

    @When("^User don't input anything$")
    public void doNothing() {

    }

    @Then("^Appointment is not created and show Date table that must input$")
    public void failedResult() {
        Assert.assertTrue(driver.findElement(By.xpath("//body/div[1]/div[1]")).isDisplayed());
        Assert.assertEquals(urlAppointment,driver.getCurrentUrl());
    }
}
