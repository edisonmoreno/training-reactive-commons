package com.edisonmoreno.trainingreactivecommons;

import com.edisonmoreno.trainingreactivecommons.api.domain.TaskToDo;
import com.edisonmoreno.trainingreactivecommons.api.domain.usecase.ManageTasksUseCase;
import org.reactivecommons.async.api.HandlerRegistry;
import org.reactivecommons.async.commons.config.BrokerConfig;
import org.reactivecommons.async.impl.config.RabbitMqConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SomeConfigurationClass {
    @Autowired
    private ManageTasksUseCase someBusinessDependency;

    @Autowired
    private RabbitMqConfig rabbitMqConfig;

    @Bean
    public HandlerRegistry notificationEvents() {
        rabbitMqConfig = new RabbitMqConfig(null) ;
        return HandlerRegistry.register()
                .listenEvent("task.created", event -> someBusinessDependency.functionReturningMonoVoid(event), TaskToDo.class);
    }
}
