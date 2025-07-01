package com.booking.booking.services;

import com.booking.booking.Repository.BookingRepository;
import com.booking.booking.mapper.BookingMapper;
import com.booking.booking.models.Booking;
import com.booking.booking.models.DTO.BookingRequestDTO;
import com.booking.booking.models.DTO.BookingResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookingService implements IBookingService {
    @Autowired
    private final BookingRepository _bookingRepository;
    private final BookingMapper _bookingMapper;

    public BookingService(BookingRepository _bookingRepository, BookingMapper _bookingMapper) {
        this._bookingRepository = _bookingRepository;
        this._bookingMapper = _bookingMapper;
    }

    public BookingRequestDTO getBooking(UUID id) {
        return null;
    }


    public UUID createBooking(BookingResponseDTO bookingResponseDTO) {
        Booking booking = _bookingMapper.BookingResponseToEntity(bookingResponseDTO);
        _bookingRepository.save(booking);
        return booking.getId();
    }
}
