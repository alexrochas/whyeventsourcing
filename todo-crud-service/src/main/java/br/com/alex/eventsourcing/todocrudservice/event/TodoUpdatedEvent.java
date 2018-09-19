package br.com.alex.eventsourcing.todocrudservice.event;

public class TodoUpdatedEvent implements TodoEvent{

	private String description;

	public TodoUpdatedEvent() {}

	public TodoUpdatedEvent(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}
}
