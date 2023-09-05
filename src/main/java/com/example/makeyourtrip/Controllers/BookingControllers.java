package com.example.makeyourtrip.Controllers;

import com.example.makeyourtrip.RequestDTOs.BookingRequest;
import com.example.makeyourtrip.RequestDTOs.GetAvailableSeatsDto;
import com.example.makeyourtrip.ResponseDTOs.AvailableSeatResponseDto;
import com.example.makeyourtrip.Services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingControllers {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/getAvailableSeats")
    public ResponseEntity getAvailableSeats(@RequestBody GetAvailableSeatsDto getAvailableSeatsDto){

        List<AvailableSeatResponseDto> result = bookingService.getAvailableSeatsResponse(getAvailableSeatsDto);
        return new ResponseEntity(result, HttpStatus.OK);

    }

    @PostMapping("/bookFlight")
    public ResponseEntity bookFlight(@RequestBody BookingRequest bookingRequest){

    return null;
    }




}
