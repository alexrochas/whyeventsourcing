package br.com.alex.eventsourcing.todocrudservice.api;

import br.com.alex.eventsourcing.todocrudservice.aggregate.TodoAggregate;
import br.com.alex.eventsourcing.todocrudservice.api.dto.TodoDTO;
import br.com.alex.eventsourcing.todocrudservice.service.TodoService;
import io.eventuate.EntityWithIdAndVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/todo")
public class TodoApi {

	private final TodoService todoService;

	@Autowired
	public TodoApi(TodoService todoService) {
		this.todoService = todoService;
	}

	@PostMapping
	public ResponseEntity newTodo(@RequestBody TodoDTO todoDTO) throws ExecutionException, InterruptedException {
		System.out.println("New todo.");
		EntityWithIdAndVersion<TodoAggregate> todoResult = todoService.newTodo(todoDTO.getDescription()).get();
		return ResponseEntity.ok(todoResult.getEntityId());
	}

	@PutMapping("/{id}")
	public ResponseEntity updateTodo(@RequestBody TodoDTO todoDTO, @PathVariable String id) throws ExecutionException, InterruptedException {
		System.out.println("Update todo.");
		EntityWithIdAndVersion<TodoAggregate> todoResult = todoService.updateTodo(id, todoDTO.getDescription()).get();
		return ResponseEntity.ok(todoResult.getEntityId());
	}

}

