package Task;
import java.util.HashMap;
import java.util.Map;

public class TaskService {
	
	public Map<String, Task> tasks;
	int currentTaskId = 0;
	
	// Constructor
	public TaskService() {
		tasks = new HashMap<String, Task>();
	}
	
	
	
	// Add New Task
	public void addTask(String name, String description) {
		
		String _currentId = Integer.toString(currentTaskId);
		Task _task = new Task(_currentId, name, description);
		tasks.put(_currentId, _task);
	}
	
	// Delete Tasks via TaskId
	public void deleteTask(String taskId) {
		
		findTask(taskId);
		tasks.remove(taskId);
	}
	
	// Update Tasks via Task Id
	public void updateTask(String taskId, String name, String description) {
		Task task = findTask(taskId);
		
		task.validateTaskId(taskId);
		
		if (task.validateName(name)) {
			task.setName(name); 
		}
		
		if (task.validateDescription(description) ) { 
			task.setDescription(description); 
		}
		
	}
	
	// Method to search through the Tasks ArrayList given a Task Id
	public Task findTask(String taskId) {
		Task tempTask;
		
		if (tasks.get(taskId) != null) {
			tempTask = tasks.get(taskId);
			return tempTask;
		}
		else {
			throw new IllegalArgumentException("This Task Does Not Exist");
		}
	}
}
