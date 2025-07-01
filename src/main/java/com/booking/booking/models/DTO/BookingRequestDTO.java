package com.booking.booking.models.DTO;

import com.booking.booking.models.BookingStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class BookingRequestDTO {
    private String clientName;
    private String clientEmail;

    private LocalDateTime startTime;
    private BookingStatus status;

    private LocalDateTime createdAt;
}
