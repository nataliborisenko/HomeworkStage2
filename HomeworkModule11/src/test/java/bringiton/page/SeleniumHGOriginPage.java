package bringiton.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class SeleniumHGOriginPage extends AbstractPage {
    private WebDriver webDriver;

    private String buttonForCheckingLoadingOriginPage = "//div[contains(text(), 'Optional Paste Settings')]";
    private String lineForCheckingLoadingCreatedPage = "//div[contains(text(), 'RAW Paste Data')]";

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

    @FindBy(xpath = "//button[contains(text(), 'Create New Paste')]")
    private WebElement buttonForCreationNewPaste;

    @FindBy(xpath = " //a[contains(text(), 'download')]")
    private WebElement buttonToDownloadNewPaste;

    public SeleniumHGOriginPage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void openPage(String HOMEPAGE_URL) {
        webDriver.get(HOMEPAGE_URL);
        waitElementToVisibilityByXpathWithoutClick(buttonForCheckingLoadingOriginPage);
    }

    public void addingCode(String CODE_VALUE) {
        entryLineForCode.sendKeys(CODE_VALUE);
    }

    public void selectSyntaxInDropDownList() {
        waitElementToClick(clickOnTheDropDownSyntax);
        optionToChangeHighlighting.click();
    }

    public void selectExpirationInDropDownList() {
        waitElementToClick(clickOnTheDropDownExpiration);
        optionToChangePasteExpiration.click();
    }

    public void turnOnHighlighting() {
        waitElementToClick(turnOnHighlighting);
    }

    public void addingPasteTitle(String PASTE_TITLE) {
        entryLineForPasteTitle.sendKeys(PASTE_TITLE);
    }

    public void creationNewPasteAndSaving() {
        waitElementToClick(buttonForCreationNewPaste);
        waitElementToVisibilityByXpathWithoutClick(lineForCheckingLoadingCreatedPage);
        waitElementToClick(buttonToDownloadNewPaste);
    }
}

