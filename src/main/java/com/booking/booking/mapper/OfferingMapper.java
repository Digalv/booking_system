package com.booking.booking.mapper;


import com.booking.booking.models.DTO.OfferingRequest;
import com.booking.booking.models.DTO.OfferingResponse;
import com.booking.booking.models.Offering;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OfferingMapper {
    Offering offeringResponseToEntity(OfferingResponse dto);
    Offering offeringRequestToEntity(OfferingRequest dto);
    OfferingResponse offeringToResponse(Offering offering);
    OfferingRequest offeringToRequest(Offering offering);
}
