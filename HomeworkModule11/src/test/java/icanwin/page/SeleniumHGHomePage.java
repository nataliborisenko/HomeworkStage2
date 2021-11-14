package icanwin.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class SeleniumHGHomePage extends AbstractPage {

    private static final String BUTTON_TO_SEARCH_LOADING_HOME_PAGE = "//div[contains(text(), 'Optional Paste Settings')]";
    private static final String LINE_TO_CHECK_LOADING_CREATED_PAGE = "//div[contains(text(), 'RAW Paste Data')]";

    @FindBy(id = "postform-text")
    private WebElement entryLineForCode;

    @FindBy(xpath = "//span[@id='select2-postform-expiration-container']")
    private WebElement clickOnTheDropDownList;

    @FindBy(xpath = "//li[contains(text(), '10 Minutes')]")
    private WebElement optionToChangePasteExpiration;

    @FindBy(id = "postform-name")
    private WebElement entryLineForPasteTitle;

    @FindBy(xpath = "//button[contains(text(), 'Create New Paste')]")
    private WebElement buttonForCreationNewPaste;

    public SeleniumHGHomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public SeleniumHGHomePage openHomePage(String HOMEPAGE_URL) {
        webDriver.get(HOMEPAGE_URL);
        waitElementToVisibilityByXpathWithoutClick(BUTTON_TO_SEARCH_LOADING_HOME_PAGE);
        return this;
    }

    public SeleniumHGHomePage addingCodeValue(String CODE_VALUE) {
        entryLineForCode.sendKeys(CODE_VALUE);
        return this;
    }

    public SeleniumHGHomePage selectingValueInDropDownList() {
        waitElementToClick(clickOnTheDropDownList);
        optionToChangePasteExpiration.click();
        return this;
    }

    public SeleniumHGHomePage addingInformationAboutTitle(String PASTE_TITLE) {
        entryLineForPasteTitle.sendKeys(PASTE_TITLE);
        return this;
    }

    public void creationNewPaste() {
        waitElementToClick(buttonForCreationNewPaste);
        waitElementToVisibilityByXpathWithoutClick(LINE_TO_CHECK_LOADING_CREATED_PAGE);
    }
}





