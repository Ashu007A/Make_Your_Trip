package com.example.makeyourtrip.RequestDTOs;

import com.example.makeyourtrip.Enums.City;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SearchFlightDto {

    private City fromCity;
    private City toCity;
    private LocalDate journeyDate;

}
