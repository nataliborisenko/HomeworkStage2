package bringiton.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class SeleniumHGWithSyntaxPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='info-top']/h1")
    private WebElement titleValue;

    @FindBy(xpath = "//textarea[@class='textarea']")
    private WebElement areaForWritingCode;

    @FindBy(xpath = "//div[@class='left']//a")
    private WebElement styleValue;

    public SeleniumHGWithSyntaxPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getTitle() {
        return titleValue.getText();
    }

    public String getValueOfCode() {
        return areaForWritingCode.getText();
    }

    public String getStyleValue() {
        return styleValue.getText();
    }
}





