package com.booking.booking.services;

import com.booking.booking.models.DTO.OfferingRequest;
import com.booking.booking.models.DTO.OfferingResponse;

import java.util.UUID;

public interface IOfferingService {
    OfferingRequest getOffering(UUID id);
    UUID createOffering (OfferingResponse offeringResponse);
}
