package com.qaprosoft.carina.demo.api.dataWeather;

import com.qaprosoft.carina.core.foundation.commons.SpecialKeywords;
import com.qaprosoft.carina.core.foundation.crypto.CryptoTool;
import com.qaprosoft.carina.core.foundation.utils.R;

import java.util.regex.Pattern;

public class ApiKey {
    public static String getKey(){
        CryptoTool cryptoTool = new CryptoTool("/Users/asavich/Documents/crypto.key");
        Pattern CRYPTO_PATTERN = Pattern.compile(SpecialKeywords.CRYPT);

        return (cryptoTool.decryptByPattern(R.TESTDATA.get("api_key"), CRYPTO_PATTERN).replaceAll("\"", "*"));
    }
}
