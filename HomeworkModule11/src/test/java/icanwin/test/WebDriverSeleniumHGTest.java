package icanwin.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import icanwin.page.*;

public class WebDriverSeleniumHGTest {
    private WebDriver webDriver;
    private static final String HOMEPAGE_URL = "https://pastebin.com";
    private static final String CODE_VALUE = "Hello from WebDriver";
    private static final String PASTE_EXPIRATION = "10 MIN";
    private static final String PASTE_TITLE = "helloweb";
    SeleniumHGNewPastePage newPastePage;

    @BeforeClass(alwaysRun = true)
    public void browserSetup() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @Test(priority = 1, description = "Check code value")
    public void checkingCreationNewPasteWithCodeValue() {
        newPastePage = new SeleniumHGNewPastePage(webDriver);
        new SeleniumHGHomePage(webDriver)
                .openHomePage(HOMEPAGE_URL)
                .addingCodeValue(CODE_VALUE)
                .selectingValueInDropDownList()
                .addingInformationAboutTitle(PASTE_TITLE)
                .creationNewPaste();
        Assert.assertEquals(newPastePage.getValueOfCode(), CODE_VALUE);
    }

    @Test(priority = 2, description = "Check paste expiration")
    public void checkingCreationNewPasteWithPasteExpiration() {
        Assert.assertEquals(newPastePage.getValueOfPasteExpiration(), PASTE_EXPIRATION);
    }

    @Test(priority = 3, description = "Check paste title")
    public void checkingCreationNewPasteWithRightPasteTitle() {
        Assert.assertEquals(newPastePage.getValueOfPasteTitle(), PASTE_TITLE);
    }

    @AfterClass(alwaysRun = true)
    public void browserTearDown() {
        webDriver.quit();
    }
}
