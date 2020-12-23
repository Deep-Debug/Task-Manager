package bootsample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bootsample.model.Task;
import bootsample.service.TaskService;

@RestController
public class SampleRestController {

	@Autowired
	private TaskService taskservice;

	@GetMapping("/hello")
	public String hello() {
		return "Hello World!!";
	}
	
	/*
	 * @GetMapping("/all-tasks") public String allTask() { return
	 * taskservice.findAll().toString(); }
	 * 
	 * @GetMapping("/save-tasks") public String saveTask(@RequestParam String
	 * name,@RequestParam String desc) { Task task = new Task(name,desc);
	 * taskservice.save(task); return "Task saved"; }
	 * 
	 * @GetMapping("/delete-tasks") public String deleteTask(@RequestParam int id) {
	 * taskservice.delete(id); return "Task delete"; }
	 */
	
}
