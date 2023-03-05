package com.criandopessoas.pessoas.repository;

import com.criandopessoas.pessoas.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
