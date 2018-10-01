package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage{
 private WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "gh-tb")
    private WebElement searchTextBox;

    @FindBy(id = "gh-btn")
    private WebElement searchButton;

    @FindBys( {
            @FindBy(className = "s-item__link")
    } )
    private List<WebElement> itemLinks;



    @FindBy(id="atcRedesignId_btn")
    private WebElement addToCartButton;

    @FindBy(xpath = "/button[contains(text(),'No thanks')]")
    private WebElement NoThanksButton;

    @FindBy(id = "gh-cart-n")
    private WebElement itemInCart;

    @FindBy(id = "sbin-gxo-btn")
    private WebElement continueAsGuestButton;

    @FindBy(xpath = "//span[contains(text(),'Go to cart')]")
    private WebElement goToCartButton;

    @FindBy(id = "gh-cart")
    private WebElement cartIcon;

    @FindBy(className = "adnactions")
    private WebElement addOnbuttonClass;

    @FindBy(className = "actPanel")
    private WebElement buttonPanel;

    public void searchItem(String item) {
        searchTextBox.sendKeys(item);
        searchButton.click();
    }

    public void clickOnSelectedIndexedItem(int index){
        waitTillElementClickable(itemLinks.get(itemLinks.size()-1));
        itemLinks.get(index-1).click();
    }


    public void addToCart(){
            List<WebElement>buttonList= buttonPanel.findElements(By.className("btn"));
            waitTillElementClickable(buttonList.get(buttonList.size()-1));
            buttonList.stream().filter(item->item.getText().contains("Add to cart"))
                    .findFirst().get().click();
    }

    public String getItemInCart(){
        waitTillElementVisible(By.id("gh-cart-n"));
        return itemInCart.getText();
    }


    public void goToCartConfirmation(){
        waitTillElementClickable(goToCartButton);
        goToCartButton.click();
    }

    @FindBy(xpath = "//*[@id=\"ADDON_0\"]/div/div[2]/div/div[4]/div/button[1]")
    private WebElement noThanks;

    public void noThanksAddOn(){
            waitTillElementClickable(noThanks);
            noThanks.click();
    }

    public void openCart() {
        cartIcon.click();
    }
}
