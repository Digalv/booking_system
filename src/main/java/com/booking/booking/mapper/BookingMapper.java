package com.booking.booking.mapper;

import com.booking.booking.models.Booking;
import com.booking.booking.models.DTO.BookingRequest;
import com.booking.booking.models.DTO.BookingResponse;
import com.booking.booking.models.DTO.BookingUpdate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface BookingMapper {
    @Mapping(target = "offering", ignore = true)
    Booking bookingRequestToEntity(BookingRequest bookingRequest);
    @Mapping(target = "offering", source = "offering.id")
    BookingResponse bookingToResponse(Booking booking);
    @Mapping(target = "id",    ignore = true)
    @Mapping(target = "offering", ignore = true)
    void bookingUpdateToEntity(@MappingTarget Booking booking, BookingRequest bookingRequest);
}
