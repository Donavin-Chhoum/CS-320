package appointment;

import java.util.*;

public class AppointmentService {
	
	// Used as the Appointment Id
	int currentId = 0;

	public static Map<String, Appointment> appointments = new HashMap<String, Appointment>();
	
	// Creates an apppointment with a unqiue appointment ID
	public void addAppointment(Date date, String description) {
		
		String _currentId = Integer.toString(currentId);
		Appointment tempAppointment = new Appointment(_currentId, date, description);
		appointments.put(_currentId, tempAppointment);
		
		// Increments every time a new Appointment is created
		++currentId;
	}
	
	
	// Deletes appointment via appointment ID
	public void deleteAppointment(String appointmentId) {
		
		if (appointments.containsKey(appointmentId)) {
			appointments.remove(appointmentId);
		}
	}
}
