package com.example.makeyourtrip.Transformers;

import com.example.makeyourtrip.Models.Routes;
import com.example.makeyourtrip.RequestDTOs.AddRouteDto;

public class RouteTransformers {

    public static Routes convertDtoToEntity(AddRouteDto addRouteDto){

        Routes routeObject = Routes.builder().
                        fromCity(addRouteDto.getFromCity())
                        .toCity(addRouteDto.getToCity())
                        .listOfStopInBetween(addRouteDto.getStopsInBetween())
                        .modeOfTransport(addRouteDto.getModeOfTransport())
                        .build();
        return routeObject;

    }
}
