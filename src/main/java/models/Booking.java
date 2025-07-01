package models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue
    private UUID id;

    private String clientName;
    private String clientEmail;

    private LocalDateTime startTime;

    /*@ManyToOne
    private ServiceItem serviceItem;*/

    private BookingStatus status;

    private LocalDateTime createdAt;
}