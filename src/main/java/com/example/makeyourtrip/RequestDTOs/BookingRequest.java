package com.example.makeyourtrip.RequestDTOs;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingRequest {


    private String seatNos; //Comma seperated Values : 1A,1C,1E

    private LocalDate journeyDate;

    private Integer transportId;

    private Integer userId;


}
