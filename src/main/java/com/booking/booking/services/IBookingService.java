package com.booking.booking.services;

import com.booking.booking.models.DTO.BookingRequest;
import com.booking.booking.models.DTO.BookingResponse;

import java.util.UUID;

public interface IBookingService {
    BookingRequest getBooking(UUID id);
    UUID createBooking(BookingResponse bookingResponse);
}
