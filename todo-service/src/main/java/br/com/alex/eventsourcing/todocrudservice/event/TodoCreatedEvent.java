package br.com.alex.eventsourcing.todocrudservice.event;

public class TodoCreatedEvent implements TodoEvent{

	private String description;

	public TodoCreatedEvent() {
	}

	public TodoCreatedEvent(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
