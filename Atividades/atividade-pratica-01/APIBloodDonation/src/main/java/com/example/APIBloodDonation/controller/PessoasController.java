package com.example.APIBloodDonation.controller;

import com.example.APIBloodDonation.dto.PessoasDTO;
import com.example.APIBloodDonation.service.PessoasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoas")
public class PessoasController {

    @Autowired
    private PessoasService pessoaService;

    @PostMapping
    public ResponseEntity createPerson(@RequestBody PessoasDTO pessoaDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.createPerson(pessoaDTO));
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity updatePerson(@PathVariable(value = "id") Long id, @RequestBody PessoasDTO pessoaDTO) throws Exception {
        return ResponseEntity.ok().body(pessoaService.updatePerson(id, pessoaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePerson(@PathVariable(value = "id") Long id) {
        pessoaService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity getAllPersons() {
        return ResponseEntity.ok().body(pessoaService.getAllPersons());
    }

    @GetMapping("/{id}")
    public ResponseEntity getPersonById(@PathVariable(value = "id") Long id) throws Exception {
        return ResponseEntity.ok().body(pessoaService.getPersonById(id));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity getPersonByName(@PathVariable(value = "nome") String nome) throws Exception {
        return ResponseEntity.ok().body(pessoaService.getPersonByName(nome));
    }

}