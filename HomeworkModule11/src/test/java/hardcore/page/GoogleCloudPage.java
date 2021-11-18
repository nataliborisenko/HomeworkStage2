package hardcore.page;

import org.apache.logging.log4j.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.*;

public class GoogleCloudPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();
    @FindBy(name = "q")
    private WebElement searchButton;

    public GoogleCloudPage(WebDriver webDriver) {
        super(webDriver);
    }

    public GoogleCloudPage openPageCloudGoogleCom(String HOMEPAGE_URL) {
        webDriver.navigate().to(HOMEPAGE_URL);
        return this;
    }

    public GoogleCloudPage enterLineForSearchNewPage(String lineForSearch) {
        searchButton.click();
        searchButton.sendKeys(lineForSearch, Keys.ENTER);
        return this;
    }

    public GooglePricingCalculatorPage goToChildIframe(String CHILD_IFRAME, String linkToSwitchToNeedPage) {
        new WebDriverWait(webDriver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.linkText(linkToSwitchToNeedPage))).click();
        webDriver.navigate().to(CHILD_IFRAME);
        logger.info("Switch to child frame");
        return new GooglePricingCalculatorPage(webDriver);

    }
}


