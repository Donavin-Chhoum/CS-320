package appointment;

import java.util.Date;
import java.util.Calendar;

public class Appointment {

	private final String appointmentId;
	private Date date;
	private String description;
	
	public Appointment (String appointmentId, Date date, String description) {
		
		
		if (validateAppointmentId(appointmentId) == false) {
			throw new IllegalArgumentException("Invalid AppointmentId");
		}
		
		if (validateDate(date) == false) {
			throw new IllegalArgumentException("Invalid Date");
		}
		
		if (validateDescription(description) == false) {
			throw new IllegalArgumentException("Invalid Description");
		}
		
		this.appointmentId = appointmentId;
		this.date = date;
		this.description = description;
	}
	
	// Validates requirement for valid AppointmentId
	// True = Valid, False = Not Valid
	private boolean validateAppointmentId(String appointmentId) {
		
		if (appointmentId == null || appointmentId.length() > 10) {
			return false;
		}
		
		return true;
	}
		
	// Validates requirement for valid Date
	// True = Valid, False = Not Valid
	private boolean validateDate(Date date) {
		Calendar tempCal = Calendar.getInstance();
		tempCal.set(Calendar.MILLISECOND, 0);
		Date tempDate = tempCal.getTime();

		if (date == null || date.before(tempDate)) {
			return false;
		}
		
		return true;
	}
	
	// Validates requirement for valid Description
	// True = Valid, False = Not Valid
	private boolean validateDescription(String description) {
		
		if (description == null || description.length() > 50) {
			return false;
		}
		return true;
	}
	
	// Get Method for Objects
	public String getAppointmentId() { return appointmentId; }
	public Date getDate() { return date; }
	public String getDescription() { return description; }
	
}
