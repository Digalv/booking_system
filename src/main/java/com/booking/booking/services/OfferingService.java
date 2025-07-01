package com.booking.booking.services;

import com.booking.booking.Repository.OfferingRepository;
import com.booking.booking.mapper.OfferingMapper;
import com.booking.booking.models.DTO.OfferingRequest;
import com.booking.booking.models.DTO.OfferingResponse;
import com.booking.booking.models.Offering;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OfferingService implements IOfferingService{

    private final OfferingRepository offeringRepository;
    private final OfferingMapper offeringMapper;

    @Autowired
    public OfferingService(OfferingRepository offeringRepository, OfferingMapper offeringMapper) {
        this.offeringRepository = offeringRepository;
        this.offeringMapper = offeringMapper;
    }

    @Override
    public OfferingRequest getOffering(UUID id) {
        return offeringRepository.findById(id)
                .orElseThrow() -> new EntityNotFoundException("404");
    }

    @Override
    public UUID createOffering(OfferingResponse offeringResponse) {
        Offering offering = offeringMapper.OfferingResponseToEntity(offeringResponse);
        offeringRepository.save(offering);
        return offering.getId();
    }
}
