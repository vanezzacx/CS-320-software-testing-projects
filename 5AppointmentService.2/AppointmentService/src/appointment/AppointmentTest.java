package appointment;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class AppointmentTest {

	//Test creating appointment
	@Test
	public void testValidAppointment() {
		Date futureDate = new Date(System.currentTimeMillis() + 100000);

		Appointment appointment = new Appointment("PedAQ", futureDate, "Ped Physical");

		assertEquals("PedAQ", appointment.getAppointmentId());
		assertEquals(futureDate, appointment.getAppointmentDate());
		assertEquals("Ped Physical", appointment.getDescription());
	}

	//ID can't be null
	@Test
	public void testAppointmentIdCannotBeNull() {
		Date futureDate = new Date(System.currentTimeMillis() + 100000);

		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, futureDate, "Ped Physical");
		});
	}

	//ID cannot be more than 10 characters
	@Test
	public void testAppointmentIdCannotBeTooLong() {
		Date futureDate = new Date(System.currentTimeMillis() + 100000);

		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("Pediatric Appointment AQ", futureDate, "Ped Physical");
		});
	}

	//Date can't be null
	@Test
	public void testAppointmentDateCannotBeNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("PedAQ", null, "Ped Physical");
		});
	}

	//Date can't be in the past
	@Test
	public void testAppointmentDateCannotBeInPast() {
		Date pastDate = new Date(System.currentTimeMillis() - 100000);

		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("PedAQ3", pastDate, "Ped Physical");
		});
	}

	//Description can't be null
	@Test
	public void testDescriptionCannotBeNull() {
		Date futureDate = new Date(System.currentTimeMillis() + 100000);

		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("PedAQ", futureDate, null);
		});
	}

	//Description cannot be more than 50 characters
	@Test
	public void testDescriptionCannotBeTooLong() {
		Date futureDate = new Date(System.currentTimeMillis() + 100000);

		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("PedAQ", futureDate,
					"Description for the appointment cannot be more than 50 characters.");
		});
	}

	//Test update appointment date
	@Test
	public void testSetAppointmentDate() {
		Date futureDate = new Date(System.currentTimeMillis() + 100000);
		Date newFutureDate = new Date(System.currentTimeMillis() + 200000);

		Appointment appointment = new Appointment("PedAQ", futureDate, "Ped Physical");
		appointment.setAppointmentDate(newFutureDate);

		assertEquals(newFutureDate, appointment.getAppointmentDate());
	}

	//Test update description
	@Test
	public void testSetDescription() {
		Date futureDate = new Date(System.currentTimeMillis() + 100000);

		Appointment appointment = new Appointment("PedAQ", futureDate, "Ped Physical");
		appointment.setDescription("Dentist appointment");

		assertEquals("Dentist appointment", appointment.getDescription());
	}
	
	@Test
	public void testSetAppointmentDateCannotBeNull() {
	    Date futureDate = new Date(System.currentTimeMillis() + 100000);
	    Appointment appointment = new Appointment("PedAQ", futureDate, "Ped Physical");

	    assertThrows(IllegalArgumentException.class, () -> {
	        appointment.setAppointmentDate(null);
	    });
	}

	@Test
	public void testSetAppointmentDateCannotBeInPast() {
	    Date futureDate = new Date(System.currentTimeMillis() + 100000);
	    Date pastDate = new Date(System.currentTimeMillis() - 100000);
	    Appointment appointment = new Appointment("PedAQ", futureDate, "Ped Physical");

	    assertThrows(IllegalArgumentException.class, () -> {
	        appointment.setAppointmentDate(pastDate);
	    });
	}

	@Test
	public void testSetDescriptionCannotBeTooLong() {
	    Date futureDate = new Date(System.currentTimeMillis() + 100000);
	    Appointment appointment = new Appointment("PedAQ", futureDate, "Ped Physical");

	    assertThrows(IllegalArgumentException.class, () -> {
	        appointment.setDescription("Description for the appointment cannot be more than 50 characters.");
	    });
	}
	
	@Test
	public void testSetDescriptionCannotBeNull() {
	    Date futureDate = new Date(System.currentTimeMillis() + 100000);
	    Appointment appointment = new Appointment("PedAQ", futureDate, "Ped Physical");

	    assertThrows(IllegalArgumentException.class, () -> {
	        appointment.setDescription(null);
	    });
	}
}
