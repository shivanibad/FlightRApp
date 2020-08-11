package com.shivi.flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shivi.flightreservation.dto.ReservationUpdateRequest;
import com.shivi.flightreservation.entities.Flight;
import com.shivi.flightreservation.entities.Reservation;
import com.shivi.flightreservation.repos.ReservationRepository;

@RestController
@CrossOrigin
public class reservationRestController {
	@Autowired
	ReservationRepository reservationRepository;
@RequestMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id") Long id)
	{
	Reservation reservation=reservationRepository.findById(id).orElse(new Reservation());
	System.out.println(reservation);
	return reservation;
	}


@RequestMapping("/reservations")
public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
	Reservation reservation= reservationRepository.findById(request.getId()).get();
	
	reservation.setNumberOfBags(request.getNumberOfBags());
	reservation.setCheckedIn(request.getCheckedIn());
	Reservation updatedReservation = reservationRepository.save(reservation);
	 
	return updatedReservation;
	
}
}