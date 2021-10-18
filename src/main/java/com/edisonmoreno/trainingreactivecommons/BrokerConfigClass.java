package com.edisonmoreno.trainingreactivecommons;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.reactivecommons.async.commons.config.IBrokerConfigProps;
import org.reactivecommons.async.commons.utils.NameGenerator;
import org.reactivecommons.async.impl.config.props.AsyncProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.atomic.AtomicReference;

@Getter
@Configuration
@RequiredArgsConstructor
public class BrokerConfigClass {

}
