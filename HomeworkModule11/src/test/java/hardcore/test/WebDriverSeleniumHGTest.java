package hardcore.test;

import hardcore.page.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class WebDriverSeleniumHGTest {
    private WebDriver webDriver;
    private static final String HOMEPAGE_URL = "https://cloud.google.com/";
    private static final String CHILD_IFRAME = "https://cloudpricingcalculator.appspot.com";
    private static final String LINE_FOR_SEARCH_NEW_PAGE = "Google Cloud Platform Pricing Calculator";
    private static final String NUMBER_OF_INSTANCES = "4";
    private static final String NUMBER_OF_EMAILS_IN_RANDOM_MAILBOX = "1 mail";
    int indexOfPageWithEstimationPaste = 0;
    int IndexOfPageWithRandomEmail = 1;
    String totalCostOfEstimationByCalculator;
    String totalCostOfEstimationInEmail;
    String emailAddress;
    SeleniumHGGoogleCloudPage cloudPage;
    SeleniumHGPricingCalculatorPage pricingCalculatorPage;
    SeleniumHGEstimatePage estimatePage;
    SeleniumHGYopMailComPage yopMailComPage;

    @BeforeClass(alwaysRun = true)
    public void browserSetup() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @Test(description = "Checking the cost in the calculator and in the letter")
    public void checkingTotalEstimationCost() {
        estimatePage = new SeleniumHGEstimatePage(webDriver);
        yopMailComPage = new SeleniumHGYopMailComPage(webDriver);

        cloudPage = new SeleniumHGGoogleCloudPage(webDriver)
                .openPageCloudGoogleCom(HOMEPAGE_URL)
                .enterLineForSearchNewPage(LINE_FOR_SEARCH_NEW_PAGE)
                .goToChildIframe(CHILD_IFRAME, LINE_FOR_SEARCH_NEW_PAGE);

        pricingCalculatorPage = new SeleniumHGPricingCalculatorPage(webDriver)
                .addNumberOfInstances(NUMBER_OF_INSTANCES)
                .addOperationSystem()
                .addMachineClass()
                .addSeries()
                .addInstanceType()
                .addGPUsAndNumberOfGPUs()
                .addGPUType()
                .addLocalSSD()
                .addDatacenterLocation()
                .addCommittedUsage()
                .creationEstimate();
        totalCostOfEstimationByCalculator = estimatePage.saveTotalCostOfEstimationByProgram();

        estimatePage.enterEmailEstimate();

        yopMailComPage = new SeleniumHGYopMailComPage(webDriver)
                .generateRandomEmail(IndexOfPageWithRandomEmail);
        emailAddress = yopMailComPage.saveEmailAddress();
        estimatePage.enterEmailAddress(emailAddress, indexOfPageWithEstimationPaste);
        yopMailComPage.checkEmailBox(NUMBER_OF_EMAILS_IN_RANDOM_MAILBOX, IndexOfPageWithRandomEmail);
        totalCostOfEstimationInEmail = yopMailComPage.saveTotalCost();

        Assert.assertTrue(totalCostOfEstimationByCalculator.contains(totalCostOfEstimationInEmail));
    }

    @AfterClass(alwaysRun = true)
    public void browserTearDown() {
        webDriver.quit();
    }
}


