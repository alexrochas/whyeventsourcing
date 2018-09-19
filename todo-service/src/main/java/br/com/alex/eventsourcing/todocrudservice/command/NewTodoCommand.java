package br.com.alex.eventsourcing.todocrudservice.command;

public class NewTodoCommand implements TodoCommand{

	private String description;

	public NewTodoCommand(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
