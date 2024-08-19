package br.com.mentoria.ibm.email_sender.listeners;

import br.com.mentoria.ibm.email_sender.custom.EmailConsumerCustomListener;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class EmailConsumerListener {
    @EmailConsumerCustomListener(groupId = "group-1")
    public void listener(ConsumerRecord<String, String> record) {
        log.info("Enviado email para: {}", record.key() );
        log.info("Conteudo: {}", record.value());

    }

}
