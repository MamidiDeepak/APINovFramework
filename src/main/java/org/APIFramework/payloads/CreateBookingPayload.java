package org.APIFramework.payloads;

import com.google.gson.Gson;
import org.APIFramework.pojo.CreateBookingDatesPojo;
import org.APIFramework.pojo.CreateBookingPojo;
import org.APIFramework.pojo.CreateBookingResponsePojo;

public class CreateBookingPayload {

    static Gson gson = new Gson();

    public static String getCreateBookingPayload(){

        CreateBookingPojo createBookingPojo = new CreateBookingPojo();
        createBookingPojo.setFirstname("Deepak");
        createBookingPojo.setLastname("Mamidi");
        createBookingPojo.setTotalprice(50000);
        createBookingPojo.setDepositpaid(true);

        CreateBookingDatesPojo createBookingDatesPojo = new CreateBookingDatesPojo();
        createBookingDatesPojo.setCheckin("2024-11-11");
        createBookingDatesPojo.setCheckout("2024-11-18");

        createBookingPojo.setBookingdates(createBookingDatesPojo);
        createBookingPojo.setAdditionalneeds("dinner");

        String createBookingJsonPayload = gson.toJson(createBookingPojo);
        return createBookingJsonPayload;
    }

    public static CreateBookingResponsePojo getDeSerializedResponse(String response){
        CreateBookingResponsePojo crbp = gson.fromJson(response, CreateBookingResponsePojo.class);
        return crbp;
    }
}
