package com.cccmbiz.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;
import java.util.Objects;


public class Event {
    private int id;
    private String uid;
    private String nameCn;
    private String nameEn;
    private String descriptionCn;
    private String descriptionEn;
    private String stripeDescriptor;
    private String flyer;
    private String link;
    private String location;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private Date deadline;
    private Date startDate;
    private Date endDate;
    private short capacity;
    private short option;
    private String notifyEmail;
    private byte status;

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("uid")
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @JsonProperty("nameCn")
    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    @JsonProperty("nameEn")
    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    @JsonProperty("description")
    public String getDescriptionCn() {
        return descriptionCn;
    }

    public void setDescriptionCn(String descriptionCn) {
        this.descriptionCn = descriptionCn;
    }

    @JsonProperty("descriptionEn")
    public String getDescriptionEn() {
        return descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }

    @JsonProperty("stripeDescription")
    public String getStripeDescriptor() {
        return stripeDescriptor;
    }

    public void setStripeDescriptor(String stripeDescriptor) {
        this.stripeDescriptor = stripeDescriptor;
    }

    @JsonProperty("flyer")
    public String getFlyer() {
        return flyer;
    }

    public void setFlyer(String flyer) {
        this.flyer = flyer;
    }

    @JsonProperty("link")
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("zipCode")
    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @JsonProperty("deadline")
    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    @JsonProperty("startDate")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("endDate")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @JsonProperty("capacity")
    public short getCapacity() {
        return capacity;
    }

    public void setCapacity(short capacity) {
        this.capacity = capacity;
    }

    @JsonProperty("option")
    public short getOption() {
        return option;
    }

    public void setOption(short option) {
        this.option = option;
    }

    @JsonProperty("notifyEmail")
    public String getNotifyEmail() {
        return notifyEmail;
    }

    public void setNotifyEmail(String notifyEmail) {
        this.notifyEmail = notifyEmail;
    }

    @JsonProperty("status")
    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id &&
                capacity == event.capacity &&
                option == event.option &&
                status == event.status &&
                Objects.equals(uid, event.uid) &&
                Objects.equals(nameCn, event.nameCn) &&
                Objects.equals(nameEn, event.nameEn) &&
                Objects.equals(descriptionCn, event.descriptionCn) &&
                Objects.equals(descriptionEn, event.descriptionEn) &&
                Objects.equals(stripeDescriptor, event.stripeDescriptor) &&
                Objects.equals(flyer, event.flyer) &&
                Objects.equals(link, event.link) &&
                Objects.equals(location, event.location) &&
                Objects.equals(address, event.address) &&
                Objects.equals(city, event.city) &&
                Objects.equals(state, event.state) &&
                Objects.equals(zipcode, event.zipcode) &&
                Objects.equals(deadline, event.deadline) &&
                Objects.equals(startDate, event.startDate) &&
                Objects.equals(endDate, event.endDate) &&
                Objects.equals(notifyEmail, event.notifyEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uid, nameCn, nameEn, descriptionCn, descriptionEn, stripeDescriptor, flyer, link, location, address, city, state, zipcode, deadline, startDate, endDate, capacity, option, notifyEmail, status);
    }
}
