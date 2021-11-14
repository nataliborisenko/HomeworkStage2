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
    private static final String NUMBER_OF_INSTANCES = "4";
    private static final String VM_CLASS = "regular";
    private static final String INSTANCE_TYPE = "n1-standard-8";
    private static final String LOCAL_SSD = "2x375 GiB";
    private static final String LOCATION = "Frankfurt";
    private static final String COMMITMENT_TERM = "1 Year";
    private static final String AMOUNT_OF_RENT_BY_MANUAL_PASSING = "1,084.69";
    SeleniumHGEstimatePage estimatePage;

    @BeforeClass(alwaysRun = true)
    public void browserSetup() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @Test(priority = 1, description = "Check VM Class")
    public void checkingEstimationWithRightVMClass() {
        estimatePage = new SeleniumHGEstimatePage(webDriver);
        new SeleniumHGGoogleCloudPage(webDriver)
                .openPageCloudGoogleCom(HOMEPAGE_URL)
                .enterLineForSearchNewPage(LINE_FOR_SEARCH_NEW_PAGE)
                .goToChildIframe(CHILD_IFRAME, LINE_FOR_SEARCH_NEW_PAGE);
         new SeleniumHGPricingCalculatorPage(webDriver)
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
        Assert.assertTrue(estimatePage.getVMClassValue().contains(VM_CLASS));
    }

    @Test(priority = 2, description = "Check Instance Type")
    public void checkingCreationEstimationWithRightInstance() {
        Assert.assertTrue(estimatePage.getInstanceTypeValue().contains(INSTANCE_TYPE));
    }

    @Test(priority = 3, description = "Check Local SSD")
    public void checkingCreationNewEstimationPasteWithRightLocalSSD() {
        Assert.assertTrue((estimatePage.getLocalSSDValue()).contains(LOCAL_SSD));
    }

    @Test(priority = 4, description = "Check Location")
    public void checkingCreationNewEstimationPasteWithRightLocation() {
        Assert.assertTrue((estimatePage.getLocationValue()).contains(LOCATION));
    }

    @Test(priority = 5, description = "Check Committed usage")
    public void checkingCreationNewEstimationPasteWithRightCommittedUsage() {
        Assert.assertTrue(estimatePage.getCommittedUsageValue().contains(COMMITMENT_TERM));
    }

    @Test(priority = 6, description = "Check the amount of rent by manual passing and automation")
    public void checkingAmountByManualPassingAndAutomation() {
        Assert.assertTrue(estimatePage.getAmountByAutomation().contains(AMOUNT_OF_RENT_BY_MANUAL_PASSING));
    }

    @AfterClass(alwaysRun = true)
    public void browserTearDown() {
        webDriver.quit();
    }
}

