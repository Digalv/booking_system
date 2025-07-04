package com.booking.booking.models.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
public class BookingRequest {
    private String clientName;
    private String clientEmail;
    private UUID offering;

    private LocalDateTime startTime;
}
