package hurtmeplenty.test;

import hurtmeplenty.page.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class WebDriverSeleniumHGTest {
    private WebDriver webDriver;
    private static final String HOMEPAGE_URL = "https://cloud.google.com/";
    private static final String CHILD_IFRAME = "https://cloudpricingcalculator.appspot.com";
    private static final String LINE_FOR_SEARCH_NEW_PAGE = "Google Cloud Platform Pricing Calculator";
    private static final String numberOfInstances = "4";
    private static final String VMClass = "regular";
    private static final String instanceType = "n1-standard-8";
    private static final String localSSD = "2x375 GiB";
    private static final String location = "Frankfurt";
    private static final String commitmentTerm = "1 Year";
    private static final String amountOfRentByManuallyPassing = "1,084.69";

    SeleniumHGGoogleCloudPage cloudPage;
    SeleniumHGPricingCalculatorPage pricingCalculatorPage;
    SeleniumHGEstimatePage estimatePage;


    @BeforeClass(alwaysRun = true)
    public void creationEstimateComputeEngine() {
        webDriver = new ChromeDriver();
        cloudPage = new SeleniumHGGoogleCloudPage(webDriver);
        pricingCalculatorPage = new SeleniumHGPricingCalculatorPage(webDriver);
        estimatePage = new SeleniumHGEstimatePage(webDriver);

        cloudPage.openPageCloudGoogleCom(HOMEPAGE_URL);
        cloudPage.enterLineForSearchNewPage(LINE_FOR_SEARCH_NEW_PAGE);
        cloudPage.goToChildIframe(CHILD_IFRAME,LINE_FOR_SEARCH_NEW_PAGE);

        pricingCalculatorPage.addNumberOfIstances(numberOfInstances);
        pricingCalculatorPage.addOperationSystem();
        pricingCalculatorPage.addMachineClass();
        pricingCalculatorPage.addSeries();
        pricingCalculatorPage.addInstanceType();
        pricingCalculatorPage.addGPUsAndNumberOfGPUs();
        pricingCalculatorPage.addGPUType();
        pricingCalculatorPage.addLocalSSD();
        pricingCalculatorPage.addDatacenterLocation();
        pricingCalculatorPage.addCommitedUsage();
        pricingCalculatorPage.creationEstimate();
    }

    @Test(description = "Check VM Class")
    public void checkingEstimationWithRightVMClass() {
        Assert.assertTrue(estimatePage.getVMClassValue().contains(VMClass));
    }

    @Test(description = "Check Instance Type")
    public void checkingCreationEstimationWithRightInstance() {
        Assert.assertTrue(estimatePage.getInstanceTypeValue().contains(instanceType));
    }

    @Test(description = "Check Local SSD")
    public void checkingCreationNewEstimationPasteWithRightLocalSSD() {
        Assert.assertTrue((estimatePage.getLocalSSDValue()).contains(localSSD));
    }

    @Test(description = "Check Location")
    public void checkingCreationNewEstimationPasteWithRightLocation() {
        Assert.assertTrue((estimatePage.getLocationValue()).contains(location));
    }

    @Test(description = "Check Committed usage")
    public void checkingCreationNewEstimationPasteWithRightCommittedUsage() {
        Assert.assertTrue(estimatePage.getCommittedUsageValue().contains(commitmentTerm));
    }

    @Test(description = "Check the amount of rent by manual passing and automation")
    public void checkingAmountByManualPassingAndAutomation() {
        Assert.assertTrue(estimatePage.getAmountByAutomation().contains(amountOfRentByManuallyPassing));
    }

    @AfterClass(alwaysRun = true)
    public void browserTearDown() {
        webDriver.quit();
    }
}

