package com.booking.booking.controllers;

import com.booking.booking.models.DTO.BookingResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.booking.booking.services.BookingService;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
    private final BookingService _bookingService;
    @Autowired
    public BookingController(BookingService _bookingService) {
        this._bookingService = _bookingService;
    }

    @PostMapping
    public ResponseEntity<?>createBooking(BookingResponseDTO booking){
        return  ResponseEntity.ok(_bookingService.createBooking(booking));
    }
}
