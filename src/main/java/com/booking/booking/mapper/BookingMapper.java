package com.booking.booking.mapper;

import models.Booking;
import models.DTO.BookingRequestDTO;
import models.DTO.BookingResponceDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface BookingMapper {
    Booking BookingResponceToEntity(BookingResponceDTO dto);
    Booking BookingRequestToEntity(BookingRequestDTO dto);
    BookingResponceDTO BookingToResponce(Booking booking);
    BookingRequestDTO BookingToRequest(Booking booking);
}
