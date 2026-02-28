package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import module_3.Contact;
import module_3.ContactService;

class ContactServiceTest {
	
	private ContactService service;
	
	@BeforeEach
	public void setUp() {
		service = new ContactService();
	}

	@Test
	void testAddContactSuccess() {
		Contact contact = new Contact("123456789", "Donavin", "Chhoum", "6291112222", "477 Somewhere, Nevada");
		service.addContact(contact);
		assertNotNull(service);
	}
	
	@Test
	void testAddContactFailure() {
		Contact contact = new Contact("123456789", "Donavin", "Chhoum", "6291112222", "477 Somewhere, Nevada");
		service.addContact(contact);
		Contact contact1 = new Contact("123456789", "Donavin", "Chhoum", "6291112222", "477 Somewhere, Nevada");
		assertThrows(IllegalArgumentException.class, () -> {
			service.addContact(contact1);
		});
	}
	
	@Test
	void testDeleteContactSuccess() {
		Contact contact = new Contact("123456789", "Donavin", "Chhoum", "6291112222", "477 Somewhere, Nevada");
		service.addContact(contact);
		service.deleteContact("123456789");
		assertNotNull(service);
	}
	
	@Test
	void testDeleteContactFailure() {
		Contact contact = new Contact("123456789", "Donavin", "Chhoum", "6291112222", "477 Somewhere, Nevada");
		service.addContact(contact);
		service.deleteContact("123456789");
		assertThrows(IllegalArgumentException.class, () -> {
			service.deleteContact("123456789"); // Attempting to delete a non-existent contact
		});
	}
	
	@Test
	void testUpdateContact() {
		Contact contact = new Contact("123456789", "Donavin", "Chhoum", "6291112222", "477 Somewhere, Nevada");
		service.addContact(contact);
		service.updateContact("123456789", "Jose", "Lopez", "7602224444", "522 Nowhere, California");
		assertNotNull(service);
	}

}
