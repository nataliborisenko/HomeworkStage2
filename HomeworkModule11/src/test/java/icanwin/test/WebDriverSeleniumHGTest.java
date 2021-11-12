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
    protected SeleniumHGHomePage homePage;
    protected SeleniumHGNewPastePage newPastePage;

    @BeforeClass(alwaysRun = true)
    public void creationNewPaste() {
        webDriver = new ChromeDriver();
        homePage = new SeleniumHGHomePage(webDriver);
        newPastePage = new SeleniumHGNewPastePage(webDriver);

        homePage.openHomePage(HOMEPAGE_URL);
        homePage.addingCodeValue(CODE_VALUE);
        homePage.selectingValueInDropDownList();
        homePage.addingInformationAboutTitle(PASTE_TITLE);
        homePage.creationNewPaste();
    }

    @Test(description = "Check code value")
    public void checkingCreationNewPasteWithCodeValue() {
        Assert.assertEquals(newPastePage.getValueOfCode(), CODE_VALUE);
    }

    @Test(description = "Check paste expiration")
    public void checkingCreationNewPasteWithPasteExpiration() {
        Assert.assertEquals(newPastePage.getValueOfPasteExpiration(), PASTE_EXPIRATION);
    }

    @Test(description = "Check paste title")
    public void checkingCreationNewPasteWithRightPasteTitle() {
        Assert.assertEquals(newPastePage.getValueOfPasteTitle(), PASTE_TITLE);
    }

    @AfterClass(alwaysRun = true)
    public void browserTearDown() {
        webDriver.quit();
    }
}
