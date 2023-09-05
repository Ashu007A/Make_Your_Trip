package com.example.makeyourtrip.Repositories;

import com.example.makeyourtrip.Models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Integer> {

    @Query(value = "select * from bookings where journeyDate =:journeyDateInput and transportId =:transportIdInput",nativeQuery = true)
    List<Booking> findBookings(LocalDate journeyDateInput, Integer transportIdInput);

    @Query("SELECT b FROM Booking b " +
            "INNER JOIN b.ticketEntity t " +
            "WHERE b.transport.transportId = :transportId " +
            "AND t.journeyDate = :journeyDate " +
            "AND t.allSeatNos = :seatNo")
    Booking findBookingByTransportIdJourneyDateAndSeat(@Param("transportId") int transportId,
                                                       @Param("journeyDate") LocalDate journeyDate,
                                                       @Param("seatNo") String seatNo);

}
