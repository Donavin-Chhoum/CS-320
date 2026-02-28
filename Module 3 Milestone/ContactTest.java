package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import module_3.Contact;

class ContactTest {

	@Test
	void testContact() {
		Contact contact = new Contact("123", "Donavin", "Chhoum", "6291112222", "477 Somewhere, Nevada");
		assertTrue(contact.getContactId().equals("123"));
		assertTrue(contact.getFirstName().equals("Donavin"));
		assertTrue(contact.getLastName().equals("Chhoum"));
		assertTrue(contact.getPhone().equals("6291112222"));
		assertTrue(contact.getAddress().equals("477 Somewhere, Nevada"));
	}
	
	@Test
	void testContactIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			new Contact("12345678901", "Donavin", "Chhoum", "6291112222", "477 Somewhere, Nevada");
		});
	}
	
	@Test
	void testFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			new Contact("123", "Donavin1234", "Chhoum", "6291112222", "477 Somewhere, Nevada");
		});
	}
	
	@Test
	void testLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			new Contact("123", "Donavin", "Chhoum12345", "6291112222", "477 Somewhere, Nevada");
		});
	}
	
	@Test
	void testPhoneTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			new Contact("123", "Donavin", "Chhoum", "6291112222999", "477 Somewhere, Nevada");
		});
	}
	
	@Test
	void testAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			new Contact("123", "Donavin", "Chhoum", "6291112222", "477 Somewhere, Nevada 1234567890");
		});
	}
	
	@Test
	void testSetFirstName() {
		Contact contact = new Contact("123", "Donavin", "Chhoum", "6291112222", "477 Somewhere, Nevada");
		contact.setFirstName("Jose");
	}
	
	@Test
	void testSetLastName() {
		Contact contact = new Contact("123", "Donavin", "Chhoum", "6291112222", "477 Somewhere, Nevada");
		contact.setLastName("Lopez");
	}
	
	@Test
	void testSetPhone() {
		Contact contact = new Contact("123", "Donavin", "Chhoum", "6291112222", "477 Somewhere, Nevada");
		contact.setPhone("7603121999");
	}
	
	@Test
	void testSetAddress() {
		Contact contact = new Contact("123", "Donavin", "Chhoum", "6291112222", "477 Somewhere, Nevada");
		contact.setAddress("517 Nowhere, California");
	}

}
