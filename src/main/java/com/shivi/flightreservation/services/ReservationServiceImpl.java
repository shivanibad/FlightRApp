package com.shivi.flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shivi.flightreservation.dto.ReservationRequest;
import com.shivi.flightreservation.entities.Flight;
import com.shivi.flightreservation.entities.Passenger;
import com.shivi.flightreservation.entities.Reservation;
import com.shivi.flightreservation.repos.FlightRepository;
import com.shivi.flightreservation.repos.PassengerRepository;
import com.shivi.flightreservation.repos.ReservationRepository;



@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	FlightRepository flightRepository;
	@Autowired
	PassengerRepository passengerRepository;
	@Autowired
	ReservationRepository reservationRepository;
	
	
	public Reservation bookFlight(ReservationRequest request) {
		
		Long flightId = request.getFlightId();
		Flight flight= flightRepository.findById(flightId).orElse(new Flight());
		Passenger passenger=new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmail());
		Passenger savedPassenger=passengerRepository.save(passenger);
		
		Reservation reservation=new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		
		Reservation savedReservation=reservationRepository.save(reservation);
		return savedReservation;
	}

}
