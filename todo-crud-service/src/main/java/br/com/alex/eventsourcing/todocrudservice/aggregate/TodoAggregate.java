package br.com.alex.eventsourcing.todocrudservice.aggregate;

import br.com.alex.eventsourcing.todocrudservice.command.NewTodoCommand;
import br.com.alex.eventsourcing.todocrudservice.command.TodoCommand;
import br.com.alex.eventsourcing.todocrudservice.event.TodoCreatedEvent;
import io.eventuate.Event;
import io.eventuate.EventUtil;
import io.eventuate.ReflectiveMutableCommandProcessingAggregate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TodoAggregate extends ReflectiveMutableCommandProcessingAggregate<TodoAggregate, TodoCommand> {

	private String description;

	public List<Event> process(NewTodoCommand cmd) {
		System.out.println("Aggregate command.");
		return EventUtil.events(new TodoCreatedEvent(cmd.getDescription()));
	}

	public void apply(TodoCreatedEvent event) {
		System.out.println("Apply event.");
		this.description = event.getDescription();
	}

	public String getDescription() {
		return description;
	}
}
