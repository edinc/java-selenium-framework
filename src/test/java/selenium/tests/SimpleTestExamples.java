package selenium.tests;

import selenium.driver.Driver;
import io.qameta.allure.Description;
import selenium.localization.LocaleText;
import org.testng.annotations.Test;
import selenium.pageobject.HomePage;
import selenium.context.Base;
import selenium.pageobject.LoginPage;
import selenium.testdata.properties.User;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SimpleTestExamples extends Base {

    @Test(description = "Page title test")
    @Description("Checks if the page title is correct")
    public void pageTitleTest() {

        HomePage homePage = new HomePage(Driver.getDriver());
        assertThat(homePage.getPageTitle(), equalTo(LocaleText.get("homePage.title")));
    }

    @Test(description = "Authentication test")
    @Description("Checks if user is able to log in")
    public void loginTest() {

        User user = fileLoaderService.getUser("user");

        HomePage homePage = new HomePage(Driver.getDriver());
        homePage.goToLoginPage();

        LoginPage loginPage = new LoginPage(Driver.getDriver());
        loginPage.login(user.getUsername(), user.getPassword());

        assertThat(loginPage.getCurrentUrl(), equalTo(appUrl + "secure"));
    }
}
