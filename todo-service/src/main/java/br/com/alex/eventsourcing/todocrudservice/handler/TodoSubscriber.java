package br.com.alex.eventsourcing.todocrudservice.handler;

import br.com.alex.eventsourcing.todocrudservice.entity.TodoEntity;
import br.com.alex.eventsourcing.todocrudservice.event.TodoCreatedEvent;
import br.com.alex.eventsourcing.todocrudservice.repository.TodoRepository;
import io.eventuate.EventHandlerContext;
import io.eventuate.EventHandlerMethod;
import io.eventuate.EventSubscriber;
import org.springframework.beans.factory.annotation.Autowired;

@EventSubscriber(id="todoEventHandlers")
public class TodoSubscriber {

	private TodoRepository todoRepository;

	public TodoSubscriber(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	@EventHandlerMethod
	public void create(EventHandlerContext<TodoCreatedEvent> ctx) {
		TodoCreatedEvent event = ctx.getEvent();
		System.out.println("Event received " + event.getDescription());
		TodoEntity todoEntity = new TodoEntity();
		todoEntity.setDescription(event.getDescription());
		TodoEntity savedTodo = todoRepository.save(todoEntity);
		System.out.println("Saved " + savedTodo.getId());
	}
}
