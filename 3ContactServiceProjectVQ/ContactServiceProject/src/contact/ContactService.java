package contact;

import java.util.ArrayList;
import java.util.List;

//ContactService class
public class ContactService {
	private final List<Contact> contacts = new ArrayList<>();
	
	//method to Add a contact
	public void addContact(Contact contact) {
		if(contact == null) {
			throw new IllegalArgumentException("Contact cannot be null");
		}
		for (Contact existingContact : contacts) {
			if(existingContact.getContactId().equals(contact.getContactId())) {
				throw new IllegalArgumentException("Contact ID must be unique");
			}
		}
		contacts.add(contact);
	}
	
	//method to Delete contact 
	public void deleteContact(String contactId) {
		Contact contact = findContactById(contactId);
		if(contact == null) {
			throw new IllegalArgumentException("Contact not found");
		}
		contacts.remove(contact);
	}
	
	//method to update First Name
	public void updateFirstName(String contactId, String firstName) {
		Contact contact = findContactById(contactId);
		if(contact == null) {
			throw new IllegalArgumentException("Contact not found");
		}
		contact.setFirstName(firstName);
	}
	
	//method to update Last Name
	public void updateLastName(String contactId, String lastName) {
		Contact contact = findContactById(contactId);
		if(contact == null) {
			throw new IllegalArgumentException("Contact not found");
		}
		contact.setLastName(lastName);
	}
	
	//method to update Phone
	public void updatePhone(String contactId, String phone) {
		Contact contact = findContactById(contactId);
		if(contact == null) {
			throw new IllegalArgumentException("Contact not found");
		}
		contact.setPhone(phone);
	}
	
	//method to update Address
	public void updateAddress(String contactId, String address) {
		Contact contact = findContactById(contactId);
		if(contact == null) {
			throw new IllegalArgumentException("Contact not found");
		}
		contact.setAddress(address);
	}
	
	//method to get contact by Id
	public Contact findContactById(String contactId) {
		for (Contact contact : contacts) {
			if(contact.getContactId().equals(contactId)) {
				return contact;
			}
		}
		return null;
	}

}
