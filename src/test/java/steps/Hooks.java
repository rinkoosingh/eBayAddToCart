package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks extends BaseSteps{
    public WebDriver driver;

    @Before
    public void setUp(){
        getDriverInstance().get("https://www.ebay.com.au");
        getDriverInstance().manage().window().maximize();
    }

    @After
    public void tearDown(){
        getDriverInstance().close();
        getDriverInstance().quit();
    }
}
