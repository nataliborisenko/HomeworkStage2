package icanwin.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class SeleniumHGNewPastePage extends AbstractPage {
    private WebDriver webDriver;

    @FindBy(xpath = "//div[@class='de1']")
    private WebElement valueOfCode;

    @FindBy(xpath = "//div[@class='expire']")
    private WebElement valueOfPasteExpiration;

    @FindBy(xpath = "//div[@class='info-top']/h1")
    private WebElement valueOfPasteTitle;

    public SeleniumHGNewPastePage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public String getValueOfCode() {
        return valueOfCode.getText();
    }

    public String getValueOfPasteExpiration() {
        return valueOfPasteExpiration.getText();
    }

    public String getValueOfPasteTitle() {
        return valueOfPasteTitle.getText();
    }
}