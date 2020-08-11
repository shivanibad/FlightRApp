<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Complete Reservation</title>
</head>
<body>
<h2>Complete Reservation</h2>
Airline: ${flight.operatingAirlines}<br/>
Departure City: ${flight.departureCity}<br/>
Arrival City: ${flight.arrivalCity}<br/>
<form action="completeReservation" method="post">
<pre>
<h2>Passenger Details:</h2>
passengerFirstName:<input type="text" name="passengerFirstName">
passengerLastName:<input type="text" name="passengerLastName">
Email Id:<input type="text" name="passengerEmail">
Phone Number:<input type="text" name="passengerPhone">
<h2> Card Details:</h2>
name On The Card:<input type="text" name="nameOnTheCard">
expiry Date:<input type="text" name="expiryDate">
card Number:<input type="text" name="cardNumber">
security Code:<input type="text" name="securityCode">
<input type="submit" value="confirm">
<input type="hidden" name="flightId" value="${flight.id}"> 
</pre>
</form>
</body>
</html>