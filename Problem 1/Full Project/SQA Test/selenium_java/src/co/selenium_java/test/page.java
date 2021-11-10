package co.selenium_java.test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class page {

	@FindBy(xpath = "//span[text()='Search by City Name']")
    private WebElement searchSpan;

    @FindBy(xpath = "//div[@id='select2-drop']//input")
    private WebElement searchCityInput;

    @FindBy(name ="checkin")
    private WebElement checkInInput;

    @FindBy(name ="checkout")
    private WebElement checkOutInput;

    @FindBy(id ="travellersInput")
    private WebElement travellersInput;

    @FindBy(id ="adultPlusBtn")
    private WebElement adultPlusBtn;

    @FindBy(xpath ="//button[text() = 'Search']")
    private WebElement searchButton;

    @FindBy(xpath ="//table[@class = 'bgwhite table table-striped']")
    private WebElement resultsTable ;

    @FindBy(xpath="//li[@class='select2-results-dept-1 select2-result']")
    private WebElement selectResult;


    private helper helper;
    private WebDriver driver;

    public void HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.helper = new helper(driver);
        this.driver = driver;
    }

    public void setCityHotel (String cityName)  {
        searchSpan.click();
        searchCityInput.sendKeys(cityName);
        helper.waitForElementToBeDesplayed(selectResult);
        searchCityInput.sendKeys(Keys.ENTER);
    }

    public void setDate(String checkInDate, String checkOutDate ) {
        checkInInput.sendKeys(checkInDate);
        checkOutInput.sendKeys(checkOutDate);
        checkOutInput.click();
    }


    public void openTravellersModal() {
        travellersInput.click();
        helper.waitForElementToBeDesplayed(adultPlusBtn);
    }


    public void addAdult() {
        adultPlusBtn.click();
    }


    public void performSearch() {
        searchButton.click();
    }


    public List<String> getCityNames() {
        List<String> CityNames = new ArrayList<>();
        helper.waitForLisOfWebElements(resultsTable.findElements(By.xpath(".//h4//b")));
        List<WebElement> CityNameWebElements = resultsTable.findElements(By.xpath(".//h4//b"));
        for(WebElement CityNameElement: CityNameWebElements) {
            System.out.println(CityNameElement.getText());
            CityNames.add(CityNameElement.getText());
        }
        return CityNames;
    }

}
