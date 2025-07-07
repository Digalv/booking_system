package com.booking.booking.models;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue
    private UUID id;

    private String clientName;
    private String clientEmail;

    private LocalDateTime startTime;

    @ManyToOne
    private Offering Offering;

    private BookingStatus status = BookingStatus.BOOKED;

    private LocalDateTime createdAt = LocalDateTime.now();
}