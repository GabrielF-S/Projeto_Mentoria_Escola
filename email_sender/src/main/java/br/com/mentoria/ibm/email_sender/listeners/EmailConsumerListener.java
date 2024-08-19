package br.com.mentoria.ibm.email_sender.listeners;

import br.com.mentoria.ibm.email_sender.custom.EmailConsumerCustomListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface EmailConsumerListener {
    @EmailConsumerCustomListener(groupId = "group-1")
    public void listener(ConsumerRecord<String, String> record);
}
