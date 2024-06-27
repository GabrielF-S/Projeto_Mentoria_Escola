package br.com.mentoria.ibm.projeto_escola.controller;

import br.com.mentoria.ibm.projeto_escola.model.Escola;
import br.com.mentoria.ibm.projeto_escola.model.Turma;
import br.com.mentoria.ibm.projeto_escola.service.EscolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/escolas")
public class EscolaController {
    @Autowired
    EscolaService escolaService;

    @GetMapping
    public ResponseEntity<List<Escola>> buscarTodasEscola() {
        return new ResponseEntity<>(escolaService.localizarEscola(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<Escola>> buscarUmaEscola(@PathVariable("id") int id){
        return  new ResponseEntity<>(escolaService.localizarEscolaPorId(id), HttpStatus.OK);

    }

    @PostMapping("/{nome}")
    public ResponseEntity<Escola> cadastrarEscola(@PathVariable("nome") String nome) {
        return new ResponseEntity<>(escolaService.criarEscola(nome), HttpStatus.OK);

    }



    @PutMapping()
    public ResponseEntity<Escola> atualizarEscola(@RequestBody Escola escola) {
        return new ResponseEntity<>(escolaService.atualizarEscola(escola), HttpStatus.OK);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Escola> cadastrarTurma(@PathVariable("id") int id,@RequestBody Turma turma){
        Escola escola = escolaService.cadastrarTurma(id ,turma);
       if(escola == null){
           return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
       }else {
           return new ResponseEntity<>(escola, HttpStatus.OK);
       }

    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Escola> excluirEscola(@PathVariable(value = "id") int id) {
        escolaService.excuirEscola(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }



}
