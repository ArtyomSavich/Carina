package com.qaprosoft.carina.demo.api.dataWeather;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class GetDataWeatherMethodSecond extends AbstractApiMethodV2 {
        public GetDataWeatherMethodSecond(String name) {
                super(null, "api/weatherData/_get/rs.json");
                replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
                addParameterIfNotNull("id", name);
                addParameterIfNotNull("appid","3a7d92cc6e42f6db9e249daf72f0b2c7");
        }
}
