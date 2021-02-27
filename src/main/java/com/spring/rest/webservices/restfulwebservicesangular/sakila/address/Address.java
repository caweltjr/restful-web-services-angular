package com.spring.rest.webservices.restfulwebservicesangular.sakila.address;

import com.spring.rest.webservices.restfulwebservicesangular.sakila.actor.Actor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address implements Comparable<Actor>{
    @Id
    private Long addressId;
    private String address;
    private String district;
    private Long cityId;
    private String postalCode;
    private String phone;
    private java.sql.Timestamp lastUpdate;


    public long getAddressId() {
        return this.addressId;
    }

    public Address() {

    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return this.district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public long getCityId() {
        return this.cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public java.sql.Timestamp getLastUpdate() {
        return this.lastUpdate;
    }

    public void setLastUpdate(java.sql.Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public int compareTo(Actor o) {
        return 0;
    }
}
