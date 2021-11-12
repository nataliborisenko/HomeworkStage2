package icanwin.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class SeleniumHGHomePage extends AbstractPage {
    private WebDriver webDriver;

    private String buttonForCheckingLoadingHomePage = "//div[contains(text(), 'Optional Paste Settings')]";
    private String lineForCheckingLoadingCreatedPage = "//div[contains(text(), 'RAW Paste Data')]";

    @FindBy(id = "postform-text")
    private WebElement entryLineForCode;

    @FindBy(xpath = "//span[@id='select2-postform-expiration-container']")
    private WebElement clickOnTheDropDownList;

    @FindBy (xpath = "//li[contains(text(), '10 Minutes')]")
    private WebElement optionToChangePasteExpiration;

    @FindBy(id = "postform-name")
    private WebElement entryLineForPasteTitle;

    @FindBy(xpath = "//button[contains(text(), 'Create New Paste')]")
    private WebElement buttonForCreationNewPaste;

    public SeleniumHGHomePage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void openHomePage(String HOMEPAGE_URL) {
        webDriver.get(HOMEPAGE_URL);
        waitElementToVisibilityByXpathWithoutClick(buttonForCheckingLoadingHomePage);
    }

    public void addingCodeValue(String CODE_VALUE) {
        entryLineForCode.sendKeys(CODE_VALUE);
    }

    public void selectingValueInDropDownList() {
        waitElementToClick(clickOnTheDropDownList);
        optionToChangePasteExpiration.click();
    }

    public void addingInformationAboutTitle(String PASTE_TITLE) {
        entryLineForPasteTitle.sendKeys(PASTE_TITLE);
    }

    public void creationNewPaste() {
        waitElementToClick(buttonForCreationNewPaste);
        waitElementToVisibilityByXpathWithoutClick(lineForCheckingLoadingCreatedPage);
    }
}





