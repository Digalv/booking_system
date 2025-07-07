package com.booking.booking.services;

import com.booking.booking.Repository.OfferingRepository;
import com.booking.booking.mapper.OfferingMapper;
import com.booking.booking.models.DTO.OfferingResponse;
import com.booking.booking.models.DTO.OfferingRequest;
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
    public Offering getOfferingById(UUID id) {
        return offeringRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Offering not found"));
    }

    @Override
    public OfferingResponse getOfferingResponse(UUID id) {
        return offeringMapper.offeringToResponse(getOfferingById(id));
    }

    @Override
    public UUID createOffering(OfferingRequest offeringRequest) {
        Offering offering = offeringMapper.offeringRequestToEntity(offeringRequest);
        if (offeringRepository.existsByTitle(offering.getTitle())){
            throw new IllegalArgumentException("Title already in use: " + offeringRequest.getTitle());
        }
        offeringRepository.save(offering);
        return offering.getId();
    }

    @Override
    public void deleteOffering(UUID id) {
        Offering offering = this.getOfferingById(id);
        offeringRepository.delete(offering);
    }

    @Override
    public void updateOffering(UUID id, OfferingRequest offeringRequest) {
        Offering offering = getOfferingById(id);

        if(!offering.getTitle().equals(offeringRequest.getTitle()) && offeringRepository.existsByTitle(offeringRequest.getTitle())) {
            throw new IllegalArgumentException("Title already in use: " + offeringRequest.getTitle());
        }
        offering.setTitle(offeringRequest.getTitle());
        offering.setPrice(offeringRequest.getPrice());
        offering.setDurationInMinutes(offeringRequest.getDurationInMinutes());

        offeringRepository.save(offering);
    }
}
