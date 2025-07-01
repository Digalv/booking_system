package com.booking.booking.services;

import com.booking.booking.models.DTO.BookingRequestDTO;
import com.booking.booking.models.DTO.BookingResponceDTO;

import java.util.UUID;

public interface IBookingService {
    BookingRequestDTO getBooking(UUID id);
    UUID createBooking(BookingResponceDTO bookingResponceDTO);
}
