package com.example.makeyourtrip.Services;

import com.example.makeyourtrip.Enums.ModeOfTransport;
import com.example.makeyourtrip.Exceptions.RouteNotFoundException;
import com.example.makeyourtrip.Models.Booking;
import com.example.makeyourtrip.Models.Routes;
import com.example.makeyourtrip.Models.Seat;
import com.example.makeyourtrip.Models.Transport;
import com.example.makeyourtrip.Repositories.RouteRepository;
import com.example.makeyourtrip.Repositories.TransportRepository;
import com.example.makeyourtrip.RequestDTOs.AddTransportDto;
import com.example.makeyourtrip.RequestDTOs.SearchFlightDto;
import com.example.makeyourtrip.ResponseDTOs.FlightResult;
import com.example.makeyourtrip.Transformers.TransportTransformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TransportService {

    @Autowired
    private TransportRepository transportRepository;

    @Autowired
    private RouteRepository routeRepository;


    public String addTransport(AddTransportDto addTransportDto)throws Exception{

        Transport transportObj = TransportTransformer.convertDtoToEntity(addTransportDto);
        Optional<Routes> optionalRoutes = routeRepository.findById(addTransportDto.getRouteId());
        if(!optionalRoutes.isPresent())
            throw new RouteNotFoundException("Route Id is incorrect");

        Routes route = optionalRoutes.get();
        //FK column that we are setting
        transportObj.setRoute(route);
        //Bidirectional mapping also needs to be taken care of
        route.getTransportList().add(transportObj);

        //Bcz of bidirectional mapping I am only saving the parent entity
        //And child will get automatically saved
        routeRepository.save(route);
        return "Transport has been added successfully";
    }

    public List<FlightResult> searchForFlights(SearchFlightDto searchFlightDto){

    List<Routes> routes = routeRepository.findRoutesByFromCityAndToCityAndModeOfTransport(searchFlightDto.getFromCity(),searchFlightDto.getToCity(), ModeOfTransport.FLIGHT);


    List<FlightResult> flightResults = new ArrayList<>();

    for(Routes route : routes){

        List<Transport> transportList = route.getTransportList();

        for(Transport transport:transportList){
            if(transport.getJourneyDate().equals(searchFlightDto.getJourneyDate())){
                FlightResult result = TransportTransformer.convertEntityToFlightResult(transport);
                result.setListOfStopInBetween(route.getListOfStopInBetween());
                flightResults.add(result);
            }
        }
    }
        return flightResults;
    }

    public int findCheapestTransport(String fromCity, String toCity) {
        // Find transports between the specified cities
        List<Transport> transports = transportRepository.findTransportsByCities(fromCity, toCity);

        if (transports.isEmpty()) {
            // No transports found between the cities
            return -1; // You can define an appropriate error code
        }

        // Find the transport with the lowest seat price
        Transport cheapestTransport = findTransportWithLowestPrice(transports);

        return cheapestTransport.getTransportId();
    }

    private Transport findTransportWithLowestPrice(List<Transport> transports) {
        // Initialize with the first transport
        Transport cheapestTransport = transports.get(0);

        // Iterate through the transports to find the one with the lowest seat price
        for (Transport transport : transports) {
            int lowestPrice = findLowestSeatPrice(transport);
            if (lowestPrice < findLowestSeatPrice(cheapestTransport)) {
                cheapestTransport = transport;
            }
        }

        return cheapestTransport;
    }

    private int findLowestSeatPrice(Transport transport) {
        int lowestPrice = Integer.MAX_VALUE;

        // Iterate through the seats to find the lowest price
        for (Seat seat : transport.getSeatList()) {
            if (seat.getPrice() < lowestPrice) {
                lowestPrice = seat.getPrice();
            }
        }

        return lowestPrice;
    }

    public double calculateCompanyRevenueInAugust(String companyName) {
        List<Transport> transports = transportRepository.findTransportsByCompanyNameAndMonth(companyName, 8, 2023);

        double totalRevenue = 0.0;

        for (Transport transport : transports) {
            totalRevenue += calculateTransportRevenue(transport);
        }

        return totalRevenue;
    }

    private double calculateTransportRevenue(Transport transport) {
        double revenue = 0.0;

        for (Booking booking : transport.getBookings()) {
            revenue += calculateBookingRevenue(booking);
        }

        return revenue;
    }

    private double calculateBookingRevenue(Booking booking) {
        // Implement logic to calculate revenue for a booking based on seat prices, etc.
        // For simplicity, you can calculate revenue as the sum of seat prices in the booking
        double bookingRevenue = 0.0;

        for (Seat seat : booking.getTransport().getSeatList()) {
            bookingRevenue += seat.getPrice();
        }

        return bookingRevenue;
    }

}
