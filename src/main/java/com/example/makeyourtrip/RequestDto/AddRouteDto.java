package com.example.makeyourtrip.RequestDto;

import com.example.makeyourtrip.Enums.City;
import com.example.makeyourtrip.Enums.ModeOfTransport;
import lombok.Data;
import org.springframework.boot.Banner;

@Data
public class AddRouteDto {

    private City fromCity;
    private City  toCity;
    private String stopsInBetween;
    private ModeOfTransport modeOfTransport;
}
