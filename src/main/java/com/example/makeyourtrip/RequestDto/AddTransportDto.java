package com.example.makeyourtrip.RequestDto;

import com.example.makeyourtrip.Enums.ModeOfTransport;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AddTransportDto {

    private ModeOfTransport modeOfTransport;
    private LocalDate journeyDate;
    private LocalTime startTime;
    private double journeyTime;
    private Integer routeId;
    private String companyName;

}
