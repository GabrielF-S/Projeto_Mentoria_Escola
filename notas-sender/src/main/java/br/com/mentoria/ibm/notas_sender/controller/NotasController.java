package br.com.mentoria.ibm.notas_sender.controller;

import br.com.mentoria.ibm.notas_sender.model.Aluno;
import br.com.mentoria.ibm.notas_sender.model.Notas;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface NotasController {

    @PostMapping("/{alunoId}")
    public ResponseEntity<Aluno> getStatus(@PathVariable int alunoId, @RequestBody Notas notas);
}
