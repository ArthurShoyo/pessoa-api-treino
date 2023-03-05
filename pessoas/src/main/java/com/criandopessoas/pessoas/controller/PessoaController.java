package com.criandopessoas.pessoas.controller;

import com.criandopessoas.pessoas.dtos.PessoaDtos;
import com.criandopessoas.pessoas.models.Pessoa;
import com.criandopessoas.pessoas.services.PessoaServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class PessoaController {
    @Autowired
    PessoaServices pessoaServices;

    @GetMapping
    public ResponseEntity<Object> allPessoas (){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaServices.findAll());
    }

    @PostMapping
    public ResponseEntity<PessoaDtos> savePessoas (@RequestBody @Valid PessoaDtos pessoaDtos) {
        Pessoa pessoa = new Pessoa();
        pessoa.setName(pessoaDtos.getName());
        pessoa.setGender(pessoaDtos.getGender());
        pessoa.setEmail(pessoaDtos.getEmail());
        pessoa.setPassword(pessoaDtos.getPassword());
        Pessoa savedPessoa = pessoaServices.save(pessoa);

        PessoaDtos pessoaResponse = new PessoaDtos();
        pessoaResponse.setId(savedPessoa.getId());
        pessoaResponse.setName(savedPessoa.getName());
        pessoaResponse.setGender(savedPessoa.getGender());
        pessoaResponse.setEmail(savedPessoa.getEmail());

        return new ResponseEntity<PessoaDtos>(pessoaResponse, HttpStatus.CREATED);


    }
}
