package com.qaprosoft.carina.demo.api.dataWeather;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetDataWeatherByRectangleZone extends AbstractApiMethodV2 {
    public GetDataWeatherByRectangleZone() {
        super(null, "api/dataWeatherByRectangleZone/_get/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        addParameter("appid",ApiKey.getKey());
    }

}
