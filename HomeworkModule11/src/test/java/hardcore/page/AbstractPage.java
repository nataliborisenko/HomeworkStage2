package hardcore.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.util.ArrayList;

public class AbstractPage {
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

    protected void waitElementToVisibilityByXpathWithClick(String locator) {
        new WebDriverWait(webDriver, TIME_OUT_OF_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))).click();
    }

    protected void waitElementToVisibilityByLinkTextWithoutClick(String locator) {
        new WebDriverWait(webDriver, TIME_OUT_OF_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locator)));
    }

    protected void waitElementToVisibilityByLinkTextWithClick(String locator) {
        new WebDriverWait(webDriver, TIME_OUT_OF_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locator))).click();
    }

    public ArrayList<String> getAListOfOpenedWindows() {
        return new ArrayList<>(webDriver.getWindowHandles());
    }

    public void switchToWindow(int indexWindow) {
        webDriver.switchTo().window(getAListOfOpenedWindows().get(indexWindow));
    }
}
