package com.cloud.stream.springcloudstreamkafka.handler;

import com.cloud.stream.springcloudstreamkafka.model.Person;
import com.cloud.stream.springcloudstreamkafka.service.PersonService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
public class PersonHandler {

    /**
     * The Person Service.
     */
    private final PersonService personService;

    /**
     *
     * @param personService
     */
    public PersonHandler(PersonService personService) {
        this.personService = personService;
    }

    /**
     *
     * @param serverRequest
     * @return
     */
    public Mono<ServerResponse> person(ServerRequest serverRequest){
        return serverRequest.bodyToMono(Person.class).flatMap(resp -> {
            personService.sendPerson(resp);
            return ServerResponse.ok().body(BodyInserters.fromObject(resp));
        });
    }

   }
