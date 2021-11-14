package hardcore.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class SeleniumHGGoogleCloudPage extends AbstractPage {
    private static final String LINE_TO_CHECK_LOADING_PAGE = "Get started for free";

    @FindBy(name = "q")
    private WebElement searchButton;

    public SeleniumHGGoogleCloudPage(WebDriver webDriver) {
        super(webDriver);
    }

    public SeleniumHGGoogleCloudPage openPageCloudGoogleCom(String HOMEPAGE_URL) {
        webDriver.get(HOMEPAGE_URL);
        waitElementToVisibilityByLinkTextWithoutClick(LINE_TO_CHECK_LOADING_PAGE);
        return this;
    }

    public SeleniumHGGoogleCloudPage enterLineForSearchNewPage(String lineForSearch) {
        searchButton.click();
        searchButton.sendKeys(lineForSearch, Keys.ENTER);
        return this;
    }

    public SeleniumHGGoogleCloudPage goToChildIframe(String CHILD_IFRAME, String linkToSwitchToNeedPage) {
        waitElementToVisibilityByLinkTextWithClick(linkToSwitchToNeedPage);
        waitElementToVisibilityByLinkTextWithoutClick(LINE_TO_CHECK_LOADING_PAGE);
        webDriver.get(CHILD_IFRAME);
        return this;
    }
}


