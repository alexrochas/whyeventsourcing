package br.com.alex.eventsourcing.todocrudservice.snapshot;

import io.eventuate.Snapshot;

public class TodoSnapshot implements Snapshot {

	private String description;

	public TodoSnapshot() {}

	public TodoSnapshot(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
