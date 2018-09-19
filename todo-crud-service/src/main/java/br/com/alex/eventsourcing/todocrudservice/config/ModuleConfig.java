package br.com.alex.eventsourcing.todocrudservice.config;

import br.com.alex.eventsourcing.todocrudservice.aggregate.TodoAggregate;
import br.com.alex.eventsourcing.todocrudservice.command.TodoCommand;
import io.eventuate.AggregateRepository;
import io.eventuate.EventuateAggregateStore;
import io.eventuate.javaclient.spring.EnableEventHandlers;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@EnableEventHandlers
public class ModuleConfig {

	@Bean
    public AggregateRepository<TodoAggregate, TodoCommand> aggregateRepository(EventuateAggregateStore eventStore) {
        return new AggregateRepository<>(TodoAggregate.class, eventStore);
    }

}
