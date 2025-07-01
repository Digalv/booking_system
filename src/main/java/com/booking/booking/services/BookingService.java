package com.booking.booking.services;

import com.booking.booking.Repository.BookingRepository;
import com.booking.booking.mapper.BookingMapper;
import com.booking.booking.models.Booking;
import com.booking.booking.models.DTO.BookingRequest;
import com.booking.booking.models.DTO.BookingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookingService implements IBookingService {
    private final BookingRepository _bookingRepository;
    private final BookingMapper _bookingMapper;

    @Autowired
    public BookingService(BookingRepository _bookingRepository, BookingMapper _bookingMapper) {
        this._bookingRepository = _bookingRepository;
        this._bookingMapper = _bookingMapper;
    }

    public BookingRequest getBooking(UUID id) {
        return null;
    }


    public UUID createBooking(BookingResponse bookingResponse) {
        Booking booking = _bookingMapper.BookingResponseToEntity(bookingResponse);
        _bookingRepository.save(booking);
        return booking.getId();
    }
}
