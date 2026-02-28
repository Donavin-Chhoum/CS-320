package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import module_3.Contact;

class ContactTest {
	
	@Test
	void testContact() {
		Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
		
		assertEquals("1", contact.getContactId());
	    assertEquals("John", contact.getFirstName());
	    assertEquals("Doe", contact.getLastName());
	    assertEquals("1234567890", contact.getPhone());
	    assertEquals("123 Main St", contact.getAddress());
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"12345678901"})
	@NullSource
	void testInvalidContactId(String testValue) {
		assertThrows(IllegalArgumentException.class, () -> { 
		      new Contact(testValue, "John", "Doe", "1234567890", "123 Main St"); 
		   }); 
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"Not A Real First Name"})
	@NullSource
	void testInvalidFirstName(String testValue) {
		assertThrows(IllegalArgumentException.class, () -> { 
		      new Contact("1", testValue, "Doe", "1234567890", "123 Main St"); 
		   }); 
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"Not A Real Last Name"})
	@NullSource
	void testInvalidLastName(String testValue) {
		assertThrows(IllegalArgumentException.class, () -> { 
		      new Contact("1", "John", testValue, "1234567890", "123 Main St"); 
		   }); 
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"123456789", "12345678901"})
	@NullSource
	void testInvalidPhoneNumbers(String testValue) {
		assertThrows(IllegalArgumentException.class, () -> { 
		      new Contact("1", "John", "Doe", testValue, "123 Main St"); 
		   }); 
	}
	
	@ParameterizedTest
	@MethodSource("invalidAddresses")
	@NullSource
	void testInvalidAddress(String testValue) {
		assertThrows(IllegalArgumentException.class, () -> { 
		      new Contact("1", "John", "Doe", "1234567890", testValue); 
		   }); 
	}
	
	static Stream<String> invalidAddresses() {
		return Stream.of("A".repeat(31));
	}
	
	@Test
	void testSetMethods() {
		Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
		
		contact.setFirstName("Jane");
		contact.setLastName("Dawson");
		contact.setPhone("0987654321");
		contact.setAddress("321 Sub St");
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"Not A Real First Name"})
	@NullSource
	void testInvalidSetFirstName(String testValue) {
		Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
		
		assertThrows(IllegalArgumentException.class, () -> { 
		      contact.setFirstName(testValue);
		   }); 
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"Not A Real Last Name"})
	@NullSource
	void testInvalidSetLastName(String testValue) {
		Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
		
		assertThrows(IllegalArgumentException.class, () -> { 
		      contact.setLastName(testValue);
		   }); 
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"123456789", "12345678901"})
	@NullSource
	void testInvalidSetPhone(String testValue) {
		Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
		
		assertThrows(IllegalArgumentException.class, () -> { 
		      contact.setPhone(testValue);
		   }); 
	}
	
	@ParameterizedTest
	@MethodSource("invalidAddresses")
	@NullSource
	void testInvalidSetAddress(String testValue) {
		Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
		
		assertThrows(IllegalArgumentException.class, () -> { 
		      contact.setAddress(testValue);
		   }); 
	}
}
