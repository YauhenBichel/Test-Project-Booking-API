package com.booking.recruitment.hotel.service;

import com.booking.recruitment.hotel.model.Hotel;
import com.booking.recruitment.hotel.model.SortByEnum;

import java.util.List;

public interface SearchService {
  List<Hotel> getTopClosestHotels(Long cityId, SortByEnum sortByEnum);
}
