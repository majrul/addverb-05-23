package com.example;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringBootProjApplication {

	@Autowired
	private static Hello hello;

	public static void main(String[] args) {
		//SpringApplication app = new SpringApplication(SpringBootApplication.class);
		//app.setBannerMode(Banner.Mode.OFF);
		//app.run(args);
		SpringApplication.run(SpringBootProjApplication.class, args);
		//hello.sayHello();
	}

}

@Component
class Hello {

	Hello() {
		System.out.println("Hello Constructor..");
	}

	public void sayHello() {
		System.out.println("Hello Spring Boot!");
	}
}

@RestController
class HelloController {

	@GetMapping("/hello")
	public String hello() {
		return "Welcome to Spring Boot";
	}
}

@RestController
class BookingController {

	@GetMapping(path = "/status/{user}", produces = "application/json")
	public Booking checkStatus(@RequestParam List<Integer> pnrNo, @PathVariable String user) {
		System.out.println(pnrNo);
		//for the time being we will hard code the data
		Booking booking = new Booking();
		//booking.setPnrNo(pnrNo);
		booking.setTrainNo(12345);
		booking.setTravelDate(LocalDate.of(2023, 5, 20));

		List<Passenger> passengers = new ArrayList<>();
		Passenger passenger1 = new Passenger();
		passenger1.setName("Ram");
		passenger1.setMobileNo(1234567890);

		Passenger passenger2 = new Passenger();
		passenger2.setName("Shyam");
		passenger2.setMobileNo(1234567890);

		passengers.add(passenger1);
		passengers.add(passenger2);

		booking.setPassengers(passengers);

		return booking;
	}

}

@XmlRootElement(name = "book")
class Booking {

	private int pnrNo;
	private int trainNo;
	private LocalDate travelDate;

	//@JsonIgnore
	private List<Passenger> passengers;

	public int getPnrNo() {
		return pnrNo;
	}

	public void setPnrNo(int pnrNo) {
		this.pnrNo = pnrNo;
	}

	public int getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}

	public LocalDate getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
}

class Passenger {

	String name;
	int mobileNo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}
}