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
		validateId(contactId);
		validateFirstName(firstName);
		validateLastName(lastName);
		validatePhone(phone);
		validateAddress(address);
		
		//Set inputs to class variables
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	// Validation Methods
	// Will throw an error if input is invalid
	public boolean validateId(String contactId) {
		if (contactId == null || contactId.length() > 10) {
			throw new IllegalArgumentException("Invalid Contact ID");
		}
		return true;
	}
	
	public boolean validateFirstName(String firstName) {
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		return true;
	}
	
	public boolean validateLastName(String lastName) {
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		return true;
	}

	public boolean validatePhone(String phone) {
		if (phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		return true;
	}
	
	public boolean validateAddress(String address) {
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		return true;
	}
	
	//Getter Methods
	public String getContactId() { return contactId; }
	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	public String getPhone() { return phone; }
	public String getAddress() { return address; }
	
	//Setter Methods
	public void setFirstName(String firstName) {
		validateFirstName(firstName);
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		validateLastName(lastName);
		this.lastName = lastName;
	}
	
	public void setPhone(String phone) {
		validatePhone(phone);
		this.phone = phone;
	}
	
	public void setAddress(String address) {
		validateAddress(address);
		this.address = address;
	}
	
}
