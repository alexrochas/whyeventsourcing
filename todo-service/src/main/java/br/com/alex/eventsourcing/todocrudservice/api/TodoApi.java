package br.com.alex.eventsourcing.todocrudservice.api;

import br.com.alex.eventsourcing.todocrudservice.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class TodoApi {

	@Autowired
	private TodoRepository todoRepository;

	@GetMapping
	public ResponseEntity fetchAll() {
		return ResponseEntity.ok(todoRepository.findAll());
	}

}
