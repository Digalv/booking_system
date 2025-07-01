package com.booking.booking.models.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class BookingResponseDTO {
    private String clientName;
    private String clientEmail;

    private LocalDateTime startTime;
}
