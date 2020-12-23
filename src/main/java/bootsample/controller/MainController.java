package bootsample.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bootsample.model.Task;
import bootsample.service.TaskService;

@Controller
public class MainController {

	@Autowired
	private TaskService taskservice;
	
	
	@GetMapping("/")
	public String home(HttpServletRequest request)
	{
		request.setAttribute("mode","MODE_HOME");
		return "index";
	}
	
	@GetMapping("/all-tasks")
	public String allTasks(HttpServletRequest request)
	{
		request.setAttribute("tasks", taskservice.findAll());
		request.setAttribute("mode","MODE_TASKS");
		return "index";
	}
	
	@GetMapping("/new-task")
	public String newTasks(HttpServletRequest request)
	{
		request.setAttribute("mode","MODE_NEW");
		return "index";
	}
	
	@PostMapping("/save-task")
	public String saveTasks(@ModelAttribute Task task,BindingResult bindingResult,HttpServletRequest request)
	{
		taskservice.save(task);
		request.setAttribute("tasks", taskservice.findAll());
		request.setAttribute("mode","MODE_TASKS");
		return "index";
	}
	
	
	@GetMapping("/update-task")
	public String updateTasks(@RequestParam int id,HttpServletRequest request)
	{
		request.setAttribute("task", taskservice.findTask(id));
		request.setAttribute("mode","MODE_UPDATE");
		return "index";
	}
	
	@GetMapping("/delete-task")
	public String deleteTasks(@RequestParam int id,HttpServletRequest request)
	{
		taskservice.delete(id);
		request.setAttribute("tasks", taskservice.findAll());
		request.setAttribute("mode","MODE_TASKS");
		return "index";
	}
}
