package com.booking.booking.services;

import com.booking.booking.Repository.BookingRepository;
import com.booking.booking.models.DTO.BookingRequestDTO;
import com.booking.booking.models.DTO.BookingResponceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookingService implements IBookingService {
    @Autowired
    private final BookingRepository _bookingRepository;

    public BookingService(BookingRepository _bookingRepository) {
        this._bookingRepository = _bookingRepository;
    }

    @Override
    public BookingRequestDTO getBooking(UUID id) {
        return null;
    }

    @Override
    public UUID createBooking(BookingResponceDTO bookingResponceDTO) {
        return null;
    }
}
