package br.com.alex.eventsourcing.todocrudservice.config;

import br.com.alex.eventsourcing.todocrudservice.aggregate.TodoAggregate;
import br.com.alex.eventsourcing.todocrudservice.command.TodoCommand;
import br.com.alex.eventsourcing.todocrudservice.handler.TodoSubscriber;
import io.eventuate.sync.AggregateRepository;
import io.eventuate.javaclient.spring.EnableEventHandlers;
import io.eventuate.sync.EventuateAggregateStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableEventHandlers
public class ModuleConfig {
	@Bean
	public AggregateRepository<TodoAggregate, TodoCommand> customerRepository(EventuateAggregateStore eventStore) {
		return new AggregateRepository(TodoAggregate.class, eventStore);
	}

	@Bean
	public TodoSubscriber todoSubscriber() {
		System.out.println("Starting subscriber.");
		return new TodoSubscriber();
	}
}
