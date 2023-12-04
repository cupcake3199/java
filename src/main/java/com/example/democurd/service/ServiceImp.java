package com.example.democurd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.democurd.dao.TaskRepository;
import com.example.democurd.model.Task;



@Service
public class ServiceImp {
	@Autowired
	private TaskRepository repo;
	
	//curd opertion
	public Task addTask(Task task)
	{
	
		return repo.save(task);
	}
	public List<Task> findAllTask()
	{
		return repo.findAll();
		
	}
	
	public Task getTaskByTaskId(String taskId)
	{
		return repo.findById(taskId).get();
	}
	public String deleteTask(@PathVariable String taskId)
	{
		repo.deleteById(taskId);
		return "sucessfully delere";
	}
	public  Task UpdateByTaskId(Task task)
	{
		Task existingTask=repo.findById(task.getTaskId()).get();
		existingTask.setDescription(task.getDescription());
		existingTask.setAssignee(task.getAssignee());
		existingTask.setServerity(task.getServerity());
		existingTask.setStoryPoint(task.getStoryPoint());
		
		Task updatetask=repo.save(existingTask);
		
		return  updatetask;
		
	}
		

}
