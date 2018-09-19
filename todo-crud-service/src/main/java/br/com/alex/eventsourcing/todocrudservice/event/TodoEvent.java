package br.com.alex.eventsourcing.todocrudservice.event;

import io.eventuate.Event;
import io.eventuate.EventEntity;

@EventEntity(entity = "Todo")
public interface TodoEvent extends Event {
}
