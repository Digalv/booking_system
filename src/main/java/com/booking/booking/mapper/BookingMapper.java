package com.booking.booking.mapper;

import com.booking.booking.models.Booking;
import com.booking.booking.models.DTO.BookingRequest;
import com.booking.booking.models.DTO.BookingResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface BookingMapper {
    @Mapping(target = "offering", ignore = true)
    Booking bookingRequestToEntity(BookingRequest dto);
    @Mapping(target = "offering", source = "offering.id")
    BookingResponse bookingToResponse(Booking booking);
}
