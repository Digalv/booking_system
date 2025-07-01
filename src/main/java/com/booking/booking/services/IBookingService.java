package com.booking.booking.services;

import com.booking.booking.models.DTO.BookingRequestDTO;
import com.booking.booking.models.DTO.BookingResponseDTO;

import java.util.UUID;

public interface IBookingService {
    BookingRequestDTO getBooking(UUID id);
    UUID createBooking(BookingResponseDTO bookingResponceDTO);
}
