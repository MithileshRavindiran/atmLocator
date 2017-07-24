package com.nl.atm.locator.atmlocator.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AtmLocation {

    private Address address;
    private Integer distance;
    private String bank;

    public AtmLocation() {

    }

    public AtmLocation(Address address, Integer distance, String bank) {
        this.address = address;
        this.distance = distance;
        this.bank = bank;
    }

    /**
     * @return The address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @param address The address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * @return The distance
     */
    public Integer getDistance() {
        return distance;
    }

    /**
     * @param distance The distance
     */
    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    /**
     * @return The bank
     */
    @JsonProperty("bank")
    public String getBank() {
        return bank;
    }

    /**
     * @param bank The bank
     */
    @JsonProperty("type")
    public void setBank(String bank) {
        this.bank = bank;
    }


    @Override
    public String toString() {
        return "INGAtmLocation{" +
                "address=" + address +
                ", distance=" + distance +
                ", bank='" + bank + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        AtmLocation atmLocation = (AtmLocation) obj;
        return Objects.equals(this.getAddress(), atmLocation.getAddress()) &&
                Objects.equals(this.getDistance(), atmLocation.getDistance()) &&
                Objects.equals(this.getBank(), atmLocation.getBank());
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, distance, bank);
    }
}
