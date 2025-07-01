package com.booking.booking.mapper;


import com.booking.booking.models.DTO.OfferingRequest;
import com.booking.booking.models.DTO.OfferingResponse;
import com.booking.booking.models.Offering;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OfferingMapper {
    Offering OfferingResponseToEntity(OfferingResponse dto);
    Offering OfferingRequestToEntity(OfferingRequest dto);
    OfferingResponse OfferingToResponse(Offering offering);
    OfferingRequest OfferingToRequest(Offering offering);
}
