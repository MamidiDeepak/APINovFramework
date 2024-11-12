package org.APIFramework.pojo;

public class CreateBookingResponsePojo {

    private String bookingid;
    private CreateBookingPojo booking;

    public String getBookingid() {
        return bookingid;
    }

    public void setBookingid(String bookingid) {
        this.bookingid = bookingid;
    }

    public CreateBookingPojo getBooking() {
        return booking;
    }

    public void setBooking(CreateBookingPojo booking) {
        this.booking = booking;
    }
}
