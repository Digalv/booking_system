package com.booking.booking.models.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OfferingRequest {
    private String title;

    private int durationInMinutes;

    private int Price;
}
