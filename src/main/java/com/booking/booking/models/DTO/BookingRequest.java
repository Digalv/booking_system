package com.booking.booking.models.DTO;

import com.booking.booking.models.BookingStatus;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
public class BookingRequest {
    @NotBlank
    @Pattern(
            regexp = "^[A-Za-z]+(\\s[A-Za-z'-]+)*$",
            message = "Client name must contain only Latin letters, single spaces, apostrophes, or hyphens"
    )
    @Size(min = 2, max = 50)
    private String clientName;

    @NotBlank
    @Email
    private String clientEmail;

    @NotNull
    private UUID offering;

    public BookingStatus bookingStatus;

    @NotNull
    @Future
    private LocalDateTime startTime;
}
