package co.uk.zoopla.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends BasePage {
    public Homepage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "search-input-location")
    private WebElement searchField;
    @FindBy(id = "forsale_price_min")
    private WebElement minPrice;
    @FindBy(id = "forsale_price_max")
    private WebElement maxPrice;
    @FindBy(id = "property_type")
    private WebElement property;
    @FindBy(id = "beds_min")
    private WebElement noOfBeds;
    @FindBy(id = "search-submit")
    private WebElement submitButton;

    public void enterLocation(String location)
    {   waitForElementToBeDisplayed(searchField);
        searchField.clear();
        searchField.sendKeys(location);
    }
    public void selectMinimumPrice(String miniPrice)
    {
        selectElementByVisibleText(minPrice, miniPrice);
    }
    public void selectMaxPrice(String maxiPrice)
    {
        selectElementByVisibleText(maxPrice, maxiPrice);
    }
    public void selectNoOfRooms(String beds)
    {
        selectElementByVisibleText(noOfBeds, beds);
    }

    public void selectPropertyType(String propertyType){
        selectElementByVisibleText(property, propertyType);
    }
    public SearchResultPage clickSubmitButton()
    {
        submitButton.click();
        return new SearchResultPage(driver);
    }
}
