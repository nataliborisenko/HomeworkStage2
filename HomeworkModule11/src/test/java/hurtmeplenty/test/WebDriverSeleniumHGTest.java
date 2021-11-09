package hurtmeplenty.test;

import hurtmeplenty.page.SeleniumHGGoogleCloudPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class WebDriverSeleniumHGTest {
    private WebDriver webDriver;
    private static final String HOMEPAGE_URL = "https://cloud.google.com/";
    private static final String lineForSearch = "Google Cloud Platform Pricing Calculator";


    @BeforeClass(alwaysRun = true)
    public void activateComputerEngine() {
        webDriver = new ChromeDriver();
        new SeleniumHGGoogleCloudPage(webDriver)
                .openGoogleCloud(HOMEPAGE_URL);
    }
}
