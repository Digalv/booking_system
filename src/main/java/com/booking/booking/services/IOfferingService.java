package com.booking.booking.services;

import com.booking.booking.models.DTO.OfferingRequest;
import com.booking.booking.models.DTO.OfferingResponse;
import com.booking.booking.models.Offering;

import java.util.UUID;


public interface IOfferingService {
    Offering getOfferingById(UUID id);
    OfferingRequest getOfferingRequest(UUID id);
    UUID createOffering (OfferingResponse offeringResponse);
}
