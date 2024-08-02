package br.com.mentoria.ibm.notas_sender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class NotasSenderApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotasSenderApplication.class, args);
    }

}
