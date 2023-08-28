package com.booking.recruitment.hotel.service.impl;

import com.booking.recruitment.hotel.model.Hotel;
import com.booking.recruitment.hotel.model.HotelDistancePair;
import com.booking.recruitment.hotel.service.HotelService;
import com.booking.recruitment.hotel.service.SearchService;
import com.booking.recruitment.hotel.utility.Haversine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
class DefaultSearchService implements SearchService {
  private final HotelService hotelService;
  private final Integer MAX_HOTELS = 3;

  @Autowired
  DefaultSearchService(HotelService hotelService) {
    this.hotelService = hotelService;
  }

  @Override
  public List<Hotel> getTopClosestHotels(Long cityId) {

    List<Hotel> hotels = hotelService.getHotelsByCity(cityId);

    return hotels.stream()
            .map(hotel -> {
              double dist = Haversine.calculate(
                    hotel.getLatitude(),
                    hotel.getLongitude(),
                    hotel.getCity().getCityCentreLatitude(),
                    hotel.getCity().getCityCentreLongitude());

              HotelDistancePair pair = new HotelDistancePair();
              pair.setHotel(hotel);
              pair.setDistance(dist);

              return pair;

            })
            .sorted(Comparator.comparing(HotelDistancePair::getDistance))
            .limit(MAX_HOTELS)
            .map(hotelDistancePair -> hotelDistancePair.getHotel())
            .collect(Collectors.toList());

  }
}
