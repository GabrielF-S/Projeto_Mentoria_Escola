package br.com.mentoria.ibm.projeto_escola.repository;

import br.com.mentoria.ibm.projeto_escola.model.Escola;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EscolaRepository extends JpaRepository<Escola, Integer> {



}
