package selenium.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {

    private static final String HEADLESS = "headless";
    
    private static String getDriverPath(String osName) {
        if (osName.contains("win")) {
            return "driver/windows";
        } else if (osName.contains("mac")) {
            return "driver/osx";
        } else {
            // Default to Linux for Unix-based systems
            return "driver/linux";
        }
    }
    public static WebDriver createInstance(String browserName, String appUrl, String methodName) throws MalformedURLException {
        final String browserMode = System.getProperty("mode");
        final String osName = System.getProperty("os.name").toLowerCase();
        String driverPath = getDriverPath(osName);
        WebDriver driver = null;
        if(browserName.toLowerCase().contains("firefox")) {
            System.setProperty("webdriver.gecko.driver", driverPath + "/geckodriver");
            if(browserMode !=null  && browserMode.equals(HEADLESS)){
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");
                driver = new FirefoxDriver(firefoxOptions);
            }else {
                driver = new FirefoxDriver();
            }

        }
        if(browserName.toLowerCase().contains("chrome")) {
            System.setProperty("webdriver.chrome.driver", driverPath + "/chromedriver");
            if(browserMode !=null  && browserMode.equals(HEADLESS)){
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                driver = new ChromeDriver(chromeOptions);
            }else {
                driver = new ChromeDriver();
            }

        }
        if(browserName.toLowerCase().contains("zalenium")) {
            DesiredCapabilities cap = DesiredCapabilities.chrome();
            cap.setCapability("name", methodName);
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
        }
        driver.navigate().to(appUrl);
        return driver;
    }
}
