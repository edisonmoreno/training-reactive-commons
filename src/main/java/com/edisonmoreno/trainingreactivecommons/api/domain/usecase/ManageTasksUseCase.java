package com.edisonmoreno.trainingreactivecommons.api.domain.usecase;

import com.edisonmoreno.trainingreactivecommons.api.domain.TaskToDo;
import com.edisonmoreno.trainingreactivecommons.api.domain.TaskToDoFactory;
import com.edisonmoreno.trainingreactivecommons.api.domain.TaskToDoRepository;
import org.reactivecommons.api.domain.DomainEvent;
import org.reactivecommons.api.domain.DomainEventBus;
import reactor.core.publisher.Mono;

import java.util.UUID;

public class ManageTasksUseCase {
    private TaskToDoRepository tasks;
    private DomainEventBus eventBus;

    public ManageTasksUseCase(TaskToDoRepository tasks, DomainEventBus eventBus) {
        this.tasks = tasks;
        this.eventBus = eventBus;
    }

    public Mono<TaskToDo> createNew(String name, String description) {
        return Mono.justOrEmpty(UUID.randomUUID())
                .flatMap(id -> TaskToDoFactory.createTask(id, name, description))
                .flatMap(tasks::save)
                .flatMap(task -> emitCreatedEvent(task).thenReturn(task));
    }

    private Mono<Void> emitCreatedEvent(TaskToDo task) {
        return Mono.from(eventBus.emit(new DomainEvent<>("task.created", task.getId(), task)));
    }

    public Mono<Void> functionReturningMonoVoid(DomainEvent<TaskToDo> event) {
        System.out.println(event.getData().toString());
        return null;
    }
}
