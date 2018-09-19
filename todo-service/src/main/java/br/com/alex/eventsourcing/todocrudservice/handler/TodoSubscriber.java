package br.com.alex.eventsourcing.todocrudservice.handler;

import br.com.alex.eventsourcing.todocrudservice.event.TodoCreatedEvent;
import io.eventuate.EventHandlerContext;
import io.eventuate.EventHandlerMethod;
import io.eventuate.EventSubscriber;

@EventSubscriber(id="todoEventHandlers")
public class TodoSubscriber {

	@EventHandlerMethod
	public void create(EventHandlerContext<TodoCreatedEvent> ctx) {
		TodoCreatedEvent event = ctx.getEvent();
		System.out.println("Event received " + event.getDescription());
	}

}
