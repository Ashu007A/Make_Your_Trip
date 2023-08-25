package com.example.makeyourtrip.Repositories;

import com.example.makeyourtrip.Models.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEntity,Integer> {
}
