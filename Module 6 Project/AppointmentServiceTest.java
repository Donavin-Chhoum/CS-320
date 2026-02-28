package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import appointment.AppointmentService;

class AppointmentServiceTest {
	
	private AppointmentService service;
	
	@BeforeEach
	void setup() {
		service = new AppointmentService();
	}

	@AfterEach
	void tearDown() {
		service.appointments.clear(); // Clears the Map after each test
	}
	
	@Test
	void testAddAppointmentSuccess() {
		Date date;
		String description = "New Description";
		
		Calendar tempCal = Calendar.getInstance();
		tempCal.set(Calendar.MILLISECOND, 0);
		
		date = tempCal.getTime();
		
		service.addAppointment(date, description);
		
		assertEquals(1, service.appointments.size());
	}
	
	@Test
	void testAddAppointmentBadDate() {
		Date date;
		String description = "New Description";
		
		Calendar temp = Calendar.getInstance();
		temp.set(Calendar.MONTH, 0);
		
		date = temp.getTime();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addAppointment(date, description);
		});
	}
	
	@Test
	void testAddAppointmentBadDescription() {
		Date date;
		String description = "a".repeat(51);
		
		Calendar tempCal = Calendar.getInstance();
		tempCal.set(Calendar.MILLISECOND, 0);
		
		date = tempCal.getTime();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addAppointment(date, description);
		});
	}
	
	@Test
	void testDeleteAppointment() {
		Date date = new Date();
		String description = "New Description";
		
		service.addAppointment(date, description);
		service.addAppointment(date, description);
		service.addAppointment(date, description);
		
		assertEquals(3, service.appointments.size());
		
		service.deleteAppointment("2");
		
		assertEquals(2, service.appointments.size());
	}

}