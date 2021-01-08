package ru.itis;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class DocsProducer {
    public static void main(String[] args) {
        SpringApplication.run(DocsProducer.class, args);
    }

    @Bean
    public Channel channel() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        try {
            Connection connection = connectionFactory.newConnection();
            return connection.createChannel();
        } catch (TimeoutException | IOException e) {
            throw new IllegalStateException();
        }
    }
}