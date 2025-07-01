package com.booking.booking.mapper;

import com.booking.booking.models.Booking;
import com.booking.booking.models.DTO.BookingRequest;
import com.booking.booking.models.DTO.BookingResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface BookingMapper {
    @Mapping(target = "offering", ignore = true)
    Booking BookingResponseToEntity(BookingResponse dto);
    Booking BookingRequestToEntity(BookingRequest dto);
    @Mapping(target = "offering", source = "offering.id")
    BookingResponse BookingToResponse(Booking booking);
    BookingRequest BookingToRequest(Booking booking);
}
