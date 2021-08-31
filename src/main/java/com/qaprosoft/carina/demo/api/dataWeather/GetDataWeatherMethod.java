package com.qaprosoft.carina.demo.api.dataWeather;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class GetDataWeatherMethod extends AbstractApiMethodV2 {

        public GetDataWeatherMethod() {
                super(null, "api/weatherData/_get/rs.json", "api/weatherData/dataWeather.properties");
                replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
                addParameter("appid",ApiKey.getKey());
        }

}
