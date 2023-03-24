package com.example.bookmyshow.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel {
    //@Enumerated(EnumType.ORDINAL)
    private PaymentMethod paymentMethod;
    private Date timeOfPayment;
    private double amount;
    private String referenceId;

    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;

    @ManyToOne
    private Ticket ticket;
}
