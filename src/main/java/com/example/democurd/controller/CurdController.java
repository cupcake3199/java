package com.example.democurd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.democurd.model.Task;
import com.example.democurd.service.ServiceImp;



@Controller
@RestController
@RequestMapping("/")
@ResponseBody
public class CurdController {
	@Autowired
	private ServiceImp service;
	
	@PostMapping("/insert")

	
	public Task createTask(@RequestBody Task task)
	{
		return service.addTask(task);
	}
	@GetMapping(value="/task")
	public List <Task> getTask()
	{
		return service.findAllTask();
		
	}
	@GetMapping("/task/{taskId}")
	public  Task getTaskByTaskId( @PathVariable String taskId)
	{
	     return service.getTaskByTaskId(taskId);
	     
	}
	@PutMapping("/uptask/{taskId}")
	public Task UpdateByTaskId( @PathVariable String taskId,@RequestBody Task task)
	{
		task.setTaskId(taskId);
		Task updateTask=service.UpdateByTaskId(task);
	      return  updateTask;
		
	}
	@DeleteMapping("/del/{taskId}")
	public String deleteTask(@PathVariable String taskId)
	{
		service.deleteTask(taskId);
		return "delete";
		
	}
	

}
