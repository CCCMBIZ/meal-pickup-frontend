package com.cccmbiz.web;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Church {
    private int churchId;
    private String acronym;
    private String address;
    private String churchNameChn;
    private String churchNameEng;
    private String city;
    private Integer contactPersonId1;
    private Integer contactPersonId2;
    private Integer contactPersonId3;
    private String fax;
    private Timestamp lastModified;
    private String misc1;
    private String misc2;
    private String misc3;
    private Integer pastorPersonId1;
    private Integer pastorPersonId2;
    private Integer pastorPersonId3;
    private String phone;
    private String region;
    private String state;
    private String webUrl;
    private String zip;

    @Id
    @Column(name = "ChurchID")
    public int getChurchId() {
        return churchId;
    }

    public void setChurchId(int churchId) {
        this.churchId = churchId;
    }

    @Basic
    @Column(name = "acronym")
    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "churchNameChn")
    public String getChurchNameChn() {
        return churchNameChn;
    }

    public void setChurchNameChn(String churchNameChn) {
        this.churchNameChn = churchNameChn;
    }

    @Basic
    @Column(name = "churchNameEng")
    public String getChurchNameEng() {
        return churchNameEng;
    }

    public void setChurchNameEng(String churchNameEng) {
        this.churchNameEng = churchNameEng;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "contactPersonID1")
    public Integer getContactPersonId1() {
        return contactPersonId1;
    }

    public void setContactPersonId1(Integer contactPersonId1) {
        this.contactPersonId1 = contactPersonId1;
    }

    @Basic
    @Column(name = "contactPersonID2")
    public Integer getContactPersonId2() {
        return contactPersonId2;
    }

    public void setContactPersonId2(Integer contactPersonId2) {
        this.contactPersonId2 = contactPersonId2;
    }

    @Basic
    @Column(name = "contactPersonID3")
    public Integer getContactPersonId3() {
        return contactPersonId3;
    }

    public void setContactPersonId3(Integer contactPersonId3) {
        this.contactPersonId3 = contactPersonId3;
    }

    @Basic
    @Column(name = "fax")
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Basic
    @Column(name = "lastModified")
    public Timestamp getLastModified() {
        return lastModified;
    }

    public void setLastModified(Timestamp lastModified) {
        this.lastModified = lastModified;
    }

    @Basic
    @Column(name = "misc1")
    public String getMisc1() {
        return misc1;
    }

    public void setMisc1(String misc1) {
        this.misc1 = misc1;
    }

    @Basic
    @Column(name = "misc2")
    public String getMisc2() {
        return misc2;
    }

    public void setMisc2(String misc2) {
        this.misc2 = misc2;
    }

    @Basic
    @Column(name = "misc3")
    public String getMisc3() {
        return misc3;
    }

    public void setMisc3(String misc3) {
        this.misc3 = misc3;
    }

    @Basic
    @Column(name = "pastorPersonID1")
    public Integer getPastorPersonId1() {
        return pastorPersonId1;
    }

    public void setPastorPersonId1(Integer pastorPersonId1) {
        this.pastorPersonId1 = pastorPersonId1;
    }

    @Basic
    @Column(name = "pastorPersonID2")
    public Integer getPastorPersonId2() {
        return pastorPersonId2;
    }

    public void setPastorPersonId2(Integer pastorPersonId2) {
        this.pastorPersonId2 = pastorPersonId2;
    }

    @Basic
    @Column(name = "pastorPersonID3")
    public Integer getPastorPersonId3() {
        return pastorPersonId3;
    }

    public void setPastorPersonId3(Integer pastorPersonId3) {
        this.pastorPersonId3 = pastorPersonId3;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "region")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Basic
    @Column(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "webURL")
    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    @Basic
    @Column(name = "zip")
    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Church church = (Church) o;
        return churchId == church.churchId &&
                Objects.equals(acronym, church.acronym) &&
                Objects.equals(address, church.address) &&
                Objects.equals(churchNameChn, church.churchNameChn) &&
                Objects.equals(churchNameEng, church.churchNameEng) &&
                Objects.equals(city, church.city) &&
                Objects.equals(contactPersonId1, church.contactPersonId1) &&
                Objects.equals(contactPersonId2, church.contactPersonId2) &&
                Objects.equals(contactPersonId3, church.contactPersonId3) &&
                Objects.equals(fax, church.fax) &&
                Objects.equals(lastModified, church.lastModified) &&
                Objects.equals(misc1, church.misc1) &&
                Objects.equals(misc2, church.misc2) &&
                Objects.equals(misc3, church.misc3) &&
                Objects.equals(pastorPersonId1, church.pastorPersonId1) &&
                Objects.equals(pastorPersonId2, church.pastorPersonId2) &&
                Objects.equals(pastorPersonId3, church.pastorPersonId3) &&
                Objects.equals(phone, church.phone) &&
                Objects.equals(region, church.region) &&
                Objects.equals(state, church.state) &&
                Objects.equals(webUrl, church.webUrl) &&
                Objects.equals(zip, church.zip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(churchId, acronym, address, churchNameChn, churchNameEng, city, contactPersonId1, contactPersonId2, contactPersonId3, fax, lastModified, misc1, misc2, misc3, pastorPersonId1, pastorPersonId2, pastorPersonId3, phone, region, state, webUrl, zip);
    }
}
