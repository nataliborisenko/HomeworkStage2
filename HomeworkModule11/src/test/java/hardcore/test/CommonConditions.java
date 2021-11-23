package hardcore.test;

import hardcore.driver.DriverSingleton;
import hardcore.page.*;
import hardcore.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners({TestListener.class})
public abstract class CommonConditions {
    protected WebDriver webDriver;
    protected static final String HOMEPAGE_URL = "https://cloud.google.com/";
    protected static final String URL_CHILD_IFRAME = "https://cloudpricingcalculator.appspot.com";
    protected static final String LINE_FOR_SEARCH_NEW_PAGE = "Google Cloud Pricing Calculator";
    protected static final String NUMBER_OF_INSTANCES = "4";
    protected static final String COMMAND_TO_OPEN_NEW_WINDOW_FOR_JAVASCRIPT_EXECUTOR = "window.open('https://yopmail.com/ru/','_blank');";
    protected static final String NUMBER_OF_EMAILS_IN_RANDOM_MAILBOX = "1 mail";
    protected int indexOfPageWithEstimationPaste = 0;
    protected int IndexOfPageWithRandomEmail = 1;
    protected String totalCostOfEstimationByCalculator;
    protected String totalCostOfEstimationInEmail;
    protected String emailAddress;
    protected GoogleCloudPage cloudPage;
    protected GooglePricingCalculatorPage pricingCalculatorPage;
    protected EstimatePage estimatePage;
    protected YopMailPage yopMailComPage;

    @BeforeClass(alwaysRun = true)
    public void browserSetup(){
        webDriver= DriverSingleton.getWebDriver();
    }

    @AfterClass(alwaysRun = true)
    public void browserTearDown() {
       DriverSingleton.closeWebDriver();
    }
}

