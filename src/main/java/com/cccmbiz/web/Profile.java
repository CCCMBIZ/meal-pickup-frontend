package com.cccmbiz.web;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Profile {
    private Integer personId;
    private Byte leader;
    private Byte decision;
    private Byte seeker;
    private Integer churchId;
    private String roomId;
    private Integer groupId;
    private String comments;
    private Byte checkIn;
    private Timestamp checkInDate;
    private Byte checkOut;
    private Timestamp checkOutDate;
    private Timestamp registeredDate;
    private Byte nametag;
    private Byte archive;
    private String preferredLanguage;
    private Integer faithYear;
    private Byte workshop;
    private String workshop1;
    private String workshop2;
    private Timestamp lastModified;
    private int familyId;
    private String registrationId;
    private Byte needTranspotation;
    private Byte needHotel;
    private String volunteerJobs;
    private String churchName;

    @Id
    @Column(name = "PersonID")
    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Basic
    @Column(name = "Leader")
    public Byte getLeader() {
        return leader;
    }

    public void setLeader(Byte leader) {
        this.leader = leader;
    }

    @Basic
    @Column(name = "Decision")
    public Byte getDecision() {
        return decision;
    }

    public void setDecision(Byte decision) {
        this.decision = decision;
    }

    @Basic
    @Column(name = "Seeker")
    public Byte getSeeker() {
        return seeker;
    }

    public void setSeeker(Byte seeker) {
        this.seeker = seeker;
    }

    @Basic
    @Column(name = "ChurchID")
    public Integer getChurchId() {
        return churchId;
    }

    public void setChurchId(Integer churchId) {
        this.churchId = churchId;
    }

    @Basic
    @Column(name = "RoomID")
    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    @Basic
    @Column(name = "GroupID")
    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "Comments")
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Basic
    @Column(name = "CheckIn")
    public Byte getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Byte checkIn) {
        this.checkIn = checkIn;
    }

    @Basic
    @Column(name = "CheckInDate")
    public Timestamp getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Timestamp checkInDate) {
        this.checkInDate = checkInDate;
    }

    @Basic
    @Column(name = "CheckOut")
    public Byte getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Byte checkOut) {
        this.checkOut = checkOut;
    }

    @Basic
    @Column(name = "CheckOutDate")
    public Timestamp getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Timestamp checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    @Basic
    @Column(name = "RegisteredDate")
    public Timestamp getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Timestamp registeredDate) {
        this.registeredDate = registeredDate;
    }

    @Basic
    @Column(name = "Nametag")
    public Byte getNametag() {
        return nametag;
    }

    public void setNametag(Byte nametag) {
        this.nametag = nametag;
    }

    @Basic
    @Column(name = "Archive")
    public Byte getArchive() {
        return archive;
    }

    public void setArchive(Byte archive) {
        this.archive = archive;
    }

    @Basic
    @Column(name = "PreferredLanguage")
    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

    @Basic
    @Column(name = "FaithYear")
    public Integer getFaithYear() {
        return faithYear;
    }

    public void setFaithYear(Integer faithYear) {
        this.faithYear = faithYear;
    }

    @Basic
    @Column(name = "Workshop")
    public Byte getWorkshop() {
        return workshop;
    }

    public void setWorkshop(Byte workshop) {
        this.workshop = workshop;
    }

    @Basic
    @Column(name = "Workshop1")
    public String getWorkshop1() {
        return workshop1;
    }

    public void setWorkshop1(String workshop1) {
        this.workshop1 = workshop1;
    }

    @Basic
    @Column(name = "Workshop2")
    public String getWorkshop2() {
        return workshop2;
    }

    public void setWorkshop2(String workshop2) {
        this.workshop2 = workshop2;
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
    @Column(name = "FamilyID")
    public int getFamilyId() {
        return familyId;
    }

    public void setFamilyId(int familyId) {
        this.familyId = familyId;
    }

    @Basic
    @Column(name = "RegistrationID")
    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    @Basic
    @Column(name = "NeedTranspotation")
    public Byte getNeedTranspotation() {
        return needTranspotation;
    }

    public void setNeedTranspotation(Byte needTranspotation) {
        this.needTranspotation = needTranspotation;
    }

    @Basic
    @Column(name = "NeedHotel")
    public Byte getNeedHotel() {
        return needHotel;
    }

    public void setNeedHotel(Byte needHotel) {
        this.needHotel = needHotel;
    }

    @Basic
    @Column(name = "volunteerJobs")
    public String getVolunteerJobs() {
        return volunteerJobs;
    }

    public void setVolunteerJobs(String volunteerJobs) {
        this.volunteerJobs = volunteerJobs;
    }

    @Basic
    @Column(name = "ChurchName")
    public String getChurchName() {
        return churchName;
    }

    public void setChurchName(String churchName) {
        this.churchName = churchName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return personId == profile.personId &&
                familyId == profile.familyId &&
                Objects.equals(leader, profile.leader) &&
                Objects.equals(decision, profile.decision) &&
                Objects.equals(seeker, profile.seeker) &&
                Objects.equals(churchId, profile.churchId) &&
                Objects.equals(roomId, profile.roomId) &&
                Objects.equals(groupId, profile.groupId) &&
                Objects.equals(comments, profile.comments) &&
                Objects.equals(checkIn, profile.checkIn) &&
                Objects.equals(checkInDate, profile.checkInDate) &&
                Objects.equals(checkOut, profile.checkOut) &&
                Objects.equals(checkOutDate, profile.checkOutDate) &&
                Objects.equals(registeredDate, profile.registeredDate) &&
                Objects.equals(nametag, profile.nametag) &&
                Objects.equals(archive, profile.archive) &&
                Objects.equals(preferredLanguage, profile.preferredLanguage) &&
                Objects.equals(faithYear, profile.faithYear) &&
                Objects.equals(workshop, profile.workshop) &&
                Objects.equals(workshop1, profile.workshop1) &&
                Objects.equals(workshop2, profile.workshop2) &&
                Objects.equals(lastModified, profile.lastModified) &&
                Objects.equals(registrationId, profile.registrationId) &&
                Objects.equals(needTranspotation, profile.needTranspotation) &&
                Objects.equals(needHotel, profile.needHotel) &&
                Objects.equals(volunteerJobs, profile.volunteerJobs) &&
                Objects.equals(churchName, profile.churchName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, leader, decision, seeker, churchId, roomId, groupId, comments, checkIn, checkInDate, checkOut, checkOutDate, registeredDate, nametag, archive, preferredLanguage, faithYear, workshop, workshop1, workshop2, lastModified, familyId, registrationId, needTranspotation, needHotel, volunteerJobs, churchName);
    }
}
