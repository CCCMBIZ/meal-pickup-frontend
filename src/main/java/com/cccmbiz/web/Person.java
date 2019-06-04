package com.cccmbiz.web;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Person {
    private int personId;
    private Integer familyId;
    private Integer churchId;
    private String title;
    private String lastName;
    private String firstName;
    private String chineseName;
    private String gender;
    private String age;
    private String status;
    private String relationship;
    private String servingRole;
    private Byte baptized;
    private Timestamp baptizedDate;
    private String prc;
    private String commitServe;
    private Byte willingToAttendCccmTraining;
    private Byte willingToBeVolunteer;
    private Integer volunteerCode;
    private String phone;
    private Double cellPhone;
    private Double workPhone;
    private String email;
    private String preferredLanguage;
    private String loginId;
    private String password;
    private Byte familyAdmin;
    private Byte churchAdmin;
    private Byte searchable;
    private String misc1;
    private String misc2;
    private String misc3;
    private Timestamp lastModified;
    private String remarks;
    private Byte acceptedChrist;
    private Timestamp acceptedChristDate;
    private Integer acceptedChristLocation;
    private Byte seeker;
    private String headphone;
    private String allergies;
    private String healthCardNo;

    @Id
    @Column(name = "PersonID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    @Basic
    @Column(name = "FamilyID")
    public Integer getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Integer familyId) {
        this.familyId = familyId;
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
    @Column(name = "Title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "LastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "FirstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "ChineseName")
    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    @Basic
    @Column(name = "Gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "Age")
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Basic
    @Column(name = "Status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "Relationship")
    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    @Basic
    @Column(name = "ServingRole")
    public String getServingRole() {
        return servingRole;
    }

    public void setServingRole(String servingRole) {
        this.servingRole = servingRole;
    }

    @Basic
    @Column(name = "Baptized")
    public Byte getBaptized() {
        return baptized;
    }

    public void setBaptized(Byte baptized) {
        this.baptized = baptized;
    }

    @Basic
    @Column(name = "BaptizedDate")
    public Timestamp getBaptizedDate() {
        return baptizedDate;
    }

    public void setBaptizedDate(Timestamp baptizedDate) {
        this.baptizedDate = baptizedDate;
    }

    @Basic
    @Column(name = "PRC")
    public String getPrc() {
        return prc;
    }

    public void setPrc(String prc) {
        this.prc = prc;
    }

    @Basic
    @Column(name = "CommitServe")
    public String getCommitServe() {
        return commitServe;
    }

    public void setCommitServe(String commitServe) {
        this.commitServe = commitServe;
    }

    @Basic
    @Column(name = "WillingToAttendCCCMTraining")
    public Byte getWillingToAttendCccmTraining() {
        return willingToAttendCccmTraining;
    }

    public void setWillingToAttendCccmTraining(Byte willingToAttendCccmTraining) {
        this.willingToAttendCccmTraining = willingToAttendCccmTraining;
    }

    @Basic
    @Column(name = "WillingToBeVolunteer")
    public Byte getWillingToBeVolunteer() {
        return willingToBeVolunteer;
    }

    public void setWillingToBeVolunteer(Byte willingToBeVolunteer) {
        this.willingToBeVolunteer = willingToBeVolunteer;
    }

    @Basic
    @Column(name = "VolunteerCode")
    public Integer getVolunteerCode() {
        return volunteerCode;
    }

    public void setVolunteerCode(Integer volunteerCode) {
        this.volunteerCode = volunteerCode;
    }

    @Basic
    @Column(name = "Phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "CellPhone")
    public Double getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(Double cellPhone) {
        this.cellPhone = cellPhone;
    }

    @Basic
    @Column(name = "WorkPhone")
    public Double getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(Double workPhone) {
        this.workPhone = workPhone;
    }

    @Basic
    @Column(name = "Email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    @Column(name = "LoginID")
    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    @Basic
    @Column(name = "Password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "FamilyAdmin")
    public Byte getFamilyAdmin() {
        return familyAdmin;
    }

    public void setFamilyAdmin(Byte familyAdmin) {
        this.familyAdmin = familyAdmin;
    }

    @Basic
    @Column(name = "ChurchAdmin")
    public Byte getChurchAdmin() {
        return churchAdmin;
    }

    public void setChurchAdmin(Byte churchAdmin) {
        this.churchAdmin = churchAdmin;
    }

    @Basic
    @Column(name = "Searchable")
    public Byte getSearchable() {
        return searchable;
    }

    public void setSearchable(Byte searchable) {
        this.searchable = searchable;
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
    @Column(name = "LastModified")
    public Timestamp getLastModified() {
        return lastModified;
    }

    public void setLastModified(Timestamp lastModified) {
        this.lastModified = lastModified;
    }

    @Basic
    @Column(name = "Remarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Basic
    @Column(name = "AcceptedChrist")
    public Byte getAcceptedChrist() {
        return acceptedChrist;
    }

    public void setAcceptedChrist(Byte acceptedChrist) {
        this.acceptedChrist = acceptedChrist;
    }

    @Basic
    @Column(name = "AcceptedChristDate")
    public Timestamp getAcceptedChristDate() {
        return acceptedChristDate;
    }

    public void setAcceptedChristDate(Timestamp acceptedChristDate) {
        this.acceptedChristDate = acceptedChristDate;
    }

    @Basic
    @Column(name = "AcceptedChristLocation")
    public Integer getAcceptedChristLocation() {
        return acceptedChristLocation;
    }

    public void setAcceptedChristLocation(Integer acceptedChristLocation) {
        this.acceptedChristLocation = acceptedChristLocation;
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
    @Column(name = "headphone")
    public String getHeadphone() {
        return headphone;
    }

    public void setHeadphone(String headphone) {
        this.headphone = headphone;
    }

    @Basic
    @Column(name = "allergies")
    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    @Basic
    @Column(name = "healthCardNo")
    public String getHealthCardNo() {
        return healthCardNo;
    }

    public void setHealthCardNo(String healthCardNo) {
        this.healthCardNo = healthCardNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return personId == person.personId &&
                Objects.equals(familyId, person.familyId) &&
                Objects.equals(churchId, person.churchId) &&
                Objects.equals(title, person.title) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(chineseName, person.chineseName) &&
                Objects.equals(gender, person.gender) &&
                Objects.equals(age, person.age) &&
                Objects.equals(status, person.status) &&
                Objects.equals(relationship, person.relationship) &&
                Objects.equals(servingRole, person.servingRole) &&
                Objects.equals(baptized, person.baptized) &&
                Objects.equals(baptizedDate, person.baptizedDate) &&
                Objects.equals(prc, person.prc) &&
                Objects.equals(commitServe, person.commitServe) &&
                Objects.equals(willingToAttendCccmTraining, person.willingToAttendCccmTraining) &&
                Objects.equals(willingToBeVolunteer, person.willingToBeVolunteer) &&
                Objects.equals(volunteerCode, person.volunteerCode) &&
                Objects.equals(phone, person.phone) &&
                Objects.equals(cellPhone, person.cellPhone) &&
                Objects.equals(workPhone, person.workPhone) &&
                Objects.equals(email, person.email) &&
                Objects.equals(preferredLanguage, person.preferredLanguage) &&
                Objects.equals(loginId, person.loginId) &&
                Objects.equals(password, person.password) &&
                Objects.equals(familyAdmin, person.familyAdmin) &&
                Objects.equals(churchAdmin, person.churchAdmin) &&
                Objects.equals(searchable, person.searchable) &&
                Objects.equals(misc1, person.misc1) &&
                Objects.equals(misc2, person.misc2) &&
                Objects.equals(misc3, person.misc3) &&
                Objects.equals(lastModified, person.lastModified) &&
                Objects.equals(remarks, person.remarks) &&
                Objects.equals(acceptedChrist, person.acceptedChrist) &&
                Objects.equals(acceptedChristDate, person.acceptedChristDate) &&
                Objects.equals(acceptedChristLocation, person.acceptedChristLocation) &&
                Objects.equals(seeker, person.seeker) &&
                Objects.equals(headphone, person.headphone) &&
                Objects.equals(allergies, person.allergies) &&
                Objects.equals(healthCardNo, person.healthCardNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, familyId, churchId, title, lastName, firstName, chineseName, gender, age, status, relationship, servingRole, baptized, baptizedDate, prc, commitServe, willingToAttendCccmTraining, willingToBeVolunteer, volunteerCode, phone, cellPhone, workPhone, email, preferredLanguage, loginId, password, familyAdmin, churchAdmin, searchable, misc1, misc2, misc3, lastModified, remarks, acceptedChrist, acceptedChristDate, acceptedChristLocation, seeker, headphone, allergies, healthCardNo);
    }
}
