package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage{

    private WebDriver driver;
    private WebDriverWait wait;
    public BasePage(WebDriver driver) {
        this.driver=driver;
        wait=new WebDriverWait(this.driver,60);
        PageFactory.initElements(driver,this);
    }

    public void waitTillElementClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitTillElementVisible(By element){
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

}
