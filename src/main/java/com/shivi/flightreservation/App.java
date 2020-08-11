package com.shivi.flightreservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

	public static void main( String[] args)
    {
		System.setProperty("server.servlet.context-path", "/flightreservation");
       SpringApplication.run(App.class, args);
    }
}
