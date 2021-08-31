package com.qaprosoft.carina.demo.ebay;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.demo.api.dataWeather.*;

import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class APITest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    public void testGetDataByIdCity() {
        GetDataWeatherMethod getDataWeatherMethod = new GetDataWeatherMethod();
        getDataWeatherMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getDataWeatherMethod.addParameterIfNotNull("id", "625144");
        getDataWeatherMethod.callAPI();
        getDataWeatherMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getDataWeatherMethod.getProperties().replace("nameCity","skip","Minsk");
        getDataWeatherMethod.getProperties().replace("nameCountry","skip","BY");
        getDataWeatherMethod.validateResponseAgainstSchema("api/weatherData/_get/rs.schema");

    }
    @Test()
    public void testGetByNameCity(){
        GetDataWeatherByNameCity getDataWeatherByNameCity =new GetDataWeatherByNameCity();
        getDataWeatherByNameCity.expectResponseStatus(HttpResponseStatusType.OK_200);
        getDataWeatherByNameCity.addParameterIfNotNull("q", "Brest");
        getDataWeatherByNameCity.callAPI();
        getDataWeatherByNameCity.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getDataWeatherByNameCity.validateResponseAgainstSchema("api/weatherDataByName/_get/rs.schema");
    }


    @Test()
    public void testGetByGeogCoord(){
        GetDataWeatherByGeogCoord getDataWeatherByGeogCoord = new GetDataWeatherByGeogCoord();
        getDataWeatherByGeogCoord.expectResponseStatus(HttpResponseStatusType.OK_200);
        getDataWeatherByGeogCoord.addParameterIfNotNull("lat", "53,54");
        getDataWeatherByGeogCoord.addParameterIfNotNull("lon", "27,33");
        getDataWeatherByGeogCoord.callAPI();
        getDataWeatherByGeogCoord.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getDataWeatherByGeogCoord.getProperties().replace("nameCityByGC","skip","Yasen’");
        getDataWeatherByGeogCoord.getProperties().replace("nameCountry","skip","BY");
        getDataWeatherByGeogCoord.validateResponseAgainstSchema("api/dataWeatherByGeogCoord/_get/rs.schema");
    }
    @Test()
    public void testGetByGeogCoordLangRu(){
        GetDataWeatherByGeogCoordLangRu getDataWeatherByGeogCoordLangRu = new GetDataWeatherByGeogCoordLangRu();
        getDataWeatherByGeogCoordLangRu.expectResponseStatus(HttpResponseStatusType.OK_200);
        getDataWeatherByGeogCoordLangRu.addParameterIfNotNull("lat", "53,54");
        getDataWeatherByGeogCoordLangRu.addParameterIfNotNull("lon", "27,33");
        getDataWeatherByGeogCoordLangRu.addParameterIfNotNull("lang","ru");
        getDataWeatherByGeogCoordLangRu.callAPI();
        getDataWeatherByGeogCoordLangRu.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getDataWeatherByGeogCoordLangRu.validateResponseAgainstSchema("api/dataWeatherByGeogCoordRuLang/_get/rs.schema");
    }

    @Test()
    public void testGetByRectangleZone(){
        GetDataWeatherByRectangleZone getDataWeatherByRectangleZone = new GetDataWeatherByRectangleZone();
        getDataWeatherByRectangleZone.expectResponseStatus(HttpResponseStatusType.OK_200);
        getDataWeatherByRectangleZone.addParameterIfNotNull("bbox", "20,40,15,37,10");
        getDataWeatherByRectangleZone.callAPI();
        getDataWeatherByRectangleZone.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getDataWeatherByRectangleZone.validateResponseAgainstSchema("api/dataWeatherByRectangleZone/_get/rs.schema");
    }
}
