package br.com.mentoria.ibm.projeto_escola.controller;

import br.com.mentoria.ibm.projeto_escola.model.Escola;
import br.com.mentoria.ibm.projeto_escola.service.EscolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/escola")
public class EscolaController {
    @Autowired
    EscolaService escolaService;

    @GetMapping
    public List<Escola> buscarEscola() {
        return escolaService.localizarEscola();
    };
    @PostMapping("/{nome}")
    public Escola cadastrarEscola(@PathVariable("nome") String nome){
        return escolaService.criarEscola(nome);

    };

    @PutMapping()
    public Escola atualizarEscola(@RequestBody Escola escola){
        Optional<Escola> escolaBusca = escolaService.localizarEscolaPorId(escola.getId());
        escolaBusca.get().setNomeEscola(escola.getNomeEscola());
        return  escolaService.atualizarEscola(escolaBusca);

    };
    @DeleteMapping("/{id}")
    public void excluirEscola(@PathVariable(value = "id") int id){
        Optional<Escola> escola = escolaService.localizarEscolaPorId(id);
        escolaService.excuirEscola(escola);

    };





}
