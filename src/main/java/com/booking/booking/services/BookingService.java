package com.booking.booking.services;

import com.booking.booking.Repository.BookingRepository;
import com.booking.booking.mapper.BookingMapper;
import com.booking.booking.models.Booking;
import com.booking.booking.models.BookingStatus;
import com.booking.booking.models.DTO.BookingRequest;
import com.booking.booking.models.DTO.BookingResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class BookingService implements IBookingService {
    private final BookingRepository bookingRepository;
    private final OfferingService offeringService;
    private final BookingMapper bookingMapper;

    @Autowired
    public BookingService(BookingRepository bookingRepository, OfferingService offeringService, BookingMapper bookingMapper) {
        this.bookingRepository = bookingRepository;
        this.offeringService = offeringService;
        this.bookingMapper = bookingMapper;
    }

    @Override
    public Booking getBookingById(UUID id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Booking not found"));
    }

    @Override
    public BookingResponse getBookingResponse(UUID id) {
        return bookingMapper.bookingToResponse(getBookingById(id));
    }

    @Override
    public UUID createBooking(BookingRequest bookingRequest) {
        Booking booking = bookingMapper.bookingRequestToEntity(bookingRequest);
        booking.setOffering(offeringService.getOfferingById(bookingRequest.getOffering()));

        int i =
        if()
    }

    @Override
    public void updateBooking(UUID id, BookingRequest bookingRequest) {
        Booking booking = getBookingById(id);
    }

    @Override
    public void deleteBooking(UUID id) {
        Booking booking = getBookingById(id);
        bookingRepository.delete(booking);
    }
}
