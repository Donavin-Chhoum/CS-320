package module_3;
import java.util.HashMap;
import java.util.Map;

public class ContactService {

	private final Map<String, Contact> contacts;
	int currentId = 0; // Used as the unique ID
	
	public ContactService() {
		contacts = new HashMap<String, Contact>();
	}
	
	// Adds Contact
	// Finds Contact using the contactId object to check if contact already exists
	public void addContact(String firstName, String lastName, String phone, String address) {
		
		String _currentId = Integer.toString(currentId);
		Contact contact = new Contact(_currentId, firstName, lastName, phone, address);
		contacts.put(_currentId, contact);
		
		// Increments the unique ID after every added contact
		++currentId;
	}
	
	// Deletes Contact by Id
	// Finds Contact using the contactId object
	public void deleteContact(String contactId) {
		
		findContact(contactId);
		contacts.remove(contactId);
	}
	
	// Updates Contact Information
	// Finds Contact using the contactId object
	public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
		Contact contact = findContact(contactId);
		
		contact.validateId(contactId);
		
		if (contact.validateFirstName(firstName) == true) {
			contact.setFirstName(firstName);
		}
		
		if (contact.validateLastName(lastName) == true) {
			contact.setLastName(lastName);
		}
		
		if (contact.validatePhone(phone) == true) {
			contact.setPhone(phone);
		}
		
		if (contact.validateAddress(address) == true) {
			contact.setAddress(address);
		}
	}
	
	// Gets An Existing Contact
	public Contact findContact(String contactId) {
		Contact contact;
		
		if (contacts.get(contactId) != null) {
			contact = contacts.get(contactId);
			return contact;
		}
		else {
			throw new IllegalArgumentException("This Contact Does Not Exist");
		}
	}
 }
