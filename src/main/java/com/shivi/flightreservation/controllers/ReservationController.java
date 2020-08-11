package com.shivi.flightreservation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shivi.flightreservation.dto.ReservationRequest;
import com.shivi.flightreservation.entities.Flight;
import com.shivi.flightreservation.entities.Reservation;
import com.shivi.flightreservation.repos.FlightRepository;
import com.shivi.flightreservation.services.ReservationService;

@Controller
public class ReservationController {

	@Autowired
	FlightRepository flightRepository;
	@Autowired
	ReservationService reservationService;
	@RequestMapping("/showCompleteReservation")
	 public void showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelmap) {
		
		
		Flight flight=flightRepository.findById(flightId).orElse(new Flight());
		modelmap.addAttribute("flight", flight);
		//return "login/completeReservation";
		 
	 }
	
	@RequestMapping(value="/completeReservation", method=RequestMethod.POST)
	 public String completeReservation(ReservationRequest request,ModelMap modelmap) {
		
		Reservation reservation = reservationService.bookFlight(request);
		modelmap.addAttribute("msg","reservation created successfully and the id is"+reservation.getId());
		return "login/reservationConfirmation";
		 
	 }
	
	
}
