package com.example.democurd.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.democurd.model.Task;


@Repository
public interface TaskRepository extends MongoRepository<Task, String> {

	List<Task> findByStoryPoint(int storyPoint);
  @Query("{assignee:?0}")
	List<Task> findByAssignee(String assignee);

}
