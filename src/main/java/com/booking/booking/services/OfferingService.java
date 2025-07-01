package com.booking.booking.services;

import com.booking.booking.Repository.OfferingRepository;
import com.booking.booking.mapper.OfferingMapper;
import com.booking.booking.models.DTO.OfferingRequest;
import com.booking.booking.models.DTO.OfferingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OfferingService implements IOfferingService{

    private final OfferingRepository _offeringRepository;
    private final OfferingMapper _offeringMapper;

    @Autowired
    public OfferingService(OfferingRepository _offeringRepository, OfferingMapper _offeringMapper) {
        this._offeringRepository = _offeringRepository;
        this._offeringMapper = _offeringMapper;
    }

    @Override
    public OfferingRequest getOffering(UUID id) {
        return null;
    }

    @Override
    public UUID createOffering(OfferingResponse offeringResponse) {
        return null;
    }
}
