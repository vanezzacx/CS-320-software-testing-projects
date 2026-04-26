package contact;

//file containing test class for ContactService class using JUnit
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ContactServiceTest {
	//Test method to Add a contact
	@Test
	public void testAddContact() {
		ContactService service = new ContactService();
		Contact contact = new Contact("1001", "Vanessa", "Quintero", "0123456789", "678 August St");
		
		service.addContact(contact);
		//assert that Contact is added
		assertNotNull(service.findContactById("1001"));
	}
	//Test method to Delete a contact
	@Test
	public void testDeleteContact() {
		ContactService service = new ContactService();
		Contact contact = new Contact("1002", "Vanessa", "Quintero", "0123456789", "678 August St");
		
		service.addContact(contact);
		service.deleteContact("1002");
		
		//assert that you cannot find contact
		assertNull(service.findContactById("1002"));
	}
	//Test method to update First Name
	@Test
	public void testUpdateFirstName() {
		ContactService service = new ContactService();
		Contact contact = new Contact("1003", "Vanessa", "Quintero", "0123456789", "678 August St");
		
		service.addContact(contact);
		service.updateFirstName("1003", "Nessa");
		
		//assert that First Name has been updated
		assertEquals("Nessa", service.findContactById("1003").getFirstName());
	}
	//Test method to update Last Name
	@Test
	public void testUpdateLastName() {
		ContactService service = new ContactService();
		Contact contact = new Contact("1004", "Vanessa", "Quintero", "0123456789", "678 August St");
		
		service.addContact(contact);
		service.updateLastName("1004", "Ney");
		
		//assert that Last Name has been updated
		assertEquals("Ney", service.findContactById("1004").getLastName());
	}
	//Test method to update Phone
	@Test
	public void testUpdatePhone() {
		ContactService service = new ContactService();
		Contact contact = new Contact("1005", "Vanessa", "Quintero", "0123456789", "678 August St");
		
		service.addContact(contact);
		service.updatePhone("1005", "9876543210");
		
		//assert that Phone has been updated
		assertEquals("9876543210", service.findContactById("1005").getPhone());
	}
	//Test method to update Address
	@Test
	public void testUpdateAddress() {
		ContactService service = new ContactService();
		Contact contact = new Contact("1006", "Vanessa", "Quintero", "0123456789", "678 August St");
		
		service.addContact(contact);
		service.updateAddress("1006", "123 Main St");
		
		//assert that Address has been updated
		assertEquals("123 Main St", service.findContactById("1006").getAddress());
	}

}
