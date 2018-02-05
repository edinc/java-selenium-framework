package selenium.testdata.file;



import com.fasterxml.jackson.databind.ObjectMapper;
import selenium.config.DomainConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import selenium.testdata.properties.User;

import java.io.IOException;

@Service
public class FileLoaderService {

    private static final String TEST_DATA_FOLDER = "testdata";
    private static final String USER_FOLDER = "user";

    private final ObjectMapper objectMapper;
    private final ResourceLoader resourceLoader;

    @Autowired
    public FileLoaderService(ObjectMapper objectMapper, ResourceLoader resourceLoader) {
        this.objectMapper = objectMapper;
        this.resourceLoader = resourceLoader;
    }

    public User getUser(final String fileNameWithoutCountryCodeAndExtention) {
        return load(USER_FOLDER + "/" + fileNameWithoutCountryCodeAndExtention + "_"
                + DomainConfiguration.APP_DOMAIN.getCountryCode() + ".json", User.class);
    }

    private <T> T load(final String filename, final Class<T> type) {
        try{
            final Resource resource =   resourceLoader.getResource(getFullPath(filename));
            return objectMapper.readValue(resource.getInputStream(), type);
        }catch (final IOException e) {
            throw new RuntimeException("Failed to load test data", e);
        }
    }

    private String getFullPath(final String filename) {
        return TEST_DATA_FOLDER + "/" + filename;
    }
}
