package com.cloud.stream.springcloudstreamkafka.listener;

import com.cloud.stream.springcloudstreamkafka.model.Person;
import com.cloud.stream.springcloudstreamkafka.repository.PersonRepository;
import com.cloud.stream.springcloudstreamkafka.stream.PersonChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
@EnableBinding(PersonChannel.class)
@Transactional
public class PersonListener {

    private final PersonRepository personRepository;

    public PersonListener(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @StreamListener(PersonChannel.OUTPUT)
    public void handlePerson(Person person){
        personRepository.save(person);
        log.info("Received Person {}", person);
    }
}
