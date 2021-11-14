package hardcore.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class SeleniumHGPricingCalculatorPage extends AbstractPage {
    private static final String LINE_COMPUTE_ENGINE = "//*[@id='mainForm']//md-tab-item[1]";
    private static final String OPTION_IN_NUMBER_OF_GPUS = "//md-option[@id='select_option_456']//div";
    private static final String BUTTON_TO_CREATE_ESTIMATE = "//button[contains(text(), 'Add to Estimate')]";
    private static final String LINE_TO_CHECK_LOADING_ESTIMATE_PAGE = "//div[@class='md-toolbar-tools cpc-estimate-header']//h2";

    @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement lineForAddingNumberOfInstances;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_66']")
    private WebElement clickOnDropDownListOfOperationSystem;

    @FindBy(xpath = "//md-option[@id='select_option_76']")
    private WebElement optionInOperatingSystem;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_67']")
    private WebElement clickOnDropDownListOfVMClass;

    @FindBy(xpath = "//md-option[@id='select_option_89']")
    private WebElement optionInVMClass;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_69']")
    private WebElement clickOnDropDownListOfSeries;

    @FindBy(xpath = "//*[contains(text(), 'N1')]")
    private WebElement optionInSeries;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_70']")
    private WebElement clickOnDropDownListOfInstanceType;

    @FindBy(xpath = "//*[contains(text(), 'n1-standard-8 (vCPUs: 8, RAM: 30GB')]")
    private WebElement optionInInstanceType;

    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
    private WebElement buttonToAddGPUs;

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']//md-select-value")
    private WebElement clickOnDropDownListNumbersOfGPUs;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement clickOnDropDownListOfGPUType;

    @FindBy(xpath = "//*[contains(text(), 'NVIDIA Tesla P4')]")
    private WebElement optionInGPUsType;

    @FindBy(xpath = "//md-select[@placeholder='Local SSD']//md-select-value")
    private WebElement clickOnDropDownListOfLocalSSD;

    @FindBy(xpath = "//*[contains(text(), '2x375 GB')]")
    private WebElement optionInLocalSSD;

    @FindBy(xpath = "//md-select[@placeholder='Datacenter location']//md-select-value")
    private WebElement clickOnDropDownListOfLocations;

    @FindBy(xpath = "//md-option[@id='select_option_235']//div")
    private WebElement optionInLocation;

    @FindBy(xpath = "//md-select[@placeholder='Committed usage']//md-select-value")
    private WebElement clickOnDropDownListOfCommittedUsage;

    @FindBy(xpath = "//md-option[@id='select_option_112']//div")
    private WebElement optionInCommittedUsage;

    public SeleniumHGPricingCalculatorPage(WebDriver webDriver) {
        super(webDriver);
    }

    public SeleniumHGPricingCalculatorPage addNumberOfInstances(String numberOfInstances) {
        waitElementToVisibilityByXpathWithoutClick(LINE_COMPUTE_ENGINE);
        lineForAddingNumberOfInstances.sendKeys(numberOfInstances);
        return this;
    }

    public SeleniumHGPricingCalculatorPage addOperationSystem() {
        waitElementToClick(clickOnDropDownListOfOperationSystem);
        optionInOperatingSystem.click();
        return this;
    }

    public SeleniumHGPricingCalculatorPage addMachineClass() {
        waitElementToClick(clickOnDropDownListOfVMClass);
        optionInVMClass.click();
        return this;
    }

    public SeleniumHGPricingCalculatorPage addSeries() {
        waitElementToClick(clickOnDropDownListOfSeries);
        optionInSeries.click();
        return this;
    }

    public SeleniumHGPricingCalculatorPage addInstanceType() {
        waitElementToClick(clickOnDropDownListOfInstanceType);
        optionInInstanceType.click();
        return this;
    }

    public SeleniumHGPricingCalculatorPage addGPUsAndNumberOfGPUs() {
        waitElementToClick(buttonToAddGPUs);
        waitElementToClick(clickOnDropDownListNumbersOfGPUs);
        waitElementToVisibilityByXpathWithClick(OPTION_IN_NUMBER_OF_GPUS);
        return this;
    }

    public SeleniumHGPricingCalculatorPage addGPUType() {
        waitElementToClick(clickOnDropDownListOfGPUType);
        optionInGPUsType.click();
        return this;
    }

    public SeleniumHGPricingCalculatorPage addLocalSSD() {
        waitElementToClick(clickOnDropDownListOfLocalSSD);
        optionInLocalSSD.click();
        return this;
    }

    public SeleniumHGPricingCalculatorPage addDatacenterLocation() {
        waitElementToClick(clickOnDropDownListOfLocations);
        optionInLocation.click();
        return this;
    }

    public SeleniumHGPricingCalculatorPage addCommittedUsage() {
        waitElementToClick(clickOnDropDownListOfCommittedUsage);
        optionInCommittedUsage.click();
        return this;
    }

    public SeleniumHGPricingCalculatorPage creationEstimate() {
        waitElementToVisibilityByXpathWithClick(BUTTON_TO_CREATE_ESTIMATE);
        waitElementToVisibilityByXpathWithoutClick(LINE_TO_CHECK_LOADING_ESTIMATE_PAGE);
        return this;
    }
}
