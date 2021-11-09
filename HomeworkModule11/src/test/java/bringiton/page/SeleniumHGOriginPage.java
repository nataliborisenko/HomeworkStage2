package bringiton.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class SeleniumHGOriginPage {
    private WebDriver webDriver;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonForCheckingLoadingPage;

    @FindBy(xpath = "div[@class='content__title -no-border']")
    private WebElement lineForCheckingLoadingNewPage;

    @FindBy(id = "postform-text")
    private WebElement entryLineForCode;

    @FindBy(id = "select2-postform-format-container")
    private WebElement clickOnTheDropDownSyntax;

    @FindBy(xpath = "//select[@id='postform-format']//option[text()='Bash']")
    private WebElement optionToChangeHighlighting;

    @FindBy(xpath = "//div[@class='toggle']//label")
    private WebElement turnOnHighlighting;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement clickOnTheDropDownExpiration;

    @FindBy(xpath = "//ul[@role='listbox']//li[text()='10 Minutes']")
    private WebElement optionToChangePasteExpiration;

    @FindBy(id = "postform-name")
    private WebElement entryLineForPasteTitle;

    @FindBy(xpath = "//button[@class='btn -big']")
    private WebElement buttonForCreationNewPaste;

    public SeleniumHGOriginPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public SeleniumHGOriginPage openPage(String HOMEPAGE_URL) {
        webDriver.get(HOMEPAGE_URL);
        new WebDriverWait(webDriver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.valueOf(buttonForCheckingLoadingPage))));
        return this;
    }

    public SeleniumHGOriginPage addingCode(String CODE_VALUE) {
        entryLineForCode.sendKeys(CODE_VALUE);
        return this;
    }

    public SeleniumHGOriginPage selectSyntaxInDropDownList() {
        new WebDriverWait(webDriver, 10).until(ExpectedConditions.elementToBeClickable(By.id(String.valueOf(clickOnTheDropDownSyntax)))).click();
        optionToChangeHighlighting.click();
        turnOnHighlighting.click();
        return this;
    }

    public SeleniumHGOriginPage selectExpirationInDropDownList() {
        new WebDriverWait(webDriver, 10).until(ExpectedConditions.elementToBeClickable(By.id(String.valueOf(clickOnTheDropDownExpiration)))).click();
        optionToChangePasteExpiration.click();
        return this;
    }

    public SeleniumHGOriginPage addingPasteTitle(String PASTE_TITLE) {
        entryLineForPasteTitle.sendKeys(PASTE_TITLE);
        return this;
    }

    public String creationNewPaste() {
        buttonForCreationNewPaste.click();
        new WebDriverWait(webDriver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.valueOf(lineForCheckingLoadingNewPage))));
        return webDriver.getCurrentUrl();
    }
}
