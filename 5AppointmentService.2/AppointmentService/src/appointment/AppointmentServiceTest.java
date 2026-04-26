package appointment;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class AppointmentServiceTest {

	//Test add appointment
	@Test
	public void testAddAppointment() {
		AppointmentService service = new AppointmentService();
		Date futureDate = new Date(System.currentTimeMillis() + 100000);

		Appointment appointment = new Appointment("PedAQ", futureDate, "Ped Physical");
		service.addAppointment(appointment);

		assertEquals(1, service.getAppointments().size());
		assertEquals("PedAQ", service.getAppointments().get(0).getAppointmentId());
	}

	//Test can't duplicate appointment Id
	@Test
	public void testAddDuplicateAppointmentId() {
		AppointmentService service = new AppointmentService();
		Date futureDate = new Date(System.currentTimeMillis() + 100000);

		Appointment appointment1 = new Appointment("PedAQ", futureDate, "Ped Physical");
		Appointment appointment2 = new Appointment("PedAQ", futureDate, "Dentist appointment");

		service.addAppointment(appointment1);

		assertThrows(IllegalArgumentException.class, () -> {
			service.addAppointment(appointment2);
		});
	}

	//Test delete appointment
	@Test
	public void testDeleteAppointment() {
		AppointmentService service = new AppointmentService();
		Date futureDate = new Date(System.currentTimeMillis() + 100000);

		Appointment appointment = new Appointment("PedAQ", futureDate, "Ped Physical");
		service.addAppointment(appointment);
		service.deleteAppointment("PedAQ");

		assertEquals(0, service.getAppointments().size());
	}

	//Test delete appointment that doesn't exist
	@Test
	public void testDeleteAppointmentThatDoesNotExist() {
		AppointmentService service = new AppointmentService();

		assertThrows(IllegalArgumentException.class, () -> {
			service.deleteAppointment("PedAQ9");
		});
	}
	
	@Test
	public void testAddNullAppointment() {
	    AppointmentService service = new AppointmentService();

	    assertThrows(IllegalArgumentException.class, () -> {
	        service.addAppointment(null);
	    });
	}
}
