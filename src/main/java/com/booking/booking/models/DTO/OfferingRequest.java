package com.booking.booking.models.DTO;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OfferingRequest {
    @NotBlank
    @Size(min = 2, max = 50)
    private String title;

    @NotNull
    @Positive
    @Max(480) //8 hour
    private int durationInMinutes;

    @NotNull
    @PositiveOrZero
    private int Price;
}
