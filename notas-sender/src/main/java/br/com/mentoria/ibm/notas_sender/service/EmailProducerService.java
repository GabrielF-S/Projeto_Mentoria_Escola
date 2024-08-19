package br.com.mentoria.ibm.notas_sender.service;

import br.com.mentoria.ibm.notas_sender.service.util.Status;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class EmailProducerService {


    public final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMail(String email, String nome, Status status) {
        String message = EmailProducerService.gerarEmail(nome, status);
        kafkaTemplate.send("email-topic", email, message).whenComplete
                ((sucess, error) -> {
            if (error != null) {
                log.error("Mensagem não enviada para {}", error.getMessage());
            } else {
                log.info("Mensagem enviada com sucesso para {}: {} ",email, message);
                log.info("Partição: {}, Topico: {}", sucess.getRecordMetadata().partition(), sucess.getRecordMetadata().topic());
            }
        }
        );
    }

    private static String gerarEmail(String nome, Status status) {
        return "Prezado, " + nome +
                " suas notas foram lançados e informando que você foi "
                + status + " no curso";
    }
}
