package selenium.config;

import selenium.appDomain.AppDomain;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class DomainConfiguration {

    public static final AppDomain APP_DOMAIN = getAppDomain();

    @Autowired
    private Environment env;

    private static AppDomain getAppDomain() {
        final String countryCode = System.getProperty("country");
        Preconditions.checkNotNull(countryCode, "\"country\" system property missing");
        return AppDomain.fromCountryCode(countryCode);
    }

    @Bean(name = "appUrl")
    public String appUrl() {
        return env.getProperty("appUrl." + APP_DOMAIN.getCountryCode());
    }

    @Bean(name = "browser")
    public String browser() {
        return env.getProperty("browser");
    }
}
