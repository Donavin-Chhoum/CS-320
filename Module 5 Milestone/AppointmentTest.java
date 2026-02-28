package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.Calendar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import appointment.Appointment;

class AppointmentTest {

	@Test
	void testAppointment() {
		String id = "1";
		Date date;
		String description = "New Description";
		
		Calendar tempCal = Calendar.getInstance();
		tempCal.set(Calendar.MILLISECOND, 0);
		
		date = tempCal.getTime();
		
		Appointment appointment = new Appointment(id, date, description);
		
		assertEquals(id, appointment.getAppointmentId());
		assertEquals(date, appointment.getDate());
		assertEquals(description, appointment.getDescription());
	}
	
	@Test
	void testBadIDAppointment() {
		String id = "12345678901";
		Date date;
		String description = "New Description";
		
		Calendar tempCal = Calendar.getInstance();
		tempCal.set(Calendar.MILLISECOND, 0);
		
		date = tempCal.getTime();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment appointment = new Appointment(id, date, description);
		});
	}
	
	@Test
	void testBadDateAppointment() {
		String id = "12345678901";
		Date date;
		String description = "New Description";
		
		Calendar temp = Calendar.getInstance();
		temp.set(Calendar.MONTH, 0);
		
		date = temp.getTime();;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment appointment = new Appointment(id, date, description);
		});
	}
	
	@Test
	void testBadDescriptionAppointment() {
		String id = "1";
		Date date;
		String description = "This is a very long description that exceeds the 50 character limit.";
		
		Calendar tempCal = Calendar.getInstance();
		tempCal.set(Calendar.MILLISECOND, 0);
		
		date = tempCal.getTime();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment appointment = new Appointment(id, date, description);
		});
	}
	
	@Test
	void testNullID() {
		String id = null;
		Date date;
		String description = "New Description";
		
		Calendar tempCal = Calendar.getInstance();
		tempCal.set(Calendar.MILLISECOND, 0);
		
		date = tempCal.getTime();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment appointment = new Appointment(id, date, description);
		});
	}
	
	@Test
	void testNullDate() {
		String id = "1";
		Date date = null;
		String description = "New Description";
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment appointment = new Appointment(id, date, description);
		});
	}
	
	@Test
	void testNullDescription() {
		String id = "1";
		Date date;
		String description = null;
		
		Calendar tempCal = Calendar.getInstance();
		tempCal.set(Calendar.MILLISECOND, 0);
		
		date = tempCal.getTime();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment appointment = new Appointment(id, date, description);
		});
	}
}