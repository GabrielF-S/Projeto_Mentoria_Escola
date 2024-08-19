package br.com.mentoria.ibm.projeto_escola.controller.impl;

import br.com.mentoria.ibm.projeto_escola.controller.TurmaController;
import br.com.mentoria.ibm.projeto_escola.model.Aluno;
import br.com.mentoria.ibm.projeto_escola.model.Turma;
import br.com.mentoria.ibm.projeto_escola.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turmas")
public class TurmaControllerImpl implements TurmaController {

    @Autowired
    TurmaService turmaService;

    @Override
    public ResponseEntity<List<Turma>> localizarTodasTurmas() {
        return new ResponseEntity<>(turmaService.localizarTodasTurmas(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Turma> localizarTurmaPorId(@PathVariable("id") int id) {
        return new ResponseEntity<>(turmaService.localizarTurmaPorId(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> criarTurma(@PathVariable("nome") String nome) {
        Turma turma = turmaService.criarTurma(nome);
        if (turma != null) {
            return new ResponseEntity<>(turma, HttpStatus.OK);
        } else {
            String texto = "Já existe turma com este nome";
            return new ResponseEntity<>(texto, HttpStatus.FORBIDDEN);
        }
    }
    @Override
    public ResponseEntity<Turma> atualizarTurma(@RequestBody Turma turma) {
        Turma turmaBD = turmaService.atualizarNomeTurma(turma);
        if (turmaBD != null) {
            return new ResponseEntity<>(turmaBD, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @Override
    public ResponseEntity<?> adicionarAluno(@PathVariable("id") int id, @RequestBody Aluno aluno) {
        Turma turma = turmaService.adicionarAluno(id, aluno);
        if (turma != null) {
            return new ResponseEntity<>(turma, HttpStatus.OK);
        } else{
            String texto = "Turma sem vagas";
            return new ResponseEntity<>(texto, HttpStatus.FORBIDDEN);
        }
    }

    @Override
    public ResponseEntity excluirTurma(@PathVariable("id") int id) {
        turmaService.deletarTurma(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> removerAluno(@PathVariable("id")int id, @RequestBody Aluno aluno){
        turmaService.removerAluno(id ,aluno);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
