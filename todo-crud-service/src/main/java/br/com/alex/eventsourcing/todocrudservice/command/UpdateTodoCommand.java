package br.com.alex.eventsourcing.todocrudservice.command;

public class UpdateTodoCommand implements TodoCommand{

	private String description;

	public UpdateTodoCommand(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
