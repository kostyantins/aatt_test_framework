package api.requests;

import static util.PropertiesReader.getProperty;

public class BasedRequest {

    protected static final String BASE_URL = getProperty("api.base.url");
    protected static final String BADGES_PATH = getProperty("api.base.badges.path");
}
