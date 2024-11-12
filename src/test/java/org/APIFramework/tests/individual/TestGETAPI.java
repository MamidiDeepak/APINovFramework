package org.APIFramework.tests.individual;

import io.restassured.RestAssured;
import org.APIFramework.base.BaseClass;
import org.APIFramework.endpoints.APIConstants;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class TestGETAPI extends BaseClass {

    @Test
    public void testCreatedBookingDetails(ITestContext context){

        String createdId = (String) context.getAttribute("id");

        requestSpecification.basePath(APIConstants.GETBOOKING+createdId);

        response = RestAssured.given(requestSpecification)
                .when().get();

        response.then().log().all();
    }
}
