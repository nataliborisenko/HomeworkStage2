package hardcore.test;

import hardcore.model.GraphicsProcessingUnit;
import hardcore.page.*;
import hardcore.service.GPUCreator;
import org.testng.Assert;
import org.testng.annotations.*;

public class HardcoreTest extends CommonConditions {

    @Test(description = "Checking the cost in the calculator and in the letter")
    public void checkingTotalEstimationCost() {
        GraphicsProcessingUnit testGPU = GPUCreator.withCredentialsFromProperty();
        yopMailComPage = new YopMailPage(webDriver);

        cloudPage = new GoogleCloudPage(webDriver)
                .openPageCloudGoogleCom(HOMEPAGE_URL)
                .enterLineForSearchNewPage(LINE_FOR_SEARCH_NEW_PAGE);

        pricingCalculatorPage = cloudPage.goToChildIframe(URL_CHILD_IFRAME, LINE_FOR_SEARCH_NEW_PAGE);
        pricingCalculatorPage
                .addNumberOfInstances(NUMBER_OF_INSTANCES)
                .addOperationSystem()
                .addMachineClass()
                .addSeries()
                .addInstanceType()
                .addGPU()
                .addTypeAndNumberOfGPU(testGPU)
                .addLocalSSD()
                .addDatacenterLocation()
                .addCommittedUsage();
        estimatePage = pricingCalculatorPage.creationEstimate();
        totalCostOfEstimationByCalculator = estimatePage.saveTotalCostOfEstimationByProgram();
        estimatePage.enterEmailEstimate();
        yopMailComPage.switchToWindowAndGenerateRandomEmail(IndexOfPageWithRandomEmail, COMMAND_TO_OPEN_NEW_WINDOW_FOR_JAVASCRIPT_EXECUTOR);
        emailAddress = yopMailComPage.saveEmailAddress();
        estimatePage.switchToWindowAndEnterEmailAddress(emailAddress, indexOfPageWithEstimationPaste);
        yopMailComPage.switchToWindowAndCheckEmailBox(NUMBER_OF_EMAILS_IN_RANDOM_MAILBOX, IndexOfPageWithRandomEmail);
        totalCostOfEstimationInEmail = yopMailComPage.switchToFrameAndSaveTotalCost();

        Assert.assertTrue(totalCostOfEstimationByCalculator.contains(totalCostOfEstimationInEmail));
    }
}




