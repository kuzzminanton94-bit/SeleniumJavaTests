package pages;

import config.Config;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class GooglePage {

    private final WebDriver driver;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open Google")
    public void open() {
        driver.get(Config.get("baseUrl"));
    }

    @Step("Get page title")
    public String getTitle() {
        return driver.getTitle();
    }
}