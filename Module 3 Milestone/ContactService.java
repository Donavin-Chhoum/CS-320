package module_3;
import java.util.ArrayList;
import java.util.List;

public class ContactService {

	private final List<Contact> contacts;
	
	public ContactService() {
		contacts = new ArrayList<>();
	}
	
	// Adds Contact
	// Finds Contact using the contactId object to check if contact already exists
	public void addContact(Contact contact) {
		if (findContact(contact.getContactId()) != null) {
			throw new IllegalArgumentException("Contact Already Exists");
		}
		contacts.add(contact);
	}
	
	// Deletes Contact by Id
	// Finds Contact using the contactId object
	public void deleteContact(String contactId) {
		Contact contact = findContact(contactId);
			if (contact == null) {
				throw new IllegalArgumentException("Contact Does Not Exist");
			}
		contacts.remove(contact);
	}
	
	// Updates Contact Information
	// Finds Contact using the contactId object
	public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
		Contact contact = findContact(contactId);
		
		if (contact == null) {
			throw new IllegalArgumentException("Contact Does Not Exist");
		}
		
		if (firstName != null && firstName.length() <= 10) {
			contact.setFirstName(firstName);
		}
		
		if (lastName != null && lastName.length() <= 10) {
			contact.setLastName(lastName);
		}
		
		if (phone != null && phone.length() <= 10) {
			contact.setPhone(phone);
		}
		
		if (address != null && address.length() <= 30) {
			contact.setAddress(address);
		}
	}
	
	// Method to find existing contacts
	private Contact findContact(String contactId) {
		for (Contact contact : contacts) {
			if (contact.getContactId().equals(contactId)) {
				return contact;
			}
		}
		return null;
	}
 }
