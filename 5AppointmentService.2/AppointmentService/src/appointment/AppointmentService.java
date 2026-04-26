package appointment;

import java.util.ArrayList;
import java.util.List;

public class AppointmentService {
	private final List<Appointment> appointments = new ArrayList<>();

	//Add new appointment
	public void addAppointment(Appointment appointment) {
		//Can't null appointments
		if (appointment == null) {
			throw new IllegalArgumentException("Appointment cannot be null");
		}

		//Check duplicates
		for (Appointment existingAppointment : appointments) {
			if (existingAppointment.getAppointmentId().equals(appointment.getAppointmentId())) {
				throw new IllegalArgumentException("Appointment ID must be unique");
			}
		}

		appointments.add(appointment);
	}

	//Delete appointment using ID
	public void deleteAppointment(String appointmentId) {
		Appointment appointmentToDelete = null;

		for (Appointment appointment : appointments) {
			if (appointment.getAppointmentId().equals(appointmentId)) {
				appointmentToDelete = appointment;
				break;
			}
		}

		if (appointmentToDelete == null) {
			throw new IllegalArgumentException("Appointment ID not found");
		}

		appointments.remove(appointmentToDelete);
	}

	//Return list of appointments
	public List<Appointment> getAppointments() {
		return appointments;
	}
}
