package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import Task.Task;

class TaskTest {

	@Test
	void testTask() {
		Task task = new Task("1", "Task Name", "Task Description");
		assertTrue(task.getTaskId().equals("1"));
		assertTrue(task.getName().equals("Task Name"));
		assertTrue(task.getDescription().equals("Task Description"));
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"12345678901"})
	@NullSource
	void testInvalidTaskId(String testValue) {
		Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			new Task(testValue, "Task Name", "Task Description");
		});
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"This Name is too long"})
	@NullSource
	void testInvalidTaskName(String testValue) {
		Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			new Task("1", testValue, "Task Description");
		});
	}
	
	@ParameterizedTest
	@MethodSource("invalidDescription")
	@NullSource
	void testTaskDescriptionTooLong(String testValue) {
		Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			new Task("TaskId", "This Task Name Too Long", "This Task Description is way too long and does not adhere to the 50 character limit");
		});
	}
	
	static Stream<String> invalidDescription() {
		return Stream.of("A".repeat(51));
	}
	
	@Test
	void testSetNameSuccess() {
		Task task = new Task("TaskId", "Task Name", "Task Description");
		task.setName("New Task Name");
		assertTrue(task.getName().equals("New Task Name"));
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"12345678901"})
	@NullSource
	void testSetNameFail(String testValue) {
		Task task = new Task("TaskId", "Task Name", "Task Description");
		Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			task.setName(testValue);
		});
		
	}
	
	@Test
	void testSetDescriptionSuccess() {
		Task task = new Task("TaskId", "Task Name", "Task Description");
		task.setDescription("New Task Description");
		assertTrue(task.getDescription().equals("New Task Description"));
	}
	
	@ParameterizedTest
	@MethodSource("invalidDescription")
	@NullSource
	void testSetDescriptionFail(String testValue) {
		Task task = new Task("TaskId", "Task Name", "Task Description");
		Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			task.setDescription(testValue);
		});
	}

}
