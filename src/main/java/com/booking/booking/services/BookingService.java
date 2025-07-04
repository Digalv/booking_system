package com.booking.booking.services;

import com.booking.booking.Repository.BookingRepository;
import com.booking.booking.mapper.BookingMapper;
import com.booking.booking.models.Booking;
import com.booking.booking.models.DTO.BookingRequest;
import com.booking.booking.models.DTO.BookingResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public BookingResponse getBooking(UUID id) {
        return null;
    }


    public UUID createBooking(BookingRequest bookingRequest) {
        Booking booking = bookingMapper.bookingRequestToEntity(bookingRequest);
        try {
            booking.setOffering(offeringService.getOfferingById(bookingRequest.getOffering()));
            booking.setCreatedAt(LocalDateTime.now());
            bookingRepository.save(booking);
            return booking.getId();
        } catch (Exception e) {
            throw new EntityNotFoundException("404");
        }
    }
}
