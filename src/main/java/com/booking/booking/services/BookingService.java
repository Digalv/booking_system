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
import java.time.LocalTime;
import java.util.Optional;
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
        if (!isBookingSlotFree(booking)){
            throw new EntityNotFoundException("NOT AVAIBLE"); // СДЕЛАТЬ ОШИБКУ
        }
        bookingRepository.save(booking);
        return booking.getId();
    }

    @Override
    public void updateBooking(UUID id, BookingRequest bookingRequest) {
        Booking bookingUpdate = bookingMapper.bookingRequestToEntity(bookingRequest);
        bookingUpdate.setOffering(offeringService.getOfferingById(bookingRequest.getOffering()));

        Booking booking = getBookingById(id);
        if(!isBookingSlotFree(bookingUpdate)){
            throw new EntityNotFoundException("NOT AVAIBLE"); // СДЕЛАТЬ ОШИБКУ
        }
        booking.setClientName(bookingUpdate.getClientName());
        booking.setClientEmail(booking.getClientEmail());
        booking.setStatus(bookingUpdate.getStatus());
        booking.setStartTime(bookingUpdate.getStartTime());
        booking.setOffering(bookingUpdate.getOffering());

        bookingRepository.save(booking);
    }

    @Override
    public void deleteBooking(UUID id) {
        Booking booking = getBookingById(id);
        bookingRepository.delete(booking);
    }

    public boolean isBookingSlotFree(Booking booking){
        LocalDateTime bookingStartTime = booking.getStartTime();
        LocalDateTime bookingEndTime = booking.getEndTime();

        LocalTime startDay = LocalTime.of(8,0,0);
        LocalTime endDay = LocalTime.of(18,0,0);

        if(bookingStartTime.toLocalTime().isBefore(startDay)
          || bookingEndTime.toLocalTime().isAfter(endDay)) {
            return false;
        }


        LocalDateTime previousBookingEndTime = bookingRepository.findPreviousByTime(bookingStartTime)
                .map( previousBooking -> previousBooking.getEndTime())
                .orElse(LocalDateTime.MIN);
        LocalDateTime nextBookingStartTime = bookingRepository.findNextByTime(bookingStartTime)
                .map(nextBooking -> nextBooking.getStartTime())
                .orElse(LocalDateTime.MAX);

        if (bookingStartTime.isBefore(previousBookingEndTime)
            || bookingEndTime.isAfter(nextBookingStartTime)){
            return false;
        }
        return true;
    }
}
