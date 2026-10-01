package factory;

import config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    public static WebDriver createDriver() {

        String browser = Config.get("browser");
        String execution = Config.get("execution");

        if (execution.equalsIgnoreCase("local")) {
            return createLocalDriver(browser);
        }

        if (execution.equalsIgnoreCase("remote")) {
            return createRemoteDriver(browser);
        }

        throw new IllegalArgumentException(
                "Unsupported execution: " + execution
        );
    }

    private static WebDriver createLocalDriver(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
            return new ChromeDriver();
        }

        if (browser.equalsIgnoreCase("firefox")) {
            return new FirefoxDriver();
        }

        throw new IllegalArgumentException(
                "Unsupported browser: " + browser
        );
    }

    private static WebDriver createRemoteDriver(String browser) {

        try {
            URL gridUrl = new URL("http://localhost:4444");

            if (browser.equalsIgnoreCase("chrome")) {
                return new RemoteWebDriver(
                        gridUrl,
                        new ChromeOptions()
                );
            }

            if (browser.equalsIgnoreCase("firefox")) {
                return new RemoteWebDriver(
                        gridUrl,
                        new FirefoxOptions()
                );
            }

            throw new IllegalArgumentException(
                    "Unsupported browser: " + browser
            );

        } catch (MalformedURLException e) {
            throw new RuntimeException(
                    "Invalid Selenium Grid URL",
                    e
            );
        }
    }
}