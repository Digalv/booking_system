package com.booking.booking.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.processing.Pattern;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "offering")
public class Offering {
    @Id
    @GeneratedValue
    private UUID id;

    private String title;

    private int durationInMinutes;

    private int Price;
}