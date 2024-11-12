package org.APIFramework.tests.individual;

import io.restassured.RestAssured;
import org.APIFramework.base.BaseClass;
import org.APIFramework.endpoints.APIConstants;
import org.APIFramework.payloads.UpdateCreatedBookingPayload;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class TestPUTAPI extends BaseClass {

    @Test
    public void testUpdatingCreateBooking(ITestContext context){

        String createdBookingId = (String) context.getAttribute("id");

        String token = getToken();

        requestSpecification.basePath(APIConstants.UPDATEBOOKING+createdBookingId)
                .cookie("token",token);

        response = RestAssured.given(requestSpecification)
                .when().body(UpdateCreatedBookingPayload.getUpdateBookingPayload()).put();

        response.then().log().all();




    }
}
