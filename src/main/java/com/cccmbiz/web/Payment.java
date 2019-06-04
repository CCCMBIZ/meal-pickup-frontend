package com.cccmbiz.web;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Payment {
    private long id;
    private Double amount;
    private Boolean cash;
    private Boolean creditCard;
    private Boolean paidByConference;
    private Timestamp paymentDate;
    private Boolean personalCheck;
    private Boolean refund;
    private Long registrationId;
    private String remarks;
    private String referenceNumber;
    private Double mealFee;
    private Double registrationFee;
    private String currency;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "amount")
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "cash")
    public Boolean getCash() {
        return cash;
    }

    public void setCash(Boolean cash) {
        this.cash = cash;
    }

    @Basic
    @Column(name = "creditCard")
    public Boolean getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(Boolean creditCard) {
        this.creditCard = creditCard;
    }

    @Basic
    @Column(name = "paidByConference")
    public Boolean getPaidByConference() {
        return paidByConference;
    }

    public void setPaidByConference(Boolean paidByConference) {
        this.paidByConference = paidByConference;
    }

    @Basic
    @Column(name = "paymentDate")
    public Timestamp getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Timestamp paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Basic
    @Column(name = "personalCheck")
    public Boolean getPersonalCheck() {
        return personalCheck;
    }

    public void setPersonalCheck(Boolean personalCheck) {
        this.personalCheck = personalCheck;
    }

    @Basic
    @Column(name = "refund")
    public Boolean getRefund() {
        return refund;
    }

    public void setRefund(Boolean refund) {
        this.refund = refund;
    }

    @Basic
    @Column(name = "registrationID")
    public Long getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Long registrationId) {
        this.registrationId = registrationId;
    }

    @Basic
    @Column(name = "remarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Basic
    @Column(name = "referenceNumber")
    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    @Basic
    @Column(name = "MealFee")
    public Double getMealFee() {
        return mealFee;
    }

    public void setMealFee(Double mealFee) {
        this.mealFee = mealFee;
    }

    @Basic
    @Column(name = "RegistrationFee")
    public Double getRegistrationFee() {
        return registrationFee;
    }

    public void setRegistrationFee(Double registrationFee) {
        this.registrationFee = registrationFee;
    }

    @Basic
    @Column(name = "Currency")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return id == payment.id &&
                Objects.equals(amount, payment.amount) &&
                Objects.equals(cash, payment.cash) &&
                Objects.equals(creditCard, payment.creditCard) &&
                Objects.equals(paidByConference, payment.paidByConference) &&
                Objects.equals(paymentDate, payment.paymentDate) &&
                Objects.equals(personalCheck, payment.personalCheck) &&
                Objects.equals(refund, payment.refund) &&
                Objects.equals(registrationId, payment.registrationId) &&
                Objects.equals(remarks, payment.remarks) &&
                Objects.equals(referenceNumber, payment.referenceNumber) &&
                Objects.equals(mealFee, payment.mealFee) &&
                Objects.equals(registrationFee, payment.registrationFee) &&
                Objects.equals(currency, payment.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, cash, creditCard, paidByConference, paymentDate, personalCheck, refund, registrationId, remarks, referenceNumber, mealFee, registrationFee, currency);
    }
}
