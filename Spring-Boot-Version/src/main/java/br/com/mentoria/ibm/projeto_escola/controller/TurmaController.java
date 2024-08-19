package br.com.mentoria.ibm.projeto_escola.controller;

import br.com.mentoria.ibm.projeto_escola.model.Aluno;
import br.com.mentoria.ibm.projeto_escola.model.Turma;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface TurmaController {

    @GetMapping
    public ResponseEntity<List<Turma>> localizarTodasTurmas();

    @GetMapping("{id}")
    public ResponseEntity<Turma> localizarTurmaPorId(int id);

    @PostMapping("/{nome}")
    public ResponseEntity<?> criarTurma(String nome);
    @PutMapping
    public ResponseEntity<Turma> atualizarTurma(Turma turma);

    @PutMapping("/{id}/adicionarAluno")
    public ResponseEntity<?> adicionarAluno(int id, Aluno aluno);

    @DeleteMapping("/{id}")
    public ResponseEntity excluirTurma(int id);

    @DeleteMapping("{id}/removerAluno")
    public ResponseEntity<?> removerAluno(int id,  Aluno aluno);
}

