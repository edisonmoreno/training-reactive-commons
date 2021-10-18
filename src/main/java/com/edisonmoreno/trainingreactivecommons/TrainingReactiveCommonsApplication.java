package com.edisonmoreno.trainingreactivecommons;

import com.edisonmoreno.trainingreactivecommons.api.domain.TaskToDoRepository;
import com.edisonmoreno.trainingreactivecommons.api.domain.usecase.ManageTasksUseCase;
import org.reactivecommons.api.domain.DomainEventBus;
import org.reactivecommons.async.impl.config.annotations.EnableDomainEventBus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDomainEventBus
public class TrainingReactiveCommonsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingReactiveCommonsApplication.class, args);
	}

	@Bean
	public ManageTasksUseCase manageTasksUseCase(TaskToDoRepository tasks, DomainEventBus eventBus) {
		return new ManageTasksUseCase(tasks, eventBus);
	}

}
