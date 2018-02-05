package selenium.localization;

import selenium.config.DomainConfiguration;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.ResourceBundle;

@Component
public class LocaleText {

    private static final Locale LOCALE = DomainConfiguration.APP_DOMAIN.getLocale();


    public static String get(final String key) {

        /*************************************************************************
         **  The resource bundle by default uses the ISO 8859-1 character encoding
         **  Making it compatible with the commonly used UTF-8 format
         *************************************************************************/

        final String value = ResourceBundle.getBundle("locale", LOCALE).getString(key);
        final byte[] utf8Bytes = value.getBytes(Charset.forName("ISO-8859-1"));
        return new String(utf8Bytes, Charset.forName("UTF-8"));
    }
}
