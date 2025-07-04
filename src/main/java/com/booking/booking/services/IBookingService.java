package com.booking.booking.services;

import com.booking.booking.models.DTO.BookingRequest;
import com.booking.booking.models.DTO.BookingResponse;

import java.util.UUID;

public interface IBookingService {
    BookingResponse getBooking(UUID id);
    UUID createBooking(BookingRequest bookingResponse);
}
