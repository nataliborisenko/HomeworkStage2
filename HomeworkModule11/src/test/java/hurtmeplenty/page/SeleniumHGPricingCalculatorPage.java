package hurtmeplenty.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class SeleniumHGPricingCalculatorPage extends AbstractPage {
    private WebDriver webDriver;

    private String lineComputeEngine = "//*[@id='mainForm']//md-tab-item[1]";
    private String optionInNumberOfGPUs = "//md-option[@id='select_option_456']//div";
    private String buttonToCreateEstimate = "//button[contains(text(), 'Add to Estimate')]";
    private String lineToCheckLoadingEstimatePage = "//div[@class='md-toolbar-tools cpc-estimate-header']//h2";

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
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void addNumberOfIstances(String numberOfInstances) {
        waitElementToVisibilityByXpathWithoutClick(lineComputeEngine);
        lineForAddingNumberOfInstances.sendKeys(numberOfInstances);
    }

    public void addOperationSystem() {
        waitElementToClick(clickOnDropDownListOfOperationSystem);
        optionInOperatingSystem.click();
    }

    public void addMachineClass() {
        waitElementToClick(clickOnDropDownListOfVMClass);
        optionInVMClass.click();
    }

    public void addSeries() {
        waitElementToClick(clickOnDropDownListOfSeries);
        optionInSeries.click();
    }

    public void addInstanceType() {
        waitElementToClick(clickOnDropDownListOfInstanceType);
        optionInInstanceType.click();
    }

    public void addGPUsAndNumberOfGPUs() {
        waitElementToClick(buttonToAddGPUs);
        waitElementToClick(clickOnDropDownListNumbersOfGPUs);
        waitElementToVisibilityByXpathWithClick(optionInNumberOfGPUs);
    }

    public void addGPUType() {
        waitElementToClick(clickOnDropDownListOfGPUType);
        optionInGPUsType.click();
    }

    public void addLocalSSD() {
        waitElementToClick(clickOnDropDownListOfLocalSSD);
        optionInLocalSSD.click();
    }

    public void addDatacenterLocation() {
        waitElementToClick(clickOnDropDownListOfLocations);
        optionInLocation.click();
    }

    public void addCommitedUsage() {
        waitElementToClick(clickOnDropDownListOfCommittedUsage);
        optionInCommittedUsage.click();
    }

    public void creationEstimate() {
        waitElementToVisibilityByXpathWithClick(buttonToCreateEstimate);
        waitElementToVisibilityByXpathWithoutClick(lineToCheckLoadingEstimatePage);
    }
}
