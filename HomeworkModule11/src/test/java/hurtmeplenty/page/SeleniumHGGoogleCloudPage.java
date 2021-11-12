package hurtmeplenty.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class SeleniumHGGoogleCloudPage extends AbstractPage {
    private WebDriver webDriver;

   private String lineToCheckLoadingPage = "Get started for free";

    @FindBy(name = "q")
    private WebElement searchButton;

    public SeleniumHGGoogleCloudPage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void openPageCloudGoogleCom(String HOMEPAGE_URL) {
        webDriver.get(HOMEPAGE_URL);
        waitElementToVisibilityByLinkTextWithoutClick(lineToCheckLoadingPage);
    }

    public void enterLineForSearchNewPage(String lineForSearch) {
        searchButton.click();
        searchButton.sendKeys(lineForSearch, Keys.ENTER);
    }

    public void goToChildIframe(String CHILD_IFRAME, String linkToSwitchToNeedPage) {
        waitElementToVisibilityByLinkTextWithClick(linkToSwitchToNeedPage);
        waitElementToVisibilityByLinkTextWithoutClick(lineToCheckLoadingPage);
        webDriver.get(CHILD_IFRAME);
    }
}




