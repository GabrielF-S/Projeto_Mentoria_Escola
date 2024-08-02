package br.com.mentoria.ibm.notas_sender.controller;

import br.com.mentoria.ibm.notas_sender.model.Aluno;
import br.com.mentoria.ibm.notas_sender.model.Notas;
import br.com.mentoria.ibm.notas_sender.service.NotasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notas")
public class NotasController {

    @Autowired
    NotasService service;

    @GetMapping("/{alunoId}")
    public ResponseEntity<Notas> getStatus(@PathVariable int alunoId, @RequestBody Notas notas){
          return ResponseEntity.ok().body(service.getStatus(alunoId, notas));
    }


}
