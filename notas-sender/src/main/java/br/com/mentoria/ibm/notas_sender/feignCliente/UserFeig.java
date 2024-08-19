package br.com.mentoria.ibm.notas_sender.feignCliente;

import br.com.mentoria.ibm.notas_sender.model.Aluno;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="projeto-escola", url = "http://localhost:8080/alunos")
public interface UserFeig {

    @GetMapping(value = "/{id}")
    ResponseEntity<Aluno> findById(@PathVariable int id);

    @PutMapping(value = "/aprovacao")
    ResponseEntity<?> updateAluno(@RequestBody Aluno aluno);


}
