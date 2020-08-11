package com.shivi.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivi.flightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

}
