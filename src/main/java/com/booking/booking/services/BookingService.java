package com.booking.booking.services;

import com.booking.booking.Exceptions.BookingTimeNotAvaibleException;
import com.booking.booking.Repository.BookingRepository;
import com.booking.booking.mapper.BookingMapper;
import com.booking.booking.models.Booking;
import com.booking.booking.models.BookingStatus;
import com.booking.booking.models.DTO.BookingRequest;
import com.booking.booking.models.DTO.BookingResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
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

        isBookingSlotFree(booking);
        bookingRepository.save(booking);
        return booking.getId();
    }

    @Override
    public void updateBooking(UUID id, BookingRequest bookingRequestUpdate) {
        Booking booking = getBookingById(id);
        bookingMapper.bookingUpdateToEntity(booking, bookingRequestUpdate);
        booking.setOffering(offeringService.getOfferingById(bookingRequestUpdate.getOffering()));

        isBookingSlotFree(booking);

        bookingRepository.save(booking);
    }

    @Override
    public void deleteBooking(UUID id) {
        Booking booking = getBookingById(id);
        bookingRepository.delete(booking);
    }

    public void isBookingSlotFree(Booking booking){
        LocalDateTime bookingStartTime = booking.getStartTime();
        LocalDateTime bookingEndTime = booking.getEndTime();

        LocalTime startDay = LocalTime.of(8,0,0);
        LocalTime endDay = LocalTime.of(18,0,0);

        if(bookingStartTime.toLocalTime().isBefore(startDay)
          || bookingEndTime.toLocalTime().isAfter(endDay)) {
            throw new BookingTimeNotAvaibleException(bookingStartTime, "Must be within 08:00–18:00 ");
        }

        LocalDateTime previousBookingEndTime = bookingRepository.findPreviousByTime(bookingStartTime)
                .map( previousBooking -> previousBooking.getEndTime())
                .orElse(LocalDateTime.MIN);
        LocalDateTime nextBookingStartTime = bookingRepository.findNextByTime(bookingStartTime)
                .map(nextBooking -> nextBooking.getStartTime())
                .orElse(LocalDateTime.MAX);

        if (bookingStartTime.isBefore(previousBookingEndTime)
            || bookingEndTime.isAfter(nextBookingStartTime)){
            throw new BookingTimeNotAvaibleException(bookingStartTime, "Slot overlaps with existing booking");
        }
    }
}
