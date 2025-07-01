package com.booking.booking.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "service_item")
public class ServiceItem {
    @Id
    @GeneratedValue
    private UUID id;

    private String title;

    private int durationInMinutes;

    private int Price;
}