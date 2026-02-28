package module_3;

public class Contact {

	// Required Objects
	private final String contactId;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	// Constructor
	public Contact(String contactId, String firstName, String lastName, String phone, String address) {
		
		//Validate Inputs
		if (contactId == null || contactId.length() > 10) {
			throw new IllegalArgumentException("Invalid Contact ID");
		}
		
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid Name");
		}
		
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Name");
		}
		
		if (phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid Name");
		}
		
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Name");
		}
		
		//Set inputs to class variables
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	//Getter Methods
	public String getContactId() { return contactId; }
	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	public String getPhone() { return phone; }
	public String getAddress() { return address; }
	
	//Setter Methods
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid Contact ID");
		}
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Name");
		}
		this.lastName = lastName;
	}
	
	public void setPhone(String phone) {
		if (phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid Name");
		}
		this.phone = phone;
	}
	
	public void setAddress(String address) {
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Name");
		}
		this.address = address;
	}
	
}
