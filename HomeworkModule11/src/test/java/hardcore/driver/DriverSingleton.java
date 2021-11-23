package hardcore.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {
    private static WebDriver webDriver;
    private final static Logger logger = LogManager.getRootLogger();
    private DriverSingleton() {
    }

    public static WebDriver getWebDriver() {
        if (null == webDriver) {
            switch (System.getProperty("browser")) {
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    webDriver = new FirefoxDriver();
                    logger.info("setup with firefox");
                }
                case "chrome": {
                    WebDriverManager.chromedriver().setup();
                    webDriver = new ChromeDriver();
                    logger.info("setup with chrome");
                }
            }
            webDriver.manage().window().maximize();
        }

        return webDriver;
    }

    public static void closeWebDriver() {
        webDriver.quit();
        webDriver = null;
    }
}
