package br.com.alex.eventsourcing.todocrudservice;

import io.eventuate.javaclient.driver.EventuateDriverConfiguration;
import io.eventuate.javaclient.spring.common.EventuateCommonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({EventuateDriverConfiguration.class, EventuateCommonConfiguration.class})
public class TodoCrudServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoCrudServiceApplication.class, args);
	}
}
