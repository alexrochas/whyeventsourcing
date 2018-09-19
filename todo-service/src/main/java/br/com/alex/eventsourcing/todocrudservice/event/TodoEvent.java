package br.com.alex.eventsourcing.todocrudservice.event;

import io.eventuate.Event;
import io.eventuate.EventEntity;

@EventEntity(entity = "br.com.alex.eventsourcing.todocrudservice.aggregate.TodoAggregate")
public interface TodoEvent extends Event {
}
