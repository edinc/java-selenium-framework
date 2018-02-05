package selenium.appDomain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Locale;

public enum AppDomain {

    DE("de", 17, new Locale("de")),
    UK("uk", 43, new Locale("en")),
    FR("fr", 18, new Locale("fr")),
    NL("nl", 35, new Locale("nl")),
    BE("be", 36, new Locale("nl", "BE")),
    BEFR("befr", 37, new Locale("fr", "BE")),
    COM("com", 38, new Locale("en")),
    AT("at", 39, new Locale("de", "AT")),
    CH("ch", 40, new Locale("de", "CH")),
    CHFR("chfr", 41, new Locale("fr", "CH")),
    IT("it", 44, new Locale("it")),
    PL("pl", 45, new Locale("pl")),
    DEV("dev", 17, new Locale("dev"));


    private final String countryCode;
    private final Locale locale;
    private final int appDomainId;


    AppDomain(String countyCode, int appDomainId, Locale locale) {

        this.appDomainId = appDomainId;
        this.countryCode = countyCode;
        this.locale = locale;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public Locale getLocale() {
        return locale;
    }

    public static AppDomain fromCountryCode(final String countryCode) {
        for (final AppDomain tld : AppDomain.values()) {
            if (tld.getCountryCode().equalsIgnoreCase(countryCode)) {
                return tld;
            }
        }

        switch (countryCode) {

            case "co.uk":
            case "gb":
                return UK;

            default:
                throw new IllegalArgumentException("No constant with countryCode" + countryCode + "found");
        }
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("countryCode", countryCode)
                .append("locale", locale)
                .append("appDomainID", appDomainId)
                .toString();
    }
}
