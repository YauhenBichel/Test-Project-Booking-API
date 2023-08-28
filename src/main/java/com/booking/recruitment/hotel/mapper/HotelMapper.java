package com.booking.recruitment.hotel.mapper;

import com.booking.recruitment.hotel.model.Hotel;
import com.booking.recruitment.hotel.vo.HotelResponse;
import org.springframework.stereotype.Component;

@Component
public class HotelMapper {
    public HotelResponse toResponse(Hotel hotel) {
        HotelResponse hotelResponse = HotelResponse.builder()
                .setId(hotel.getId())
                .setAddress(hotel.getAddress())
                .setName(hotel.getName())
                .setRating(hotel.getRating())
                .setLatitude(hotel.getLatitude())
                .setLongitude(hotel.getLongitude())
                .setCity(hotel.getCity())
                .build();

        return hotelResponse;
    }
}
