package hardcore.page;

import org.apache.logging.log4j.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class EstimatePage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();
    private static final String LINE_WITH_VALUE_OF_GPU_TYPE = "//md-list-item[@class='md-no-proxy ng-scope']//div";
    private static final String LINE_TO_CHECK_LOADING_PAGE = "//span[contains (text(), 'Email Your Estimate')]";
    private static final String LINE_TO_CHECK_LOADING_PAGE_TO_INPUT_EMAIL = "//input[@id='input_527']";

    @FindBy(xpath = "//button[contains(text(), 'Email Estimate')]")
    private WebElement buttonToEmailEstimate;

    @FindBy(xpath = "//h2[@class='md-title']//b")
    private WebElement lineWithTotalCost;

    @FindBy(xpath = "//input[@id='input_527']")
    private WebElement lineToInputEmailAddress;

    @FindBy(xpath = "//button[contains(text(), 'Send Email')]")
    private WebElement buttonToSendEmail;

    public EstimatePage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getGPUType() {
        return webDriver.findElement(By.xpath(LINE_WITH_VALUE_OF_GPU_TYPE)).getText();
    }

    public void enterEmailEstimate() {
        waitToCheckElementToBeClickable(buttonToEmailEstimate);
        waitToCheckVisibilityOfElementLocatedWithoutClick(LINE_TO_CHECK_LOADING_PAGE);
    }

    public String saveTotalCostOfEstimationByProgram() {
        return lineWithTotalCost.getText();
    }

    public void switchToWindowAndEnterEmailAddress(String emailAddress, int indexOfWindow) {
        switchToWindow(indexOfWindow);
        waitToCheckVisibilityOfElementLocatedWithoutClick(LINE_TO_CHECK_LOADING_PAGE_TO_INPUT_EMAIL);
        lineToInputEmailAddress.sendKeys(emailAddress);
        logger.info("Switch to estimate window and enter an email address: " + emailAddress);
        waitToCheckElementToBeClickable(buttonToSendEmail);
    }
}


