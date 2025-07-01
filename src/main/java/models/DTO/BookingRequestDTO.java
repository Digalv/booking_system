package models.DTO;

import models.BookingStatus;

import java.time.LocalDateTime;

public class BookingRequestDTO {
    private String clientName;
    private String clientEmail;

    private LocalDateTime startTime;
    private BookingStatus status;

    private LocalDateTime createdAt;
}
