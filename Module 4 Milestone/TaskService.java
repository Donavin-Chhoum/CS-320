package Task;
import java.util.ArrayList;
import java.util.List;

public class TaskService {

	public List<Task> tasks;
	
	// Constructor
	public TaskService() {
		tasks = new ArrayList<>();
	}
	
	// Add New Task
	public void addTask(Task task) {
		if (findTask(task.getTaskId()) != null) {
			throw new IllegalArgumentException("Task Already Exists");
		}
		tasks.add(task);
	}
	
	// Delete Tasks via TaskId
	public void deleteTask(String taskId) {
		Task task = findTask(taskId);
		
		if (task == null) {
			throw new IllegalArgumentException("Task Does Not Exist");
		}
		
		tasks.remove(task);
	}
	
	// Update Tasks via Task Id
	public void updateTask(String taskId, String name, String description) {
		Task task = findTask(taskId);
		
		if (task == null) {
			throw new IllegalArgumentException("Task Does Not Exist");
		}
		
		if (name != null && name.length() <= 20) {
			task.setName(name);
		}
		else {
			throw new IllegalArgumentException("Invalid Name");
		}
		
		if (description != null && description.length() <= 50) {
			task.setDescription(description);
		}
		else {
			throw new IllegalArgumentException("Invalid Description");
		}
	}
	
	// Method to search through the Tasks ArrayList given a Task Id
	public Task findTask(String taskId) {
		for (Task task : tasks) {
			if (task.getTaskId().equals(taskId)) {
				return task;
			}
		}
		return null;
	}
}
