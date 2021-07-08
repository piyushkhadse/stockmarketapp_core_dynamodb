package com.stockmarket.core_d.events.publisher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stockmarket.core_d.events.DomainEvent;
import lombok.NoArgsConstructor;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Component
@NoArgsConstructor
public class KafkaPublisher {
    @Value("${messaging.producer.topic}")
    private String topic;

    @Value("${spring.kafka.producer.bootstrap-servers}")
    private String bootstrapAddress;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate<String, String> producer;


    /**
     * To publish a Domain Event
     * @param event
     * @return
     */
    public boolean publish(DomainEvent event) {
        try {
            producer.send(topic, this.objectMapper.writeValueAsString(event));
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    /**
     * To publish a message
     * @param message
     * @return
     */
    public boolean publish(String message) {
        try {
            producer.send(topic, message);
            return true;
        } catch(Exception e) {
            System.out.println("error:"+e);
            return false;
        }
    }

    /**
     * To publish a Domain Event by passing topic name & doamin event
     * @param topic
     * @param event
     * @return
     */
    public boolean publish(String topic, DomainEvent event) {
        try {
            producer.send(topic, this.objectMapper.writeValueAsString(event));
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    /**
     * To publish a Domain Event by passing topic name & message
     * @param topic
     * @param message
     * @return
     */
    public boolean publish(String topic, String message) {
        try {
            if(producer==null) {
                producer = getKafkaTemplate();
            }
            producer.send(topic, message);
            return true;
        } catch(Exception e) {
            System.out.println("error:"+e);
            return false;
        }
    }

    /**
     * return producerfactory
     * @return
     */
    public ProducerFactory<String, String> producerFactory() {
        Properties properties = new Properties();
        try {
            URL res = getClass().getResource("application.properties");
            File file = Paths.get(res.toURI()).toFile();
            String absolutePath = file.getAbsolutePath();
            BufferedReader reader = new BufferedReader(new FileReader(absolutePath));
            properties.load(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                properties.get("spring.kafka.producer.bootstrap-servers"));
        configProps.put(
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);
        configProps.put(
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    /**
     * return kafkatemplate
     * @return
     */
    public KafkaTemplate<String, String> getKafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

}
