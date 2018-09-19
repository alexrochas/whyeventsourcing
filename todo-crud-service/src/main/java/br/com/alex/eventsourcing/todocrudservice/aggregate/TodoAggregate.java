package br.com.alex.eventsourcing.todocrudservice.aggregate;

import br.com.alex.eventsourcing.todocrudservice.command.NewTodoCommand;
import br.com.alex.eventsourcing.todocrudservice.command.TodoCommand;
import br.com.alex.eventsourcing.todocrudservice.command.UpdateTodoCommand;
import br.com.alex.eventsourcing.todocrudservice.event.TodoCreatedEvent;
import br.com.alex.eventsourcing.todocrudservice.event.TodoUpdatedEvent;
import io.eventuate.Event;
import io.eventuate.EventUtil;
import io.eventuate.ReflectiveMutableCommandProcessingAggregate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TodoAggregate extends ReflectiveMutableCommandProcessingAggregate<TodoAggregate, TodoCommand> {

	private String description;

	public List<Event> process(NewTodoCommand cmd) {
		System.out.println("Create todo.");
		return EventUtil.events(new TodoCreatedEvent(cmd.getDescription()));
	}

	public List<Event> process(UpdateTodoCommand cmd) {
		System.out.println("Update todo.");
		return EventUtil.events(new TodoUpdatedEvent(cmd.getDescription()));
	}

	public void apply(TodoCreatedEvent event) {
		System.out.println("Created event.");
		this.description = event.getDescription();
	}

	public void apply(TodoUpdatedEvent event) {
		System.out.println("Updated event.");
		this.description = event.getDescription();
	}

	public String getDescription() {
		return description;
	}
}
