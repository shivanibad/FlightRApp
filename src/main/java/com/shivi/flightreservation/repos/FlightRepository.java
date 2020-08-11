package com.shivi.flightreservation.repos;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivi.flightreservation.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

	@Query("from Flight where departure_city=:departureCity and arrival_city=:arrivalCity")
	public List<Flight> findFlights(@Param("departureCity") String from, @Param("arrivalCity") String to/*,@Param("dateOfDeparture") Date departureDate*/);



	/*
	 * @Query(value =
	 * "select * from Flight where departure_city=? and arrival_city=? and date_of_departure=?"
	 * , nativeQuery = true) public List<Flight> findFlights(String from, String to,
	 * LocalDate date);
	 */

}
