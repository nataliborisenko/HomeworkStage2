package bringiton.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
}






