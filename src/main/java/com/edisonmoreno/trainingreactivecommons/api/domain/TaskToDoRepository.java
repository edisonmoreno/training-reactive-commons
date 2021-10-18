package com.edisonmoreno.trainingreactivecommons.api.domain;

import reactor.core.publisher.Mono;

public interface TaskToDoRepository {
    Mono<TaskToDo> save(TaskToDo model);
}
