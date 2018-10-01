package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import drivers.DriverFactory;
import org.openqa.selenium.WebDriver;

public class BaseSteps {

    public WebDriver getDriverInstance(){
        return new DriverFactory().getDriver();
    }

}
