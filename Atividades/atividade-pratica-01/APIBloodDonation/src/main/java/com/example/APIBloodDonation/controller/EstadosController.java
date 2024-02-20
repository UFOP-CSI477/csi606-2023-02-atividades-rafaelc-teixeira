package com.example.APIBloodDonation.controller;

import com.example.APIBloodDonation.dto.EstadosDTO;
import com.example.APIBloodDonation.service.EstadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estados")
public class EstadosController {

    @Autowired
    private EstadosService estadoService;

    @PostMapping
    public ResponseEntity createState(@RequestBody EstadosDTO estadoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(estadoService.createState(estadoDTO));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updateState(@PathVariable(value = "id") Long id, @RequestBody EstadosDTO estadoDTO) throws Exception {
        return ResponseEntity.ok().body(estadoService.updateState(id, estadoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteState(@PathVariable(value = "id") Long id) {
        estadoService.deleteState(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity getAllStates() {
        return ResponseEntity.ok().body(estadoService.getAllStates());
    }

    @GetMapping("/{id}")
    public ResponseEntity getStateById(@PathVariable(value = "id") Long id) throws Exception {
        return ResponseEntity.ok().body(estadoService.getStateById(id));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity getStateByName(@PathVariable(value = "nome") String nome) throws Exception {
        return ResponseEntity.ok().body(estadoService.getStateByName(nome));
    }
}