package contact;

//file containing test class for Contact class using JUnit
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//ContactTest class
public class ContactTest {
	
	//test method for Valid contact creation
	@Test
	public void testValidContact() {
		Contact contact = new Contact("0123", "Vanessa", "Quintero", "0123456789", "678 August St");
		
		assertNotNull(contact);
		assertEquals("0123", contact.getContactId());
		assertEquals("Vanessa", contact.getFirstName());
		assertEquals("Quintero", contact.getLastName());
		assertEquals("0123456789", contact.getPhone());
		assertEquals("678 August St", contact.getAddress());
	}
	
	//test method for Invalid contact Id creation
	@Test
	public void testInvalidContactId() {
		assertThrows(IllegalArgumentException.class, ()->{
			new Contact("12345678900", "Vanessa", "Quintero", "0123456789", "678 August St");
		});
		
	}
	
	//test method for Invalid Phone creation
	@Test
	public void testInvalidPhone() {
		assertThrows(IllegalArgumentException.class, ()->{
			new Contact("0123", "Vanessa", "Quintero", "123", "678 August St");
		});
	}

}
