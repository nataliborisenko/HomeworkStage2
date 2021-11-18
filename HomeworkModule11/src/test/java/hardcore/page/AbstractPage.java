package hardcore.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.util.ArrayList;

public class AbstractPage {
    protected WebDriver webDriver;
    protected final long TIME_OUT_OF_SECONDS = 20;

    protected AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    protected void waitToCheckElementToBeClickable(WebElement element) {
        new WebDriverWait(webDriver, TIME_OUT_OF_SECONDS).until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void waitToCheckVisibilityOfElementLocatedWithoutClick(String locator) {
        new WebDriverWait(webDriver, TIME_OUT_OF_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    protected void waitToCheckVisibilityOfElementLocatedWithClick(String locator) {
        new WebDriverWait(webDriver, TIME_OUT_OF_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))).click();
    }

    protected ArrayList<String> getAListOfOpenedWindows() {
        return new ArrayList<>(webDriver.getWindowHandles());
    }

    protected void switchToWindow(int indexWindow) {
        webDriver.switchTo().window(getAListOfOpenedWindows().get(indexWindow));
    }
}
