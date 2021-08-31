package com.qaprosoft.carina.demo.api.dataWeather;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetDataWeatherByGeogCoord extends AbstractApiMethodV2 {
    public GetDataWeatherByGeogCoord() {
        super(null, "api/dataWeatherByGeogCoord/_get/rs.json","api/dataWeatherByGeogCoord/_get/dataWeatherByGeogCoord.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        addParameter("appid",ApiKey.getKey());
    }

}
