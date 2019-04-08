package util;

import io.restassured.response.Response;

import java.util.concurrent.TimeUnit;

import static io.qameta.allure.Allure.addAttachment;

public final class ReportUtil {

    private ReportUtil() {
    }

    public static Response logResponseTime (final Response response){
        addAttachment("response_time",
                Double.toString(response.getTimeIn(TimeUnit.MILLISECONDS) / 1000.0));
        return response;
    }
}
