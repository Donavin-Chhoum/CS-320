package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
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
		Task task = new Task("TaskId", "Task Name", "Task Description");
		service.addTask(task);
		assertEquals(1, service.tasks.size());
	}
	
	@Test
	void testAddTaskFail() {
		Task task = new Task("TaskId", "Task Name", "Task Description");
		
		service.addTask(task);
		
		Task dupeTask = new Task("TaskId", "Task Name", "Task Description");
		assertThrows(IllegalArgumentException.class, () -> { // Attempts to add a duplicate task
			service.addTask(dupeTask);
		});
	}
	
	@Test
	void testDeleteTaskSuccess() {
		Task task1 = new Task("TaskId #1", "Task Name", "Task Description");
		Task task2 = new Task("TaskId #2", "Task Name", "Task Description");
		Task task3 = new Task("TaskId #3", "Task Name", "Task Description");
		
		service.addTask(task1);
		service.addTask(task2);
		service.addTask(task3);
		
		assertEquals(3, service.tasks.size());
		
		service.deleteTask("TaskId #1");
		
		assertEquals(2, service.tasks.size());	
	}
	
	@Test
	void testDeleteTaskFail() {
		Task task = new Task("TaskId #1", "Task Name", "Task Description");
		service.addTask(task);
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.deleteTask("TaskId #2"); // Attempting to delete a non-existent contact
		});
		
	}
	
	@Test
	void testUpdateTaskSuccess() {
		Task task = new Task("TaskId", "Task Name", "Task Description");
		service.addTask(task);
		service.updateTask("TaskId", "Updated Task Name", "This is a description");
		
		assertEquals("Updated Task Name", service.findTask("TaskId").getName());
		assertEquals("This is a description", service.findTask("TaskId").getDescription());
	}
	
	@Test
	void testUpdateTaskNameFail() {
		Task task = new Task("TaskId", "Task Name", "Task Description");
		service.addTask(task);
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateTask("TaskId", "Updated Task Name Is Too Long", "This is a description"); // Attempting to update with a task name that is too long
		});
	}
	
	@Test
	void testUpdateTaskDescriptionFail() {
		Task task = new Task("TaskId", "Task Name", "Task Description");
		service.addTask(task);
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateTask("TaskId", "Task Name", "This is a description is way too long and does not adhere to the 50 character limit"); // Attempting to update with a task name that is too long
		});
	}
}
