package com.criandopessoas.pessoas.services;

import com.criandopessoas.pessoas.models.Pessoa;
import com.criandopessoas.pessoas.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PessoaServices {
    @Autowired
    PessoaRepository pessoaRepository;

    public List findAll(){
        return pessoaRepository.findAll();
    }

    public Pessoa save(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
}
