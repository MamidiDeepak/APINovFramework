package org.APIFramework.base;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.APIFramework.assertions.AssertActions;
import org.APIFramework.endpoints.APIConstants;
import org.APIFramework.listeners.ReListener;
import org.APIFramework.listeners.ReTryAnalyzer;
import org.APIFramework.payloads.CreateBookingPayload;
import org.APIFramework.payloads.TokenPayload;
import org.APIFramework.pojo.TokenResponse;
import org.testng.annotations.BeforeClass;

public class BaseClass {

    public APIConstants apiConstants;
    public CreateBookingPayload createBookingPayload;
    public AssertActions assertActions;
    public ReListener reListener;
    public ReTryAnalyzer reTryAnalyzer;
    public RequestSpecification requestSpecification;
    public Response response;
    public JsonPath jsonPath;

    @BeforeClass
    public void baseClass(){
        requestSpecification = RestAssured.given()
                .baseUri(APIConstants.BASEURL)
                .contentType("application/json");
    }

    @BeforeClass
    public String getToken(){
        requestSpecification = RestAssured.given()
                .baseUri(APIConstants.BASEURL)
                .basePath(APIConstants.TOKEN)
                .contentType("application/json");

        response = RestAssured.given(requestSpecification)
                .when().body(TokenPayload.getTokenPayload()).post();

        response.then().log().all();

        TokenResponse tokenActualResponse = TokenPayload.getDeSerializedResponse(response.asString());

        String tokenId = tokenActualResponse.getToken();
        System.out.println("Generated token : "+tokenId);
        return tokenId;
    }
}
