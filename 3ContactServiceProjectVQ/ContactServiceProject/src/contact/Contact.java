package contact;

//Contact class
public class Contact {
	//Private Variables
	private final String contactId;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	//Constructor
	public Contact(String contactId, String firstName, String lastName, String phone, String address) {
		
		//Contact class requirements
		//Contact ID no longer than 10 characters
		if(contactId == null || contactId.length()>10) {
			throw new IllegalArgumentException("Invalid contact ID");
		}
		//First Name no longer than 10 characters
		if(firstName == null || firstName.length()>10) {
			throw new IllegalArgumentException("Invalid First Valid");
		}
		//Last Name no longer than 10 characters
		if(lastName == null || lastName.length()>10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		//Phone number no longer than 10 digits
		if(phone == null || !phone.matches("\\d{10}")) {
			throw new IllegalArgumentException("Invalid Phone");
		}
		//Address no longer than 30 characters
		if(address == null || address.length()>30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	//Getter method to get contact info
	
	public String getContactId() {
	    return contactId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		if(firstName == null || firstName.length()>10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		if(lastName == null || lastName.length()>10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		if(phone == null || !phone.matches("\\d{10}")) {
			throw new IllegalArgumentException("Invalid Phone");
		}
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		if(address == null || address.length()>30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		this.address = address;
	}

}
