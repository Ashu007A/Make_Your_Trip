package com.example.makeyourtrip.Controllers;

import com.example.makeyourtrip.RequestDTOs.AddTransportDto;
import com.example.makeyourtrip.RequestDTOs.SearchFlightDto;
import com.example.makeyourtrip.ResponseDTOs.FlightResult;
import com.example.makeyourtrip.Services.BookingService;
import com.example.makeyourtrip.Services.TransportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RequestMapping("/transport")
@RestController
@Slf4j
public class TransportControllers {

    @Autowired
    private TransportService transportService;

    @Autowired
    private BookingService bookingService;

    @PostMapping("/add")
    public ResponseEntity addTransport(@RequestBody AddTransportDto addTransportDto){
        try{
            String result = transportService.addTransport(addTransportDto);
            return new ResponseEntity(result, HttpStatus.OK);
        }catch (Exception e){
            log.error("Add transport failed {}",e.getMessage());
            System.out.printf("We are in the print statement {}",e.getMessage());
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/searchFlights")
    public ResponseEntity searchFlights(@RequestBody SearchFlightDto searchFlightDto){

        List<FlightResult> flightResults = transportService.searchForFlights(searchFlightDto);

        return new ResponseEntity(flightResults,HttpStatus.OK);
    }

    @DeleteMapping("/cancelTicket")
    public ResponseEntity<Map<String, Object>> cancelTicket(@RequestParam int transportId,
                                                            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate journeyDate,
                                                            @RequestParam String seatNo) {
        Map<String, Object> result = bookingService.cancelTicket(transportId, journeyDate, seatNo);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/cheapestTransport")
    public ResponseEntity<Integer> findCheapestTransport(@RequestParam String fromCity,
                                                         @RequestParam String toCity) {
        int cheapestTransportId = transportService.findCheapestTransport(fromCity, toCity);

        if (cheapestTransportId == -1) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(cheapestTransportId, HttpStatus.OK);
    }

    @GetMapping("/companyRevenue")
    public ResponseEntity<Double> getCompanyRevenue(@RequestParam String companyName) {
        double revenue = transportService.calculateCompanyRevenueInAugust(companyName);
        return ResponseEntity.ok(revenue);
    }

}
