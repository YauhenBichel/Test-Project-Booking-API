package com.booking.recruitment.hotel.vo;

import com.booking.recruitment.hotel.model.City;
import com.booking.recruitment.hotel.model.Hotel;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class HotelResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double rating;

    private City city;

    private String address;
    private double latitude;
    private double longitude;

    public HotelResponse() {}

    public HotelResponse(
            Long id,
            String name,
            Double rating,
            City city,
            String address,
            double latitude,
            double longitude) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.city = city;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HotelResponse)) return false;

        HotelResponse that = (HotelResponse) o;

        if (Double.compare(that.latitude, latitude) != 0) return false;
        if (Double.compare(that.longitude, longitude) != 0) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (rating != null ? !rating.equals(that.rating) : that.rating != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        return address != null ? address.equals(that.address) : that.address == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        temp = Double.doubleToLongBits(latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public static HotelResponse.Builder builder() {
        return new HotelResponse.Builder();
    }

    public static class Builder {
        private Long id;
        private String name;
        private Double rating;
        private City city;
        private String address;
        private double latitude;
        private double longitude;

        public HotelResponse.Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public HotelResponse.Builder setName(String name) {
            this.name = name;
            return this;
        }

        public HotelResponse.Builder setRating(Double rating) {
            this.rating = rating;
            return this;
        }

        public HotelResponse.Builder setCity(City city) {
            this.city = city;
            return this;
        }

        public HotelResponse.Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public HotelResponse.Builder setLatitude(double latitude) {
            this.latitude = latitude;
            return this;
        }

        public HotelResponse.Builder setLongitude(double longitude) {
            this.longitude = longitude;
            return this;
        }

        public HotelResponse build() {
            return new HotelResponse(id, name, rating, city, address, latitude, longitude);
        }
    }
}
