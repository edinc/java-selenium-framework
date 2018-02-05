package selenium.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.driver.Driver;
import org.openqa.selenium.WebDriver;

public class HomePage extends Driver {

    public HomePage(WebDriver driver) {

        super(driver);
    }

    @FindBy(css = "a[href='/login']")
    private WebElement loginPageLink;

    public String getPageTitle() {
        return getDriver().getTitle();
    }

    public void goToLoginPage() {

        waitForElement(loginPageLink);
        loginPageLink.click();
    }
}
