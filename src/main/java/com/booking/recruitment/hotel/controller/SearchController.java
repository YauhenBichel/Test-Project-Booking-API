package com.booking.recruitment.hotel.controller;

import com.booking.recruitment.hotel.mapper.HotelMapper;
import com.booking.recruitment.hotel.model.SortByEnum;
import com.booking.recruitment.hotel.service.SearchService;
import com.booking.recruitment.hotel.vo.HotelResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
  private final SearchService searchService;
  private final HotelMapper hotelMapper;

  @Autowired
  public SearchController(SearchService searchService, HotelMapper hotelMapper) {
    this.searchService = searchService;
    this.hotelMapper = hotelMapper;
  }

  @GetMapping("/{cityId}")
  public ResponseEntity<List<HotelResponse>> findHotelsClosestToCity(
          @PathVariable("cityId") final Long cityId,
          @RequestParam(required = false) String sortBy) {
    List<HotelResponse> responseVO = hotelMapper.toResponse(searchService.getTopClosestHotels(cityId, SortByEnum.DISTANCE));
    return new ResponseEntity<>(responseVO, HttpStatus.OK);
  }
}
