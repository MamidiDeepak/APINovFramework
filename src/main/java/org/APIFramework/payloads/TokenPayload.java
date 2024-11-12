package org.APIFramework.payloads;

import com.google.gson.Gson;
import org.APIFramework.pojo.TokenPojo;
import org.APIFramework.pojo.TokenResponse;

public class TokenPayload {

    static Gson gson = new Gson();

    public static String getTokenPayload(){

        TokenPojo tokenPojo = new TokenPojo();
        tokenPojo.setUsername("admin");
        tokenPojo.setPassword("password123");

//        Convert the java payload to Json payload
        String jsonTokenPayload = gson.toJson(tokenPojo);
        return jsonTokenPayload;
    }

    public static TokenResponse getDeSerializedResponse(String response){
        TokenResponse tokenResponse = gson.fromJson(response, TokenResponse.class);
        return tokenResponse;
    }
}
