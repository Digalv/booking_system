package com.booking.booking.mapper;

import com.booking.booking.models.Booking;
import com.booking.booking.models.DTO.BookingRequestDTO;
import com.booking.booking.models.DTO.BookingResponceDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface BookingMapper {
    Booking BookingResponceToEntity(BookingResponceDTO dto);
    Booking BookingRequestToEntity(BookingRequestDTO dto);
    BookingResponceDTO BookingToResponce(Booking booking);
    BookingRequestDTO BookingToRequest(Booking booking);
}
