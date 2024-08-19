package br.com.mentoria.ibm.projeto_escola.controller;

import br.com.mentoria.ibm.projeto_escola.model.Escola;
import br.com.mentoria.ibm.projeto_escola.model.Turma;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface EscolaController {

    @GetMapping
    public ResponseEntity<List<Escola>> buscarTodasEscola();


    @GetMapping("/{id}")
    public ResponseEntity<Optional<Escola>> buscarUmaEscola(int id);

    @PostMapping("/{nome}")
    public ResponseEntity<Escola> cadastrarEscola(String nome);

    @PutMapping()
    public ResponseEntity<Escola> atualizarEscola(Escola escola);

    @PutMapping(value = "{id}/cadastrarTurma")
    public ResponseEntity<?> cadastrarTurma(int id, Turma turma);

    @PutMapping("/removerTurma/{id}")
    public ResponseEntity<?> removerTurma(int id);

    @DeleteMapping("/{id}")
    public ResponseEntity<Escola> excluirEscola(int id);
}
