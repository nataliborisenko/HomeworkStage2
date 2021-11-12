package hurtmeplenty.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;


public abstract class AbstractPage {
    protected WebDriver webDriver;
    private final long timeOutOfSeconds = 20;

    public AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    protected void waitElementToClick(WebElement element) {
        new WebDriverWait(webDriver, timeOutOfSeconds).until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    protected void waitElementToVisibilityByXpathWithoutClick(String locator) {
        new WebDriverWait(webDriver, timeOutOfSeconds).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    protected void waitElementToVisibilityByXpathWithClick(String locator) {
        new WebDriverWait(webDriver, timeOutOfSeconds).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))).click();
    }

    protected void waitElementToVisibilityByLinkTextWithoutClick(String locator) {
        new WebDriverWait(webDriver, timeOutOfSeconds).until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locator)));
    }

    protected void waitElementToVisibilityByLinkTextWithClick(String locator) {
        new WebDriverWait(webDriver, timeOutOfSeconds).until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locator))).click();
    }
}

