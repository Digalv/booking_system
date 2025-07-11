package com.booking.booking.models.DTO;

import com.booking.booking.models.BookingStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
public class BookingResponse {
    private String clientName;
    private String clientEmail;

    private UUID offering;

    private LocalDateTime startTime;
    private BookingStatus status;

    private LocalDateTime createdAt;
}
