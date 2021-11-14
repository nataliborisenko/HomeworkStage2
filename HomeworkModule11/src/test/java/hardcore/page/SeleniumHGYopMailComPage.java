package hardcore.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class SeleniumHGYopMailComPage extends AbstractPage {

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

    public SeleniumHGYopMailComPage(WebDriver webDriver) {
        super(webDriver);
    }

    public SeleniumHGYopMailComPage generateRandomEmail(int indexOfWindow) {
        String command = "window.open('https://yopmail.com/ru/','_blank');";
        ((JavascriptExecutor) webDriver).executeScript(command);
        getAListOfOpenedWindows();
        switchToWindow(indexOfWindow);
        waitElementToVisibilityByXpathWithClick(BUTTON_TO_CREATE_RANDOM_EMAIL_ADDRESS);
        return this;
    }

    public String saveEmailAddress() {
        waitElementToVisibilityByXpathWithoutClick(LINE_TO_CHECK_LOADING_PAGE_WITH_RANDOM_EMAIL);
        return lineWithRandomEmailAddress.getText();
    }

    public void checkEmailBox(String numberOfEmails, int indexOfWindow) {
        switchToWindow(indexOfWindow);
        waitElementToClick(buttonToCheckEmailBox);
        waitElementToVisibilityByXpathWithoutClick(LINE_TO_CHECK_LOADING_PAGE_WITH_EMAIL);
        while (!lineWithNumberOfEmailsInEmailBox.getText().contains(numberOfEmails)) {
            buttonToRefreshPage.click();
        }
    }

    public String saveTotalCost() {
        webDriver.switchTo().frame(2);
        waitElementToVisibilityByXpathWithoutClick(LINE_TO_CHECK_LOADING_PAGE_WITH_NEW_LETTER);
        return lineWithTotalCostInEmail.getText();
    }
}
