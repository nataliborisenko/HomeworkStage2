package hardcore.test;

import hardcore.model.GraphicsProcessingUnit;
import hardcore.page.GoogleCloudPage;
import hardcore.service.GPUCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GPUTest extends CommonConditions {
    @Test
    public void creationNewEstimateWithRightGPU() {
        GraphicsProcessingUnit testGPU = GPUCreator.withCredentialsFromProperty();
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
        String result = estimatePage.getGPUType();

        Assert.assertTrue(result.contains(testGPU.getTypeOfGPU().toUpperCase()));


    }
}

