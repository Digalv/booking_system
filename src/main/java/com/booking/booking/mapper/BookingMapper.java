package com.booking.booking.mapper;

import com.booking.booking.models.Booking;
import com.booking.booking.models.DTO.BookingRequestDTO;
import com.booking.booking.models.DTO.BookingResponseDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface BookingMapper {
    Booking BookingResponseToEntity(BookingResponseDTO dto);
    Booking BookingRequestToEntity(BookingRequestDTO dto);
    BookingResponseDTO BookingToResponse(Booking booking);
    BookingRequestDTO BookingToRequest(Booking booking);
}
