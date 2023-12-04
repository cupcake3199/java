package com.example.democurd;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.example.democurd.model.Task;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
class DemoofcurdOperationApplicationTests {

	@Test
	void testGetProduct() {
		RestTemplate restTemplate=new RestTemplate();
		Task task= restTemplate.getForObject("http://localhost:8080/task/1", Task.class);
		assertNotNull(task);
		assertEquals("updated",task.getDescription());
		
	}
	@Test
	void testPostTask()
	{
		RestTemplate restTemplate=new RestTemplate();
		Task task=new Task();
	    task= restTemplate.postForObject("http://localhost:8080/insert", task,Task.class);
		 task.setTaskId("2");
		 task.setDescription("hello");
		 task.setAssignee("shradha");
		 task.setStoryPoint(16);
		 task.setServerity(03);
		 assertNotNull(task);
		 assertNotNull(task.getTaskId());
		 assertEquals("hello",task.getDescription());
		 
		 
	}
	@Test
	void TestUpdateProduct()
	{
		RestTemplate restTemplate=new RestTemplate();
		Task task=new Task();
		 task= restTemplate.getForObject("http://localhost:8080/task/1", Task.class);
		 task.setDescription("updated");
		 
		 restTemplate.put("http://localhost:8080/uptask/1",task);
		 
	}

}
