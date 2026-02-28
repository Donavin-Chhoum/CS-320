package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.BeforeEach;

import Task.Task;
import Task.TaskService;

class TaskServiceTest {

	private TaskService service;
	
	@BeforeEach
	public void setUp() {
		service = new TaskService();
	}
	
	@Test
	void testAddTaskSuccess() {
		service.addTask("Task Name", "Task Description");
		
		Task task = service.findTask("0");
		
		assertNotNull(task);
		assertEquals("0", task.getTaskId());
		assertEquals("Task Name", task.getName());
		assertEquals("Task Description", task.getDescription());
	}
	
	
	@Test
	void testValidDeleteTask() {
		service.addTask("Task Name", "Task Description");
		
		assertDoesNotThrow(() -> {
			service.deleteTask("0");
		});
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"1"})
	@NullSource
	void testInvalidDeleteTaskFail(String testValue) {
		service.addTask("Task Name", "Task Description");
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.deleteTask(testValue); 
		});
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"1"})
	@NullSource
	void testInvalidUpdateName(String testValue) {
		service.addTask("Task Name", "Task Description");
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateTask("0", testValue, "Task Description"); 
		});
	}
	
	@ParameterizedTest
	@MethodSource("invalidDescription")
	@NullSource
	void testInvalidUpdateDescription(String testValue) {
		service.addTask("Task Name", "Task Description");
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateTask("0", "Task Name", testValue); 
		});
	}
	
	static Stream<String> invalidDescription() {
		return Stream.of("A".repeat(51));
	}
	
}
