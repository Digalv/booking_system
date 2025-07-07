package com.booking.booking.services;

import com.booking.booking.models.DTO.OfferingRequest;
import com.booking.booking.models.DTO.OfferingResponse;
import com.booking.booking.models.Offering;

import java.util.UUID;


public interface IOfferingService {
    Offering getOfferingById(UUID id);
    OfferingResponse getOfferingResponse(UUID id);
    UUID createOffering (OfferingRequest offeringRequest);
    void deleteOffering(UUID id);
    void updateOffering(UUID id, OfferingRequest offeringRequest);
}
