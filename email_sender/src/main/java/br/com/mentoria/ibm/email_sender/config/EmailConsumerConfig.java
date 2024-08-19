package br.com.mentoria.ibm.email_sender.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;

public interface EmailConsumerConfig {
    @Bean
    public ConsumerFactory<?,?> consumerFactory();

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> emailContainerFactory(
            ConsumerFactory<String, String > consumerFactory
    );
}
