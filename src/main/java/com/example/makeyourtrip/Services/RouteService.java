package com.example.makeyourtrip.Services;

import com.example.makeyourtrip.Models.Routes;
import com.example.makeyourtrip.Repositories.RouteRepository;
import com.example.makeyourtrip.RequestDTOs.AddRouteDto;
import com.example.makeyourtrip.Transformers.RouteTransformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    public String addRoutes(AddRouteDto addRouteDto){
//        Routes route = new Routes();
        Routes routeObj = RouteTransformers.convertDtoToEntity(addRouteDto);
        routeRepository.save(routeObj);
        return "Routes has been successfully added to DB. ";
    }


}
