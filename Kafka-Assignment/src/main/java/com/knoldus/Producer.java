package com.knoldus;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/***
 * producer class is generated to produce messages.
 */

public class Producer {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "com.knoldus.UserSerializer");

        KafkaProducer kafkaProducer = new KafkaProducer(properties);
        try {
            /***
             * for statement is used to iterate the message.
             */
            for (int i = 1; i < 2; i++) {
                User user = new User("64", "Aravind Kumar", 21, "B.Tech");
                System.out.println(user.toString());
                kafkaProducer.send(new ProducerRecord("user", user));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            kafkaProducer.close();
        }
    }
}