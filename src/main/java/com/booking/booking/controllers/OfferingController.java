package com.booking.booking.controllers;

import com.booking.booking.models.DTO.OfferingRequest;
import com.booking.booking.services.OfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/offering")
public class OfferingController {

    private final OfferingService offeringService;
    @Autowired
    public OfferingController(OfferingService _offeringService) {
        this.offeringService = _offeringService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createOffering(OfferingRequest offering){
        return ResponseEntity.ok(offeringService.createOffering(offering));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getOffering(@PathVariable UUID id){
        return ResponseEntity.ok(offeringService.getOfferingResponse(id));
    }
}
