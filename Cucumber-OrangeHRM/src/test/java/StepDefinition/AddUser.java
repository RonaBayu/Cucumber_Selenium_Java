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
import pageObject.AddEmployeePage;
import pageObject.DashboardPage;
import pageObject.LandingPage;
import pageObject.ViewEmployeeListPage;

import static Runner.Hooks.properties;

public class AddUser {

    private WebDriver driver;
    DashboardPage dashboardPage;
    LandingPage landingPage;
    ViewEmployeeListPage viewEmployeeListPage;
    AddEmployeePage addEmployeePage;

    public AddUser() {
        super();
        this.driver = Hooks.driver;
    }
    @Given("I already login on OrangeHRM website")
    public void login() {
        landingPage = new LandingPage(driver);

        landingPage.inputUsernameField(properties.getProperty("username"));
        landingPage.inputPasswordField(properties.getProperty("password"));
        landingPage.clickLoginButton();
    }


    @When("I click PIM button on side menu")
    public void clickPIM() {
        dashboardPage = new DashboardPage(driver);

        dashboardPage.clickPimButton();
    }

    @And("I click add button")
    public void ClickAddButton() {
        viewEmployeeListPage = new ViewEmployeeListPage(driver);

        viewEmployeeListPage.clickAddButton();
    }

    @And("I input firstname and lastname field")
    public void inputFirstnameAndLastname() {
        addEmployeePage = new AddEmployeePage(driver);

        addEmployeePage.inputFirstNameField("Didier");
        addEmployeePage.inputLastNameField("Drogba");
    }

    @And("I click Create Login Details switch button")
    public void ClickSwitch() {
        addEmployeePage = new AddEmployeePage(driver);

        addEmployeePage.clickSwitchButton();
    }

    @And("I input username, password and confirm password")
    public void inputUsernamePasswordAndConfirmPasswordField() {
        addEmployeePage = new AddEmployeePage(driver);

        addEmployeePage.inputUsernameField("Drogba10");
        addEmployeePage.inputPasswordField("Drogba10*");
        addEmployeePage.inputConfirmPasswordField("Drogba10*");
    }

    @And("I click save button")
    public void clickSaveButton() {
        addEmployeePage = new AddEmployeePage(driver);

        addEmployeePage.clickSaveButton();
    }

    @Then("New employee list or user has been created")
    public void newEmployeeListHasBeenCreated() throws Throwable{
        Thread.sleep(5000);
        Assert.assertTrue(driver.getPageSource().contains("Drogba"));
    }


    @And("I input existed username data")
    public void iInputExistedUsernameData() {
        addEmployeePage = new AddEmployeePage(driver);

        addEmployeePage.inputUsernameField("Mudryk10");
    }

    @And("^I input ([^”]*), ([^”]*) and ([^”]*) field$")
    public void iInputFirstnameAndLastnameField(String firstname,String middleName, String lastName) throws  Throwable{
        addEmployeePage = new AddEmployeePage(driver);
        Thread.sleep(3000);
        addEmployeePage.inputFirstNameField(firstname);
        addEmployeePage.inputMiddleNameField(middleName);
        addEmployeePage.inputLastNameField(lastName);
    }

    @And("^I input ([^”]*), ([^”]*) and ([^”]*) on login details$")
    public void iInputUsernamePasswordAndConfirmPasswordOnLoginDetails(String username, String password, String confirmPassword) {
        addEmployeePage = new AddEmployeePage(driver);

        addEmployeePage.inputUsernameField(username);
        addEmployeePage.inputPasswordField(password);
        addEmployeePage.inputConfirmPasswordField(confirmPassword);
    }

//    VERIFY OR RESULT METHOD

    @Then("New user is not successfully created and show {string} message")
    public void newUserIsNotSuccessfullyCreatedAndShowMessage(String arg0) throws Throwable{
        Assert.assertTrue(driver.getPageSource().contains("Username already exists"));
        Thread.sleep(3000);
    }

    @Then("New user could not created and show {string} message")
    public void newUserCouldNotCreatedAndShowMessage(String arg0) throws Throwable{
        WebElement message = driver.findElement(By.xpath("//span[.='Required']"));
        Assert.assertTrue(message.isDisplayed());
        Thread.sleep(3000);
    }

    @Then("password field shows {string} message")
    public void passwordFieldShowsMessage(String arg0) throws Throwable{
        WebElement message = driver.findElement(By.xpath("//span[.='Should have at least 8 characters']"));
        Assert.assertTrue(message.isDisplayed());
        Thread.sleep(3000);
    }

    @Then("confirmation password field shows {string} message")
    public void confirmationPasswordFieldShowsMessage(String arg0) throws Throwable{
        WebElement message = driver.findElement(By.xpath("//span[.='Passwords do not match']"));
        Assert.assertTrue(message.isDisplayed());
        Thread.sleep(3000);
    }

    @Then("username field is error and shows {string} message")
    public void usernameFieldIsErrorAndShowMessage(String arg0) throws Throwable{
        WebElement message = driver.findElement(By.xpath("//span[.='Should be at least 5 characters']"));
        Assert.assertTrue(message.isDisplayed());
        Thread.sleep(3000);
    }

    @Then("password field is error and shows {string} message")
    public void passwordFieldIsErrorAndShowMessage(String arg0) throws Throwable{
        WebElement message = driver.findElement(By.xpath("//span[.='Your password must contain a lower-case letter, an upper-case letter, a digit and a special character. Try a different password']"));
        Assert.assertTrue(message.isDisplayed());
        Thread.sleep(3000);
    }
}
