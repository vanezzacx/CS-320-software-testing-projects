package appointment;

import java.util.Date;

public class Appointment {
	private final String appointmentId;
	private Date appointmentDate;
	private String description;

	//Constructor
	public Appointment(String appointmentId, Date appointmentDate, String description) {
		
		//ID can't be more than 10 characters
		if (appointmentId == null || appointmentId.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}

		//Date can't be in the past
		if (appointmentDate == null || appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("Invalid Date");
		}

		//Description can't be more than 50 characters
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}

		//Assign values
		this.appointmentId = appointmentId;
		this.appointmentDate = appointmentDate;
		this.description = description;
	}

	//Getter for ID
	public String getAppointmentId() {
		return appointmentId;
	}

	//Getter for Date
	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		if (appointmentDate == null || appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("Invalid Date");
		}
		this.appointmentDate = appointmentDate;
	}

	//Getter for Description
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		this.description = description;
	}
}
