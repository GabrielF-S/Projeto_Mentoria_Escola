package br.com.mentoria.ibm.notas_sender.controller;

import br.com.mentoria.ibm.notas_sender.model.Aluno;
import br.com.mentoria.ibm.notas_sender.model.Notas;
import br.com.mentoria.ibm.notas_sender.service.AlunoService;
import br.com.mentoria.ibm.notas_sender.service.NotasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notas")
public class NotasController {

    @Autowired
    NotasService notasService;

    @Autowired
    AlunoService alunoService;

    @PostMapping("/{alunoId}")
    public ResponseEntity<Aluno> getStatus(@PathVariable int alunoId, @RequestBody Notas notas){
        notasService.calcularNotaFinal(notas);
        var aluno = alunoService.getStatus(alunoId, notas);
        notasService.sendEmail(aluno);
        return ResponseEntity.ok().body(aluno);
    }


}