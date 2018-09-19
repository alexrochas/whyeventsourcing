package br.com.alex.eventsourcing.todocrudservice.repository;

import br.com.alex.eventsourcing.todocrudservice.entity.TodoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends MongoRepository<TodoEntity, String> {
}

