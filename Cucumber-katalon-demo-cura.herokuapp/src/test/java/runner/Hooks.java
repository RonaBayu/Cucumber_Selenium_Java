package runner;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
//        System.setProperty("webdriver.chrome.driver", "D:\\Chrome driver 109\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
    }
    @After(order = 1)
    public void takeScraenshotOnFailure(Scenario scenario) {

        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] src = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(src, "image/png", "screenshot");
        }
    }

    @After(order = 0)
    public void tearDown() {
        driver.quit();
    }
}
