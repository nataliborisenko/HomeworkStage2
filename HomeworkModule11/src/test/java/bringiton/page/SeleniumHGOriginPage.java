package bringiton.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class SeleniumHGOriginPage extends AbstractPage {

    private static final String BUTTON_TO_CHECK_LOADING_ORIGIN_PAGE = "//div[contains(text(), 'Optional Paste Settings')]";
    private static final String LINE_TO_CHECK_LOADING_CREATED_PAGE = "//div[contains(text(), 'RAW Paste Data')]";

    @FindBy(id = "postform-text")
    private WebElement entryLineForCode;

    @FindBy(xpath = "//span[@id='select2-postform-format-container']")
    private WebElement clickOnTheDropDownSyntax;

    @FindBy(xpath = "//li[contains(text(), 'Bash')]")
    private WebElement optionToChangeHighlighting;

    @FindBy(xpath = "//div[@class='toggle']//label")
    private WebElement turnOnHighlighting;

    @FindBy(xpath = "//span[@id='select2-postform-expiration-container']")
    private WebElement clickOnTheDropDownExpiration;

    @FindBy(xpath = "//li[contains(text(), '10 Minutes')]")
    private WebElement optionToChangePasteExpiration;

    @FindBy(id = "postform-name")
    private WebElement entryLineForPasteTitle;

    @FindBy(xpath = "//button[@class='btn -big']")
    private WebElement buttonForCreationNewPaste;

    @FindBy(xpath = " //a[contains(text(), 'download')]")
    private WebElement buttonToDownloadNewPaste;

    public SeleniumHGOriginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public SeleniumHGOriginPage openPage(String HOMEPAGE_URL) {
        webDriver.get(HOMEPAGE_URL);
        waitElementToVisibilityByXpathWithoutClick(BUTTON_TO_CHECK_LOADING_ORIGIN_PAGE);
        return this;
    }

    public SeleniumHGOriginPage addingCode(String CODE_VALUE) {
        entryLineForCode.sendKeys(CODE_VALUE);
        return this;
    }

    public SeleniumHGOriginPage selectSyntaxInDropDownList() {
        waitElementToClick(clickOnTheDropDownSyntax);
        optionToChangeHighlighting.click();
        return this;
    }

    public SeleniumHGOriginPage selectExpirationInDropDownList() {
        waitElementToClick(clickOnTheDropDownExpiration);
        optionToChangePasteExpiration.click();
        return this;
    }

    public SeleniumHGOriginPage turnOnHighlighting() {
        waitElementToClick(turnOnHighlighting);
        return this;
    }

    public SeleniumHGOriginPage addingPasteTitle(String PASTE_TITLE) {
        entryLineForPasteTitle.sendKeys(PASTE_TITLE);
        return this;
    }

    public void creationNewPasteAndSaving() {
        waitElementToClick(buttonForCreationNewPaste);
        waitElementToVisibilityByXpathWithoutClick(LINE_TO_CHECK_LOADING_CREATED_PAGE);
        waitElementToClick(buttonToDownloadNewPaste);
    }
}

