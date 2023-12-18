package org.lova.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.enterprise.context.ApplicationScoped;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.lova.DTO.ReservationCreateDTO;


import java.util.Properties;


@ApplicationScoped
public class KafkaReservationProd {

    private final Producer<String, ReservationCreateDTO> producer;

    public KafkaReservationProd(){
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "io.quarkus.kafka.client.serialization.ObjectMapperSerializer");

        producer = new KafkaProducer<String, ReservationCreateDTO>(properties);

    }

    public void produceReservation(ReservationCreateDTO reservationDTO) {

        String topic = "reservation-topic";
        ProducerRecord<String, ReservationCreateDTO> record = new ProducerRecord<>(topic, reservationDTO);

        producer.send(record);
    }

    }

