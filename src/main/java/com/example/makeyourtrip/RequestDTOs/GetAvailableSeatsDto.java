package com.example.makeyourtrip.RequestDTOs;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GetAvailableSeatsDto {

    private LocalDate journeyDate;
    private int transportId;

}
