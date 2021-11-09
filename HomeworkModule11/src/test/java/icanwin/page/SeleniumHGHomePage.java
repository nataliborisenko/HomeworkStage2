package icanwin.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class SeleniumHGHomePage {
    private WebDriver webDriver;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonForCheckingLoadingPage;

    @FindBy(xpath = "div[@class='content__title -no-border']")
    private WebElement lineForCheckingLoadingNewPage;

    @FindBy(id = "postform-text")
    private WebElement entryLineForCode;

    @FindBy(xpath = "//span[@id='select2-postform-expiration-container']")
    private WebElement clickOnTheDropDownList;

    @FindBy(xpath = "//ul[@role='listbox']//li[text()='10 Minutes']")
    private WebElement findFieldToChangePasteExpiration;

    @FindBy(id = "postform-name")
    private WebElement entryLineForPasteTitle;

    @FindBy(xpath = "//button[@class='btn -big']")
    private WebElement buttonForCreationNewPaste;


    public SeleniumHGHomePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public SeleniumHGHomePage openHomePage(String HOMEPAGE_URL) {
        webDriver.get(HOMEPAGE_URL);
       new WebDriverWait(webDriver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.valueOf(buttonForCheckingLoadingPage))));
        return this;
    }

    public SeleniumHGHomePage addingCodeValue(String CODE_VALUE) {
        entryLineForCode.sendKeys(CODE_VALUE);
        return this;
    }

    public SeleniumHGHomePage selectingValueInDropDownList() {
         new WebDriverWait(webDriver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath(String.valueOf(clickOnTheDropDownList)))).click();
        findFieldToChangePasteExpiration.click();
        return this;
    }

    public SeleniumHGHomePage addingInformationAboutTitle(String PASTE_TITLE) {
        entryLineForPasteTitle.sendKeys(PASTE_TITLE);
        return this;
    }

    public String creationNewPaste() {
            buttonForCreationNewPaste.click();
          new WebDriverWait(webDriver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.valueOf(lineForCheckingLoadingNewPage))));
        return webDriver.getCurrentUrl();
    }
}





