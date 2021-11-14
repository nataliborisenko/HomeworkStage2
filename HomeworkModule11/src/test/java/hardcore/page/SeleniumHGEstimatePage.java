package hardcore.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class SeleniumHGEstimatePage extends AbstractPage {

    private static final String LINE_TO_CHECK_LOADING_PAGE = "//span[contains (text(), 'Email Your Estimate')]";
    private static final String LINE_TO_CHECK_LOADING_PAGE_TO_INPUT_EMAIL = "//input[@id='input_533']";

    @FindBy(xpath = "//button[contains(text(), 'Email Estimate')]")
    private WebElement buttonToEmailEstimate;

    @FindBy(xpath = "//h2[@class='md-title']//b")
    private WebElement lineWithTotalCost;

    @FindBy(xpath = "//input[@id='input_533']")
    private WebElement lineToInputEmailAddress;

    @FindBy(xpath = "//button[contains(text(), 'Send Email')]")
    private WebElement buttonToSendEmail;

    public SeleniumHGEstimatePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterEmailEstimate() {
        waitElementToClick(buttonToEmailEstimate);
        waitElementToVisibilityByXpathWithoutClick(LINE_TO_CHECK_LOADING_PAGE);
    }

    public String saveTotalCostOfEstimationByProgram() {
        return lineWithTotalCost.getText();
    }

    public void enterEmailAddress(String emailAddress, int indexOfWindow) {
        switchToWindow(indexOfWindow);
        waitElementToVisibilityByXpathWithoutClick(LINE_TO_CHECK_LOADING_PAGE_TO_INPUT_EMAIL);
        lineToInputEmailAddress.sendKeys(emailAddress);
        waitElementToClick(buttonToSendEmail);
    }
}


