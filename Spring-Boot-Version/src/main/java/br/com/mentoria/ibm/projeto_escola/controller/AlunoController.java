package br.com.mentoria.ibm.projeto_escola.controller;

import br.com.mentoria.ibm.projeto_escola.model.Aluno;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface AlunoController {

    @PostMapping()
    public ResponseEntity<Aluno> criarALuno(Aluno aluno);

    @GetMapping(value = "/{id}")
    public ResponseEntity<Aluno> buscarUmAluno(int id);

    @GetMapping()
    public ResponseEntity<List<Aluno>> buscarTodosAlunos();

    @PutMapping()
    public ResponseEntity<Aluno> atualizarAluno(Aluno aluno);

    @PutMapping(value = "/aprovacao")
    public ResponseEntity<?> graduacao(Aluno aluno);

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarAluno(int id);

}
