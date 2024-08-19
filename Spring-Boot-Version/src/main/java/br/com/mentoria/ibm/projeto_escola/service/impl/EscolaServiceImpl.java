package br.com.mentoria.ibm.projeto_escola.service.impl;

import br.com.mentoria.ibm.projeto_escola.model.Escola;
import br.com.mentoria.ibm.projeto_escola.model.Turma;
import br.com.mentoria.ibm.projeto_escola.repository.EscolaRepository;
import br.com.mentoria.ibm.projeto_escola.service.AlunoService;
import br.com.mentoria.ibm.projeto_escola.service.EscolaService;
import br.com.mentoria.ibm.projeto_escola.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EscolaServiceImpl implements EscolaService {
    private Escola escola;
    @Autowired
    private AlunoService alunoService;
    @Autowired
    private TurmaService turmaService;
    @Autowired
    private EscolaRepository escolaRepo;

    @Override
    public Escola adicionarTurma(int id, Turma turma) {
        escola = escolaRepo.findById(id).get();
        if (escola.getTurmas().size() < escola.getTAMANHO_MAX()) {
            if (escola.getTurmas().contains(turma)) {
                System.out.println("Turma já cadastrada");
                return null;
            } else {
                List<Turma> turmaList = escola.getTurmas();
                turmaList.add(turma);
                System.out.println("Turma Cadastrada");
                escola.setTurmas(turmaList);
                return escolaRepo.save(escola);
            }
        }
        return null;
    }

    @Override
    public Escola removerTurma(int idTurma) {
        List<Escola> escolaList = escolaRepo.findAll();
        Turma turmaBusca = turmaService.localizarTurmaPorId(idTurma);
        for (Escola escola : escolaList) {
            if (escola.getTurmas().contains(turmaBusca)) {
                escola.getTurmas().remove(turmaBusca);
                return escolaRepo.save(escola);
            }
        }
        return null;
    }

    @Override
    public String obterNomeEscola() {
        return escola.getNomeEscola();
    }


    @Override
    public Escola criarEscola(String nome) {
        Escola escolaCriada = new Escola(nome);
        return escolaRepo.save(escolaCriada);
    }

    @Override
    public void excuirEscola(int id) {
        escolaRepo.deleteById(id);

    }

    @Override
    public Optional<Escola> localizarEscolaPorId(int id) {
        return escolaRepo.findById(id);
    }

    @Override
    public Escola atualizarEscola(Escola escola) {
        return escolaRepo.save(escola);
    }

    @Override
    public List<Escola> localizarEscola() {
        return escolaRepo.findAll();
    }
}

