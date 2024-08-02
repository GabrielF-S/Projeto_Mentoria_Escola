package br.com.mentoria.ibm.notas_sender.feignCliente;

import br.com.mentoria.ibm.notas_sender.model.Aluno;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="projeto-escola", url = "http://localhost:8080")
public interface UserFeig {

    @GetMapping(value = "alunos/{id}")
    ResponseEntity<Aluno> findById(@PathVariable int id);


}
