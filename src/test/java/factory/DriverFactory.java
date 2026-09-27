package factory;

import config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver createDriver() {

        String browser = Config.get("browser");

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
}