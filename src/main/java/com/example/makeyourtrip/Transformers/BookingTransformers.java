package com.example.makeyourtrip.Transformers;

import com.example.makeyourtrip.Models.Booking;
import com.example.makeyourtrip.RequestDto.BookingRequest;

public class BookingTransformers {

    public static Booking convertRequestToEntity(BookingRequest bookingRequest){

        Booking bookingObj = Booking.builder().journeyDate(bookingRequest.getJourneyDate())
                .seatNos(bookingRequest.getSeatNos())
                .transportId(bookingRequest.getTransportId())
                .build();

        return bookingObj;
    }
}
