package com.booking.booking.Exceptions;

import java.time.LocalDateTime;

public class BookingTimeNotAvaibleException extends RuntimeException {
    public BookingTimeNotAvaibleException(String message) {
        super(message);
    }

    public BookingTimeNotAvaibleException(LocalDateTime bookingTime, String message) {
        super( bookingTime.toString() + message);
    }
}
