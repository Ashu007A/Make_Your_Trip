package com.example.makeyourtrip.Models;


import com.example.makeyourtrip.Enums.City;
import com.example.makeyourtrip.Enums.ModeOfTransport;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "transport")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transportId;

    @Enumerated(value = EnumType.STRING)
    private ModeOfTransport modeOfTransport;

    private LocalDate journeyDate;

    private LocalTime startTime;

    private double journeyTime;

    private String companyName;

    @ManyToOne
    @JoinColumn
    private Routes route;

    @OneToMany(mappedBy = "transport",cascade = CascadeType.ALL)
    List<Seat> seatList = new ArrayList<>();

    @OneToMany(mappedBy = "transport",cascade = CascadeType.ALL)
    List<Booking> bookings = new ArrayList<>();

}
