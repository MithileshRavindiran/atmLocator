package com.nl.atm.locator.atmlocator.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address {



    private String street;
    private String housenumber;
    private String postalcode;
    private String city;
    private GeoLocation geoLocation;

    public Address() {

    }

    public Address(String street, String housenumber, String postalcode, String city, GeoLocation geoLocation) {
        this.street = street;
        this.housenumber = housenumber;
        this.postalcode = postalcode;
        this.city = city;
        this.geoLocation = geoLocation;
    }

    /**
     *
     * @return
     * The street
     */
    public String getStreet() {
        return street;
    }

    /**
     *
     * @param street
     * The street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     *
     * @return
     * The housenumber
     */
    public String getHousenumber() {
        return housenumber;
    }

    /**
     *
     * @param housenumber
     * The housenumber
     */
    public void setHousenumber(String housenumber) {
        this.housenumber = housenumber;
    }

    /**
     *
     * @return
     * The postalcode
     */
    public String getPostalcode() {
        return postalcode;
    }

    /**
     *
     * @param postalcode
     * The postalcode
     */
    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    /**
     *
     * @return
     * The city
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     * The city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return
     * The geoLocation
     */
    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    /**
     *
     * @param geoLocation
     * The geoLocation
     */
    public void setGeoLocation(GeoLocation geoLocation) {
        this.geoLocation = geoLocation;
    }


    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", housenumber='" + housenumber + '\'' +
                ", postalcode='" + postalcode + '\'' +
                ", city='" + city + '\'' +
                ", geoLocation=" + geoLocation +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Address address = (Address) obj;
        return Objects.equals(this.getStreet(), address.getStreet()) &&
                Objects.equals(this.getHousenumber(), address.getHousenumber()) &&
                Objects.equals(this.getPostalcode(), address.getPostalcode()) &&
                Objects.equals(this.getCity(), address.getHousenumber()) &&
                this.getGeoLocation().equals(address.getGeoLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, housenumber, postalcode, city, geoLocation);
    }
}