package com.example.APIBloodDonation.controller;

import com.example.APIBloodDonation.dto.LocaisColetaDTO;
import com.example.APIBloodDonation.service.LocaisColetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/local-coleta")
public class LocaisColetaController {

    @Autowired
    private LocaisColetaService localColetaService;

    @PostMapping
    public ResponseEntity createLocal(@RequestBody LocaisColetaDTO localColetaDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(localColetaService.createLocal(localColetaDTO));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updateLocal(@PathVariable(value = "id") Long id, @RequestBody LocaisColetaDTO localColetaDTO) throws Exception {
        return ResponseEntity.ok().body(localColetaService.updateLocal(id, localColetaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteLocal(@PathVariable(value = "id") Long id) {
        localColetaService.deleteLocal(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity getAllLocal() {
        return ResponseEntity.ok().body(localColetaService.getAllLocal());
    }

    @GetMapping("/{id}")
    public ResponseEntity getLocalById(@PathVariable(value = "id") Long id) throws Exception {
        return ResponseEntity.ok().body(localColetaService.getLocalById(id));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity getLocalByName(@PathVariable(value = "nome") String nome) throws Exception {
        return ResponseEntity.ok().body(localColetaService.getLocalByName(nome));
    }

}