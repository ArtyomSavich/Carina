package com.qaprosoft.carina.demo.api.dataWeather;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetDataWeatherByRectangleZone extends AbstractApiMethodV2 {
    public GetDataWeatherByRectangleZone() {
        super(null, "api/dataWeatherByRectangleZone/_get/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        addParameter("appid","3a7d92cc6e42f6db9e249daf72f0b2c7");
    }

}