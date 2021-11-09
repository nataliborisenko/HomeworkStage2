package bringiton.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class SeleniumHGPageWithSyntax {
    private WebDriver webDriver;

    @FindBy(xpath = "//textarea[@class='textarea']")
    private WebElement areaForWrittingCode;

    @FindBy(xpath = "//div[@class='source']//ol")
    private WebElement styleValue;

    public SeleniumHGPageWithSyntax(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public String getValueOfCode() {
        return areaForWrittingCode.getAttribute("text");
    }

    public String getStyleValue(){
        return styleValue.getAttribute("class");
    }
}





