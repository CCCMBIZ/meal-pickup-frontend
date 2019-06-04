package com.cccmbiz.web;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Family {
    private int familyId;
    private String headOfFamilyPersonId;
    private String churchId;
    private String familyName;
    private String homeAddress;
    private String homeCity;
    private String homeState;
    private String homeZip;
    private String country;
    private String homePhone;
    private String homeFax;
    private Byte newsletter;
    private Timestamp lastModified;
    private String misc1;
    private String misc2;
    private String misc3;
    private String homeAddress2;
    private String otherCountry;
    private String otherState;
    private String ucCountry;
    private String ucState;
    private String hotel;

    @Id
    @Column(name = "FamilyID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int getFamilyId() {
        return familyId;
    }

    public void setFamilyId(int familyId) {
        this.familyId = familyId;
    }

    @Basic
    @Column(name = "HeadOfFamilyPersonID")
    public String getHeadOfFamilyPersonId() {
        return headOfFamilyPersonId;
    }

    public void setHeadOfFamilyPersonId(String headOfFamilyPersonId) {
        this.headOfFamilyPersonId = headOfFamilyPersonId;
    }

    @Basic
    @Column(name = "ChurchID")
    public String getChurchId() {
        return churchId;
    }

    public void setChurchId(String churchId) {
        this.churchId = churchId;
    }

    @Basic
    @Column(name = "FamilyName")
    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    @Basic
    @Column(name = "HomeAddress")
    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    @Basic
    @Column(name = "HomeCity")
    public String getHomeCity() {
        return homeCity;
    }

    public void setHomeCity(String homeCity) {
        this.homeCity = homeCity;
    }

    @Basic
    @Column(name = "HomeState")
    public String getHomeState() {
        return homeState;
    }

    public void setHomeState(String homeState) {
        this.homeState = homeState;
    }

    @Basic
    @Column(name = "HomeZip")
    public String getHomeZip() {
        return homeZip;
    }

    public void setHomeZip(String homeZip) {
        this.homeZip = homeZip;
    }

    @Basic
    @Column(name = "Country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "HomePhone")
    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    @Basic
    @Column(name = "HomeFax")
    public String getHomeFax() {
        return homeFax;
    }

    public void setHomeFax(String homeFax) {
        this.homeFax = homeFax;
    }

    @Basic
    @Column(name = "Newsletter")
    public Byte getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(Byte newsletter) {
        this.newsletter = newsletter;
    }

    @Basic
    @Column(name = "LastModified")
    public Timestamp getLastModified() {
        return lastModified;
    }

    public void setLastModified(Timestamp lastModified) {
        this.lastModified = lastModified;
    }

    @Basic
    @Column(name = "Misc1")
    public String getMisc1() {
        return misc1;
    }

    public void setMisc1(String misc1) {
        this.misc1 = misc1;
    }

    @Basic
    @Column(name = "Misc2")
    public String getMisc2() {
        return misc2;
    }

    public void setMisc2(String misc2) {
        this.misc2 = misc2;
    }

    @Basic
    @Column(name = "Misc3")
    public String getMisc3() {
        return misc3;
    }

    public void setMisc3(String misc3) {
        this.misc3 = misc3;
    }

    @Basic
    @Column(name = "HomeAddress2")
    public String getHomeAddress2() {
        return homeAddress2;
    }

    public void setHomeAddress2(String homeAddress2) {
        this.homeAddress2 = homeAddress2;
    }

    @Basic
    @Column(name = "otherCountry")
    public String getOtherCountry() {
        return otherCountry;
    }

    public void setOtherCountry(String otherCountry) {
        this.otherCountry = otherCountry;
    }

    @Basic
    @Column(name = "otherState")
    public String getOtherState() {
        return otherState;
    }

    public void setOtherState(String otherState) {
        this.otherState = otherState;
    }

    @Basic
    @Column(name = "ucCountry")
    public String getUcCountry() {
        return ucCountry;
    }

    public void setUcCountry(String ucCountry) {
        this.ucCountry = ucCountry;
    }

    @Basic
    @Column(name = "ucState")
    public String getUcState() {
        return ucState;
    }

    public void setUcState(String ucState) {
        this.ucState = ucState;
    }

    @Basic
    @Column(name = "hotel")
    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return familyId == family.familyId &&
                Objects.equals(headOfFamilyPersonId, family.headOfFamilyPersonId) &&
                Objects.equals(churchId, family.churchId) &&
                Objects.equals(familyName, family.familyName) &&
                Objects.equals(homeAddress, family.homeAddress) &&
                Objects.equals(homeCity, family.homeCity) &&
                Objects.equals(homeState, family.homeState) &&
                Objects.equals(homeZip, family.homeZip) &&
                Objects.equals(country, family.country) &&
                Objects.equals(homePhone, family.homePhone) &&
                Objects.equals(homeFax, family.homeFax) &&
                Objects.equals(newsletter, family.newsletter) &&
                Objects.equals(lastModified, family.lastModified) &&
                Objects.equals(misc1, family.misc1) &&
                Objects.equals(misc2, family.misc2) &&
                Objects.equals(misc3, family.misc3) &&
                Objects.equals(homeAddress2, family.homeAddress2) &&
                Objects.equals(otherCountry, family.otherCountry) &&
                Objects.equals(otherState, family.otherState) &&
                Objects.equals(ucCountry, family.ucCountry) &&
                Objects.equals(ucState, family.ucState) &&
                Objects.equals(hotel, family.hotel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(familyId, headOfFamilyPersonId, churchId, familyName, homeAddress, homeCity, homeState, homeZip, country, homePhone, homeFax, newsletter, lastModified, misc1, misc2, misc3, homeAddress2, otherCountry, otherState, ucCountry, ucState, hotel);
    }
}
