package com.shivi.flightreservation.services;

import com.shivi.flightreservation.dto.ReservationRequest;
import com.shivi.flightreservation.entities.Reservation;

public interface ReservationService {

	public Reservation bookFlight(ReservationRequest reservationRequest);
}
