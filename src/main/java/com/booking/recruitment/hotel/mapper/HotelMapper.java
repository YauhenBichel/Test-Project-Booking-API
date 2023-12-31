package com.booking.recruitment.hotel.mapper;

import com.booking.recruitment.hotel.model.Hotel;
import com.booking.recruitment.hotel.vo.HotelResponse;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.ArrayList;

@Component
public class HotelMapper {
    public HotelResponse toResponse(Hotel hotel) {
        return HotelResponse.builder()
                .setId(hotel.getId())
                .setAddress(hotel.getAddress())
                .setName(hotel.getName())
                .setRating(hotel.getRating())
                .setLatitude(hotel.getLatitude())
                .setLongitude(hotel.getLongitude())
                .setCity(hotel.getCity())
                .build();
    }

    public List<HotelResponse> toResponse(List<Hotel> hotels) {

        List<HotelResponse> hotelResponses = new ArrayList<>();

        for(Hotel hotel: hotels) {
            HotelResponse hotelResponse = toResponse(hotel);
            hotelResponses.add(hotelResponse);
        }

        return hotelResponses;
    }
}
