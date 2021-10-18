package com.edisonmoreno.trainingreactivecommons.api.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class DomainEvent<T> {
    private String name;
    private String eventId;
    private T data;
}
