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
    private static final String HIGHLIGHTING = "Bash";
    private static final String PASTE_TITLE = "how to gain dominance among developers";
    SeleniumHGWithSyntaxPage newCreatedPage;

    @BeforeClass(alwaysRun = true)
    public void browserSetup() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @Test(priority = 1, description = "Check paste title")
    public void checkingCreationNewPasteWithRightPasteTitle() {
                new SeleniumHGOriginPage(webDriver)
                .openPage(HOMEPAGE_URL)
                .addingCode(CODE_VALUE)
                .selectSyntaxInDropDownList()
                .selectExpirationInDropDownList()
                .turnOnHighlighting()
                .addingPasteTitle(PASTE_TITLE)
                .creationNewPasteAndSaving();
        newCreatedPage = new SeleniumHGWithSyntaxPage(webDriver);
        Assert.assertEquals((newCreatedPage.getTitle()), PASTE_TITLE);
    }

    @Test(priority = 2, description = "Check code")
    public void checkingCreationNewPasteWithRightCodeValue() {
        Assert.assertEquals(newCreatedPage.getValueOfCode(), CODE_VALUE);
    }

    @Test(priority = 3, description = "Check syntax highlighting")
    public void checkingCreationNewPasteWithRightSyntaxHighlighting() {
        Assert.assertEquals(newCreatedPage.getStyleValue(), HIGHLIGHTING);
    }

    @AfterClass(alwaysRun = true)
    public void browserTearDown() {
        webDriver.quit();
    }
}
