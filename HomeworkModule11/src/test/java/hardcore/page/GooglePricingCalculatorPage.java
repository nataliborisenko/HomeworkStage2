package hardcore.page;

import hardcore.model.GraphicsProcessingUnit;
import org.apache.logging.log4j.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class GooglePricingCalculatorPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private static final String LINE_COMPUTE_ENGINE = "//*[@id='mainForm']//md-tab-item[1]";
    private static final String BUTTON_TO_CREATE_ESTIMATE = "//button[contains(text(), 'Add to Estimate')]";
    private static final String LINE_TO_CHECK_LOADING_ESTIMATE_PAGE = "//div[@class='md-toolbar-tools cpc-estimate-header']//h2";
    private static final String PATH_TO_CHOOSE_TYPE_OF_GPU = "//div[contains(text(), '%s')]";
    private static final String PATH_CHOOSE_NUMBER_OF_GPU = "//md-option[@id='select_option_462']//div[contains(text(), '%s')]";

    @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement lineForAddingNumberOfInstances;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_67']")
    private WebElement clickOnDropDownListOfOperationSystem;

    @FindBy(xpath = "//md-option[@id='select_option_77']")
    private WebElement optionInOperatingSystem;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_68']")
    private WebElement clickOnDropDownListOfVMClass;

    @FindBy(xpath = "//md-option[@id='select_option_90']")
    private WebElement optionInVMClass;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_70']")
    private WebElement clickOnDropDownListOfSeries;

    @FindBy(xpath = "//div[contains(text(), 'N1')]")
    private WebElement optionInSeries;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_71']")
    private WebElement clickOnDropDownListOfInstanceType;

    @FindBy(xpath = "//div[contains(text(), 'n1-standard-8 (vCPUs: 8, RAM: 30GB')]")
    private WebElement optionInInstanceType;

    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
    private WebElement buttonToAddGPUs;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement clickOnDropDownListOfGPUType;

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement clickOnDropDownListNumbersOfGPUs;

    @FindBy(xpath = "//md-select[@placeholder='Local SSD']//md-select-value")
    private WebElement clickOnDropDownListOfLocalSSD;

    @FindBy(xpath = "//div[contains(text(), '2x375 GB')]")
    private WebElement optionInLocalSSD;

    @FindBy(xpath = "//md-select[@placeholder='Datacenter location']//md-select-value")
    private WebElement clickOnDropDownListOfLocations;

    @FindBy(xpath = "//md-option[@id='select_option_236']//div")
    private WebElement optionInLocation;

    @FindBy(xpath = "//md-select[@placeholder='Committed usage']//md-select-value")
    private WebElement clickOnDropDownListOfCommittedUsage;

    @FindBy(xpath = "//md-option[@id='select_option_113']//div")
    private WebElement optionInCommittedUsage;

    public GooglePricingCalculatorPage(WebDriver webDriver) {
        super(webDriver);
    }

    public GooglePricingCalculatorPage addNumberOfInstances(String numberOfInstances) {
        waitToCheckVisibilityOfElementLocatedWithoutClick(LINE_COMPUTE_ENGINE);
        lineForAddingNumberOfInstances.sendKeys(numberOfInstances);
        return this;
    }

    public GooglePricingCalculatorPage addOperationSystem() {
        waitToCheckElementToBeClickable(clickOnDropDownListOfOperationSystem);
        optionInOperatingSystem.click();
        return this;
    }

    public GooglePricingCalculatorPage addMachineClass() {
        waitToCheckElementToBeClickable(clickOnDropDownListOfVMClass);
        optionInVMClass.click();
        return this;
    }

    public GooglePricingCalculatorPage addSeries() {
        waitToCheckElementToBeClickable(clickOnDropDownListOfSeries);
        optionInSeries.click();
        return this;
    }

    public GooglePricingCalculatorPage addInstanceType() {
        waitToCheckElementToBeClickable(clickOnDropDownListOfInstanceType);
        optionInInstanceType.click();
        return this;
    }

    public GooglePricingCalculatorPage addGPU() {
        buttonToAddGPUs.click();
        return this;
    }

    public GooglePricingCalculatorPage addTypeAndNumberOfGPU(GraphicsProcessingUnit testGPU) {

        waitToCheckElementToBeClickable(clickOnDropDownListOfGPUType);
        webDriver.findElement(By.xpath(String.format(PATH_TO_CHOOSE_TYPE_OF_GPU, testGPU.getTypeOfGPU()))).click();

        waitToCheckElementToBeClickable(clickOnDropDownListNumbersOfGPUs);
        webDriver.findElement(By.xpath(String.format(PATH_CHOOSE_NUMBER_OF_GPU, testGPU.getNumberOfGPU()))).click();
        return this;
    }

    public GooglePricingCalculatorPage addLocalSSD() {
        waitToCheckElementToBeClickable(clickOnDropDownListOfLocalSSD);
        optionInLocalSSD.click();
        return this;
    }

    public GooglePricingCalculatorPage addDatacenterLocation() {
        waitToCheckElementToBeClickable(clickOnDropDownListOfLocations);
        optionInLocation.click();
        return this;
    }

    public void addCommittedUsage() {
        waitToCheckElementToBeClickable(clickOnDropDownListOfCommittedUsage);
        optionInCommittedUsage.click();
    }

    public EstimatePage creationEstimate() {
        waitToCheckVisibilityOfElementLocatedWithClick(BUTTON_TO_CREATE_ESTIMATE);
        waitToCheckVisibilityOfElementLocatedWithoutClick(LINE_TO_CHECK_LOADING_ESTIMATE_PAGE);
        logger.info("Creation estimation is finished");
        return new EstimatePage(webDriver);
    }
}
