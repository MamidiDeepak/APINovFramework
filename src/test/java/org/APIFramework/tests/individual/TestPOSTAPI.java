package org.APIFramework.tests.individual;

import io.restassured.RestAssured;
import org.APIFramework.assertions.AssertActions;
import org.APIFramework.base.BaseClass;
import org.APIFramework.endpoints.APIConstants;
import org.APIFramework.payloads.CreateBookingPayload;
import org.APIFramework.pojo.CreateBookingResponsePojo;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class TestPOSTAPI extends BaseClass {

    @Test
    public void testCreationOfBooking(ITestContext context){

        requestSpecification.basePath(APIConstants.CREATEBOOKING);

      response =  RestAssured.given(requestSpecification)
                .when().body(CreateBookingPayload.getCreateBookingPayload()).post();

      response.then().log().all();

        CreateBookingResponsePojo cff = CreateBookingPayload.getDeSerializedResponse(response.asString());

//        Assert.assertEquals(cff.getBooking().getFirstname(),"Deepak");

//        AssertActions.validateResponseData(cff.getBooking().getFirstname(),"Deepak");

        AssertActions.validateResponseDataUsingAssertJ(cff.getBooking().getFirstname(),"Deepak");

        String bookId =  cff.getBookingid();
        context.setAttribute("id",bookId);

    }
}
