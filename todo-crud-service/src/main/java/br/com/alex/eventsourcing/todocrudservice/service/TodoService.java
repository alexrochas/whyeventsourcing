package br.com.alex.eventsourcing.todocrudservice.service;

import br.com.alex.eventsourcing.todocrudservice.aggregate.TodoAggregate;
import br.com.alex.eventsourcing.todocrudservice.command.NewTodoCommand;
import br.com.alex.eventsourcing.todocrudservice.command.TodoCommand;
import io.eventuate.AggregateRepository;
import io.eventuate.EntityWithIdAndVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class TodoService {

    private final AggregateRepository<TodoAggregate, TodoCommand> accountRepository;

    @Autowired
    public TodoService(AggregateRepository<TodoAggregate, TodoCommand> accountRepository) {
        this.accountRepository = accountRepository;
    }

    public CompletableFuture<EntityWithIdAndVersion<TodoAggregate>> newTodo(String description) {
        return accountRepository.save(new NewTodoCommand(description));
    }

}
