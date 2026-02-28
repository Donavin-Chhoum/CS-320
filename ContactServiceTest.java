package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import module_3.Contact;
import module_3.ContactService;

class ContactServiceTest {
	
	private ContactService service;
	
	@BeforeEach
	public void setUp() {
		service = new ContactService();
	}

	@Test
	void testAddContact() {	
		service.addContact("John", "Doe", "1234567890", "123 Main St");
		
		Contact contact = service.findContact("0");
		
		assertNotNull(contact);
		assertEquals("John", contact.getFirstName());
		assertEquals("Doe", contact.getLastName());
		assertEquals("1234567890", contact.getPhone());
		assertEquals("123 Main St", contact.getAddress());
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"0"})
	void testValidDeleteContact(String testValue) {
		service.addContact("John", "Doe", "1234567890", "123 Main St");
		
		assertDoesNotThrow(() -> {
			service.deleteContact(testValue);
		});
	} 
	
	@ParameterizedTest
	@ValueSource(strings = {"1"})
	@NullSource
	void testInvalidDeleteContact(String testValue) {
		service.addContact("John", "Doe", "1234567890", "123 Main St");
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.deleteContact(testValue);
		});
	} 
	
	@Test
	void testValidUpdateContact() {	
		service.addContact("John", "Doe", "1234567890", "123 Main St");
		
		service.updateContact("0", "Jane", "Dawson", "0987654321", "321 Main St");
		Contact contact = service.findContact("0");
		
		assertNotNull(contact);
		assertEquals("Jane", contact.getFirstName());
		assertEquals("Dawson", contact.getLastName());
		assertEquals("0987654321", contact.getPhone());
		assertEquals("321 Main St", contact.getAddress());
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"1"})
	@NullSource
	void testInvalidUpdateContact(String testValue) {
		service.addContact("John", "Doe", "1234567890", "123 Main St");
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateContact(testValue, "Jane", "Dawson", "0987654321", "321 Main St");
		});
		
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"Not A Real First Name"})
	@NullSource
	void testInvalidUpdateFirstName(String testValue) {
		service.addContact("John", "Doe", "1234567890", "123 Main St");
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateContact("0", testValue, "Doe", "0987654321", "321 Main St");
		});
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"Not A Real Last Name"})
	@NullSource
	void testInvalidUpdateLastName(String testValue) {
		service.addContact("John", "Doe", "1234567890", "123 Main St");
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateContact("0", "John", testValue, "0987654321", "321 Main St");
		});
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"123456789", "12345678901"})
	@NullSource
	void testInvalidUpdatePhone(String testValue) {
		service.addContact("John", "Doe", "1234567890", "123 Main St");
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateContact("0", "John", "Doe", testValue, "321 Main St");
		});
	}
	
	@ParameterizedTest
	@MethodSource("invalidAddresses")
	@NullSource
	void testInvalidUpdateAddress(String testValue) {
		service.addContact("John", "Doe", "1234567890", "123 Main St");
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateContact("0", "John", "Doe", "1234567890", testValue);
		});
	}
	
	static Stream<String> invalidAddresses() {
		return Stream.of("A".repeat(31));
	}

}
