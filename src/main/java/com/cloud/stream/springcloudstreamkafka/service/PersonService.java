package com.cloud.stream.springcloudstreamkafka.service;

import com.cloud.stream.springcloudstreamkafka.model.Person;
import com.cloud.stream.springcloudstreamkafka.stream.PersonChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
@Slf4j
public class PersonService {

    private final PersonChannel personChannel;

    public PersonService(PersonChannel personChannel) {
        this.personChannel = personChannel;
    }

    public void sendPerson(final Person person){

        log.info("Sending person {}", person);

//        SubscribableChannel subscribableChannel = personChannel.inbound();
        MessageChannel messageChannel = personChannel.outbound();
        messageChannel.send(MessageBuilder
                .withPayload(person)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());

    }
}
