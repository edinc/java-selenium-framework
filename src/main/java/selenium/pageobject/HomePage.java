package selenium.pageobject;

import selenium.driver.Driver;
import org.openqa.selenium.WebDriver;

public class HomePage extends Driver {

    public HomePage(WebDriver driver) {

        super(driver);
    }

    public String getPageTitle() {
        return getDriver().getTitle();
    }
}
