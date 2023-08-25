package com.example.makeyourtrip.RequestDto;

import com.example.makeyourtrip.Models.TicketEntity;
import com.example.makeyourtrip.Models.Transport;
import com.example.makeyourtrip.Models.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class BookingRequest {


    private String seatNos; //Comma seperated Values : 1A,1C,1E

    private LocalDate journeyDate;

    private Integer transportId;

    private Integer userId;


}
