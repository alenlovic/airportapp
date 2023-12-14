package org.lova.kafka;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

@ApplicationScoped
public class KafkaProducer {

    @Outgoing("kafka-outgoing")
    public String produce(){
        return "hello world";
    }
}
