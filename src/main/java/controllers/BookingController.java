package controllers;

import models.DTO.BookingResponceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import services.BookingService;

@RestController
public class BookingController {
    private final BookingService _bookingService;
    @Autowired
    public BookingController(BookingService _bookingService) {
        this._bookingService = _bookingService;
    }

    public ResponseEntity<?>createBooking(BookingResponceDTO booking){
        return  ResponseEntity.ok(_bookingService.createBooking(booking));
    }
}
