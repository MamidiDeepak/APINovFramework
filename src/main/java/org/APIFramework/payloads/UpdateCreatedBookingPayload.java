package org.APIFramework.payloads;

import com.google.gson.Gson;
import org.APIFramework.pojo.CreateBookingDatesPojo;
import org.APIFramework.pojo.CreateBookingPojo;
import org.APIFramework.pojo.CreateBookingResponsePojo;

public class UpdateCreatedBookingPayload {

    static Gson gson = new Gson();

    public static String getUpdateBookingPayload(){

        CreateBookingPojo createBookingPojo = new CreateBookingPojo();
        createBookingPojo.setFirstname("Ram");
        createBookingPojo.setLastname("Kumar");
        createBookingPojo.setTotalprice(400082);
        createBookingPojo.setDepositpaid(false);

        CreateBookingDatesPojo createBookingDatesPojo = new CreateBookingDatesPojo();
        createBookingDatesPojo.setCheckin("2025-11-23");
        createBookingDatesPojo.setCheckout("2026-12-28");

        createBookingPojo.setBookingdates(createBookingDatesPojo);
        createBookingPojo.setAdditionalneeds("Lunch");

        String createBookingJsonPayload = gson.toJson(createBookingPojo);
        return createBookingJsonPayload;
    }

    public static CreateBookingResponsePojo getDeSerializedResponse(String response){
        CreateBookingResponsePojo crbp = gson.fromJson(response, CreateBookingResponsePojo.class);
        return crbp;
    }
}
