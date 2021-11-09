package hurtmeplenty.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class SeleniumHGGoogleCloudPage {
    private WebDriver webDriver;

    @FindBy(name = "q")
    private WebElement buttonToOpenSearch;


    public SeleniumHGGoogleCloudPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public SeleniumHGGoogleCloudPage openGoogleCloud(String HOMEPAGE_URL) {
        webDriver.get(HOMEPAGE_URL);
        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Get started for free")));
        ;
        return this;
    }

    public SeleniumHGGoogleCloudPage addSearchLineAndAchieveNewURL(String lineForSearch) {
        buttonToOpenSearch.click();
        buttonToOpenSearch.sendKeys(lineForSearch, Keys.ENTER);                                   //!
        return this;
    }
}
