package br.com.alex.eventsourcing.todocrudservice.event;

public class TodoCreatedEvent implements TodoEvent{

	private final String description;

	public TodoCreatedEvent(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}
}
