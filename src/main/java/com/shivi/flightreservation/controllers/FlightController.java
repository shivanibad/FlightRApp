package com.shivi.flightreservation.controllers;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shivi.flightreservation.entities.Flight;
import com.shivi.flightreservation.repos.FlightRepository;

@Controller
public class FlightController {
	
@Autowired	
FlightRepository flightRepository;

	@RequestMapping("/findFlights")
	 public String findFlights(@RequestParam("from")String from,@RequestParam("to") String to,@RequestParam("departureDate") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate departureDate, ModelMap modelmap) {
		System.out.println("res---"+from+"--"+to+"--"+departureDate);
		
		List<Flight> flights= flightRepository.findFlights(from,to);
		
		System.out.println(flights);
		
		modelmap.addAttribute("flights",flights);
		return "login/displayFlights";
		}
	
	@RequestMapping("admin/showAddFlight")
	public String showAddFlight() {
		return "addFlight";
	}
	
	
}
