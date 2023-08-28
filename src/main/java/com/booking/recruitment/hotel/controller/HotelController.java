package com.booking.recruitment.hotel.controller;

import com.booking.recruitment.hotel.mapper.HotelMapper;
import com.booking.recruitment.hotel.model.Hotel;
import com.booking.recruitment.hotel.service.HotelService;
import com.booking.recruitment.hotel.vo.HotelResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/hotel")
public class HotelController {
  private final HotelService hotelService;
  private final HotelMapper hotelMapper;

  @Autowired
  public HotelController(HotelService hotelService, HotelMapper hotelMapper) {
    this.hotelService = hotelService;
    this.hotelMapper = hotelMapper;
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Hotel> getAllHotels() {
    return hotelService.getAllHotels();
  }

  @GetMapping("/{id}")
  public ResponseEntity<HotelResponse> getHotelById(@PathVariable("id") final Long id) {
    HotelResponse responseVO = hotelMapper.toResponse(hotelService.getHotelById(id));
    return new ResponseEntity<>(responseVO, HttpStatus.OK);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Hotel createHotel(@RequestBody Hotel hotel) {
    return hotelService.createNewHotel(hotel);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HotelResponse> deleteHotelById(@PathVariable("id") final Long id) {
    hotelService.deleteHotelById(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
