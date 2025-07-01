package com.booking.booking.models.DTO;

import com.booking.booking.models.BookingStatus;

import java.time.LocalDateTime;

public class BookingRequestDTO {
    private String clientName;
    private String clientEmail;

    private LocalDateTime startTime;
    private BookingStatus status;

    private LocalDateTime createdAt;
}
