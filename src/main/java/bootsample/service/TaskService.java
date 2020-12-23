package bootsample.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import bootsample.dao.TaskRepository;
import bootsample.model.Task;

@Service
@Transactional
public class TaskService {

	
	private final TaskRepository taskRepo;

	public TaskService(TaskRepository taskRepo) {
		this.taskRepo = taskRepo;
	}
	
	public List<Task> findAll()
	{
		List<Task> tasks = new ArrayList<>();
		for(Task task: taskRepo.findAll()) {
			tasks.add(task);
		}
		return tasks;
	}
	
	public Task findTask(int id)
	{
		return taskRepo.findOne(id);
	}
	
	public void save(Task task)
	{
		taskRepo.save(task);
	}
	
	public void delete(int id)
	{
		taskRepo.delete(id);
	}
}
