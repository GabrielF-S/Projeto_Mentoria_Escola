package br.com.mentoria.ibm.projeto_escola.controller;

import br.com.mentoria.ibm.projeto_escola.model.Aluno;
import br.com.mentoria.ibm.projeto_escola.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;


    @PostMapping()
    public ResponseEntity<Aluno> criarALuno(@RequestBody Aluno aluno){
        return new ResponseEntity<>(alunoService.criarAluno(aluno), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Aluno> buscarUmAluno(@PathVariable("id") int id){
        return  new ResponseEntity<>(alunoService.localizarAlunoPorId(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Aluno>> buscarTodosAlunos(){
        return new ResponseEntity<>(alunoService.localizarTodosAlunos(), HttpStatus.OK  );
    }

    @PutMapping()
    public ResponseEntity<Aluno> atualizarAluno(@RequestBody Aluno aluno){
        return new ResponseEntity<>(alunoService.atualizarAluno(aluno), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarAluno(@PathVariable("id") int id){
        alunoService.deletarAluno(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }


}
