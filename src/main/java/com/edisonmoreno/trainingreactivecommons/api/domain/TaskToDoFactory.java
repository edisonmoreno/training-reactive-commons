package com.edisonmoreno.trainingreactivecommons.api.domain;

import reactor.core.publisher.Mono;

import java.util.UUID;

public class TaskToDoFactory {
    public static Mono<TaskToDo> createTask(UUID id, String name, String description) {
        return Mono.just(new TaskToDo(id.toString(), name, description));
    }
}
