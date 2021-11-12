package bringiton.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import bringiton.page.*;

public class WebDriverSeleniumHGTest {
    private WebDriver webDriver;
    private static final String HOMEPAGE_URL = "https://pastebin.com";
    private static final String CODE_VALUE = "git config --global user.name \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    private static final String HIGHLIGHTING = "bash";
    private static final String PASTE_TITLE = "how to gain dominance among developers";
    protected SeleniumHGOriginPage homePage;
    protected SeleniumHGWithSyntaxPage newCreatedPage;

    @BeforeClass(alwaysRun = true)
    public void creationNewPage() {
        webDriver = new ChromeDriver();
        homePage = new SeleniumHGOriginPage(webDriver);
        newCreatedPage = new SeleniumHGWithSyntaxPage(webDriver);

            homePage.openPage(HOMEPAGE_URL);
            homePage.addingCode(CODE_VALUE);
            homePage.selectSyntaxInDropDownList();
            homePage.selectExpirationInDropDownList();
            homePage.turnOnHighlighting();
            homePage.addingPasteTitle(PASTE_TITLE);
            homePage.creationNewPasteAndSaving();
    }

    @Test(description = "Check paste title")
    public void checkingCreationNewPasteWithRightPasteTitle() {
        Assert.assertEquals((newCreatedPage.getTitle()), PASTE_TITLE);
    }

    @Test(description = "Check code")
    public void checkingCreationNewPasteWithRightCodeValue() {
        Assert.assertEquals(newCreatedPage.getValueOfCode(), CODE_VALUE);
    }

    @Test(description = "Check syntax highlighting")
    public void checkingCreationNewPasteWithRightSyntaxHighlighting() {
        Assert.assertEquals(newCreatedPage.getStyleValue(), HIGHLIGHTING);
    }

    @AfterClass(alwaysRun = true)
    public void browserTearDown() {
        webDriver.quit();
    }
}
