package Task;

public class Task {

	// Required Objects
	private final String taskId;
	private String name;
	private String description;
	
	// Constructor
	public Task(String taskId, String name, String description) {
		
		validateTaskId(taskId);
		validateName(name);
		validateDescription(description);
		
		this.taskId = taskId;
		this.name = name;
		this.description = description;
	}
	
	// Validation Methods
	public boolean validateTaskId(String taskId) {
		if (taskId == null || taskId.length() > 10) {
			throw new IllegalArgumentException("Invalid Task ID");
		}
		else {
			return true;
		}
	}
	
	public boolean validateName(String name) {
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid Name");
		}
		else {
			return true;
		}
	}
	
	public boolean validateDescription(String description) {
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		else {
			return true;
		}
	}
	
	// Getter Methods
	public String getTaskId() { return taskId; }
	public String getName() { return name; }
	public String getDescription() { return description; }
	
	// Setter Methods
	public void setName(String name) {
		validateName(name);
		this.name = name;
	}
	
	public void setDescription(String description) {
		validateDescription(description);
		this.description = description;
	}
}
