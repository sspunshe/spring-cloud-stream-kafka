package com.cloud.stream.springcloudstreamkafka.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface PersonChannel {

//    String INPUT = "person-in";
    String OUTPUT = "person-out";

//    @Input(INPUT)
//    SubscribableChannel inbound();

    @Output(OUTPUT)
    MessageChannel outbound();

}
