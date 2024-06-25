package br.com.mentoria.ibm.projeto_escola;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("br.com.mentoria.ibm.projeto_escola")
@SpringBootApplication
public class ProjetoEscolaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoEscolaApplication.class, args);
	}

}
