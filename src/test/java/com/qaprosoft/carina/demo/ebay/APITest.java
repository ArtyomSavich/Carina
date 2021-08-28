package com.qaprosoft.carina.demo.ebay;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.api.GetUserMethods;
import com.qaprosoft.carina.demo.api.PostUserMethod;
import com.qaprosoft.carina.demo.api.dataWeather.GetDataWeatherMethod;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class APITest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    public void testGetDataByNameCity() {
        GetDataWeatherMethod getDataWeatherMethod = new GetDataWeatherMethod();
        getDataWeatherMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getDataWeatherMethod.callAPI();
        getDataWeatherMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getDataWeatherMethod.validateResponseAgainstSchema("api.weatherData/_get/rs.schema");
    }
}