package icanwin.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

public abstract class AbstractPage {
    protected WebDriver webDriver;
    private static final long TIME_OUT_OF_SECONDS = 20;

    public AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    protected void waitElementToClick(WebElement element) {
        new WebDriverWait(webDriver, TIME_OUT_OF_SECONDS).until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void waitElementToVisibilityByXpathWithoutClick(String locator) {
        new WebDriverWait(webDriver, TIME_OUT_OF_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }
}
