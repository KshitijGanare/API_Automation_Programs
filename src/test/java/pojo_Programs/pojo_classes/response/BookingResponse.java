package pojo_Programs.pojo_classes.response;

import pojo_Programs.pojo_classes.request.Booking;
import pojo_Programs.pojo_classes.request.BookingDates;

public class BookingResponse {
    BookingDates bookingid;
    Booking booking;

    public BookingDates getBookingid() {
        return bookingid;
    }

    public void setBookingid(BookingDates bookingid) {
        this.bookingid = bookingid;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }


}
