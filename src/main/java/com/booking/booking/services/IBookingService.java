package com.booking.booking.services;

import com.booking.booking.models.Booking;
import com.booking.booking.models.DTO.BookingRequest;
import com.booking.booking.models.DTO.BookingResponse;

import java.util.UUID;

public interface IBookingService {
    Booking getBookingById(UUID id);
    BookingResponse getBookingResponse(UUID id);
    UUID createBooking(BookingRequest bookingResponse);
    void updateBooking(UUID id, BookingRequest bookingRequest);
    void deleteBooking(UUID id);
}
