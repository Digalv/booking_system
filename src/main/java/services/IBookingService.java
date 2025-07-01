package services;

import models.DTO.BookingRequestDTO;
import models.DTO.BookingResponceDTO;

import java.util.UUID;

public interface IBookingService {
    BookingRequestDTO getBooking(UUID id);
    UUID createBooking(BookingResponceDTO bookingResponceDTO);
}
