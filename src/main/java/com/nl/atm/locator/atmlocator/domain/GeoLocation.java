package com.nl.atm.locator.atmlocator.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeoLocation {


    private String latitude;

    private String longitude;

    public GeoLocation() {

    }

    public GeoLocation(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * @return The lat
     */
    @JsonProperty("latitude")
    public String getLatitude() {
        return latitude;
    }

    /**
     * @param latitude The latitude
     */
    @JsonProperty("lat")
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * @return The lng
     */
    @JsonProperty("longitude")
    public String getLongitude() {
        return longitude;
    }

    /**
     * @param longitude The longitude
     */
    @JsonProperty("lng")
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }


    @Override
    public String toString() {
        return "GeoLocation{" +
                "latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        GeoLocation geoLocation = (GeoLocation) obj;
        return Objects.equals(this.getLatitude(), geoLocation.getLatitude()) &&
                Objects.equals(this.getLongitude(), geoLocation.getLongitude()) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }
}
