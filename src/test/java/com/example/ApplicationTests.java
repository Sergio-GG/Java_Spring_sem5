package com.example;

import com.example.model.Task;
import com.example.repository.TaskRepository;
import com.example.service.TaskService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
class ApplicationTests {

	@InjectMocks
	TaskService taskService;

	@Mock
	TaskRepository taskRepository;

	@Test
	void contextLoads() {
		// given
		Task task = new Task();
		task.setDescription("New task");

		// when
		when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

		// then
		Assertions.assertEquals("New task", taskService.getTaskById(1L).getDescription());
		verify(taskRepository,times(1)).findById(1L);
	}

}
