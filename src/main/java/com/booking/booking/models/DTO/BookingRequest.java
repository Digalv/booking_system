package com.booking.booking.models.DTO;

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
    @Pattern(regexp = "^[^0-9]*$") //excluded number
    @Size(min = 2, max = 50)
    private String clientName;

    @NotBlank
    @Email
    private String clientEmail;

    @NotNull
    private UUID offering;

    @NotNull
    @Future
    private LocalDateTime startTime;
}
