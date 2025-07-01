package com.booking.booking.controllers;

import com.booking.booking.models.DTO.OfferingResponse;
import com.booking.booking.services.OfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/offering")
public class OfferingController {

    private final OfferingService _offeringService;
    @Autowired
    public OfferingController(OfferingService _offeringService) {
        this._offeringService = _offeringService;
    }

    @PostMapping
    public ResponseEntity<?> createOffering(OfferingResponse offering){
        return ResponseEntity.ok(_offeringService.createOffering(offering));
    }
}
