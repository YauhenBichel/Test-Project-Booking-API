package com.booking.recruitment.hotel.model;

public class HotelDistancePair  {
  private Hotel hotel;
  private double distance;

  public Hotel getHotel() {
    return hotel;
  }

  public void setHotel(Hotel hotel) {
    this.hotel = hotel;
  }

  public double getDistance() {
    return distance;
  }

  public void setDistance(double distance) {
    this.distance = distance;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof HotelDistancePair)) return false;

    HotelDistancePair that = (HotelDistancePair) o;

    if (Double.compare(that.distance, distance) != 0) return false;
    return hotel != null ? hotel.equals(that.hotel) : that.hotel == null;
  }

  @Override
  public int hashCode() {
    int result;
    long temp;
    result = hotel != null ? hotel.hashCode() : 0;
    temp = Double.doubleToLongBits(distance);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    return result;
  }
}
