package com.example.makeyourtrip.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "bookings")
@Data
//This will keep a record of already booked seats on a particular Date
//of a particular transportId
public class Booking {

    @Id
    private Integer bookingId;

    private String seatNos; //Comma seperated Values : 1A,1C,1E

    private Date journeyDate;

    private Integer transportId;

    @ManyToOne
    @JoinColumn
    private Transport transport;

    @OneToOne(mappedBy = "booking",cascade = CascadeType.ALL)
    private TicketEntity ticketEntity;


    @ManyToOne
    @JoinColumn
    private User user;
}
