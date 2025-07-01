package com.booking.booking.mapper;

import com.booking.booking.models.Booking;
import com.booking.booking.models.DTO.BookingRequest;
import com.booking.booking.models.DTO.BookingResponse;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface BookingMapper {
    Booking BookingResponseToEntity(BookingResponse dto);
    Booking BookingRequestToEntity(BookingRequest dto);
    BookingResponse BookingToResponse(Booking booking);
    BookingRequest BookingToRequest(Booking booking);
}
