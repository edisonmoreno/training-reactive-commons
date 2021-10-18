package com.edisonmoreno.trainingreactivecommons.impl.repository;

import com.edisonmoreno.trainingreactivecommons.api.domain.TaskToDo;
import reactor.core.publisher.Mono;

public class TaskToDoRepository implements com.edisonmoreno.trainingreactivecommons.api.domain.TaskToDoRepository {
    @Override
    public Mono<TaskToDo> save(TaskToDo model) {
        return Mono.justOrEmpty(model);
    }
}
