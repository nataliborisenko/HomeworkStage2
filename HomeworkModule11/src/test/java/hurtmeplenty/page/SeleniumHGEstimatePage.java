package hurtmeplenty.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class SeleniumHGEstimatePage {
    private WebDriver webDriver;

    @FindBy(xpath = "//md-list[@class='cartitem ng-scope']//*[contains(text(), 'VM class')]")
    private WebElement lineToCheckValueOfVMClass;

    @FindBy(xpath = "//md-list[@class='cartitem ng-scope']//*[contains(text(), ' Instance type')]")
    private WebElement lineToCheckValueOfInstanceType;

    @FindBy(xpath = "//md-list[@class='cartitem ng-scope']//*[contains(text(), 'Local SSD')]")
    private WebElement lineToCheckValueOfLocalSSD;

    @FindBy(xpath = "//md-list[@class='cartitem ng-scope']//*[contains(text(), 'Region')]")
    private WebElement lineToCheckValueOfLocation;

    @FindBy(xpath = "//md-list-item[@class='md-1-line md-no-proxy ng-scope']/div")
    private WebElement lineToCheckValueOfCommitmentTerm;

    @FindBy(xpath = "//h2[@class='md-title']//b")
    private WebElement totalEstimatedCostByAutomation;

    public SeleniumHGEstimatePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public String getVMClassValue() {
        return lineToCheckValueOfVMClass.getText();
    }

    public String getInstanceTypeValue() {
        return lineToCheckValueOfInstanceType.getText();
    }

    public String getLocalSSDValue() {
        return lineToCheckValueOfLocalSSD.getText();
    }

    public String getLocationValue() {
        return lineToCheckValueOfLocation.getText();
    }

    public String getCommittedUsageValue() {
        return lineToCheckValueOfCommitmentTerm.getText();
    }

    public String getAmountByAutomation() {
        return totalEstimatedCostByAutomation.getText();
    }
}


