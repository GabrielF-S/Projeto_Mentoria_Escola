package br.com.mentoria.ibm.projeto_escola.controller;

import br.com.mentoria.ibm.projeto_escola.model.Turma;
import br.com.mentoria.ibm.projeto_escola.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    @Autowired
    TurmaService turmaService;

    @GetMapping
    public ResponseEntity<List<Turma>> localizarTodasTurmas() {
        return new ResponseEntity<>(turmaService.localizarTodasTurmas(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Turma> localizarTurmaPorId(@PathVariable("id") int id) {
        return new ResponseEntity<>(turmaService.localizarTurmaPorId(id), HttpStatus.OK);
    }

    @PostMapping("/{nome}")
    public ResponseEntity<Turma> criarTurma(@PathVariable("nome") String nome) {
        Turma turma = turmaService.criarTurma(nome);
        if (turma != null) {
            return new ResponseEntity<>(turma, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(turma, HttpStatus.EXPECTATION_FAILED);
        }

    }


    @PutMapping
    public ResponseEntity<Turma> atualizarTurma(@RequestBody Turma turma) {
        Turma turmaBD = turmaService.atualizarNomeTurma(turma);
        if (turmaBD != null) {
            return new ResponseEntity<>(turmaBD, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity excluirTurma(@PathVariable("id") int id) {
        turmaService.deletarTurma(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }


}
