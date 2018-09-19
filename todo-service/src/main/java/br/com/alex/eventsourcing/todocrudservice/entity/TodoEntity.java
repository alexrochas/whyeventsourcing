package br.com.alex.eventsourcing.todocrudservice.entity;

import org.springframework.data.mongodb.core.mapping.Field;

public class TodoEntity {

	@Field("_id")
	private String id;
	private String description;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
