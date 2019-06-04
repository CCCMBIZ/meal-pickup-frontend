package com.cccmbiz.web;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Mealtracker {
    private Integer tid;
    private Timestamp lastModified;
    private String mealType;
    private Integer personId;
    private String registrationId;
    private String remark;

    @Id
    @Column(name = "tid")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
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
    @Column(name = "MealType")
    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    @Basic
    @Column(name = "PersonID")
    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
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
    @Column(name = "Remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mealtracker that = (Mealtracker) o;
        return tid == that.tid &&
                personId == that.personId &&
                Objects.equals(lastModified, that.lastModified) &&
                Objects.equals(mealType, that.mealType) &&
                Objects.equals(registrationId, that.registrationId) &&
                Objects.equals(remark, that.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tid, lastModified, mealType, personId, registrationId, remark);
    }
}
