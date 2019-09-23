package com.cloud.stream.springcloudstreamkafka.router;

import com.cloud.stream.springcloudstreamkafka.handler.PersonHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@Slf4j
public class PersonRouter {

    /**
     * The Person URL.
     */
    private static final String URL = "/person";

    /**
     * The Handler.
     */
    private final PersonHandler personHandler;

    /**
     * @param personHandler
     */
    public PersonRouter(PersonHandler personHandler) {
        this.personHandler = personHandler;
    }

    /**
     * @return
     */
    @Bean
    public RouterFunction<ServerResponse> initRoutes() {

        return RouterFunctions.route(RequestPredicates.POST(URL),
                personHandler::person);

    }
}
