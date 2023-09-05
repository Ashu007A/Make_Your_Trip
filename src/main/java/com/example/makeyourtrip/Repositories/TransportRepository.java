package com.example.makeyourtrip.Repositories;

import com.example.makeyourtrip.Models.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransportRepository extends JpaRepository<Transport,Integer> {

    @Query("SELECT t FROM Transport t " +
            "INNER JOIN t.route r " +
            "WHERE r.fromCity = :fromCity " +
            "AND r.toCity = :toCity")
    List<Transport> findTransportsByCities(@Param("fromCity") String fromCity,
                                           @Param("toCity") String toCity);

    @Query(value = "SELECT * FROM transport WHERE company_name = :companyName " +
            "AND EXTRACT(MONTH FROM journey_date) = :month " +
            "AND EXTRACT(YEAR FROM journey_date) = :year", nativeQuery = true)
    List<Transport> findTransportsByCompanyNameAndMonth(String companyName, int month, int year);

}
