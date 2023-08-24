package com.example.makeyourtrip.RequestDto;

import com.example.makeyourtrip.Enums.City;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SearchFlightDto {

    private City fromCity;
    private City toCity;
    private LocalDate journeyDate;

}
