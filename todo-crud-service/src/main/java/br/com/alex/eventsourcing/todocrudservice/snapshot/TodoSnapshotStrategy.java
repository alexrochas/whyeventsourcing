package br.com.alex.eventsourcing.todocrudservice.snapshot;

import br.com.alex.eventsourcing.todocrudservice.aggregate.TodoAggregate;
import br.com.alex.eventsourcing.todocrudservice.command.NewTodoCommand;
import io.eventuate.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TodoSnapshotStrategy implements SnapshotStrategy {

  @Override
  public Class<?> getAggregateClass() {
    return TodoAggregate.class;
  }

  @Override
  public Optional<Snapshot> possiblySnapshot(Aggregate aggregate, Optional<Int128> snapshotVersion, List<EventWithMetadata> oldEvents, List<Event> newEvents) {
    TodoAggregate todo = (TodoAggregate) aggregate;
    return Optional.of(new TodoSnapshot(todo.getDescription()));
  }

  @Override
  public Aggregate recreateAggregate(Class<?> clasz, Snapshot snapshot, MissingApplyEventMethodStrategy missingApplyEventMethodStrategy) {
    TodoSnapshot todoSnapshot = (TodoSnapshot) snapshot;
    TodoAggregate aggregate = new TodoAggregate();
    List<Event> events = aggregate.process(new NewTodoCommand(todoSnapshot.getDescription()));
    Aggregates.applyEventsToMutableAggregate(aggregate, events, missingApplyEventMethodStrategy);
    return aggregate;
  }
}
