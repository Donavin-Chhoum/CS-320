package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Task.Task;

class TaskTest {

	@Test
	void testTask() {
		Task task = new Task("TaskId", "Task Name", "Task Description");
		assertTrue(task.getTaskId().equals("TaskId"));
		assertTrue(task.getName().equals("Task Name"));
		assertTrue(task.getDescription().equals("Task Description"));
	}
	
	@Test
	void testTaskIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			new Task("TaskIdTooLong", "Task Name", "Task Description");
		});
	}
	
	@Test
	void testTaskNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			new Task("TaskId", "This Task Name Too Long", "Task Description");
		});
	}
	
	@Test
	void testTaskDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			new Task("TaskId", "This Task Name Too Long", "This Task Description is way too long and does not adhere to the 50 character limit");
		});
	}
	
	@Test
	void testSetNameSuccess() {
		Task task = new Task("TaskId", "Task Name", "Task Description");
		task.setName("New Task Name");
		assertTrue(task.getName().equals("New Task Name"));
	}
	
	@Test
	void testSetNameFail() {
		Task task = new Task("TaskId", "Task Name", "Task Description");
		Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			task.setName("New Task Name That Is Too Long");
		});
		
	}
	
	@Test
	void testSetDescriptionSuccess() {
		Task task = new Task("TaskId", "Task Name", "Task Description");
		task.setDescription("New Task Description");
		assertTrue(task.getDescription().equals("New Task Description"));
	}
	
	@Test
	void testSetDescriptionFail() {
		Task task = new Task("TaskId", "Task Name", "Task Description");
		Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			task.setDescription("This Task Description is way too long and does not adhere to the 50 character limit");
		});
	}

}
