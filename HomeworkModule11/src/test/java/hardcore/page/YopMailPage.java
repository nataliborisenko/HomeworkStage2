package hardcore.page;

import org.apache.logging.log4j.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class YopMailPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private static final String BUTTON_TO_CREATE_RANDOM_EMAIL_ADDRESS = "//div[@class='txtlien']/b";
    private static final String LINE_TO_CHECK_LOADING_PAGE_WITH_RANDOM_EMAIL = "//h2[@class='pagetitle']";
    private static final String LINE_TO_CHECK_LOADING_PAGE_WITH_NEW_LETTER = "//*[contains(text(), 'Total Estimated Monthly Cost')]//following::h3";
    private static final String LINE_TO_CHECK_LOADING_PAGE_WITH_EMAIL = "//div[@id='nbmail']";

    @FindBy(xpath = "//div[@id='egen']")
    private WebElement lineWithRandomEmailAddress;

    @FindBy(xpath = "//span[contains(text(), 'Проверить почту')]")
    private WebElement buttonToCheckEmailBox;

    @FindBy(xpath = "//div[@id='nbmail']")
    private WebElement lineWithNumberOfEmailsInEmailBox;

    @FindBy(xpath = "//button[@id='refresh']")
    private WebElement buttonToRefreshPage;

    @FindBy(xpath = "//*[contains(text(), 'Total Estimated Monthly Cost')]//following::h3")
    private WebElement lineWithTotalCostInEmail;

    public YopMailPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void switchToWindowAndGenerateRandomEmail(int indexOfWindow, String command) {
        ((JavascriptExecutor) webDriver).executeScript(command);
        getAListOfOpenedWindows();
        switchToWindow(indexOfWindow);
        waitToCheckVisibilityOfElementLocatedWithClick(BUTTON_TO_CREATE_RANDOM_EMAIL_ADDRESS);
    }

    public String saveEmailAddress() {
        waitToCheckVisibilityOfElementLocatedWithoutClick(LINE_TO_CHECK_LOADING_PAGE_WITH_RANDOM_EMAIL);
        return lineWithRandomEmailAddress.getText();
    }

    public void switchToWindowAndCheckEmailBox(String numberOfEmails, int indexOfWindow) {
        switchToWindow(indexOfWindow);
        waitToCheckElementToBeClickable(buttonToCheckEmailBox);
        waitToCheckVisibilityOfElementLocatedWithoutClick(LINE_TO_CHECK_LOADING_PAGE_WITH_EMAIL);
        while (!lineWithNumberOfEmailsInEmailBox.getText().contains(numberOfEmails)) {
            buttonToRefreshPage.click();
        }
    }

    public String switchToFrameAndSaveTotalCost() {
        webDriver.switchTo().frame(2);
        waitToCheckVisibilityOfElementLocatedWithoutClick(LINE_TO_CHECK_LOADING_PAGE_WITH_NEW_LETTER);
        return lineWithTotalCostInEmail.getText();
    }
}
