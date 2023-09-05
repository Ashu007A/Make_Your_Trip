package com.example.makeyourtrip.RequestDTOs;

import lombok.Data;

@Data
public class AddFlightSeatDto {

    private int noOfEconomySeats;
    private int noOfBusinessSeats;

    private int priceOfBusinessSeat;
    private int priceOfEconomySeat;

    private int transportId;
}
